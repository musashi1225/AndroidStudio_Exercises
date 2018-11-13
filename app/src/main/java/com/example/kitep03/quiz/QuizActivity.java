package com.example.kitep03.quiz;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

import au.com.bytecode.opencsv.CSVReader;

public class QuizActivity extends AppCompatActivity {

    boolean decision;
    boolean answer_state;
    TextView question;
    Button choices_1;
    Button choices_2;
    Button choices_3;
    Button choices_4;
    String commentary;
    String questions[][] = new String[100][8];
    String temp[][] = new String[100][8];
    int question_number = 0;
    int max_question;
    int classification;
    int response = 0;
    int correct_answers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        answer_state = false;
        question = (TextView)findViewById(R.id.question_textview);
        choices_1 = (Button)findViewById(R.id.choices_1_button);
        choices_2 = (Button)findViewById(R.id.choices_2_button);
        choices_3 = (Button)findViewById(R.id.choices_3_button);
        choices_4 = (Button)findViewById(R.id.choices_4_button);

        max_question = 0;
        int parse = 0;
        Intent intent = getIntent();
        response = intent.getIntExtra("response",0);
        correct_answers = intent.getIntExtra("correct_answers",0);
        classification = intent.getIntExtra("classfication",0);

        try {
            AssetManager as = getResources().getAssets();
            InputStream is = as.open("question.csv");
            CSVReader reader = new CSVReader(new InputStreamReader(is), ',');
            while ((temp[parse] =reader.readNext()) != null) {
                if(classification == 0) {
                    questions[max_question] = temp[parse];
                    max_question++;
                }else{
                    if(Integer.parseInt(temp[parse][7]) == classification){
                        questions[max_question] = temp[parse];
                        max_question++;
                    }
                }
                parse++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(response == max_question){
            intent = new Intent(this,ResultActivity.class);
            intent.putExtra("response",response);
            intent.putExtra("correct_answers", correct_answers);
            startActivity(intent);
        }

        Random rand = new Random();
        question_number = rand.nextInt(max_question);


        question.setText(questions[question_number][1]);
        choices_1.setText(questions[question_number][2]);
        choices_2.setText(questions[question_number][3]);
        choices_3.setText(questions[question_number][4]);
        choices_4.setText(questions[question_number][5]);
        commentary = questions[question_number][8];

    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        if(answer_state == true){
            if(decision == true){
                Intent intent = new Intent(this,QuizActivity.class);
                intent.putExtra("classfication",classification);
                intent.putExtra("response",response);
                intent.putExtra("correct_answers",correct_answers);
                startActivity(intent);
            }else{
                Intent intent = new Intent(this,Commentary.class);
                intent.putExtra("classfication",classification);
                intent.putExtra("response",response);
                intent.putExtra("correct_answers",correct_answers);
                intent.putExtra("commentary",commentary);
                startActivity(intent);
            }
        }
        return true;
    }

    public void AlphaAnimation(){
        ImageView maru = (ImageView) findViewById(R.id.maru_image);
        ImageView batu = (ImageView) findViewById(R.id.batu_image);
        AlphaAnimation alpha = new AlphaAnimation(0.0f,1.0f);

        alpha.setDuration(1000);
        alpha.setFillAfter(true);

        if(decision == true){
            maru.startAnimation(alpha);
        }else{
            batu.startAnimation(alpha);
        }

        alpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                answer_state = true;

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    public void OnExitButtonClick(View View) {
        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
    }

    public void OnChoicesButton1Click(View view){
        if(answer_state == false) {
            if(Integer.parseInt(questions[question_number][6]) == 1){
                decision = true;
                correct_answers++;
            }else{
                decision = false;
            }
            response++;
            AlphaAnimation();
        }
    }

    public void OnChoicesButton2Click(View view){
        if(answer_state == false) {
            if(Integer.parseInt(questions[question_number][6]) == 2){
                decision = true;
                correct_answers++;
            }else{
                decision = false;
            }
            response++;
            AlphaAnimation();
        }
    }

    public void OnChoicesButton3Click(View view){
        if(answer_state == false) {
            if(Integer.parseInt(questions[question_number][6]) == 3){
                decision = true;
                correct_answers++;
            }else{
                decision = false;
            }
            response++;
            AlphaAnimation();
        }
    }

    public void OnChoicesButton4Click(View view){
        if(answer_state == false) {
            if(Integer.parseInt(questions[question_number][6]) == 4){
                decision = true;
                correct_answers++;
            }else{
                decision = false;
            }
            response++;
            AlphaAnimation();
        }
    }

}

