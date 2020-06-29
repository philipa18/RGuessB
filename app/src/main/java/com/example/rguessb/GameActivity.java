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
    // Sets up the game itself
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        // Displays randomly-generated color.
        findViewById(R.id.viewColor).setBackgroundColor(getRandomColor());

        sbRed = findViewById(R.id.seekBarRed);
        sbGreen = findViewById(R.id.seekBarGreen);
        sbBlue = findViewById(R.id.seekBarBlue);
        // Changes the displayed value of the users guess for each color when they move the dials.
        sbRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ((TextView)findViewById(R.id.textView)).setText("R: "+String.valueOf(progress));
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
                ((TextView)findViewById(R.id.textView2)).setText("G: "+String.valueOf(progress));
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
                ((TextView)findViewById(R.id.textView3)).setText("B: "+String.valueOf(progress));
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

    // Generates the random color to be displayed color to be displayed.
    public int getRandomColor(){
        // Random number generator that will be used for each basic color.
        Random rnd = new Random();
        /* Intensity of red, green, and blue are each designated in the RGB code by an integer in
           the range[0,255], so a bound of 256 will be used for the RNG. */
        redVal = rnd.nextInt(256);
        blueVal = rnd.nextInt(256);
        greenVal = rnd.nextInt(256);
        // Color object with composite color is returned.
        // Alpha value of 255 is used as we want the color to be completely opaque.
        return Color.argb(255, redVal, blueVal, greenVal);
    }

    // Will calculate score and send it to the final screen to be displayed.
    public void endRound(View view){
        // Intent that will carry score to Score Activity
        Intent intent = new Intent(this, ScoreActivity.class);
        // Difference between user guess and actual value of each color is found.
        int redDif = Math.abs(redVal - redGuess);
        int blueDif = Math.abs(blueVal - blueGuess);
        int greenDif = Math.abs(greenVal - greenGuess);
        // Differences are all subtracted from 765, the maximum cumulative difference.
        int score = 765 - redDif - blueDif - greenDif;
        // Text for score display is placed on Score Activity before activity itself is displayed.
        intent.putExtra("com.example.rguessb.score", "Score: "+ String.valueOf(score));
        startActivity(intent);

    }



}
