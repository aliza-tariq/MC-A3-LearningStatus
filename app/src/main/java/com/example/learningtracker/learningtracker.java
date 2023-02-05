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
        manzilSt=findViewById(R.id.statusManzil);


        btnMistakes=findViewById(R.id.btnMistakes);

        String name=getIntent().getStringExtra("stdName");
        DbHelper dbHelper = new DbHelper(learningtracker.this);
        LearningModel std1=dbHelper.getStudent(name);
        if(std1.getSabak()==30)
        {
          //  resetStudent(std1);
        }
//        textView1.setText(std1.getStudentName()+" + "+std1.getStudentDept());
        sabakNum.setText(String.valueOf(std1.getSabak()));
        sabkiNum.setText(String.valueOf(std1.getSabki()));
        manzilNum.setText(String.valueOf(std1.getManzil()));

        setAllStatus(std1);

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

                if((std1.getSabak()+1)%31==0)
                {
                    std1.setSabak(1);
                }
                else {
                    std1.setSabak((std1.getSabak() + 1) % 31);
                }

                std1.setSabki(std1.getSabak()-1);

                sabakNum.setText(String.valueOf(std1.getSabak()));
                sabkiNum.setText(String.valueOf(std1.getSabki()));
                sabakSt.setText("You have to recite : "+std1.getSabak());
                std1.setSabakStatus(false);
                //dbHelper.updateStudent(std1);
            }
        });

        sabakIC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sabakSt.setText("Incorrect Sabak again recite : "+std1.getSabak());
                sabkiNum.setText(String.valueOf(std1.getSabki()));
                if(std1.getIncorrectSabak()==""||std1.getIncorrectSabak().length()==0)
                    std1.setIncorrectSabak(String.valueOf(std1.getSabak()));
                else
                    std1.setIncorrectSabak(std1.getIncorrectSabak()+","+std1.getSabak());
                sabakSt.setText(std1.getIncorrectSabak());
                std1.setSabakStatus(true);
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

                if((std1.getManzil()+1)%std1.getSabak()==0)
                    std1.setManzil(1);
                else
                    std1.setManzil((std1.getManzil()+1)%std1.getSabak());
                manzilNum.setText(String.valueOf(std1.getManzil()));
                manzilSt.setText("You have to Recite Manzil : "+std1.getManzil());
                std1.setManzilStatus(false);
               // dbHelper.updateStudent(std1);
            }
        });

        manzilIC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manzilSt.setText("Incorrect Manzil again recite : "+std1.getManzil());
                if(std1.getIncorrectMazil()==""||std1.getIncorrectMazil().length()==0)
                    std1.setIncorrectMazil(String.valueOf(std1.getManzil()));
                else
                    std1.setIncorrectMazil(std1.getIncorrectMazil()+","+String.valueOf(std1.getManzil()));

                std1.setManzilStatus(true);
            }
        });

    }

    public void resetStudent(LearningModel std)
    {
        std.setSabak(1);
        std.setSabki(0);
       // std.setManzil(0);
        std.setSabakStatus(false);
        std.setSabkiStatus(false);
        //std.setManzilStatus(false);
    }
    public void setAllStatus(LearningModel std)
    {
        if(std.isSabakStatus()==false)
            sabakSt.setText("You have to Recite : "+std.getSabak());
        else if(std.isSabakStatus()==true)
            sabakSt.setText("Incorrect Sabak again recite : "+std.getSabak());

        if(std.isManzilStatus()==false)
            manzilSt.setText("You have to Recite Manzil : "+std.getManzil());
        else if(std.isManzilStatus()==true)
            manzilSt.setText("Incorrect Manzil again recite : "+std.getManzil());

    }
}