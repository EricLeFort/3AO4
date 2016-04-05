package com.example.phanngocduc.sql_demo;

import android.content.ContentValues;
import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by
 */
public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME ="Rock.db";
    public static final String TABLE_NAME ="Rock_table";
    public static final String COL_1 ="ID";
    public static final String COL_2 ="NAME";
    public static final String COL_3 ="VALUE";
    public static final String COL_4 ="HARDNESS";
    public static final String COL_5 ="COLOUR";
    public static final String COL_6 ="TEXTURE";
    public static final String COL_7 ="SIZE";
    public static final String COL_8 ="LATITUDE";
    public static final String COL_9="LONGITUDE";
    public static final String COL_10 ="RADIUS";

    //private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_String = "CREATE TABLE " + TABLE_NAME + "(" +
                COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_2 + " TEXT," +
                COL_3 + " DOUBLE," +
                COL_4 + " TEXT," +
                COL_5 + " TEXT," +
                COL_6 + " TEXT," +
                COL_7 + " TEXT," +
                COL_8 + " INTEGER," +
                COL_9 + " INTEGER," +
                COL_10 + " INTEGER" +")";
        db.execSQL(SQL_String);
        db.execSQL("INSERT INTO Rock_table(NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Amphibole',0.005,'Medium','Black','Rough','Medium', 10, 29, 4582)");
        db.execSQL("INSERT INTO Rock_table(NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Amphibole',0.005,'Medium','Brown','Rough','Medium', 10, 29, 4582)");
        db.execSQL("INSERT INTO Rock_table(NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Amphibole',0.005,'Medium','Green','Rough','Medium', 10, 29, 4582)");

        db.execSQL("INSERT INTO Rock_table(NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Amphibole',0.005,'Medium','Black','Rough','Medium', 52, -99, 1604)");
        db.execSQL("INSERT INTO Rock_table(NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Amphibole',0.005,'Medium','Brown','Rough','Medium', 52, -99, 1604)");
        db.execSQL("INSERT INTO Rock_table(NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Amphibole',0.005,'Medium','Green','Rough','Medium', 52, -99, 1604)");


        db.execSQL("INSERT INTO Rock_table(NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Carbonatite',0.001,'soft','Pink','Rough','Coarse', 51, -99, 2335)");
        db.execSQL("INSERT INTO Rock_table(NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Carbonatite',0.001,'Soft','Grey','Rough','Coarse', 51, -99, 2335)");
        db.execSQL("INSERT INTO Rock_table(NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Carbonatite',0.001,'Soft','Green','Rough','Coarse', 51, -99, 2335)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public boolean insertData(String name, Double value,String hardness, String colour,String texture,String size, Integer latitude,Integer longitude,Integer radius)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_2, name);
        contentValues.put(COL_3,value);
        contentValues.put(COL_4, hardness);
        contentValues.put(COL_5, colour);
        contentValues.put(COL_6,texture);
        contentValues.put(COL_7, size);
        contentValues.put(COL_8, latitude);
        contentValues.put(COL_9, longitude);
        contentValues.put(COL_10, radius);

        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
            return false;
            else
            return true;

    }



    public Cursor queryData(String[] columns, String SQLquery) {
        SQLiteDatabase db=this.getWritableDatabase();
        //query(String table, String[] columns, String selection, String[]selectionArgs, String groupBy, String having, String orderBy)
        Cursor cursor = db.query(TABLE_NAME, columns, SQLquery, null, null, null, null);
        //Cursor cursor = db.rawQuery("SELECT NAME FROM  WHERE NAME LIKE '%" +  + "%'", null);
        return cursor;
    }
}


