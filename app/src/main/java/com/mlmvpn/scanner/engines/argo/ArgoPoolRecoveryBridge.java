package com.mlmvpn.scanner.engines.argo;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BooleanSupplier;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public final class ArgoPoolRecoveryBridge {
    private ArgoPoolRecoveryBridge() {}

    public static List<ArgoProtocol.Endpoint> candidates(String selectedId, String rawConfig) {
        ArgoPool pool = ArgoPool.INSTANCE;
        if (rawConfig != null && !rawConfig.trim().isEmpty()) {
            return Collections.singletonList(pool.endpointFromRaw(rawConfig));
        }
        if (selectedId != null && !selectedId.trim().isEmpty()) {
            ArgoProtocol.Endpoint selected = pool.get(selectedId);
            if (selected == null) throw new IllegalStateException("این مورد در فهرست نیست");
            return Collections.singletonList(selected);
        }
        return pool.pick(3);
    }

    public static void recordFailed(ArgoProtocol.Endpoint endpoint, String message) {
        ArgoPool.INSTANCE.record(endpoint.getId(), false, 0L, "", "", message, false, "");
    }

    public static ArgoPool.Page telegramPage(ArgoPool pool, String channel, Long beforeId, ArgoNet.Route route)
            throws UnsupportedEncodingException {
        return pool.telegramPage(channel, beforeId, route);
    }

    public static int absorbText(ArgoPool pool, String text, String sourceId, long at) {
        ArgoPool.Absorbed absorbed = pool.absorbText(text, sourceId, at, false, false);
        return absorbed.getBridges() + absorbed.getFalcons();
    }

    public static String sourceId(ArgoPool.Source source) {
        return source.getId();
    }

    public static String sourceChannel(ArgoPool.Source source) {
        List<String> value = source.getValue();
        return value == null || value.isEmpty() ? null : value.get(value.size() - 1);
    }

    public static Object recoverTelegramPageRetry(
            ArgoPool pool, String channel, Long beforeId, ArgoNet.Route route,
            ee.a stop, wd.d continuation) {
        BooleanSupplier shouldStop = () -> Boolean.TRUE.equals(stop.invoke());
        return ArgoTelegramRecoveryKt.recoverTelegramPageRetry(
                pool, channel, beforeId, route, shouldStop, (Continuation) continuation);
    }

    public static Object recoverHarvestTelegram(
            ArgoPool pool, ArgoPool.Source source, int maxPages, ArgoNet.Route route,
            ee.e progress, ee.a stop, wd.d continuation) {
        BooleanSupplier shouldStop = () -> Boolean.TRUE.equals(stop.invoke());
        BiConsumer<Integer, Integer> onProgress = (page, total) -> {
            progress.invoke(page, total);
        };
        return ArgoTelegramRecoveryKt.recoverHarvestTelegram(
                pool, source, maxPages, route, onProgress, shouldStop, (Continuation) continuation);
    }
}