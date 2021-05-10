package com.hllbr.kenneyversion1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView scoretext ;
    TextView timetext ;
    int score ;
    ImageView imageView;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView[] kennyArray ;
    Handler handler;
    Runnable runnable ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoretext = findViewById(R.id.scoreText);

        timetext = findViewById(R.id.timeText);

        score = 0 ;

        imageView = findViewById(R.id.imageView);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3= findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);

        kennyArray = new ImageView[]{imageView,imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8};

        hideImages();

        new CountDownTimer(30000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timetext.setText("Time "+millisUntilFinished/1000);

            }

            @Override
            public void onFinish() {
                timetext.setText("Time Off");
                handler.removeCallbacks(runnable);
                for(ImageView image : kennyArray){
                    image.setVisibility(View.INVISIBLE);

                }
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Are you sure Reset");
                dialog.setMessage("Are you sure to restart game ?");
                dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                        intent.putExtra("score",score);
                        finish();
                        startActivity(intent);
                    }
                });
                dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"Game Over !",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
            }
        }.start();


    }

    public void touch(View view){

        score++;

        scoretext.setText("Score : "+score);
    }
    public void hideImages(){
        handler = new Handler();
        runnable= new Runnable() {
            @Override
            public void run() {
                for (ImageView image :kennyArray){
                    image.setVisibility(View.INVISIBLE);
                }
                Random random = new Random();
                int  i = random.nextInt(9);//bir fazla
                kennyArray[i].setVisibility(View.VISIBLE);

                handler.postDelayed(this,500);
            }
        };
        handler.post(runnable);

    }

}