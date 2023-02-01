package com.example.learningtracker;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public static final String STUDENT_NAME = "STUDENT_NAME";
    public static final String STUDENT_DEPT = "STUDENT_DEPT";
    public static final String STUDENT_ID = "STUDENT_ID";
    public static final String SABAK = "SABAK";
    public static final String SABKI = "SABKI";
    public static final String MANZIL = "MANZIL";

    public static final String SABAK_ST = "SABAK_ST";
    public static final String SABKI_ST= "SABKI_ST";
    public static final String MANZIL_ST = "MANZIL_ST";

    public static final String SABAK_IC = "SABAK_IC";
    public static final String SABKI_IC = "SABKI_IC";
    public static final String MANZIL_IC = "MANZIL_IC";

    public static final String LEARNING_TABLE = "LEARNING_TABLE";

    public DbHelper(@Nullable Context context) {

        super(context, "studenttrackerDB.db", null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableSTatement = "CREATE TABLE " + LEARNING_TABLE + "(" + STUDENT_ID +
                " Integer PRIMARY KEY AUTOINCREMENT, " +
                STUDENT_NAME + " Text, "+STUDENT_DEPT + " Text, " + SABAK + " Int, " +SABKI + " Int, " +
                MANZIL + " Int, " +SABAK_ST + " Int, " +SABKI_ST + " Int, " +MANZIL_ST + " Int, " +
                SABAK_IC + " Text, " +SABKI_IC + " Text, " +MANZIL_IC + " Text) ";

        sqLiteDatabase.execSQL(createTableSTatement);
        System.out.println("db made successfully");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}