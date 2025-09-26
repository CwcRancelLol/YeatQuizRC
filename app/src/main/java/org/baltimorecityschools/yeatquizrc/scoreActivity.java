package org.baltimorecityschools.yeatquizrc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class scoreActivity extends AppCompatActivity {

    TextView scoreTV;
    Intent incomingIntent;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        scoreTV = (TextView) findViewById(R.id.scoreTV);
        score = 0;
        incomingIntent = getIntent();
        score = incomingIntent.getIntExtra("score", score);
        scoreTV.setText(score +"");
    }
}