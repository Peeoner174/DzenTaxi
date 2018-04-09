package com.peeoner174.msi.oneapril2.dzen.data.db;

import java.lang.System;

/**
 * \u041e\u0441\u043d\u043e\u0432\u043d\u043e\u0439 \u043a\u043b\u0430\u0441\u0441 \u043f\u043e \u0440\u0430\u0431\u043e\u0442\u0435 \u0441 \u0411\u0414
 * * [entities] - \u043a\u0430\u043a\u0438\u0435 \u0442\u0430\u0431\u043b\u0438\u0446\u044b \u0431\u0443\u0434\u0443\u0442 \u0432 \u0431\u0443\u0434\u0443\u0442 \u0432 \u0411\u0414
 * * [version] - \u0432\u0435\u0440\u0441\u0438\u044f \u0431\u0430\u0437\u044b
 * * 
 */
@android.arch.persistence.room.Database(entities = {com.peeoner174.msi.oneapril2.dzen.data.model.Trip.class, com.peeoner174.msi.oneapril2.dzen.data.model.Gallery.class, com.peeoner174.msi.oneapril2.dzen.data.model.User.class}, version = 4)
@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/peeoner174/msi/oneapril2/dzen/data/db/AppDatabase;", "Landroid/arch/persistence/room/RoomDatabase;", "()V", "galleryDao", "Lcom/peeoner174/msi/oneapril2/dzen/data/db/dao/GalleryDao;", "tripDao", "Lcom/peeoner174/msi/oneapril2/dzen/data/db/dao/TripDao;", "userDao", "Lcom/peeoner174/msi/oneapril2/dzen/data/db/dao/UserDao;", "app_debug"})
public abstract class AppDatabase extends android.arch.persistence.room.RoomDatabase {
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.peeoner174.msi.oneapril2.dzen.data.db.dao.TripDao tripDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.peeoner174.msi.oneapril2.dzen.data.db.dao.GalleryDao galleryDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.peeoner174.msi.oneapril2.dzen.data.db.dao.UserDao userDao();
    
    public AppDatabase() {
        super();
    }
}