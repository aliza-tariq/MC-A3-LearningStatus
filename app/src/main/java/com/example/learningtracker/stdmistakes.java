package com.example.learningtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class stdmistakes extends AppCompatActivity {

    private TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stdmistakes);
        textView1=findViewById(R.id.textViewName);
        String name=getIntent().getStringExtra("stdName");
        textView1.setText(name);

    }
}