package com.example.anmolsharma.minifinance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.anmolsharma.minifinance.AnmolHelper;

public class MyDb{

    private AnmolHelper dbHelper;

    private SQLiteDatabase database;

    public final static String EMP_TABLE="MyCustomers"; // name of table

    public final static String CUSTOMER_ID="_id"; // id value for employee
    public final static String CUSTOMER_NAME="name";
    public final static String CUSTOMER_ENROLL_NO="enrollment_no";
    public final static String CUSTOMER_PASSWORD="password";
    public final static String CUSTOMER_ADDRESS="address";
    public final static String CUSTOMER_PHONE_NO="phone_no";
    public final static String CUSTOMER_LOAN_AMOUNT="loan_amount";
    // name of employee
    /**
     *
     * records kha karna
     *hn
     * @param context
     */
    public MyDb(Context context){
        dbHelper = new AnmolHelper(context);
        database = dbHelper.getWritableDatabase();
    }


    public boolean createRecords( String name, int enroll_no,String password,String address,int phone_no,int loan_amount){
        ContentValues values = new ContentValues();
        //values.put(CUSTOMER_ID, id);
        values.put(CUSTOMER_NAME, name);
        values.put(CUSTOMER_ENROLL_NO, enroll_no);
        values.put(CUSTOMER_PASSWORD, password);
        values.put(CUSTOMER_ADDRESS, address);
        values.put(CUSTOMER_PHONE_NO, phone_no);
        values.put(CUSTOMER_LOAN_AMOUNT, loan_amount);
        long result= database.insert(EMP_TABLE, null, values);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor selectRecords() {
        database=dbHelper.getReadableDatabase();
        String[] cols = new String[] {CUSTOMER_ID,CUSTOMER_NAME,CUSTOMER_ENROLL_NO,CUSTOMER_PASSWORD,CUSTOMER_ADDRESS,CUSTOMER_PHONE_NO,CUSTOMER_LOAN_AMOUNT};
       Cursor mCursor = database.query(true, EMP_TABLE,cols,null
                , null, null, null, null, null);
       // Cursor mCursor=dbHelper.rawQuery("select * from " + EMP_TABLE,null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor; // iterate to get each value.
    }
}