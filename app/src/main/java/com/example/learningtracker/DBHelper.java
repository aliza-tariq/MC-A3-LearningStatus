package com.example.learningtracker;


import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public static final String STUDENT_NAME = "STUDENTName";
    public static final String STUDENT_Dept = "STUDENTAge";
    public static final String ACTIVE_STUDENT = "ActiveSTUDENT";
    public static final String STUDENT_ID = "STUDENTID";
    public static final String STUDENT_TABLE = "StudentTable";

    public DbHelper(@Nullable Context context) {

        super(context, "studentDB.db", null, 4);
    }
}