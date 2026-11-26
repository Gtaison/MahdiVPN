package com.mlmvpn.scanner.engines.mami;

import com.mlmvpn.core.aether.i;
import com.mlmvpn.core.warp.WarpIdRelay;
import com.mlmvpn.core.warp.XrayCoreHostService;
import com.mlmvpn.scanner.data.studio.api.StudioError;
import com.mlmvpn.scanner.engines.rstaspoof.SniSession;
import com.mlmvpn.scanner.engines.scout.PsiphonProbeService;
import com.mlmvpn.scanner.utils.LocalPort;
import java.util.Collection;
import kittoku.mvc.unit.property.ConstKt;
import kotlin.jvm.internal.j;
import org.scilab.forge.jlatexmath.TeXSymbolParser;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final class MamiXrayConfig {
    public static final int $stable = 0;
    public static final String FP = "chrome";
    public static final MamiXrayConfig INSTANCE = new MamiXrayConfig();
    public static final String TAG = "mami-vpn";

    private MamiXrayConfig() {
    }

    public static /* synthetic */ sf.c configFor$default(MamiXrayConfig mamiXrayConfig, sf.c cVar, int i, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i = LocalPort.DEFAULT;
        }
        if ((i10 & 4) != 0) {
            str = SniSession.LOCAL_HOST;
        }
        if ((i10 & 8) != 0) {
            str2 = "warning";
        }
        return mamiXrayConfig.configFor(cVar, i, str, str2);
    }

    public static /* synthetic */ String configJson$default(MamiXrayConfig mamiXrayConfig, MamiCatalog.Server server, String str, int i, String str2, String str3, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = TAG;
        }
        String str4 = str;
        if ((i10 & 4) != 0) {
            i = LocalPort.DEFAULT;
        }
        int i11 = i;
        if ((i10 & 8) != 0) {
            str2 = SniSession.LOCAL_HOST;
        }
        String str5 = str2;
        if ((i10 & 16) != 0) {
            str3 = "warning";
        }
        String str6 = str3;
        if ((i10 & 32) != 0) {
            z10 = false;
        }
        return mamiXrayConfig.configJson(server, str4, i11, str5, str6, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final sf.c hysteria2(MamiCatalog.Server server, String str) {
        MamiCatalog.Hysteria2 hysteria2 = server.getHysteria2();
        j.b(hysteria2);
        sf.c cVar = new sf.c();
        cVar.D(StudioError.NETWORK, "hysteria");
        cVar.D("security", "tls");
        sf.c cVar2 = new sf.c();
        cVar2.D(ConstKt.SEP_VERSION, 2);
        cVar2.D("auth", hysteria2.getAuth());
        sf.c cVarQ = i.q(cVar, cVar2, "hysteriaSettings");
        cVarQ.D("serverName", server.getSni());
        sf.a aVar = new sf.a();
        aVar.put("h3");
        cVarQ.D("alpn", aVar);
        cVarQ.D("pinnedPeerCertSha256", hexOfPin(hysteria2.getPinSHA256()));
        sf.c cVarQ2 = i.q(cVar, cVarQ, "tlsSettings");
        if (hysteria2.getObfs().length() > 0) {
            sf.c cVar3 = new sf.c();
            cVar3.D("password", hysteria2.getObfsPassword());
            if (j.a(hysteria2.getObfs(), "gecko")) {
                cVar3.D("packetSize", "512-1200");
            }
            sf.a aVar2 = new sf.a();
            sf.c cVar4 = new sf.c();
            cVar4.D(TeXSymbolParser.TYPE_ATTR, hysteria2.getObfs());
            cVar4.D("settings", cVar3);
            aVar2.put(cVar4);
            cVarQ2.D("udp", aVar2);
        }
        if (hysteria2.getHopPorts().length() > 0) {
            sf.c cVar5 = new sf.c();
            sf.c cVar6 = new sf.c();
            cVar6.D("ports", hysteria2.getHopPorts());
            cVar6.D("interval", Integer.valueOf(hysteria2.getHopInterval()));
            cVar5.D("udpHop", cVar6);
            cVarQ2.D("quicParams", cVar5);
        }
        if (cVarQ2.f67158a.size() > 0) {
            cVar.D("finalmask", cVarQ2);
        }
        sf.c cVarP = i.p("tag", str, "protocol", "hysteria");
        sf.c cVar7 = new sf.c();
        cVar7.D(ConstKt.SEP_VERSION, 2);
        cVar7.D("address", server.getHost());
        cVar7.D(PsiphonProbeService.PORT, Integer.valueOf(server.getPort()));
        cVarP.D("settings", cVar7);
        cVarP.D("streamSettings", cVar);
        return cVarP;
    }

    private final sf.c opt(sf.c cVar, String str, Object obj) {
        if (obj != null && !obj.equals("") && !obj.equals(Boolean.FALSE) && (!(obj instanceof Number) || ((Number) obj).doubleValue() != 0.0d)) {
            cVar.D(str, obj);
        }
        return cVar;
    }

    public static /* synthetic */ sf.c outboundFor$default(MamiXrayConfig mamiXrayConfig, MamiCatalog.Server server, String str, boolean z10, int i, Object obj) {
        if ((i & 2) != 0) {
            str = TAG;
        }
        if ((i & 4) != 0) {
            z10 = false;
        }
        return mamiXrayConfig.outboundFor(server, str, z10);
    }

    private final sf.c reality(String str, String str2, String str3, String str4, String str5, String str6) {
        sf.c cVarO = i.o("serverName", str);
        if (str2.length() == 0) {
            str2 = FP;
        }
        cVarO.D("fingerprint", str2);
        cVarO.D("publicKey", str3);
        cVarO.D("shortId", str4);
        if (str5.length() > 0) {
            cVarO.D("spiderX", str5);
        }
        if (str6.length() > 0) {
            cVarO.D("mldsa65Verify", str6);
        }
        return cVarO;
    }

    public static /* synthetic */ sf.c reality$default(MamiXrayConfig mamiXrayConfig, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 16) != 0) {
            str5 = "";
        }
        if ((i & 32) != 0) {
            str6 = "";
        }
        return mamiXrayConfig.reality(str, str2, str3, str4, str5, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final sf.c trojan(MamiCatalog.Server server, String str) {
        sf.c cVarP = i.p("tag", str, "protocol", "trojan");
        sf.c cVar = new sf.c();
        sf.a aVar = new sf.a();
        sf.c cVar2 = new sf.c();
        cVar2.D("address", server.getHost());
        cVar2.D(PsiphonProbeService.PORT, Integer.valueOf(server.getPort()));
        cVar2.D("password", server.getPassword());
        aVar.put(cVar2);
        cVar.D("servers", aVar);
        cVarP.D("settings", cVar);
        sf.c cVar3 = new sf.c();
        cVar3.D(StudioError.NETWORK, "raw");
        sf.c cVarM = com.mlmvpn.scanner.e.m("security", "tls", cVar3);
        cVarM.D("serverName", server.getSni());
        cVarM.D("minVersion", "1.2");
        cVar3.D("tlsSettings", cVarM);
        cVarP.D("streamSettings", cVar3);
        return cVarP;
    }

    public static /* synthetic */ String unsupportedReason$default(MamiXrayConfig mamiXrayConfig, MamiCatalog.Server server, boolean z10, int i, Object obj) {
        if ((i & 2) != 0) {
            z10 = false;
        }
        return mamiXrayConfig.unsupportedReason(server, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final sf.c vlessGeneric(MamiCatalog.Server server, String str) {
        MamiCatalog.Vless vless = server.getVless();
        j.b(vless);
        sf.c cVar = new sf.c();
        cVar.D(StudioError.NETWORK, vless.getNetwork());
        cVar.D("security", vless.getSecurity());
        String network = vless.getNetwork();
        int iHashCode = network.hashCode();
        if (iHashCode != -1041340268) {
            if (iHashCode != 3804) {
                if (iHashCode != 3181598) {
                    if (iHashCode == 114035968 && network.equals("xhttp")) {
                        MamiCatalog.XhttpTransport xhttp = vless.getXhttp();
                        j.b(xhttp);
                        cVar.D("xhttpSettings", xhttpSettings(xhttp));
                    }
                } else if (network.equals("grpc")) {
                    MamiCatalog.GrpcTransport grpc = vless.getGrpc();
                    j.b(grpc);
                    sf.c cVar2 = new sf.c();
                    cVar2.D("serviceName", grpc.getServiceName());
                    cVar2.E("multiMode", grpc.getMultiMode());
                    if (grpc.getMultiConnections() > 0) {
                        cVar2.D("multi_connections", Integer.valueOf(grpc.getMultiConnections()));
                    }
                    opt(cVar2, "authority", grpc.getAuthority());
                    if (grpc.getIdleTimeout() > 0) {
                        cVar2.D("idle_timeout", Integer.valueOf(grpc.getIdleTimeout()));
                    }
                    if (grpc.getHealthCheckTimeout() > 0) {
                        cVar2.D("health_check_timeout", Integer.valueOf(grpc.getHealthCheckTimeout()));
                    }
                    if (grpc.getPermitWithoutStream()) {
                        cVar2.E("permit_without_stream", true);
                    }
                    cVar.D("grpcSettings", cVar2);
                }
            } else if (network.equals("ws")) {
                MamiCatalog.WsTransport ws = vless.getWs();
                j.b(ws);
                sf.c cVar3 = new sf.c();
                cVar3.D("path", ws.getPath());
                cVar.D("wsSettings", opt(opt(cVar3, "host", ws.getHost()), "heartbeatPeriod", Integer.valueOf(ws.getHeartbeatPeriod() > 0 ? ws.getHeartbeatPeriod() : 0)));
            }
        } else if (network.equals("httpupgrade")) {
            sf.c cVar4 = new sf.c();
            MamiCatalog.HttpUpgradeTransport httpupgrade = vless.getHttpupgrade();
            j.b(httpupgrade);
            cVar4.D("path", httpupgrade.getPath());
            cVar.D("httpupgradeSettings", opt(cVar4, "host", vless.getHttpupgrade().getHost()));
        }
        if (j.a(vless.getSecurity(), "reality")) {
            MamiCatalog.RealityBlock reality = vless.getReality();
            j.b(reality);
            cVar.D("realitySettings", reality(server.getSni(), reality.getFingerprint(), reality.getPublicKey(), reality.getShortId(), reality.getSpiderX(), reality.getMldsa65Verify()));
        } else {
            MamiCatalog.TlsBlock tls = vless.getTls();
            j.b(tls);
            sf.c cVar5 = new sf.c();
            cVar5.D("serverName", server.getSni());
            String fingerprint = tls.getFingerprint();
            if (fingerprint.length() == 0) {
                fingerprint = FP;
            }
            cVar5.D("fingerprint", fingerprint);
            cVar5.D("minVersion", "1.2");
            if (!tls.getAlpn().isEmpty()) {
                cVar5.D("alpn", new sf.a((Collection) tls.getAlpn()));
            }
            if (tls.getPinSHA256().length() > 0) {
                cVar5.D("pinnedPeerCertSha256", hexOfPin(tls.getPinSHA256()));
            }
            cVar.D("tlsSettings", cVar5);
        }
        MamiCatalog.Sockopt sockopt = vless.getSockopt();
        if (sockopt != null) {
            sf.c cVar6 = new sf.c();
            if (sockopt.getTcpKeepAliveIdle() > 0) {
                cVar6.D("tcpKeepAliveIdle", Integer.valueOf(sockopt.getTcpKeepAliveIdle()));
            }
            if (sockopt.getTcpKeepAliveInterval() > 0) {
                cVar6.D("tcpKeepAliveInterval", Integer.valueOf(sockopt.getTcpKeepAliveInterval()));
            }
            if (sockopt.getTcpFastOpen()) {
                cVar6.E("tcpFastOpen", true);
            }
            if (sockopt.getTcpMptcp()) {
                cVar6.E("tcpMptcp", true);
            }
            INSTANCE.opt(cVar6, "tcpCongestion", sockopt.getTcpCongestion());
            if (cVar6.f67158a.size() > 0) {
                cVar.D("sockopt", cVar6);
            }
        }
        sf.c cVar7 = new sf.c();
        cVar7.D(XrayCoreHostService.KEY_ID, vless.getUuid());
        cVar7.D("encryption", vless.getEncryption());
        sf.c cVarOpt = opt(cVar7, "flow", vless.getFlow());
        sf.c cVarP = i.p("tag", str, "protocol", "vless");
        cVarP.D("settings", vlessSettings(server, cVarOpt));
        cVarP.D("streamSettings", cVar);
        MamiCatalog.Mux mux = vless.getMux();
        if (mux != null && mux.getEnabled()) {
            sf.c cVar8 = new sf.c();
            cVar8.E("enabled", true);
            if (mux.getConcurrency() > 0) {
                cVar8.D("concurrency", Integer.valueOf(mux.getConcurrency()));
            }
            if (mux.getXudpConcurrency() > 0) {
                cVar8.D("xudpConcurrency", Integer.valueOf(mux.getXudpConcurrency()));
            }
            INSTANCE.opt(cVar8, "xudpProxyUDP443", mux.getXudpProxyUDP443());
            cVarP.D("mux", cVar8);
        }
        return cVarP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final sf.c vlessGrpc(MamiCatalog.Server server, String str) {
        MamiCatalog.Grpc grpc = server.getGrpc();
        j.b(grpc);
        sf.c cVar = new sf.c();
        cVar.D("tag", str);
        cVar.D("protocol", "vless");
        sf.c cVar2 = new sf.c();
        cVar2.D(XrayCoreHostService.KEY_ID, grpc.getUuid());
        cVar2.D("encryption", "none");
        cVar.D("settings", vlessSettings(server, cVar2));
        sf.c cVar3 = new sf.c();
        cVar3.D(StudioError.NETWORK, "grpc");
        sf.c cVarM = com.mlmvpn.scanner.e.m("security", "reality", cVar3);
        cVarM.D("serviceName", grpc.getServiceName());
        cVarM.E("multiMode", true);
        cVarM.D("multi_connections", Integer.valueOf(grpc.getMultiConnections()));
        cVar3.D("grpcSettings", cVarM);
        cVar3.D("realitySettings", reality$default(this, server.getSni(), grpc.getFingerprint(), grpc.getPublicKey(), grpc.getShortId(), null, null, 48, null));
        cVar.D("streamSettings", cVar3);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final sf.c vlessRaw(MamiCatalog.Server server, String str) {
        MamiCatalog.Raw raw = server.getRaw();
        j.b(raw);
        sf.c cVar = new sf.c();
        cVar.D("tag", str);
        cVar.D("protocol", "vless");
        sf.c cVar2 = new sf.c();
        cVar2.D(XrayCoreHostService.KEY_ID, raw.getUuid());
        cVar2.D("encryption", "none");
        cVar2.D("flow", "xtls-rprx-vision");
        cVar.D("settings", vlessSettings(server, cVar2));
        sf.c cVar3 = new sf.c();
        cVar3.D(StudioError.NETWORK, "raw");
        cVar3.D("security", "reality");
        sf.c cVarQ = i.q(cVar3, reality$default(this, server.getSni(), raw.getFingerprint(), raw.getPublicKey(), raw.getShortId(), null, null, 48, null), "realitySettings");
        cVarQ.D("tcpKeepAliveIdle", 30);
        cVarQ.D("tcpKeepAliveInterval", 15);
        cVar3.D("sockopt", cVarQ);
        cVar.D("streamSettings", cVar3);
        return cVar;
    }

    private final sf.c vlessSettings(MamiCatalog.Server server, sf.c cVar) {
        sf.c cVar2 = new sf.c();
        sf.a aVar = new sf.a();
        sf.c cVar3 = new sf.c();
        cVar3.D("address", server.getHost());
        cVar3.D(PsiphonProbeService.PORT, Integer.valueOf(server.getPort()));
        sf.a aVar2 = new sf.a();
        aVar2.put(cVar);
        cVar3.D("users", aVar2);
        aVar.put(cVar3);
        cVar2.D("vnext", aVar);
        return cVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final sf.c vlessXhttp(MamiCatalog.Server server, String str) {
        MamiXrayConfig mamiXrayConfig;
        MamiCatalog.Xhttp xhttp = server.getXhttp();
        j.b(xhttp);
        sf.c cVar = new sf.c();
        cVar.D(StudioError.NETWORK, "xhttp");
        cVar.D("security", xhttp.getSecurity());
        if (j.a(xhttp.getSecurity(), "reality")) {
            mamiXrayConfig = this;
            cVar.D("realitySettings", reality$default(mamiXrayConfig, server.getSni(), FP, xhttp.getPublicKey(), xhttp.getShortId(), null, null, 48, null));
        } else {
            mamiXrayConfig = this;
            sf.c cVar2 = new sf.c();
            cVar2.D("serverName", server.getSni());
            cVar2.D("fingerprint", FP);
            sf.a aVar = new sf.a();
            aVar.put("h2");
            cVar2.D("alpn", aVar);
            cVar.D("tlsSettings", cVar2);
        }
        cVar.D("xhttpSettings", mamiXrayConfig.xhttpSettings(new MamiCatalog.XhttpTransport(xhttp.getPath(), xhttp.getMode(), "", xhttp.getPaddingBytes(), xhttp.getSessionIDLength(), xhttp.getSessionIDTable(), xhttp.getMaxPostBytes(), xhttp.getMinPostInterval(), null, 256, null)));
        sf.c cVar3 = new sf.c();
        cVar3.D("tag", str);
        sf.c cVarM = com.mlmvpn.scanner.e.m("protocol", "vless", cVar3);
        cVarM.D(XrayCoreHostService.KEY_ID, xhttp.getUuid());
        cVarM.D("encryption", xhttp.getEncryption());
        cVar3.D("settings", mamiXrayConfig.vlessSettings(server, cVarM));
        cVar3.D("streamSettings", cVar);
        return cVar3;
    }

    private final sf.c xhttpSettings(MamiCatalog.XhttpTransport xhttpTransport) {
        sf.c cVar = new sf.c();
        cVar.D("path", xhttpTransport.getPath());
        String mode = xhttpTransport.getMode();
        if (mode.length() == 0) {
            mode = "auto";
        }
        cVar.D("mode", mode);
        opt(cVar, "host", xhttpTransport.getHost());
        opt(cVar, "xPaddingBytes", xhttpTransport.getPaddingBytes());
        opt(cVar, "sessionIDLength", xhttpTransport.getSessionIDLength());
        opt(cVar, "sessionIDTable", xhttpTransport.getSessionIDTable());
        opt(cVar, "scMaxEachPostBytes", xhttpTransport.getMaxPostBytes());
        opt(cVar, "scMinPostsIntervalMs", xhttpTransport.getMinPostInterval());
        MamiCatalog.Xmux xmux = xhttpTransport.getXmux();
        if (xmux != null) {
            sf.c cVar2 = new sf.c();
            MamiXrayConfig mamiXrayConfig = INSTANCE;
            mamiXrayConfig.opt(cVar2, "maxConcurrency", xmux.getMaxConcurrency());
            mamiXrayConfig.opt(cVar2, "maxConnections", xmux.getMaxConnections());
            mamiXrayConfig.opt(cVar2, "cMaxReuseTimes", xmux.getCMaxReuseTimes());
            mamiXrayConfig.opt(cVar2, "hMaxRequestTimes", xmux.getHMaxRequestTimes());
            mamiXrayConfig.opt(cVar2, "hMaxReusableSecs", xmux.getHMaxReusableSecs());
            if (xmux.getHKeepAlivePeriod() > 0) {
                cVar2.D("hKeepAlivePeriod", Integer.valueOf(xmux.getHKeepAlivePeriod()));
            }
            if (cVar2.f67158a.size() > 0) {
                cVar.D("xmux", cVar2);
            }
        }
        return cVar;
    }

    public final sf.c configFor(sf.c outbound, int i, String listen, String logLevel) {
        j.e(outbound, "outbound");
        j.e(listen, "listen");
        j.e(logLevel, "logLevel");
        sf.c cVar = new sf.c();
        sf.c cVar2 = new sf.c();
        cVar2.D("loglevel", logLevel);
        cVar.D(XrayCoreHostService.KEY_LOG, cVar2);
        sf.a aVar = new sf.a();
        sf.c cVarO = i.o("tag", "mami-in");
        com.mlmvpn.scanner.e.q(i, PsiphonProbeService.PORT, "listen", listen, cVarO);
        cVarO.D("protocol", "socks");
        sf.c cVar3 = new sf.c();
        cVar3.E("udp", true);
        cVarO.D("settings", cVar3);
        aVar.put(cVarO);
        cVar.D("inbounds", aVar);
        sf.a aVar2 = new sf.a();
        aVar2.put(outbound);
        sf.c cVar4 = new sf.c();
        cVar4.D("tag", WarpIdRelay.VIA_DIRECT);
        sf.c cVarO2 = com.mlmvpn.scanner.e.o(cVar4, "protocol", "freedom", aVar2, cVar4);
        cVarO2.D("tag", "block");
        cVarO2.D("protocol", "blackhole");
        aVar2.put(cVarO2);
        cVar.D("outbounds", aVar2);
        sf.c cVar5 = new sf.c();
        sf.a aVarL = com.mlmvpn.scanner.e.l("domainStrategy", "AsIs", cVar5);
        sf.c cVarO3 = i.o(TeXSymbolParser.TYPE_ATTR, "field");
        sf.a aVar3 = new sf.a();
        aVar3.put("::/0");
        cVarO3.D("ip", aVar3);
        cVarO3.D("outboundTag", "block");
        aVarL.put(cVarO3);
        sf.c cVar6 = new sf.c();
        cVar6.D(TeXSymbolParser.TYPE_ATTR, "field");
        cVar6.D(StudioError.NETWORK, "udp");
        cVar6.D(PsiphonProbeService.PORT, "443");
        cVar6.D("outboundTag", "block");
        aVarL.put(cVar6);
        cVar5.D("rules", aVarL);
        cVar.D("routing", cVar5);
        return cVar;
    }

    public final String configJson(MamiCatalog.Server server, String tag, int i, String listen, String logLevel, boolean z10) {
        j.e(server, "server");
        j.e(tag, "tag");
        j.e(listen, "listen");
        j.e(logLevel, "logLevel");
        String json = server.getJson();
        if (json != null) {
            return json;
        }
        String string = configFor(outboundFor(server, tag, z10), i, listen, logLevel).toString();
        j.d(string, "toString(...)");
        return string;
    }

    public final String hexOfPin(String b64url) {
        j.e(b64url, "b64url");
        MamiJs mamiJs = MamiJs.INSTANCE;
        return mamiJs.hex(mamiJs.nodeBase64(b64url));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:25:0x006f  */
    /* JADX WARN: Code duplicated, block: B:27:0x0076  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final sf.c outboundFor(MamiCatalog.Server server, String tag, boolean z10) throws MamiConfigException {
        ee.e mamiXrayConfig$outboundFor$out$4;
        String strUnsupportedReason;
        j.e(server, "server");
        j.e(tag, "tag");
        String protocol = server.getProtocol();
        switch (protocol.hashCode()) {
            case -2104049249:
                if (protocol.equals("vless-grpc-reality")) {
                    mamiXrayConfig$outboundFor$out$4 = new MamiXrayConfig$outboundFor$out$4(this);
                    strUnsupportedReason = unsupportedReason(server, z10);
                    if (strUnsupportedReason == null) {
                        return (sf.c) mamiXrayConfig$outboundFor$out$4.invoke(server, tag);
                    }
                    throw new MamiConfigException(strUnsupportedReason);
                }
                throw new MamiConfigException(v0.a.h("پروتکل این سرور پشتیبانی نمی\u200cشود: ", server.getProtocol()));
            case -865292602:
                if (protocol.equals("trojan")) {
                    mamiXrayConfig$outboundFor$out$4 = new MamiXrayConfig$outboundFor$out$1(this);
                    strUnsupportedReason = unsupportedReason(server, z10);
                    if (strUnsupportedReason == null) {
                        return (sf.c) mamiXrayConfig$outboundFor$out$4.invoke(server, tag);
                    }
                    throw new MamiConfigException(strUnsupportedReason);
                }
                throw new MamiConfigException(v0.a.h("پروتکل این سرور پشتیبانی نمی\u200cشود: ", server.getProtocol()));
            case -463551909:
                if (protocol.equals("hysteria2")) {
                    mamiXrayConfig$outboundFor$out$4 = new MamiXrayConfig$outboundFor$out$5(this);
                    strUnsupportedReason = unsupportedReason(server, z10);
                    if (strUnsupportedReason == null) {
                        return (sf.c) mamiXrayConfig$outboundFor$out$4.invoke(server, tag);
                    }
                    throw new MamiConfigException(strUnsupportedReason);
                }
                throw new MamiConfigException(v0.a.h("پروتکل این سرور پشتیبانی نمی\u200cشود: ", server.getProtocol()));
            case -259010366:
                if (protocol.equals("vless-xhttp")) {
                    mamiXrayConfig$outboundFor$out$4 = new MamiXrayConfig$outboundFor$out$2(this);
                    strUnsupportedReason = unsupportedReason(server, z10);
                    if (strUnsupportedReason == null) {
                        return (sf.c) mamiXrayConfig$outboundFor$out$4.invoke(server, tag);
                    }
                    throw new MamiConfigException(strUnsupportedReason);
                }
                throw new MamiConfigException(v0.a.h("پروتکل این سرور پشتیبانی نمی\u200cشود: ", server.getProtocol()));
            case 112293647:
                if (protocol.equals("vless")) {
                    mamiXrayConfig$outboundFor$out$4 = new MamiXrayConfig$outboundFor$out$6(this);
                    strUnsupportedReason = unsupportedReason(server, z10);
                    if (strUnsupportedReason == null) {
                        return (sf.c) mamiXrayConfig$outboundFor$out$4.invoke(server, tag);
                    }
                    throw new MamiConfigException(strUnsupportedReason);
                }
                throw new MamiConfigException(v0.a.h("پروتکل این سرور پشتیبانی نمی\u200cشود: ", server.getProtocol()));
            case 228052973:
                if (protocol.equals("vless-raw-reality")) {
                    mamiXrayConfig$outboundFor$out$4 = new MamiXrayConfig$outboundFor$out$3(this);
                    strUnsupportedReason = unsupportedReason(server, z10);
                    if (strUnsupportedReason == null) {
                        return (sf.c) mamiXrayConfig$outboundFor$out$4.invoke(server, tag);
                    }
                    throw new MamiConfigException(strUnsupportedReason);
                }
                throw new MamiConfigException(v0.a.h("پروتکل این سرور پشتیبانی نمی\u200cشود: ", server.getProtocol()));
            default:
                throw new MamiConfigException(v0.a.h("پروتکل این سرور پشتیبانی نمی\u200cشود: ", server.getProtocol()));
        }
    }

    public final String unsupportedReason(MamiCatalog.Server server, boolean z10) {
        if (!z10 && server != null && j.a(server.getProtocol(), "hysteria2")) {
            MamiCatalog.Hysteria2 hysteria2 = server.getHysteria2();
            if (j.a(hysteria2 != null ? hysteria2.getObfs() : null, "gecko")) {
                return "پوشش gecko را Xray این برنامه ندارد";
            }
        }
        return null;
    }
}
