package com.example.administrator.memorygame;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Administrator on 24/04/2017.
 */


public class SecondActivity extends AppCompatActivity {

    TextView textView3,timer;
    ImageView pause;
    //need an array here to improve the code
    //  ImageView iv_11, iv_12, iv_13, iv_14, iv_21, iv_22, iv_23, iv_24, iv_31, iv_32, iv_33, iv_34;
    ImageView []iv;
    //ImageView []iv_easy = new ImageView[8];
   // ImageView []iv_hard = new ImageView[20];
    RelativeLayout easy,medium,hard;
    //array for the image
    int[] cardArray;
    int firstCard, secondCard;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;
    int img1, img2, img3, img4, img5, img6,img7, img8, img9, img10, img11, img12,img13, img14, img15, img16, img17, img18,img19, img20, img21, img22, img23, img24;
    int moves,playerPoints,count,stop ;
    String difficult;
    CountDownTimer countTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        moves = 0;
        playerPoints = 0;
        count=0;
        stop=1;
        //pause.setText("Tam Dung");
        timer = (TextView) findViewById(R.id.timer);
        textView3 = (TextView) findViewById(R.id.textView3);
        medium =(RelativeLayout)findViewById(R.id.medium);
        easy =(RelativeLayout)findViewById(R.id.easy);
        hard =(RelativeLayout)findViewById(R.id.hard);
        pause = (ImageView) findViewById(R.id.pause);
        easy.setVisibility(View.INVISIBLE);
        medium.setVisibility(View.INVISIBLE);
        hard.setVisibility(View.INVISIBLE);
        Intent intent = getIntent();
        difficult = intent.getStringExtra("difficult");

        long time=60000;
        if(difficult.equals("medium"))
            time = 90000;
        else  if(difficult.equals("hard"))
            time=120000;
        countTimer = new CountDownTimer(time, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {

                timer.setText("" + formatTime(millisUntilFinished));
            }

            @Override
            public void onFinish() {
                AlertDialog.Builder alterDialogBuilder = new AlertDialog.Builder(SecondActivity.this);
                alterDialogBuilder
                        .setMessage("You loose!! Try again")
                        .setCancelable(false)
                        .setPositiveButton("Replay",new DialogInterface.OnClickListener(){
                            @Override
                            public  void onClick(DialogInterface dialogInterface,int i){
                                finish();
                                startActivity(getIntent());
                            }
                        })
                        .setNegativeButton("Level",new DialogInterface.OnClickListener(){
                            @Override
                            public  void onClick(DialogInterface dialogInterface,int i){
                                finish();
                            }
                        });
                AlertDialog alertDialog = alterDialogBuilder.create();
                alertDialog.show();
            }
        }.start();


