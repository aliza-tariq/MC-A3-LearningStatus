package com.example.learningtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class stdmistakes extends AppCompatActivity {

    private TextView textView1,t1,t2,t3,total1,total3;
    private DbHelper dbHelper = new DbHelper(stdmistakes.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stdmistakes);
       t1=findViewById(R.id.m1);
        t2=findViewById(R.id.m2);
        t3=findViewById(R.id.m3);
        total1=findViewById(R.id.total1);
        total3=findViewById(R.id.total3);

        String name=getIntent().getStringExtra("stdName");
       // textView1.setText(name);
        LearningModel std1=dbHelper.getStudent(name);
        String [] strSabak =std1.getIncorrectSabak().split(",");
        String [] strManzil =std1.getIncorrectMazil().split(",");

        String [] str1= new HashSet<String>(Arrays.asList(strSabak)).toArray(new String[0]);
        String [] count1=new String[str1.length];
        String [] str2= new HashSet<String>(Arrays.asList(strManzil)).toArray(new String[0]);
        String [] count2=new String[str2.length];

        Arrays.sort(str1, Collections.reverseOrder());
        Arrays.sort(str2,Collections.reverseOrder());

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            Arrays.stream(str1).sorted();
//        }
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            Arrays.stream(str2).sorted();
//        }

        for (int i=0;i<str1.length;i++)
        {
            count1[i]=search(strSabak,str1[i]);
        }

        for (int i=0;i<str2.length;i++)
        {
            count2[i]=search(strManzil,str2[i]);
        }

        String mistakes1="";
        for (int i=0;i<str1.length;i++)
        {
           mistakes1=mistakes1+str1[i]+" --- "+count1[i]+" times\n";
        }
        t1.setText(mistakes1);

        String mistakes3="";
        for (int i=0;i<str2.length;i++)
        {
            mistakes3=mistakes3+str2[i]+" --- "+count2[i]+" times\n";
        }
        t3.setText(mistakes3);

        total1.setText("Total Sabak Mistakes Count : "+strSabak.length);
        total3.setText("Total Manzil Mistakes Count : "+strManzil.length);

    }

    static String search(String[]arr, String s)
    {
        int counter = 0;
        for (int j = 0; j < arr.length; j++)

                /* checking if string given in query is
                  present in the given string. If present,
                  increase times*/
            if (s.equals(arr[j]))
                counter++;

        return String.valueOf(counter);
    }

}