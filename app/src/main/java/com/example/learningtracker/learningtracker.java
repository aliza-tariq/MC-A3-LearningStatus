package com.example.learningtracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class learningtracker extends AppCompatActivity {

    private TextView textView1,sabakNum,sabkiNum,manzilNum,sabakSt,sabkiSt,manzilSt;
    private Button btnMistakes,sabakC,sabakIC,sabkiC,sabkiIC,manzilC,manzilIC;
    private DbHelper dbHelper = new DbHelper(learningtracker.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learningtracker);

     //   textView1=findViewById(R.id.textViewStd);
        sabakNum=findViewById(R.id.sabakNum);
        sabkiNum=findViewById(R.id.sabkiNum);
        manzilNum=findViewById(R.id.manzilNum);

        sabakC=findViewById(R.id.r1);
        sabakIC=findViewById(R.id.nr1);
        sabkiC=findViewById(R.id.r2);
        sabkiIC=findViewById(R.id.nr2);
        manzilC=findViewById(R.id.r3);
        manzilIC=findViewById(R.id.nr3);

        sabakSt=findViewById(R.id.statusSabak);
        sabkiSt=findViewById(R.id.statusSabki);
        manzilSt=findViewById(R.id.statusSabki);


        btnMistakes=findViewById(R.id.btnMistakes);

        String name=getIntent().getStringExtra("stdName");
        DbHelper dbHelper = new DbHelper(learningtracker.this);
        LearningModel std1=dbHelper.getStudent(name);
//        textView1.setText(std1.getStudentName()+" + "+std1.getStudentDept());
        sabakNum.setText(String.valueOf(std1.getSabak()));
        sabkiNum.setText(String.valueOf(std1.getSabki()));
        manzilNum.setText(String.valueOf(std1.getManzil()));

        btnMistakes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(learningtracker.this, stdmistakes.class);
                int number=123456;

                intent.putExtra("WelcomeMessage","السلام علیکم");
                intent.putExtra("stdName",name);
                startActivity(intent);

            }
        });

        sabakC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                std1.setSabak(std1.getSabak()+1);
                std1.setSabki(std1.getSabak()-1);

                sabakNum.setText(String.valueOf(std1.getSabak()));
                sabkiNum.setText(String.valueOf(std1.getSabki()));
                dbHelper.updateStudent(std1);
            }
        });

        sabkiC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                std1.setSabki(std1.getSabki()+1);
                sabakNum.setText(String.valueOf(std1.getSabak()));
                dbHelper.updateStudent(std1);
            }
        });

        manzilC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                std1.setManzil((std1.getManzil()+1)%std1.getSabak());
                manzilNum.setText(String.valueOf(std1.getManzil()));
                dbHelper.updateStudent(std1);
            }
        });

    }
}