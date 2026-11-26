# Argo data recovery

`argo-pool.json.gz` is the exact gzip-compressed copy of
`assets/argo/argo-pool.json` extracted from the user's original
`mlmvpn-1.2.51-universal-release.apk`. CI decompresses it and verifies the
uncompressed SHA-256 before packaging:

`7712ca8c0ddf1aab957a3d24e75f01613034e7ab14d06a9650eab588333bec6c`

The snapshot contains 295 entries and 46 Falcon servers and is dated
2026-11-07. It is not a claim that every endpoint is still live; the real
Argo engine must retain runtime validation and refresh behavior.

**Native dependency correction:** `libarjni.so` belongs to the separate
Arman subsystem, not Argo. DEX call-reference analysis shows ArgoEngine uses
Aether/Tunnel and the existing app networking stack instead. Do not treat the
Arman GoMobile AAR as an Argo implementation.
