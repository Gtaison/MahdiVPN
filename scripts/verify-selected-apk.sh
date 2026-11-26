#!/usr/bin/env bash
# Fail closed: a successful Gradle task is not proof that the selected MLM modules
# and their native backends are actually present in the APK.
set -euo pipefail

APK="${1:?usage: verify-selected-apk.sh path/to.apk arm64-v8a|armeabi-v7a}"
ABI="${2:?usage: verify-selected-apk.sh path/to.apk arm64-v8a|armeabi-v7a}"
command -v unzip >/dev/null
command -v strings >/dev/null
[[ -s "$APK" ]] || { echo "APK missing or empty: $APK" >&2; exit 2; }

TMP="$(mktemp -d)"
trap 'rm -rf "$TMP"' EXIT
unzip -q "$APK" -d "$TMP"
missing=0
need_file() {
  local path="$1"
  if [[ ! -s "$TMP/$path" ]]; then
    echo "MISSING FILE: $path"
    missing=1
  else
    echo "OK FILE: $path ($(stat -c %s "$TMP/$path") bytes)"
  fi
}
need_dex_class() {
  local descriptor="$1" found=0
  for dex in "$TMP"/classes*.dex; do
    [[ -f "$dex" ]] || continue
    if strings -a "$dex" | grep -Fq "$descriptor"; then found=1; break; fi
  done
  if (( found )); then echo "OK CLASS: $descriptor"; else echo "MISSING CLASS: $descriptor"; missing=1; fi
}

# Argo and Mami are independent, user-requested products. Their code and catalog data
# must travel with the app. The libarjni/hev pair below is Arman's separate backend,
# not an Argo substitute. Aether/Tunnel are separately managed runtime dependencies.
need_file "assets/argo/argo-pool.json"
need_file "assets/mami/catalog-bootstrap.json"
# Arman GoMobile backend (not the Argo engine).
need_file "lib/$ABI/libarjni.so"
need_file "lib/$ABI/libhev-socks5-tunnel.so"
need_dex_class 'Lmobile/Mobile;'
need_dex_class 'Lcom/mlmvpn/scanner/engines/fenix/arman/Tun2Socks;'
need_dex_class 'Lar/Seq;'
need_dex_class 'Lar/Universe;'
need_dex_class 'Lar/error;'
need_dex_class 'Lcom/mlmvpn/scanner/engines/argo/ArgoEngine;'
need_dex_class 'Lcom/mlmvpn/scanner/ui/argo/ArgoScreenKt;'
need_dex_class 'Lcom/mlmvpn/scanner/engines/mami/MamiEngine;'
need_dex_class 'Lcom/mlmvpn/scanner/ui/mami/MamiScreenKt;'

# Lantern and URnetwork route the device TUN to a local proxy. Both bridge libraries
# were absent from the earlier debug APK despite the Kotlin code calling them.
need_file "lib/$ABI/libtun2proxy.so"
need_file "lib/$ABI/libtun2socks.so"
need_file "lib/$ABI/libmhrv_rs.so"

# Core data used by the other selected products must not silently disappear either.
need_file "assets/iran_profiles.json"
need_file "assets/outline/shadowmere_seed.json"
need_file "assets/tor_bridges_seed.txt"

if (( missing )); then
  echo "RESULT: INCOMPLETE APK — refusing to publish this build as usable." >&2
  exit 1
fi
echo "RESULT: required selected-module files/classes are present. This is a packaging check, not an on-device connectivity test."
