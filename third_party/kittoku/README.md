# Kittoku Minimum VPN Client for SoftEther VPN

The SoftEther client sources under `app/src/main/java/kittoku/mvc/` originate
from the upstream project:

- Repository: https://github.com/kittoku/Minimum-VPN-Client-for-SoftEther-VPN
- Pinned upstream commit used to restore the missing controller files:
  `289fa2d4afb6ff4de8e597a175b75affd8fb8889`
- License: Apache License 2.0. The upstream repository also provides
  `SOFTETHER_LICENSE`; both upstream license files are retained here.

The restored files are `control/Controller.kt`, `control/LogWriter.kt` and
`control/NetworkObserver.kt`. They complete the existing MVC sources used by
the app's VPN Gate / SoftEther integration. Existing MLMVPN changes elsewhere
in the integration are maintained separately.

This app is an unofficial client and is not affiliated with or endorsed by
SoftEther Corporation. "SoftEther" is a registered trademark of SoftEther
Corporation.
