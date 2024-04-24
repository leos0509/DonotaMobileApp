package com.donota.donotamobileapp.database.impl;

import static com.donota.donotamobileapp.utils.DbUtils.COL_PRODUCT_ID;
import static com.donota.donotamobileapp.utils.DbUtils.COL_PRODUCT_CATEGORY;
import static com.donota.donotamobileapp.utils.DbUtils.COL_PRODUCT_DESCRIPTION;
import static com.donota.donotamobileapp.utils.DbUtils.COL_PRODUCT_IMG;
import static com.donota.donotamobileapp.utils.DbUtils.COL_PRODUCT_NAME;
import static com.donota.donotamobileapp.utils.DbUtils.COL_PRODUCT_PRICE;
import static com.donota.donotamobileapp.utils.DbUtils.COL_PRODUCT_QUANTITY;
import static com.donota.donotamobileapp.utils.DbUtils.COL_PRODUCT_RATING;
import static com.donota.donotamobileapp.utils.DbUtils.DB_NAME;
import static com.donota.donotamobileapp.utils.DbUtils.DB_VERSION;
import static com.donota.donotamobileapp.utils.DbUtils.TBL_PRODUCT;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import com.donota.donotamobileapp.database.Databases;

public class TbProductImpl extends SQLiteOpenHelper implements Databases {
    public TbProductImpl(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = " CREATE TABLE IF NOT EXISTS " + TBL_PRODUCT + " (" + COL_PRODUCT_ID + " TEXT PRIMARY KEY NOT NULL UNIQUE, "+ COL_PRODUCT_NAME +
                " TEXT NOT NULL,  " + COL_PRODUCT_PRICE + " NUMERIC, " +COL_PRODUCT_QUANTITY + "  NUMERIC, " + COL_PRODUCT_CATEGORY
                + " TEXT, productcategorysub2 TEXT,  productcategorysub3 TEXT, productcategorysub4 TEXT," + COL_PRODUCT_DESCRIPTION
                + " TEXT, " + COL_PRODUCT_IMG + "TEXT, " + COL_PRODUCT_RATING + " REAL)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TBL_PRODUCT);
        onCreate(db);
    }

    @Override
    public Cursor queryData(String sql) {
        SQLiteDatabase db = getReadableDatabase();
        return(db.rawQuery(sql,null));
    }

    @Override
    public boolean execSql(String sql) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            db.execSQL(sql);
            return true;
        } catch (Exception e) {
            Log.e("Error",e.toString());
            return false;
        }
    }
}
