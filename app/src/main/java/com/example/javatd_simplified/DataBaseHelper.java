package com.example.javatd_simplified;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String TDL_TABLE = "TDL_TABLE";
    public static final String COLUMN_TDL_ITEM = "TDL_ITEM";
    public static final String COLUMN_ID = "ID";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "TDL.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableStatement= "CREATE TABLE " + TDL_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_TDL_ITEM + " TEXT)";
        sqLiteDatabase.execSQL(createTableStatement);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addOne(Model model) {

        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(COLUMN_TDL_ITEM, model.getTd_item());

        long insert = sqLiteDatabase.insert(TDL_TABLE, null, cv);

        if (insert==-1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean deleteOne(Model model) {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        String queryString="DELETE FROM " + TDL_TABLE + " WHERE " +COLUMN_ID + " = " + model.getId();

        Cursor cursor = sqLiteDatabase.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            return true;
        }
        else {
            return false;
        }
    }

    public List<Model> getEverything() {

        List<Model> returnList=new ArrayList<>();

        String queryString="SELECT * FROM " + TDL_TABLE;

        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(queryString, null);

        if(cursor.moveToFirst()) {
            do {
                int item_id=cursor.getInt(0);
                String TDL_item= cursor.getString(1);

                Model newModel=new Model(TDL_item, item_id);
                returnList.add(newModel);
            } while(cursor.moveToNext());
        }
        else {

        }

        cursor.close();
        sqLiteDatabase.close();
        return returnList;


    }
}
