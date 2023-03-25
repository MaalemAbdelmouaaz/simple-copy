package com.example.simple;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
public class ConnectionHelper extends SQLiteAssetHelper {
    public static int DB_version=2;
    public static String DB_name= "simple.db";

    public ConnectionHelper( Context context) {
        super(context, DB_name, null, DB_version);

    }
}
