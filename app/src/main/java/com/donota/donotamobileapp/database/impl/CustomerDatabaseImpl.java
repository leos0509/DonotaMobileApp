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

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.donota.donotamobileapp.database.Databases;

public class CustomerDatabaseImpl extends SQLiteOpenHelper implements Databases {
    public static final int DB_VERSION = 1;

    public CustomerDatabaseImpl(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = " CREATE TABLE IF NOT EXISTS " + TBL_CUSTOMER_PROFILE  + "  (" + COL_CUSTOMER_ID + " TEXT PRIMARY KEY NOT NULL UNIQUE, " + COL_CUSTOMER_NAME +
                " TEXT NOT NULL,  " + COL_CUSTOMER_PHONENUMB + " INTERGER NOT NULL UNIQUE, " + COL_CUSTOMER_ADDRESS + "  TEXT, " + COL_CUSTOMER_PURCHASE_HISTORY
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
}
