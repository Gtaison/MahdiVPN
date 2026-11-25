# Upstream artifacts, kept pristine

## Reproducible binary inputs

The Android CI downloads these exact upstream artifacts and verifies their checksums before
the app build. They are build inputs, not files copied from a third-party APK:

| Artifact | Pinned source | Verification |
|---|---|---|
| Xray `libv2ray.aar` | AndroidLibXrayLite `v26.11.9` | SHA-256 `cdfef146218233a31a8b52c8b1016557730d3b63fc121d4c84cacea50e669155` |
| Windscribe `wsnet.aar` | Windscribe Android-App commit `2c585dd5979ba93655853d56d849ed8ad2c964cb` | SHA-256 `5b0145d526aa10f6b7ec094639bfc8dc2f187d76d1b70915cf4da4802b822f11` |
| Psiphon `psiphontunnel-2.0.39.aar` | Psiphon Android Maven repository, tag `v2.0.39` | SHA-1 `e131f63e6c88e61d2cd9a0e5fc503ee4eda3f816` |

The workflow is the canonical downloader; it creates `app/libs/` in the CI workspace and
does not commit large binary artifacts to the source tree.

## `psiphontunnel-2.0.39.aar`

Psiphon's Go controller as published. **It is not the copy the app builds against.**

It cannot be, because this APK also carries `libv2ray.aar` and both are gomobile builds:
each ships the Java classes `go.Seq` / `go.Universe` / `go.error` and a native library
called `libgojni.so`. Two of each in one APK is a duplicate-class error and a duplicate
native-library error, and neither can be resolved by picking one — the two `libgojni.so`
are different Go programs (Xray, Psiphon), so whichever lost would leave every native
method of its own library unresolvable at runtime.

`app/libs/psiphontunnel-2.0.39-ns.aar` is this file with its gomobile runtime moved from
`go` to `pg` and its native library renamed to `libpgjni.so`. To regenerate it:

In CI, the pinned Maven AAR is downloaded into `app/libs/`, checked against the SHA-1
published in the Maven repository, and transformed automatically:

```bash
python3 scripts/repackage-psiphon-aar.py app/libs/psiphontunnel-2.0.39.aar app/libs/psiphontunnel-2.0.39-ns.aar
```

The script explains every substitution and verifies its own output. Run it again after
upgrading psiphon-tunnel-core, from the new upstream file rather than from the patched one.
