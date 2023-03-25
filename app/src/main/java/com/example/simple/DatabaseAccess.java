package com.example.simple;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class DatabaseAccess {
    private final ConnectionHelper openHelper;
    private SQLiteDatabase db;
    private static  DatabaseAccess instance;
    Cursor c=null;
    private DatabaseAccess (Context context){
        this.openHelper=new ConnectionHelper(context);
    }
    public static  DatabaseAccess getInstance(Context context){
        if(instance==null){
            instance=new DatabaseAccess(context);
        }
        return instance;
    }
    public void open(){
        this.db=openHelper.getWritableDatabase();
    }
    public  void close(){
        if (db!=null){
            this.db.close();
        }
    }
    public String getProductName(long barcode){
        c=db.rawQuery("select product_name from BonPrix where _id= '"+barcode+"'",new String[]{});
        StringBuilder buffer =new StringBuilder();
        while(c.moveToNext()){
            String product_name=c.getString(0);
            buffer.append("").append(product_name);
        }
        return buffer.toString();
    }

    public String getPrice(long barcode) {
        c=db.rawQuery("select Field3 from BonPrix where _id= '"+barcode+"'",new String[]{});
        StringBuilder buffer =new StringBuilder();
        while(c.moveToNext()){
            String product_name=c.getString(0);
            buffer.append("").append(product_name);
        }
        return buffer.toString();
    }
    }

