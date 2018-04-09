package com.peeoner174.msi.oneapril2.dzen.data.db.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import com.peeoner174.msi.oneapril2.dzen.data.model.User;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfUser;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  public UserDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUser = new EntityInsertionAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `users`(`id`,`full_name`,`phone`,`email`,`website`,`city`,`main_photo`,`avatar`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getFull_name() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFull_name());
        }
        if (value.getPhone() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPhone());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getEmail());
        }
        if (value.getWebsite() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getWebsite());
        }
        if (value.getCity() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getCity());
        }
        if (value.getMain_photo() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getMain_photo());
        }
        if (value.getAvatar() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getAvatar());
        }
      }
    };
    this.__updateAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `users` SET `id` = ?,`full_name` = ?,`phone` = ?,`email` = ?,`website` = ?,`city` = ?,`main_photo` = ?,`avatar` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getFull_name() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFull_name());
        }
        if (value.getPhone() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPhone());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getEmail());
        }
        if (value.getWebsite() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getWebsite());
        }
        if (value.getCity() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getCity());
        }
        if (value.getMain_photo() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getMain_photo());
        }
        if (value.getAvatar() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getAvatar());
        }
        if (value.getId() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getId());
        }
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM users";
        return _query;
      }
    };
  }

  @Override
  public void insertAll(List<User> trips) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser.insert(trips);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(List<User> posts) {
    __db.beginTransaction();
    try {
      __updateAdapterOfUser.handleMultiple(posts);
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
  public List<User> getAll() {
    final String _sql = "SELECT * FROM users";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfFullName = _cursor.getColumnIndexOrThrow("full_name");
      final int _cursorIndexOfPhone = _cursor.getColumnIndexOrThrow("phone");
      final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("email");
      final int _cursorIndexOfWebsite = _cursor.getColumnIndexOrThrow("website");
      final int _cursorIndexOfCity = _cursor.getColumnIndexOrThrow("city");
      final int _cursorIndexOfMainPhoto = _cursor.getColumnIndexOrThrow("main_photo");
      final int _cursorIndexOfAvatar = _cursor.getColumnIndexOrThrow("avatar");
      final List<User> _result = new ArrayList<User>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final User _item;
        final String _tmpId;
        _tmpId = _cursor.getString(_cursorIndexOfId);
        final String _tmpFull_name;
        _tmpFull_name = _cursor.getString(_cursorIndexOfFullName);
        final String _tmpPhone;
        _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        final String _tmpWebsite;
        _tmpWebsite = _cursor.getString(_cursorIndexOfWebsite);
        final String _tmpCity;
        _tmpCity = _cursor.getString(_cursorIndexOfCity);
        final String _tmpMain_photo;
        _tmpMain_photo = _cursor.getString(_cursorIndexOfMainPhoto);
        final String _tmpAvatar;
        _tmpAvatar = _cursor.getString(_cursorIndexOfAvatar);
        _item = new User(_tmpId,_tmpFull_name,_tmpPhone,_tmpEmail,_tmpWebsite,_tmpCity,_tmpMain_photo,_tmpAvatar);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
