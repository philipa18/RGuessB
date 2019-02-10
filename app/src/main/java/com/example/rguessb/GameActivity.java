package com.example.rguessb;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    private SeekBar sbRed;
    private SeekBar sbGreen;
    private SeekBar sbBlue;

    int redVal;
    int greenVal;
    int blueVal;

    int redGuess;
    int greenGuess;
    int blueGuess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        findViewById(R.id.viewColor).setBackgroundColor(getRandomColor());
        sbRed = findViewById(R.id.seekBarRed);
        sbGreen = findViewById(R.id.seekBarGreen);
        sbBlue = findViewById(R.id.seekBarBlue);
        //Changing the displayed value of the color when user moves seek bar
        sbRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ((TextView)findViewById(R.id.textView)).setText(String.valueOf(progress));
                redGuess = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sbGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ((TextView)findViewById(R.id.textView2)).setText(String.valueOf(progress));
                blueGuess = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sbBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ((TextView)findViewById(R.id.textView3)).setText(String.valueOf(progress));
                greenGuess = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public int getRandomColor(){
        Random rnd = new Random();
        redVal = rnd.nextInt(256);
        blueVal = rnd.nextInt(256);
        greenVal = rnd.nextInt(256);
        return Color.argb(255, redVal, blueVal, greenVal);
    }

    public void endRound(View view){
        Intent intent = new Intent(this, ScoreActivity.class);
        int redDif = Math.abs(redVal - redGuess);
        int blueDif = Math.abs(blueVal - blueGuess);
        int greenDif = Math.abs(greenVal - greenGuess);
        int score = 255*3 - redDif - blueDif - greenDif;
        intent.putExtra("com.example.rguessb.score", "Score: "+ String.valueOf(score));
        startActivity(intent);

    }



}
