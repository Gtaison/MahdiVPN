# Argo recovery provenance

## Android JNI backend

The original MLMVPN 1.2.51 APK contains `libarjni.so` for both Android ARM ABIs.
ELF inspection confirms AArch64 for `arm64-v8a` and ARM for `armeabi-v7a`.
Its exported JNI entry points include `Java_mobile_Mobile_*` and the GoMobile
binding support `Java_ar_Seq_*` / `Java_ar_Universe_*`.

Go build metadata in that APK identifies the core module as
`github.com/armanlife/arman-vpn-client/core`, Go 1.27.3, and the upstream
dependencies pinned by the source project. The native backend is therefore
rebuilt from the corresponding public GPL-3.0 source instead of copying an
unverified opaque binary:

- Source: https://github.com/armanlife/arman-vpn-client
- Pinned source commit: `492dd7f389c539790cde3d07167535d28788a0d0` (1.0.19)
- Go: `1.27.3`
- GoMobile: `v0.0.0-20260908204917-8b95e45f8d3e`
- License: GPL-3.0

CI builds `core/mobile` as an Android AAR for ARM and ARM64. The stock GoMobile
AAR names its runtime package `go` and its library `libgojni.so`; the original
MLM APK instead uses `ar.Seq`, `ar.Universe`, and `libarjni.so`. The pinned
post-processor `scripts/repackage-argo-gomobile-aar.py` performs same-length
class-file and ELF JNI symbol remapping, then verifies both ABI outputs before
installing the AAR. This is not a filename-only rename: generated Java load names,
JNI symbols, class descriptors and AAR entries are remapped together.

Keeping the AAR rather than only its `.so` is intentional: it also supplies the
generated `mobile.Mobile`, `ar.Seq`, and `ar.Universe` Java bindings required by JNI.

The original APK's extracted library hashes are recorded here for provenance,
not used as the build output:

- ARM64: `4740aaea39773c82fec4d17e81dc0a0e5c8b5a61e2a8a1906a75ad351eea86fb`
- ARMv7: `55c1065836faaeda38dfa2b947b7c93a43925586206de96f103905b4d7d51703`

## Argo pool data

`argo-pool.json.gz` is the exact gzip-compressed copy of
`assets/argo/argo-pool.json` extracted from the user's original
`mlmvpn-1.2.51-universal-release.apk`. CI decompresses it and verifies the
uncompressed SHA-256 before packaging:

`7712ca8c0ddf1aab957a3d24e75f01613034e7ab14d06a9650eab588333bec6c`

This is a dated snapshot from 2026-11-07 (295 entries, 46 Falcon servers),
not a claim that every endpoint is still live. The Argo engine must retain its
runtime validation and refresh behavior.
