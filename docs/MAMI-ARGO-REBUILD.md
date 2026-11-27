# Mami and Argo reconstruction

## Working baseline

This branch starts from `feature/lean-vpn-no-warp` at
`604508293ccb0a27dc80d6b1ade99bcd0d4d0aa8`. It deliberately does not inherit the
APK-decompiled Java tree from `test/argo-mami-compile-1249`.

The APK-derived tree is not a viable source drop. Its Java output references R8-renamed
classes and Kotlin/Compose internals that are not part of the source project. The last
attempt (workflow run `45827919956`) failed during Java compilation with 100 errors,
including missing obfuscated types such as `k0`, `e1`, `j`, `s1`, `i0`,
and missing packages such as `a6`. Adding arbitrary compatibility stubs would only
hide the failure and would not produce working engines.

## What the 1.2.51 APK reveals

### Mami

The recovered implementation shows that Mami is not just a static server list:

- It discovers its control host through a dead-drop mechanism, with a cached host and
  fallback host ordering (`host`, `edge.<host>`, `assets.<host>`).
- It registers a device, stores access/refresh tokens, refreshes sessions, and sends
  authenticated requests to the `/api/v1/` API.
- Its bootstrap asset supplies the catalog endpoint, audience, storage identifier, and
  trusted signing keys.
- Catalog delivery uses a request/envelope exchange with a fresh device recipient,
  payload-version negotiation, signature verification, and encrypted response opening.
- It also exposes a separate `device/hive` feed and device route selection endpoint.
- Server profiles observed in the APK include Trojan, VLESS XHTTP, VLESS Reality, Hysteria2,
  gRPC Reality, and VLESS. The generated outbound configuration is Xray-compatible.

### Argo

The recovered implementation shows that Argo is also more than a list of endpoints:

- It has a custom authenticated session handshake, crypto helpers (RSA-OAEP, AES-GCM,
  HKDF and HMAC), session metadata, and Xray outbound generation.
- It obtains candidate endpoints from a persistent pool, including bridge, public and
  Falcon endpoint types.
- A connection is not considered successful until the VPN service starts and an external
  trace request returns traffic through the selected endpoint.
- The engine uses the app's existing `MyVpnService` and Xray runtime, with node id
  `argo`; it can run in proxy-only or full-tunnel mode.
- The recovered engine has a failover path that can be connected to Mami after both
  implementations are independently working.

## Reconstruction rules

1. Keep the clean, source-compatible baseline and preserve the existing no-WARP changes.
2. Do not compile the JADX/decompiler Java output as application source.
3. Reimplement the protocol and engine state in Kotlin against the current app APIs.
4. Add UI only after a real engine API exists; UI controls must invoke real actions.
5. Keep Mami and Argo independent at first. Add Mami-backed failover only after each
   engine passes its own connection and disconnect tests.
6. Test protocol parsing, crypto/envelope validation, candidate selection, cancellation,
   VPN service lifecycle, traffic verification, and APK packaging.
7. Never satisfy verification by adding placeholder classes, fake connected states, or
   weakening the APK verification script.
8. Preserve the upstream MLMVPN attribution and GPLv3 notices in all distributed builds.

## Milestones

- [ ] Confirm clean baseline compiles and preserve its current tests.
- [ ] Rebuild Argo protocol primitives and pool parsing with deterministic tests.
- [ ] Integrate Argo connection lifecycle with the existing Xray/VPN service.
- [ ] Rebuild Mami identity, API/session, signed envelope, catalog and Xray config layers.
- [ ] Integrate Mami connection lifecycle and device/server selection.
- [ ] Add real Compose screens and home navigation for both engines.
- [ ] Add Mami failover to Argo and verify cancellation/recovery.
- [ ] Verify all required classes, assets and native libraries in each APK ABI.
