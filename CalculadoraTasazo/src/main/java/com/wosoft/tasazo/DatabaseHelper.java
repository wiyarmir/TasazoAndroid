package com.wosoft.tasazo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by wiyarmir on 11/08/13.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String name = "DB_TASAS";
    private static final int version = 1;

    public DatabaseHelper(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int from, int to) {
        sqLiteDatabase.execSQL("DROP TABLE " + "TABLE_TASAS");
        onCreate(sqLiteDatabase);
    }
}
