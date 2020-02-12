package com.xeylyne.testingle;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DataHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "place.db";
    public static final int DATABASE_VERSION = 2;
    public static final String TABLE_NAME = "tab_place";


    public static final String COL_1 = "ID_PLACE";
    public static final String COL_2 = "NAME_PLACE";

    public DataHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + "( ID_PLACE INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME_PLACE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public ArrayList<Place> getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<Place> accounts = new ArrayList<>();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        if (res.getCount() == 0) {
            Log.d("onGetAll", "DB Empty");
        } else {
            if (res.moveToFirst()) {
                do {
                    Place place = new Place();
                    place.setID_PLACE(res.getInt(0));
                    place.setNAME_PLACE(res.getString(1));
                    accounts.add(place);
                } while (res.moveToNext());
            }
        }
        return accounts;
    }

    public boolean AddPlace(String name_place) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name_place);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            Log.d("onInsert", "GagalInsert");
            return false;
        } else {
            Log.d("onInsert", "Insert Success");
            return true;
        }
    }

    public boolean deleteData(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "ID_PLACE = " + id, null);
        return true;
    }

}
