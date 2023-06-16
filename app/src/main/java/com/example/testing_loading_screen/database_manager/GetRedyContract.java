package com.example.testing_loading_screen.database_manager;

import android.provider.BaseColumns;

public final class GetRedyContract {
    private GetRedyContract() {}

    public static class Users implements BaseColumns {
        public static final String TABLE_NAME = "users";
        public static final String COLUMN_NAME_PASSWORD = "password";
        public static final String COLUMN_NAME_COINS = "coins";
        public static final String COLUMN_NAME_ACCUMULATED_TIME = "accumulated_time";
    }

    public static class Tasks implements BaseColumns {
        public static final String TABLE_NAME = "tasks";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_IS_DONE = "is_done";
    }

    public static class Characters implements BaseColumns {
        public static final String TABLE_NAME = "characters";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_CHARACTER_DRAWABLE = "character_drawable";
        public static final String COLUMN_NAME_PRICE = "price";
        public static final String COLUMN_NAME_IS_COLLECTED = "is_collected";
        public static final String COLUMN_NAME_REQUIRED_TIME = "required_time";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
    }

    // SQLs
    public static final String SQL_CREATE_USERS_TABLE = "CREATE TABLE " + Users.TABLE_NAME + " (" +
            Users._ID + " INTEGER PRIMARY KEY," +
            Users.COLUMN_NAME_PASSWORD + " TEXT," +
            Users.COLUMN_NAME_COINS + " INTEGER," +
            Users.COLUMN_NAME_ACCUMULATED_TIME + " INTEGER)";

    public static final String SQL_CREATE_TASKS_TABLE = "CREATE TABLE " + Tasks.TABLE_NAME + " (" +
            Tasks._ID + " INTEGER PRIMARY KEY, " +
            Tasks.COLUMN_NAME_NAME + " TEXT, " +
            Tasks.COLUMN_NAME_IS_DONE + " NUMERIC)";

    public static final String SQL_CREATE_CHARACTERS_TABLE = "CREATE TABLE " + Characters.TABLE_NAME + " (" +
            Characters._ID + " INTEGER PRIMARY KEY, " +
            Characters.COLUMN_NAME_NAME + " TEXT, " +
            Characters.COLUMN_NAME_CHARACTER_DRAWABLE + " TEXT, " +
            Characters.COLUMN_NAME_PRICE + " INTEGER, " +
            Characters.COLUMN_NAME_IS_COLLECTED + " NUMERIC, " +
            Characters.COLUMN_NAME_REQUIRED_TIME + " INTEGER, " +
            Characters.COLUMN_NAME_DESCRIPTION + " TEXT)";

    public static final String SQL_INSERT_USER = "INSERT INTO " + Users.TABLE_NAME + " VALUES (1, '', 0, 0);";

    public static final String SQL_DROP_USERS_TABLE = "DROP TABLE IF EXISTS " + Users.TABLE_NAME + ";";
    public static final String SQL_DROP_TASKS_TABLE = "DROP TABLE IF EXISTS " + Tasks.TABLE_NAME + ";";
}