        //need a loop here to clean code
        if(difficult.equals("easy"))
        {
            easy.setVisibility(View.VISIBLE);
            cardArray = new int[]{1, 2, 3, 4, 1, 2, 3, 4};
            iv = new ImageView[8];
            iv[0] = (ImageView) findViewById(R.id.iv_easy_11);
            iv[1] = (ImageView) findViewById(R.id.iv_easy_12);
            iv[2] = (ImageView) findViewById(R.id.iv_easy_21);
            iv[3] = (ImageView) findViewById(R.id.iv_easy_22);
            iv[4] = (ImageView) findViewById(R.id.iv_easy_31);
            iv[5] = (ImageView) findViewById(R.id.iv_easy_32);
            iv[6] = (ImageView) findViewById(R.id.iv_easy_41);
            iv[7] = (ImageView) findViewById(R.id.iv_easy_42);

        }
       else if(difficult.equals("medium")) {
            medium.setVisibility(View.VISIBLE);
            cardArray = new int[]{1, 2, 3, 4,5,6, 1, 2, 3, 4,5,6};
            iv = new ImageView[12];
            iv[0] = (ImageView) findViewById(R.id.iv_11);
            iv[1] = (ImageView) findViewById(R.id.iv_12);
            iv[2] = (ImageView) findViewById(R.id.iv_13);
            iv[3] = (ImageView) findViewById(R.id.iv_14);
            iv[4] = (ImageView) findViewById(R.id.iv_21);
            iv[5] = (ImageView) findViewById(R.id.iv_22);
            iv[6] = (ImageView) findViewById(R.id.iv_23);
            iv[7] = (ImageView) findViewById(R.id.iv_24);
            iv[8] = (ImageView) findViewById(R.id.iv_31);
            iv[9] = (ImageView) findViewById(R.id.iv_32);
            iv[10] = (ImageView) findViewById(R.id.iv_33);
            iv[11] = (ImageView) findViewById(R.id.iv_34);
        }
        else {
            hard.setVisibility(View.VISIBLE);
            cardArray = new int[]{1, 2, 3, 4,5,6,7,8, 1, 2, 3, 4,5,6,7,8};
            iv = new ImageView[16];
            iv[0]= (ImageView) findViewById(R.id.iv_hard_11);
            iv[1]= (ImageView) findViewById(R.id.iv_hard_12);
            iv[2]= (ImageView) findViewById(R.id.iv_hard_13);
            iv[3]= (ImageView) findViewById(R.id.iv_hard_14);
            iv[4]= (ImageView) findViewById(R.id.iv_hard_21);
            iv[5]= (ImageView) findViewById(R.id.iv_hard_22);
            iv[6]= (ImageView) findViewById(R.id.iv_hard_23);
            iv[7]= (ImageView) findViewById(R.id.iv_hard_24);
            iv[8]= (ImageView) findViewById(R.id.iv_hard_31);
            iv[9]= (ImageView) findViewById(R.id.iv_hard_32);
            iv[10]= (ImageView) findViewById(R.id.iv_hard_33);
            iv[11]= (ImageView) findViewById(R.id.iv_hard_34);
            iv[12]= (ImageView) findViewById(R.id.iv_hard_41);
            iv[13]= (ImageView) findViewById(R.id.iv_hard_42);
            iv[14]= (ImageView) findViewById(R.id.iv_hard_43);
            iv[15]= (ImageView) findViewById(R.id.iv_hard_44);
        }

            // need a loop here to clean code -> done
       for(int i=0;i<iv.length;i++)
           iv[i].setTag(i);

