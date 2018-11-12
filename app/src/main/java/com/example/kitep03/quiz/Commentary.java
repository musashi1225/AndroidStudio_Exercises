package com.example.kitep03.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Commentary extends AppCompatActivity {

    int classification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commentary);
        Intent intent = getIntent();
        classification = intent.getIntExtra("classfication",0);

    }

    public void OnExitButtonClick(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
    }

    public void OnNextButtonClick(View view){
        Intent intent = new Intent(this,QuizActivity.class);
        intent.putExtra("classfication",classification);
        startActivity(intent);
    }
}
