package com.donota.donotamobileapp.database.impl;

import static com.donota.donotamobileapp.utils.DbUtils.COL_CUSTOMER_EMAIL;
import static com.donota.donotamobileapp.utils.DbUtils.DB_NAME;
import static com.donota.donotamobileapp.utils.DbUtils.COL_CUSTOMER_ACCOUNT;
import static com.donota.donotamobileapp.utils.DbUtils.COL_CUSTOMER_ACCOUNT_PASSWORD;
import static com.donota.donotamobileapp.utils.DbUtils.COL_CUSTOMER_DOB;
import static com.donota.donotamobileapp.utils.DbUtils.COL_CUSTOMER_ID;
import static com.donota.donotamobileapp.utils.DbUtils.COL_CUSTOMER_NAME;
import static com.donota.donotamobileapp.utils.DbUtils.COL_CUSTOMER_PHONENUMB;
import static com.donota.donotamobileapp.utils.DbUtils.COL_CUSTOMER_PURCHASE_HISTORY;
import static com.donota.donotamobileapp.utils.DbUtils.DB_VERSION;
import static com.donota.donotamobileapp.utils.DbUtils.TBL_CUSTOMER_PROFILE;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.donota.donotamobileapp.database.Databases;

public class TbCustomerProfileImpl extends SQLiteOpenHelper implements Databases {


    public TbCustomerProfileImpl(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = " CREATE TABLE IF NOT EXISTS " + TBL_CUSTOMER_PROFILE  + "  (" + COL_CUSTOMER_ID + "INTERGER PRIMARY KEY ASC ON CONFLICT ROLLBACK AUTOINCREMENT NOT NULL UNIQUE, "
                + COL_CUSTOMER_NAME + " TEXT NOT NULL,  " + COL_CUSTOMER_PHONENUMB + " INTERGER NOT NULL UNIQUE, " + COL_CUSTOMER_PURCHASE_HISTORY
                + " TEXT, " + COL_CUSTOMER_ACCOUNT + " TEXT UNIQUE , " + COL_CUSTOMER_ACCOUNT_PASSWORD + "TEXT, "  + COL_CUSTOMER_DOB + " INTEGER, " + COL_CUSTOMER_EMAIL + " TEXT UNIQUE NOT NULL)";
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
