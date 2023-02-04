package com.example.learningtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class learningtracker extends AppCompatActivity {

    private TextView textView1;
    private Button btnMistakes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learningtracker);

        textView1=findViewById(R.id.textViewStd);
        btnMistakes=findViewById(R.id.btnMistakes);

        String name=getIntent().getStringExtra("stdName");
        DbHelper dbHelper = new DbHelper(learningtracker.this);
        LearningModel std1=dbHelper.getStudent(name);
        textView1.setText(std1.getStudentName()+" + "+std1.getStudentDept());

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

    }
}