package com.peeoner174.msi.oneapril2.dzen.data.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import com.peeoner174.msi.oneapril2.dzen.data.db.dao.GalleryDao;
import com.peeoner174.msi.oneapril2.dzen.data.db.dao.GalleryDao_Impl;
import com.peeoner174.msi.oneapril2.dzen.data.db.dao.TripDao;
import com.peeoner174.msi.oneapril2.dzen.data.db.dao.TripDao_Impl;
import com.peeoner174.msi.oneapril2.dzen.data.db.dao.UserDao;
import com.peeoner174.msi.oneapril2.dzen.data.db.dao.UserDao_Impl;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.HashSet;

public class AppDatabase_Impl extends AppDatabase {
  private volatile TripDao _tripDao;

  private volatile GalleryDao _galleryDao;

  private volatile UserDao _userDao;

  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(4) {
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `trips` (`id` TEXT NOT NULL, `title` TEXT NOT NULL, `place` TEXT NOT NULL, `date` TEXT NOT NULL, `notes` TEXT NOT NULL, `photo` TEXT NOT NULL, `user_image` TEXT NOT NULL, `photo_gallery` TEXT NOT NULL, `user_name` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `gallery` (`name` TEXT NOT NULL, `url` TEXT NOT NULL, PRIMARY KEY(`url`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `users` (`id` TEXT NOT NULL, `full_name` TEXT NOT NULL, `phone` TEXT NOT NULL, `email` TEXT NOT NULL, `website` TEXT NOT NULL, `city` TEXT NOT NULL, `main_photo` TEXT NOT NULL, `avatar` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"56b0bb899856e05d0db24506e759d168\")");
      }

      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `trips`");
        _db.execSQL("DROP TABLE IF EXISTS `gallery`");
        _db.execSQL("DROP TABLE IF EXISTS `users`");
      }

      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsTrips = new HashMap<String, TableInfo.Column>(9);
        _columnsTrips.put("id", new TableInfo.Column("id", "TEXT", true, 1));
        _columnsTrips.put("title", new TableInfo.Column("title", "TEXT", true, 0));
        _columnsTrips.put("place", new TableInfo.Column("place", "TEXT", true, 0));
        _columnsTrips.put("date", new TableInfo.Column("date", "TEXT", true, 0));
        _columnsTrips.put("notes", new TableInfo.Column("notes", "TEXT", true, 0));
        _columnsTrips.put("photo", new TableInfo.Column("photo", "TEXT", true, 0));
        _columnsTrips.put("user_image", new TableInfo.Column("user_image", "TEXT", true, 0));
        _columnsTrips.put("photo_gallery", new TableInfo.Column("photo_gallery", "TEXT", true, 0));
        _columnsTrips.put("user_name", new TableInfo.Column("user_name", "TEXT", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTrips = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTrips = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTrips = new TableInfo("trips", _columnsTrips, _foreignKeysTrips, _indicesTrips);
        final TableInfo _existingTrips = TableInfo.read(_db, "trips");
        if (! _infoTrips.equals(_existingTrips)) {
          throw new IllegalStateException("Migration didn't properly handle trips(com.peeoner174.msi.oneapril2.dzen.data.model.Trip).\n"
                  + " Expected:\n" + _infoTrips + "\n"
                  + " Found:\n" + _existingTrips);
        }
        final HashMap<String, TableInfo.Column> _columnsGallery = new HashMap<String, TableInfo.Column>(2);
        _columnsGallery.put("name", new TableInfo.Column("name", "TEXT", true, 0));
        _columnsGallery.put("url", new TableInfo.Column("url", "TEXT", true, 1));
        final HashSet<TableInfo.ForeignKey> _foreignKeysGallery = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesGallery = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoGallery = new TableInfo("gallery", _columnsGallery, _foreignKeysGallery, _indicesGallery);
        final TableInfo _existingGallery = TableInfo.read(_db, "gallery");
        if (! _infoGallery.equals(_existingGallery)) {
          throw new IllegalStateException("Migration didn't properly handle gallery(com.peeoner174.msi.oneapril2.dzen.data.model.Gallery).\n"
                  + " Expected:\n" + _infoGallery + "\n"
                  + " Found:\n" + _existingGallery);
        }
        final HashMap<String, TableInfo.Column> _columnsUsers = new HashMap<String, TableInfo.Column>(8);
        _columnsUsers.put("id", new TableInfo.Column("id", "TEXT", true, 1));
        _columnsUsers.put("full_name", new TableInfo.Column("full_name", "TEXT", true, 0));
        _columnsUsers.put("phone", new TableInfo.Column("phone", "TEXT", true, 0));
        _columnsUsers.put("email", new TableInfo.Column("email", "TEXT", true, 0));
        _columnsUsers.put("website", new TableInfo.Column("website", "TEXT", true, 0));
        _columnsUsers.put("city", new TableInfo.Column("city", "TEXT", true, 0));
        _columnsUsers.put("main_photo", new TableInfo.Column("main_photo", "TEXT", true, 0));
        _columnsUsers.put("avatar", new TableInfo.Column("avatar", "TEXT", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUsers = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUsers = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUsers = new TableInfo("users", _columnsUsers, _foreignKeysUsers, _indicesUsers);
        final TableInfo _existingUsers = TableInfo.read(_db, "users");
        if (! _infoUsers.equals(_existingUsers)) {
          throw new IllegalStateException("Migration didn't properly handle users(com.peeoner174.msi.oneapril2.dzen.data.model.User).\n"
                  + " Expected:\n" + _infoUsers + "\n"
                  + " Found:\n" + _existingUsers);
        }
      }
    }, "56b0bb899856e05d0db24506e759d168");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "trips","gallery","users");
  }

  @Override
  public TripDao tripDao() {
    if (_tripDao != null) {
      return _tripDao;
    } else {
      synchronized(this) {
        if(_tripDao == null) {
          _tripDao = new TripDao_Impl(this);
        }
        return _tripDao;
      }
    }
  }

  @Override
  public GalleryDao galleryDao() {
    if (_galleryDao != null) {
      return _galleryDao;
    } else {
      synchronized(this) {
        if(_galleryDao == null) {
          _galleryDao = new GalleryDao_Impl(this);
        }
        return _galleryDao;
      }
    }
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }
}
