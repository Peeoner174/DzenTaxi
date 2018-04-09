package com.peeoner174.msi.oneapril2.dzen.producer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0014\u0010\u000b\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u0004J\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00042\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/peeoner174/msi/oneapril2/dzen/producer/TripDataLoaderWeb;", "", "()V", "loadToCashe", "Lkotlinx/coroutines/experimental/Deferred;", "", "app", "Lcom/peeoner174/msi/oneapril2/App;", "trips", "", "Lcom/peeoner174/msi/oneapril2/dzen/data/model/Trip;", "loadTrip", "Lcom/peeoner174/msi/oneapril2/dzen/data/model/Trip$List;", "kotlin.jvm.PlatformType", "loadTripFromCache", "app_debug"})
public final class TripDataLoaderWeb {
    
    /**
     * async(CommonPool) - \u043a\u0430\u0440\u0443\u0442\u0438\u043d\u0430 \u0441\u043e\u0437\u0434\u0430\u0451\u0442 background-\u043f\u043e\u0442\u043e\u043a
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.experimental.Deferred<com.peeoner174.msi.oneapril2.dzen.data.model.Trip.List> loadTrip() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.experimental.Deferred<java.util.List<com.peeoner174.msi.oneapril2.dzen.data.model.Trip>> loadTripFromCache(@org.jetbrains.annotations.NotNull()
    com.peeoner174.msi.oneapril2.App app) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.experimental.Deferred<kotlin.Unit> loadToCashe(@org.jetbrains.annotations.NotNull()
    com.peeoner174.msi.oneapril2.App app, @org.jetbrains.annotations.NotNull()
    java.util.List<com.peeoner174.msi.oneapril2.dzen.data.model.Trip> trips) {
        return null;
    }
    
    public TripDataLoaderWeb() {
        super();
    }
}