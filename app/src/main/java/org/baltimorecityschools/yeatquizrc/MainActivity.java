package org.baltimorecityschools.yeatquizrc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button correctBTN, falseBTN, doneBTN;
    TextView questionTV;

    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        correctBTN = (Button) findViewById(R.id.correctBTN);
        falseBTN = (Button) findViewById(R.id.falseBTN);
        doneBTN = (Button) findViewById(R.id.doneBTN);
        correctBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, R.string.correct_btn, Toast.LENGTH_SHORT).show();
                score += 1;
            }
        });
        falseBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You got it wrong!", Toast.LENGTH_SHORT).show();
            }
        });



        doneBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent leaveIntent = new Intent(MainActivity.this, scoreActivity.class);
                leaveIntent.putExtra("score", score);
                startActivity(leaveIntent);
            }
        });

    }
}


// for done button