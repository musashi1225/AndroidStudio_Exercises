package com.example.kitep03.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class Commentary extends AppCompatActivity {

    int classification;
    int response;
    int correct_answers;
    String commentary;
    ArrayList<Integer> answered = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commentary);
        Intent intent = getIntent();
        classification = intent.getIntExtra("classfication",0);
        response = intent.getIntExtra("response",0);
        correct_answers = intent.getIntExtra("correct_answers",0);
        commentary = intent.getStringExtra("commentary");
        answered = intent.getIntegerArrayListExtra("answered");

        TextView commentary_textview = (TextView)findViewById(R.id.commentary_textview);
        commentary_textview.setText(commentary);
    }

    public void OnExitButtonClick(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("response",response);
        intent.putExtra("correct_answers",correct_answers);
        startActivity(intent);
    }

    public void OnNextButtonClick(View view){
        Intent intent = new Intent(this,QuizActivity.class);
        intent.putExtra("classfication",classification);
        intent.putExtra("response",response);
        intent.putExtra("correct_answers",correct_answers);
        intent.putExtra("answered",answered);
        startActivity(intent);
    }
}
