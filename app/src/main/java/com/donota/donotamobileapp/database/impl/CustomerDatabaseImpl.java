package com.donota.donotamobileapp.database.impl;

import static com.donota.donotamobileapp.utils.DbUtils.DB_NAME;
import static com.donota.donotamobileapp.utils.DbUtils.COL_CUSTOMER_ACCOUNT;
import static com.donota.donotamobileapp.utils.DbUtils.COL_CUSTOMER_ACCOUNT_PASSWORD;
import static com.donota.donotamobileapp.utils.DbUtils.COL_CUSTOMER_ADDRESS;
import static com.donota.donotamobileapp.utils.DbUtils.COL_CUSTOMER_CART;
import static com.donota.donotamobileapp.utils.DbUtils.COL_CUSTOMER_DOB;
import static com.donota.donotamobileapp.utils.DbUtils.COL_CUSTOMER_ID;
import static com.donota.donotamobileapp.utils.DbUtils.COL_CUSTOMER_NAME;
import static com.donota.donotamobileapp.utils.DbUtils.COL_CUSTOMER_PHONENUMB;
import static com.donota.donotamobileapp.utils.DbUtils.COL_CUSTOMER_PURCHASE_HISTORY;
import static com.donota.donotamobileapp.utils.DbUtils.COL_CUSTOMER_WISHLIST;
import static com.donota.donotamobileapp.utils.DbUtils.TBL_CUSTOMER_PROFILE;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.donota.donotamobileapp.database.Databases;
import com.donota.donotamobileapp.models.Customers;

public class CustomerDatabaseImpl extends SQLiteOpenHelper implements Databases {
    public static final int DB_VERSION = 1;
    public static final String TBL_CUSTOMER_PROFILE = "customerProfile";

    public static final String COL_CUSTOMER_ID = "customerId";
    public static final String COL_CUSTOMER_NAME = "customerName";
    public static final String COL_CUSTOMER_EMAIL = "customerEmail" ;
    public static final String COL_CUSTOMER_USERNAME = "customerUsername" ;
    public static final String COL_CUSTOMER_PHONENUMB = "customerPhoneNumb";
    public static final String COL_CUSTOMER_ADDRESS = "customerAddress";
    public static final String COL_CUSTOMER_PURCHASE_HISTORY = "customerPurchaseHistory";
    public static final String COL_CUSTOMER_ACCOUNT = "customerAccount";
    public static final String COL_CUSTOMER_ACCOUNT_PASSWORD = "customerPassword";
    public static final String COL_CUSTOMER_CART = "customerCart";
    public static final String COL_CUSTOMER_WISHLIST = "customerWishlist";
    public static final String COL_CUSTOMER_DOB = "customerDob";

    public CustomerDatabaseImpl(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = " CREATE TABLE IF NOT EXISTS " + TBL_CUSTOMER_PROFILE  + "  (" + COL_CUSTOMER_ID + " TEXT PRIMARY KEY NOT NULL UNIQUE, " + COL_CUSTOMER_NAME +
                " TEXT NOT NULL,  " + COL_CUSTOMER_EMAIL + " TEXT NOT NULL,  " + COL_CUSTOMER_USERNAME + " TEXT NOT NULL,  " + COL_CUSTOMER_PHONENUMB + " INTERGER NOT NULL UNIQUE, " + COL_CUSTOMER_ADDRESS + "  TEXT, " + COL_CUSTOMER_PURCHASE_HISTORY
                + " TEXT, " + COL_CUSTOMER_ACCOUNT + " TEXT UNIQUE , " + COL_CUSTOMER_ACCOUNT_PASSWORD + "TEXT, " + COL_CUSTOMER_CART + " TEXT, "
                + COL_CUSTOMER_WISHLIST + " TEXT, " + COL_CUSTOMER_DOB + " INTEGER)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TBL_CUSTOMER_PROFILE);
        onCreate(db);
    }

    @Override
    public Cursor queryData(String sql) {
        SQLiteDatabase db = getReadableDatabase();
        return (db.rawQuery(sql, null));
    }

    @Override
    public boolean execSql(String sql) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            db.execSQL(sql);
            return true;
        } catch (Exception e) {
            Log.e("Error", e.toString());
            return false;
        }
    }

    public void insertCustomer (Customers customer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_CUSTOMER_USERNAME, customer.getCustomerUsername());
        values.put(COL_CUSTOMER_EMAIL, customer.getCustomerEmail());
        values.put(COL_CUSTOMER_ACCOUNT_PASSWORD, customer.getCustomerPassword());
        db.insert(TBL_CUSTOMER_PROFILE,null,values);
    }

}