        //load the card Image
        fontOfCardResources();
        // mix the images
       // Collections.shuffle(Arrays.asList(cardArray));
       shuffleArray(cardArray);
        textView3.setTextColor(Color.GRAY);
        //clean code -> done
        // pause game
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(stop==1) {
                    countTimer.cancel();
                    pause.setImageResource(R.drawable.continue_game);
                    for (int i = 0; i < iv.length; i++)
                        iv[i].setImageResource(R.drawable.img_default);

                    //clean code
                    for (int i = 0; i < iv.length; i++)
                        iv[i].setEnabled(false);
                    stop=2;
                }
                else{

                    for (int i = 0; i < iv.length; i++)
                        iv[i].setEnabled(true);
                    pause.setImageResource(R.drawable.pause_game);
                    stop=1;
                }

            }

        });
        for(int i=0;i<iv.length;i++) {
            iv[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int theCard = (int)view.getTag();
                    doStuff(iv[theCard], theCard);
                }

            });
        }
    }
        // mix function
    static void shuffleArray(int[] ar) {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            if (i == index) {
                ++i;
            } else {
                int a = ar[index];
                ar[index] = ar[i];
                ar[i] = a;
            }
        }
    }
    public String formatTime(long millis) {
        String output = "00:00";
        long seconds = millis / 1000;
        long minutes = seconds / 60;

        seconds = seconds % 60;
        minutes = minutes % 60;

        String sec = String.valueOf(seconds);
        String min = String.valueOf(minutes);

        if (seconds < 10)
            sec = "0" + seconds;
        if (minutes < 10)
            min= "0" + minutes;

        output = min + " : " + sec;
        return output;
    }//formatTime


    //clean code
    private void fontOfCardResources() {
        img1 = R.drawable.animals_1;
        img2 = R.drawable.animals_2;
        img3 = R.drawable.animals_3;
        img4 = R.drawable.animals_4;
        img5 = R.drawable.animals_5;
        img6 = R.drawable.animals_6;
        img7 = R.drawable.animals_7;
        img8 = R.drawable.animals_8;
        img9 = R.drawable.animals_9;
        img10 = R.drawable.animals_10;
        img11 = R.drawable.animals_11;
        img12 = R.drawable.animals_12;
        img13 = R.drawable.animals_13;
        img14=  R.drawable.animals_14;
        img15 = R.drawable.animals_15;
        img16 = R.drawable.animals_16;
        img17 = R.drawable.animals_17;
        img18 = R.drawable.animals_18;
        img19 = R.drawable.animals_19;
        img20 = R.drawable.animals_20;
        img21 = R.drawable.animals_21;
        img22 = R.drawable.animals_22;
        img23 = R.drawable.animals_23;
        img24=  R.drawable.animals_24;

    }

    private void doStuff(ImageView iv_single, final int theCard) {

        if(difficult.equals("medium")) {
            if (cardArray[theCard] == 1) {
                iv_single.setImageResource(img1);
            } else if (cardArray[theCard] == 2) {
                iv_single.setImageResource(img2);
            } else if (cardArray[theCard] == 3) {
                iv_single.setImageResource(img3);
            } else if (cardArray[theCard] == 4) {
                iv_single.setImageResource(img4);
            } else if (cardArray[theCard] == 5) {
                iv_single.setImageResource(img5);
            } else
                iv_single.setImageResource(img6);
        }
        else if(difficult.equals("easy"))
        {
            if(cardArray[theCard]==1){
                iv_single.setImageResource(img7);
            }
           else if(cardArray[theCard]==2){
                iv_single.setImageResource(img8);
            }
           else if(cardArray[theCard]==3){
                iv_single.setImageResource(img9);
            }
            else if(cardArray[theCard]==4){
                iv_single.setImageResource(img10);
            }

        }
        else {

            if (cardArray[theCard] == 1) {
                iv_single.setImageResource(img11);
            } else if (cardArray[theCard] == 2) {
                iv_single.setImageResource(img12);
            } else if (cardArray[theCard] == 3) {
                iv_single.setImageResource(img13);
            } else if (cardArray[theCard] == 4) {
                iv_single.setImageResource(img14);
            } else if (cardArray[theCard] == 5) {
                iv_single.setImageResource(img15);
            } else if (cardArray[theCard] == 6) {
                iv_single.setImageResource(img16);
            } else  if(cardArray[theCard]==7){
                iv_single.setImageResource(img17);
            }
            else{
                iv_single.setImageResource(img18);
            }
        }


        if (cardNumber == 1) {
            cardNumber = 2;
            firstCard = cardArray[theCard];
            clickedFirst= theCard;
            iv_single.setEnabled(false);
        } else {
            moves++;
            cardNumber = 1;
            secondCard = cardArray[theCard];
            clickedSecond = theCard;
          // clean code -> done
            for(int i=0;i<iv.length;i++)
            iv[i].setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    checkPair();
                }
            }, 500);
        }

    }

    private void checkPair() {
        if (cardArray[firstCard]==(cardArray[secondCard])) {
                iv[clickedFirst].setVisibility(View.INVISIBLE);
                iv[clickedSecond].setVisibility(View.INVISIBLE);
                playerPoints+=5;
                textView3.setText("Diem: "+playerPoints);
                for(int i=0;i<iv.length;i++)
                iv[i].setEnabled(true);
                count++;
                checkEndGame();
        }
        else {
            //clean code -> done
            for(int i=0;i< iv.length;i++)
            iv[i].setImageResource(R.drawable.img_default);

            //clean code
            for(int i=0;i< iv.length;i++)
            iv[i].setEnabled(true);
        }

    }

    private  void checkEndGame(){
     if((count==4&&difficult.equals("easy"))||(count==6&&difficult.equals("medium"))||(count==8&&difficult.equals("hard")))
     {
         countTimer.cancel();
         AlertDialog.Builder alterDialogBuilder = new AlertDialog.Builder(SecondActivity.this);
        alterDialogBuilder
                    .setMessage("You won !!! \n Your high score "+playerPoints+"\n Your moves"+moves)
                    .setCancelable(false)
                    .setPositiveButton("Menu",new DialogInterface.OnClickListener(){
                            @Override
                            public  void onClick(DialogInterface dialogInterface,int i){
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                    })
                    .setNegativeButton("Level",new DialogInterface.OnClickListener(){
                        @Override
                        public  void onClick(DialogInterface dialogInterface,int i){
                            finish();
                        }
                    });
         AlertDialog alertDialog = alterDialogBuilder.create();
         alertDialog.show();
     }
    }


}