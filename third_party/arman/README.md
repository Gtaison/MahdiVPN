# Arman Android native backend

This directory documents the **Arman** subsystem found in the original MLMVPN
1.2.51 APK. It is separate from the Argo engine.

## GoMobile core

The original APK's `libarjni.so` and the generated Java bindings
`mobile.Mobile`, `ar.Seq`, and `ar.Universe` are used by
`com.mlmvpn.scanner.engines.fenix.arman.ArmanCore` / `ArmanEngine`.
DEX call-reference analysis confirms that `ArgoEngine` does not call
`mobile.Mobile`; the earlier checkpoint's attribution of `libarjni.so` to
Argo was incorrect.

- Source: https://github.com/armanlife/arman-vpn-client
- Pinned source commit: `492dd7f389c539790cde3d07167535d28788a0d0` (1.0.19)
- Go: `1.27.3`
- GoMobile: `v0.0.0-20260908204917-8b95e45f8d3e`
- License: GPL-3.0

The stock GoMobile AAR names its runtime package `go` and library
`libgojni.so`; MLMVPN 1.2.51 uses `ar.Seq`, `ar.Universe`, and
`libarjni.so`. The pinned post-processor
`scripts/repackage-arman-gomobile-aar.py` remaps Java class references,
library-load names, ELF JNI symbols and AAR entries using same-length
replacements, and validates both ARM ABIs.

## TUN bridge

The original APK also contains `libhev-socks5-tunnel.so`. Its JNI_OnLoad
looks up this exact class:

`com/mlmvpn/scanner/engines/fenix/arman/Tun2Socks`

CI rebuilds it from the same pinned upstream repository's
`app/android/hev-socks5-tunnel` sources using the Android NDK. The upstream
library is MIT-licensed (copyright hev, 2022). The Kotlin JNI adapter is
restored at the original package path.

Original APK hashes (provenance only; CI rebuilds from source):

- `libarjni.so` ARM64: `4740aaea39773c82fec4d17e81dc0a0e5c8b5a61e2a8a1906a75ad351eea86fb`
- `libarjni.so` ARMv7: `55c1065836faaeda38dfa2b947b7c93a43925586206de96f103905b4d7d51703`
- `libhev-socks5-tunnel.so` ARM64: `dacbfa7056178caf635782da334f7b3f00ac57a8ea866e8f61b4cff6a40d8fff`
- `libhev-socks5-tunnel.so` ARMv7: `a8784955e9f32ddff033f2d7427b64d418a188eb7e87fb3b3f31979e2c30f01f`

**Important:** rebuilding these native components does not by itself restore the
full ArmanEngine Kotlin/UI/service integration. The Arman engine remains
unavailable until its actual engine and service classes are restored and tested.
