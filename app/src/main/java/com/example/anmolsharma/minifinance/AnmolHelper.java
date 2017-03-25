package com.example.anmolsharma.minifinance;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class AnmolHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "customersdb";
    private static final String TABLE_NAME="CUSTOMERS_FINAL_TABLE";
    private static final int DATABASE_VERSION = 2;


    public static final String COL1 = "ID";
    public static final String COL2 = "NAME";
    public static final String COL3 = "ENROLLMENT_NO";
    public static final String COL4 = "PASSWORD";
    public static final String COL5 = "ADDRESS";
    public static final String COL6 = "PHONE_NO";
    public static final String COL7 = "LOAN_AMOUNT";
    // Database creation sql statement
   private static final String DATABASE_CREATE = "CREATE TABLE " + TABLE_NAME + " (" + COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL2 + " INTEGER," + COL3 + " TEXT NOT NULL," + COL4 + " TEXT NOT NULL," + COL5 + " INTEGER," + COL6 + " INTEGER," + COL7 + "TEXT NOT NULL);";

    public AnmolHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Method is called during creation of the database
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    // Method is called during an upgrade of the database,
    @Override
    public void onUpgrade(SQLiteDatabase database,int oldVersion,int newVersion){
        Log.w(AnmolHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS" + DATABASE_NAME);
        onCreate(database);
    }


}