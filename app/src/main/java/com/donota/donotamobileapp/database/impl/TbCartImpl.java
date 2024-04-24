package com.donota.donotamobileapp.database.impl;


import static com.donota.donotamobileapp.utils.DbUtils.COL_CUSTOMER_CART_QUANTITY;
import static com.donota.donotamobileapp.utils.DbUtils.COL_CUSTOMER_ID;
import static com.donota.donotamobileapp.utils.DbUtils.COL_PRODUCT_ID;
import static com.donota.donotamobileapp.utils.DbUtils.DB_NAME;
import static com.donota.donotamobileapp.utils.DbUtils.DB_VERSION;
import static com.donota.donotamobileapp.utils.DbUtils.TBL_CUSTOMER_CART;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.donota.donotamobileapp.database.Databases;

public class TbCartImpl extends SQLiteOpenHelper implements Databases {

    public TbCartImpl(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = " CREATE TABLE IF NOT EXISTS " + TBL_CUSTOMER_CART + " (" + COL_CUSTOMER_ID + " INTERGER    REFERENCES tbcustomerprofile (customerid) NOT NULL, " + COL_PRODUCT_ID +
                " TEXT    REFERENCES tbproduct (productid),  " + COL_CUSTOMER_CART_QUANTITY + "INTEGER NOT NULL ON CONFLICT ROLLBACK DEFAULT (1))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TBL_CUSTOMER_CART);
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
