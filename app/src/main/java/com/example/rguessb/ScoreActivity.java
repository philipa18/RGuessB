package com.example.rguessb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

// Screen that will display final score and allow return to main menu.
public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        // Pulls score from passed on intent and displays it
        Intent intent = getIntent();
        String scoreText  = intent.getStringExtra("com.example.rguessb.score");
        TextView scoreView = findViewById(R.id.scoreView);
        scoreView.setText(scoreText);
    }

    // Triggered by button click on screen. Immediately returns to main menu, no data saved.
    public void toMenu(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
