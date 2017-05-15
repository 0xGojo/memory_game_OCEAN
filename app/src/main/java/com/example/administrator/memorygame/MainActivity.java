package com.example.administrator.memorygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    private Button mStartGameButton;
    ImageView hard,medium,easy,ggPlay,settings,tooltip,buttonLight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStartGameButton = (Button) findViewById(R.id.start_game_button);
        hard = (ImageView) findViewById(R.id.iv_hard);
        medium = (ImageView) findViewById(R.id.iv_medium);
        easy = (ImageView) findViewById(R.id.iv_easy);
        ggPlay = (ImageView) findViewById(R.id.google_play_button);
        settings = (ImageView) findViewById(R.id.settings_game_button);
        tooltip = (ImageView) findViewById(R.id.tooltip);
        buttonLight = (ImageView) findViewById(R.id.start_game_button_lights);
        mStartGameButton.setVisibility(View.VISIBLE);
        ggPlay.setVisibility(View.VISIBLE);
        settings.setVisibility(View.VISIBLE);
        tooltip.setVisibility(View.VISIBLE);
        buttonLight.setVisibility(View.VISIBLE);
        hard.setVisibility(View.INVISIBLE);
        easy.setVisibility(View.INVISIBLE);
        medium.setVisibility(View.INVISIBLE);
        mStartGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStartGameButton.setVisibility(View.INVISIBLE);
                ggPlay.setVisibility(View.INVISIBLE);
                settings.setVisibility(View.INVISIBLE);
                tooltip.setVisibility(View.INVISIBLE);
                buttonLight.setVisibility(View.INVISIBLE);
                hard.setVisibility(View.VISIBLE);
                easy.setVisibility(View.VISIBLE);
                medium.setVisibility(View.VISIBLE);
           }
        });

        hard.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                callActivity_2("hard");
            }
        });
        medium.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                callActivity_2("medium");
            }
        });
        easy.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                callActivity_2("easy");
            }
        });
    }



    protected void callActivity_2(String s) {
        Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);
        myIntent.putExtra("difficult",s);
        startActivity(myIntent);
    }
}
