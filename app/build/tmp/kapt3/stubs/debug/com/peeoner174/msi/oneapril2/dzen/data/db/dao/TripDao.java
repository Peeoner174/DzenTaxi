package com.peeoner174.msi.oneapril2.dzen.data.db.dao;

import java.lang.System;

@android.arch.persistence.room.Dao()
@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\'J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006H\'J\u0016\u0010\t\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\'J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\'\u00a8\u0006\r"}, d2 = {"Lcom/peeoner174/msi/oneapril2/dzen/data/db/dao/TripDao;", "", "delete", "", "getAll", "", "Lcom/peeoner174/msi/oneapril2/dzen/data/model/Trip;", "insert", "trip", "insertAll", "trips", "update", "posts", "app_debug"})
public abstract interface TripDao {
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * FROM trips")
    public abstract java.util.List<com.peeoner174.msi.oneapril2.dzen.data.model.Trip> getAll();
    
    @android.arch.persistence.room.Insert(onConflict = android.arch.persistence.room.OnConflictStrategy.REPLACE)
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.peeoner174.msi.oneapril2.dzen.data.model.Trip trip);
    
    @android.arch.persistence.room.Insert()
    public abstract void insertAll(@org.jetbrains.annotations.NotNull()
    java.util.List<com.peeoner174.msi.oneapril2.dzen.data.model.Trip> trips);
    
    @android.arch.persistence.room.Update()
    public abstract void update(@org.jetbrains.annotations.NotNull()
    java.util.List<com.peeoner174.msi.oneapril2.dzen.data.model.Trip> posts);
    
    @android.arch.persistence.room.Query(value = "DELETE FROM trips")
    public abstract void delete();
}