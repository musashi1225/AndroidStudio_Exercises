package com.example.kitep03.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Commentary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commentary);
    }

    public void OnExitButtonClick(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
    }

    public void OnNextButtonClick(View view){
        Intent intent = new Intent(this,QuizActivity.class);
        startActivity(intent);
    }
}
