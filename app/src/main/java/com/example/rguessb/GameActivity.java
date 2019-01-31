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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        findViewById(R.id.viewColor).setBackgroundColor(getRandomColor());
        sbRed = findViewById(R.id.seekBarRed);
        sbGreen = findViewById(R.id.seekBarGreen);
        sbBlue = findViewById(R.id.seekBarBlue);

        sbRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ((TextView)findViewById(R.id.textView)).setText(String.valueOf(progress));
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
        //Intent intent = new Intent(this, scoreScreenActivity.class);

    }



}
