package com.example.learningtracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {

    List<LearningModel> studentList = new ArrayList<>();

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LearningModel f0 = new LearningModel("Student1",1, false,0,false,0,false ,
                "","","");
        LearningModel f1 = new LearningModel("Student2",1, false,0,false,0,false ,
                "","","");
        LearningModel f2 = new LearningModel("Student3",1, false,0,false,0,false,
                "","","");
        LearningModel f3 = new LearningModel("Student4",1, false,0,false,0,false ,
                "","","");
        LearningModel f4 = new LearningModel("Student5",1, false,0,false,0,false,
                "","","");

        studentList.addAll(Arrays.asList(new LearningModel[]{f0,f1,f2,f3,f4}));
        recyclerView = findViewById(R.id.recylerViewStudent);

        recyclerView.setHasFixedSize(true);

        //LinearLayoutManager GridLayoutManager
        layoutManager = new LinearLayoutManager(MainActivity.this);
//        layoutManager = new LinearLayoutManager(MainActivity.this,
//                LinearLayoutManager.HORIZONTAL,
//                true);
        recyclerView.setLayoutManager(layoutManager);

        //implements
        adapter = new myRecyclerViewAdapter(studentList,this) ;
        recyclerView.setAdapter(adapter);
        //adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this, learningtracker.class);
        int number=123456;

        intent.putExtra("WelcomeMessage","السلام علیکم");
        intent.putExtra("nmbr",number);
        startActivity(intent);
    }
}