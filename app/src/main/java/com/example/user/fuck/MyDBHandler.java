package com.example.user.fuck;

/**
 * Created by user on 2017-12-06.
 */

import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "musicalDB.db";
    public static final String TABLE_MUSICALS = "musicals";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_MUSICALNAME = "musicalname";
    public static final String COLUMN_SUMMARY = "summary";

    public MyDBHandler(Context context, String name,
                       SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_MUSICALS_TABLE = "CREATE TABLE " +
                TABLE_MUSICALS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_MUSICALNAME
                + " TEXT," + COLUMN_SUMMARY + " TEXT" + ")";
        db.execSQL(CREATE_MUSICALS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MUSICALS);
        onCreate(db);
    }

    public void addMusical(Musical musical) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_MUSICALNAME, musical.getMusicalName());
        values.put(COLUMN_SUMMARY, musical.getSummary());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_MUSICALS, null, values);
        db.close();
    }

    public Musical findMusical(String musicalname) {
        String query = "SELECT * FROM " + TABLE_MUSICALS + " WHERE " +
                COLUMN_MUSICALNAME + " = \"" + musicalname + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Musical musical = new Musical();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            musical.setID(Integer.parseInt(cursor.getString(0)));
            musical.setMusicalName(cursor.getString(1));
            musical.setSummary(cursor.getString(2));
            cursor.close();
        } else {
            musical = null;
        }
        db.close();
        return musical;
    }

    public boolean deleteMusical(String musicalname) {
        boolean result = false;
        String query = "SELECT * FROM " + TABLE_MUSICALS + " WHERE " +
                COLUMN_MUSICALNAME + " = \"" + musicalname + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Musical musical = new Musical();

        if (cursor.moveToFirst()) {
            musical.setID(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_MUSICALS, COLUMN_ID + " = ?",
                    new String[]{String.valueOf(musical.getID())});
            cursor.close();
            result = true;
        }
        db.close();

        return result;
    }
}




