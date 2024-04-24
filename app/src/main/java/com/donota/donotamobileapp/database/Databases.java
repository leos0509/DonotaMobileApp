package com.donota.donotamobileapp.database;

import android.database.Cursor;

public interface Databases {
    Cursor queryData (String sql);
    boolean execSql(String sql);
}
