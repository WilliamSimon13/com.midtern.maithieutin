package com.example.commidternmaithieutin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "quiz.db";
    private static final int DATABASE_VERSION = 1;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_QUIZ_TABLE = "CREATE TABLE " + QuizContract.QuizEntry.TABLE_NAME + " ("
                + QuizContract.QuizEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + QuizContract.QuizEntry.COLUMN_QUESTION + " TEXT NOT NULL, "
                + QuizContract.QuizEntry.COLUMN_ANSWER + " TEXT NOT NULL);";

        db.execSQL(SQL_CREATE_QUIZ_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuizContract.QuizEntry.TABLE_NAME);
        onCreate(db);
    }
}
