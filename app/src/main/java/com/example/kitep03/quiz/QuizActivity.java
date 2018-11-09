package com.example.kitep03.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }

    public void OnExitButtonClick(View View) {
        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
    }

    public void OnChoicesButton1Click(View view){
        Intent intent = new Intent(this,Commentary.class);
        startActivity(intent);
    }

    public void OnChoicesButton2Click(View view){
        Intent intent = new Intent(this,Commentary.class);
        startActivity(intent);
    }

    public void OnChoicesButton3Click(View view){
        Intent intent = new Intent(this,Commentary.class);
        startActivity(intent);
    }

    public void OnChoicesButton4Click(View view){
        Intent intent = new Intent(this,Commentary.class);
        startActivity(intent);
    }
}
