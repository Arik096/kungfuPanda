package com.example.tafsir.kungfupanda;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class databaseHelper2 extends SQLiteOpenHelper {

    private static final String Database_Name = "product_Buy.pb";
    private static final String Table_Name = "productDetails";
    private static final String ID = "Id";
    private static final String NAME = "Name";
    private static final int VERSION_NUMBER = 2;
    private static final String CREATE_TABLE = "CREATE TABLE "+Table_Name+"("+ID+" INTEGER PRIMARY KEY,"+NAME+" VARCHAR(30));";
    private static final String DROP_TABLE="DROP TABLE IF EXISTS "+Table_Name;
    private Context context;

    public databaseHelper2(Context context) {
        super(context, Database_Name, null, VERSION_NUMBER);
        this.context = context;
    }




    @Override
    public void onCreate(SQLiteDatabase db) {

        try{

            db.execSQL(CREATE_TABLE);
            Toast.makeText(context, "onCreate is called", Toast.LENGTH_LONG).show();


        }catch (Exception e)
        {

            Toast.makeText(context, "Exception : "+e, Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try{

            Toast.makeText(context, "onUpgrade is called", Toast.LENGTH_LONG).show();
            db.execSQL(DROP_TABLE);
            onCreate(db);



        }catch (Exception e)
        {

            Toast.makeText(context, "Exception : "+e, Toast.LENGTH_LONG).show();
        }

    }






    public long saveData(String id, String name) {



        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(ID,id);
        contentValues.put(NAME,name);

        long rowNumer = sqLiteDatabase.insert(Table_Name,null,contentValues);
        return rowNumer;

    }

    public Cursor showAllData()
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+Table_Name,null);
        return cursor;
    }


    public Boolean updateData(String id,String name)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(ID,id);
        contentValues.put(NAME,name);
        sqLiteDatabase.update(Table_Name,contentValues,ID+ " = ?",new String[] {id});
        return true;

    }


    public int deleteData(String id)
    {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        int value = sqLiteDatabase.delete(Table_Name,ID+" = ?",new String[] {id});
        return value;
    }



}
