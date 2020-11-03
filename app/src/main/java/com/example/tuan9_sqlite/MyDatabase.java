package com.example.tuan9_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME ="Database.db";
    private static final String TABLE_NAME = "SinhVien";
    private static final String COL_1="ID";
    private static final String COL_2="Name";
    private static final String COL_3="Toan";
    private static final String COL_4="Ly";
    private static final String COL_5="Hoa";



    public MyDatabase(Context context){
        super (context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABLE_NAME + "  ( "+COL_1 +" INTEGER PRIMARY KEY AUTOINCREMENT,"+ COL_2+" TEXT,"+ COL_4+" INTEGER, "+COL_5+" INTEGER,"+COL_3+" INTEGER) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(String name, String toan, String ly, String hoa)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2,name);
        values.put(COL_3,toan);
        values.put(COL_4,ly);
        values.put(COL_5,hoa);

        long result = db.insert(TABLE_NAME,null,values);
        if(result==-1)
            return  false;
        else
            return true;
    }

    public boolean updateData(String id, String name, String Toan, String Ly, String Hoa)
    {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_1,id);
        values.put(COL_2,name);
        values.put(COL_3,Toan);
        values.put(COL_4,Ly);
        values.put(COL_5,Hoa);
        long result = db.update(TABLE_NAME,values,COL_1+"=?",new String[]{id});
        if(result==-1)
            return  false;
        else
            return true;
    }
    public boolean deleteData(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME,COL_1+"=?",new  String[]{id});
        if(result==-1)
            return  false;
        else
            return true;
    }

}
