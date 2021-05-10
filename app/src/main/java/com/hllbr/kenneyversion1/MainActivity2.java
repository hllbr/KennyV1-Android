package com.hllbr.kenneyversion1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    int score;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView= findViewById(R.id.scoreTt);
        Intent intent = getIntent();
        score = intent.getIntExtra("score",0);
        if(score == 0){
            textView.setText("welcome to imposter capture game");
        }else{
            textView.setText("Your Last Catch Score "+score);
        }

    }
    public void start(View view){

        Intent intent = new Intent(MainActivity2.this,MainActivity.class);

        startActivity(intent);
    }

}