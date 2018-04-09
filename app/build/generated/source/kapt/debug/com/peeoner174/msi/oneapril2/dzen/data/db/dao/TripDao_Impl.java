package com.peeoner174.msi.oneapril2.dzen.data.db.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import com.peeoner174.msi.oneapril2.dzen.data.model.Trip;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public class TripDao_Impl implements TripDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfTrip;

  private final EntityInsertionAdapter __insertionAdapterOfTrip_1;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfTrip;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  public TripDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTrip = new EntityInsertionAdapter<Trip>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `trips`(`id`,`title`,`place`,`date`,`notes`,`photo`,`user_image`,`photo_gallery`,`user_name`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Trip value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getPlace() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPlace());
        }
        if (value.getDate() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDate());
        }
        if (value.getNotes() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getNotes());
        }
        if (value.getPhoto() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPhoto());
        }
        if (value.getUser_image() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getUser_image());
        }
        if (value.getPhoto_gallery() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getPhoto_gallery());
        }
        if (value.getUser_name() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getUser_name());
        }
      }
    };
    this.__insertionAdapterOfTrip_1 = new EntityInsertionAdapter<Trip>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `trips`(`id`,`title`,`place`,`date`,`notes`,`photo`,`user_image`,`photo_gallery`,`user_name`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Trip value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getPlace() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPlace());
        }
        if (value.getDate() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDate());
        }
        if (value.getNotes() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getNotes());
        }
        if (value.getPhoto() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPhoto());
        }
        if (value.getUser_image() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getUser_image());
        }
        if (value.getPhoto_gallery() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getPhoto_gallery());
        }
        if (value.getUser_name() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getUser_name());
        }
      }
    };
    this.__updateAdapterOfTrip = new EntityDeletionOrUpdateAdapter<Trip>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `trips` SET `id` = ?,`title` = ?,`place` = ?,`date` = ?,`notes` = ?,`photo` = ?,`user_image` = ?,`photo_gallery` = ?,`user_name` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Trip value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getPlace() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPlace());
        }
        if (value.getDate() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDate());
        }
        if (value.getNotes() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getNotes());
        }
        if (value.getPhoto() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPhoto());
        }
        if (value.getUser_image() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getUser_image());
        }
        if (value.getPhoto_gallery() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getPhoto_gallery());
        }
        if (value.getUser_name() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getUser_name());
        }
        if (value.getId() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getId());
        }
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM trips";
        return _query;
      }
    };
  }

  @Override
  public void insert(Trip trip) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfTrip.insert(trip);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAll(List<Trip> trips) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfTrip_1.insert(trips);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(List<Trip> posts) {
    __db.beginTransaction();
    try {
      __updateAdapterOfTrip.handleMultiple(posts);
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
  public List<Trip> getAll() {
    final String _sql = "SELECT * FROM trips";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfTitle = _cursor.getColumnIndexOrThrow("title");
      final int _cursorIndexOfPlace = _cursor.getColumnIndexOrThrow("place");
      final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("date");
      final int _cursorIndexOfNotes = _cursor.getColumnIndexOrThrow("notes");
      final int _cursorIndexOfPhoto = _cursor.getColumnIndexOrThrow("photo");
      final int _cursorIndexOfUserImage = _cursor.getColumnIndexOrThrow("user_image");
      final int _cursorIndexOfPhotoGallery = _cursor.getColumnIndexOrThrow("photo_gallery");
      final int _cursorIndexOfUserName = _cursor.getColumnIndexOrThrow("user_name");
      final List<Trip> _result = new ArrayList<Trip>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Trip _item;
        final String _tmpId;
        _tmpId = _cursor.getString(_cursorIndexOfId);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final String _tmpPlace;
        _tmpPlace = _cursor.getString(_cursorIndexOfPlace);
        final String _tmpDate;
        _tmpDate = _cursor.getString(_cursorIndexOfDate);
        final String _tmpNotes;
        _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
        final String _tmpPhoto;
        _tmpPhoto = _cursor.getString(_cursorIndexOfPhoto);
        final String _tmpUser_image;
        _tmpUser_image = _cursor.getString(_cursorIndexOfUserImage);
        final String _tmpPhoto_gallery;
        _tmpPhoto_gallery = _cursor.getString(_cursorIndexOfPhotoGallery);
        final String _tmpUser_name;
        _tmpUser_name = _cursor.getString(_cursorIndexOfUserName);
        _item = new Trip(_tmpId,_tmpTitle,_tmpPlace,_tmpDate,_tmpNotes,_tmpPhoto,_tmpUser_image,_tmpPhoto_gallery,_tmpUser_name);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
