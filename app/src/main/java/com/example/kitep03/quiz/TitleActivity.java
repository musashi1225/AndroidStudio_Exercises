package com.example.kitep03.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class TitleActivity extends AppCompatActivity {
    int classification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
    }

    public void OnSynthesisButtonClick(View view){
        classification = 0;
        Intent intent = new Intent(this,QuizActivity.class);
        intent.putExtra("classfication",classification);
        startActivity(intent);
    }

    public void OnTechnologyButtonClick(View view){
        classification = 1;
        Intent intent = new Intent(this,QuizActivity.class);
        intent.putExtra("classfication",classification);
        startActivity(intent);
    }

    public void OnStrategyButtonClick(View view){
        classification = 2;
        Intent intent = new Intent(this,QuizActivity.class);
        intent.putExtra("classfication",classification);
        startActivity(intent);
    }

    public void OnManegementButtonClick(View view){
        classification = 3;
        Intent intent = new Intent(this,QuizActivity.class);
        intent.putExtra("classfication",classification);
        startActivity(intent);
    }


}

