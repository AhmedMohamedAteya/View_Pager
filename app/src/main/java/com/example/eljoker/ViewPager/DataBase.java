package com.example.eljoker.zadelmuslim;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.eljoker.zadelmuslim.Models.FavModel;

import java.util.ArrayList;
import java.util.List;

public class DataBase extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "favorite.db";
    public static final String FAVORITES_TABLE = "Favorits";
    public static final String COLUMN_ID = "Id";
    public static final String FavoriteTEXT = "FavoriteTEXT";

    public DataBase(@Nullable Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

        String CREATE_TABLE = "CREATE TABLE " + FAVORITES_TABLE + "(" + COLUMN_ID +
                "INTEGER PRIMARYKEY," + FavoriteTEXT + " TEXT NOT NULL "+");";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        db.execSQL("DROP TABLE IF EXISTS Favorits");
        onCreate(db);
    }

     public void addToFavorite(String zekr_name, SQLiteDatabase db)
    {
        ContentValues values = new ContentValues();
        values.put(FavoriteTEXT, zekr_name);
        //values.put(COLUMN_ID, position);
        db.insert(FAVORITES_TABLE, null, values);
        Log.i("DataBase", "addToFavorite: ");
    }

    public void removeFromFavorite(String zekr_name)
    {
        FavModel FavModel = new FavModel();

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(FAVORITES_TABLE, FavoriteTEXT + " = ?",
                new String[]{String.valueOf(zekr_name)});
        //db.close();

        /*SQLiteDatabase db = getReadableDatabase();
        String query = String.format("DELETE FROM Favorits WHERE Id='%s';", zekr_name);
        db.execSQL(query);*/
    }

/*
     boolean isFavorite(String zekr_id)
    {
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("SELECT * FROM Favorits WHERE Id='%s';", zekr_id);
        Cursor cursor = db.rawQuery(query,null);
        if (cursor.getCount() <= 0)
        {
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }
*/

    public List<FavModel> isFavorite()
    {
        List<FavModel> list = new ArrayList<>();
        int count = 0;
        // Select All Query
        String selectQuery = "SELECT  * FROM " + FAVORITES_TABLE ;

        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        /*if(cursor != null && !cursor.isClosed())
        {
            count = cursor.getCount();
            cursor.close();
        }*/

         if (cursor.moveToFirst())
        {
            do {
                FavModel FavModel = new FavModel();
                //FavModel.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
                FavModel.setZekr(cursor.getString(cursor.getColumnIndex(FavoriteTEXT)));

                list.add(FavModel);
            } while (cursor.moveToNext());
        }

        // close db connection
        //db.close();

        // return notes list
        return list;

    }




}
