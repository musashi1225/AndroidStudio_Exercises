package com.example.kitep03.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    int response;
    int correct_answers;
    float parsent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        response = intent.getIntExtra("response",0);
        correct_answers = intent.getIntExtra("correct_answers",0);
        parsent = ( (float)correct_answers / (float)response) * 100;
        parsent = (int)parsent;
        TextView result_textview = (TextView)findViewById(R.id.result_textview);
        result_textview.setText(String.valueOf(parsent) + "%\n\n\n" + response + " 問中 " + correct_answers + " 問正解");
    }

    public void OnTitleButtonClick(View view){
        Intent intent = new Intent(this,TitleActivity.class);
        startActivity(intent);
    }
}
