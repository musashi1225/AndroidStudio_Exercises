package com.example.kitep03.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

public class QuizActivity extends AppCompatActivity {

    boolean decision;
    boolean answer_state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        answer_state = false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        if(answer_state == true){
            if(decision == true){
                Intent intent = new Intent(this,QuizActivity.class);
                startActivity(intent);
            }else{
                Intent intent = new Intent(this,Commentary.class);
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
            decision = true;
            AlphaAnimation();
        }
    }

    public void OnChoicesButton2Click(View view){
        if(answer_state == false) {
            decision = false;
            AlphaAnimation();
        }
    }

    public void OnChoicesButton3Click(View view){
        if(answer_state == false) {
            decision = false;
            AlphaAnimation();
        }
    }

    public void OnChoicesButton4Click(View view){
        if(answer_state == false) {
            decision = false;
            AlphaAnimation();
        }
    }

}
