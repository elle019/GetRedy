package com.example.testing_loading_screen.database_manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseManager extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "getredy_db";
    public static final int DATABASE_VERSION = 6;

    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(GetRedyContract.SQL_CREATE_USERS_TABLE);
        db.execSQL(GetRedyContract.SQL_INSERT_USER);
        db.execSQL(GetRedyContract.SQL_CREATE_TASKS_TABLE);
        db.execSQL(GetRedyContract.SQL_CREATE_CHARACTERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(GetRedyContract.SQL_DROP_USERS_TABLE);
        db.execSQL(GetRedyContract.SQL_DROP_TASKS_TABLE);
        onCreate(db);
    }

    public void addAccumulatedTime(int time) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("UPDATE " + GetRedyContract.Users.TABLE_NAME + " SET " + GetRedyContract.Users.COLUMN_NAME_ACCUMULATED_TIME + " = " + GetRedyContract.Users.COLUMN_NAME_ACCUMULATED_TIME + " + " + time + " WHERE " + GetRedyContract.Users._ID + " = 1");
    }
}
