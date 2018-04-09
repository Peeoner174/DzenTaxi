package com.peeoner174.msi.oneapril2.dzen.data.db.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import com.peeoner174.msi.oneapril2.dzen.data.model.Gallery;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public class GalleryDao_Impl implements GalleryDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfGallery;

  private final EntityInsertionAdapter __insertionAdapterOfGallery_1;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfGallery;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  public GalleryDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfGallery = new EntityInsertionAdapter<Gallery>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `gallery`(`name`,`url`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Gallery value) {
        if (value.getName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getName());
        }
        if (value.getUrl() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUrl());
        }
      }
    };
    this.__insertionAdapterOfGallery_1 = new EntityInsertionAdapter<Gallery>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `gallery`(`name`,`url`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Gallery value) {
        if (value.getName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getName());
        }
        if (value.getUrl() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUrl());
        }
      }
    };
    this.__updateAdapterOfGallery = new EntityDeletionOrUpdateAdapter<Gallery>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `gallery` SET `name` = ?,`url` = ? WHERE `url` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Gallery value) {
        if (value.getName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getName());
        }
        if (value.getUrl() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUrl());
        }
        if (value.getUrl() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getUrl());
        }
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM gallery";
        return _query;
      }
    };
  }

  @Override
  public void insert(Gallery gallery) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfGallery.insert(gallery);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAll(List<Gallery> gallery) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfGallery_1.insert(gallery);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(List<Gallery> gallery) {
    __db.beginTransaction();
    try {
      __updateAdapterOfGallery.handleMultiple(gallery);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDelete.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDelete.release(_stmt);
    }
  }

  @Override
  public List<Gallery> getAll() {
    final String _sql = "SELECT * FROM gallery";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfUrl = _cursor.getColumnIndexOrThrow("url");
      final List<Gallery> _result = new ArrayList<Gallery>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Gallery _item;
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpUrl;
        _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
        _item = new Gallery(_tmpName,_tmpUrl);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
