package com.donota.donotamobileapp.database.impl;

import static com.donota.donotamobileapp.utils.DbUtils.DB_NAME;
import static com.donota.donotamobileapp.utils.DbUtils.COL_DELIVERY_DATE;
import static com.donota.donotamobileapp.utils.DbUtils.COL_ORDER_DATE;
import static com.donota.donotamobileapp.utils.DbUtils.COL_ORDER_DETAIL_ID;
import static com.donota.donotamobileapp.utils.DbUtils.COL_ORDER_ID;
import static com.donota.donotamobileapp.utils.DbUtils.COL_ORDER_QUANTITY;
import static com.donota.donotamobileapp.utils.DbUtils.COL_PRODUCT_ID;
import static com.donota.donotamobileapp.utils.DbUtils.DB_VERSION;
import static com.donota.donotamobileapp.utils.DbUtils.TBL_ORDER_DETAIL;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.donota.donotamobileapp.database.Databases;

public class TbOrderDetailImpl extends SQLiteOpenHelper implements Databases {

    public TbOrderDetailImpl(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = " CREATE TABLE IF NOT EXISTS " + TBL_ORDER_DETAIL  + "  (" + COL_ORDER_ID + " TEXT NOT NULL, " + COL_PRODUCT_ID +
                " TEXT NOT NULL REFERENCES tbproduct (productid)," + COL_ORDER_QUANTITY + " INTEGER NOT NULL, " + COL_ORDER_DETAIL_ID + " TEXT PRIMARY KEY NOT NULL UNIQUE, "
                + COL_ORDER_DATE + " INTEGER NOT NULL, " + COL_DELIVERY_DATE + " INTEGER)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TBL_ORDER_DETAIL);
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
