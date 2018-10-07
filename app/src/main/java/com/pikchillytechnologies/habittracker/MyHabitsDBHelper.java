package com.pikchillytechnologies.habittracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyHabitsDBHelper extends SQLiteOpenHelper {

    // Database Name
    private static final String DATABASE_NAME = "MyTracker.db";
    private static final int DATABASE_VERSION = 1;

    public MyHabitsDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Create Table
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE_TRACKING_DIARY = "CREATE TABLE " + Contract.HabitEntry.TABLE_NAME +
                "(" + Contract.HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                Contract.HabitEntry.COLUMN_DATE + " TEXT NOT NULL," +
                Contract.HabitEntry.COLUMN_DURATION + " INTEGER NOT NULL," +
                Contract.HabitEntry.COLUMN_HABIT + " TEXT NOT NULL," +
                Contract.HabitEntry.COLUMN_COMMENT + " TEXT);";
        Log.v("HabitDbHelper", "create table: " + CREATE_TABLE_TRACKING_DIARY);
        sqLiteDatabase.execSQL(CREATE_TABLE_TRACKING_DIARY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Contract.HabitEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    // Insert Habit in Database
    public void insertHabit(String date, Integer duration, String habit, String comment) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Contract.HabitEntry.COLUMN_DATE, date);
        values.put(Contract.HabitEntry.COLUMN_DURATION, duration);
        values.put(Contract.HabitEntry.COLUMN_HABIT, habit);
        values.put(Contract.HabitEntry.COLUMN_COMMENT, comment);
        db.insert(Contract.HabitEntry.TABLE_NAME, null, values);
    }

    // Read Habits from database
    public Cursor readHabits() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                Contract.HabitEntry._ID,
                Contract.HabitEntry.COLUMN_DATE,
                Contract.HabitEntry.COLUMN_DURATION,
                Contract.HabitEntry.COLUMN_HABIT,
                Contract.HabitEntry.COLUMN_COMMENT
        };
        Cursor cursor = db.query(
                Contract.HabitEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        return cursor;
    }
}
