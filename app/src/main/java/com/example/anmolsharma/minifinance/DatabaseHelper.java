package com.example.anmolsharma.minifinance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by anmolsharma on 12/03/17.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Customer5.db";
    public static final String TABLE_NAME = "customer_table";
    public static final String COL1 = "ID";
    public static final String COL2 = "ENROLLMENT_ID";
    public static final String COL3 = "PASSWORD";
    public static final String COL4 = "ADDRESS";
    public static final String COL5 = "PHONE_NO";
    public static final String COL6 = "LONE_AMOUNT";
    public static final String COL7 = "NAME";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        //SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();//this line is to see our database
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

       // sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + " (" + COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL2 + " INTEGER, " + COL3 + " TEXT, " + COL4 + " TEXT, " + COL5 + " INTEGER, " + COL6 + " INTEGER, " + COL7 + " TEXT" + ");");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + " (" + COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL2 + " INTEGER, " + COL3 + " TEXT NOT NULL, " + COL4 + " TEXT NOT NULL, " + COL5 + " TEXT NOT NULL, " + COL6 + " INTEGER, " + COL7 + "TEXT NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

      /*  switch (i) {
            case 1:
                sqLiteDatabase.execSQL("ALTER TABLE " + TABLE_NAME + " ADD COLUMN INVENTORY TEXT");
                // intentionally fall through to other cases
        }*/
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertdata(int enroll_id, String password, String address, String ph_no, int lone_amt,String name) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(COL2,enroll_id);
        contentvalues.put(COL3,password);
        contentvalues.put(COL4,address);
        contentvalues.put(COL5,ph_no);
        contentvalues.put(COL6,lone_amt);
        contentvalues.put(COL7,name);
        long result = sqLiteDatabase.insert(TABLE_NAME, null, contentvalues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getalldata() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor res= sqLiteDatabase.rawQuery("select * from "+TABLE_NAME,null);
        if (res != null) {
            res.moveToFirst();
        }
        return res;
    }
}