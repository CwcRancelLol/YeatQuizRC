package org.baltimorecityschools.yeatquizrc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    q1 = new Question("The Earth is round.", false, true);
    Question q2 = new Question("There are 3 contintents.", false, false);
    Question q3 = new Question("Earth is the closest planet to the sun.", false, false);
    Question q4 = new Question("The rain means God is crying.", false, false);
    Question q5 = new Question("The Earth's atmosphere is made mostly of oxygen", false, false);
    Question q6 = new Question("Earth is the biggest planet in our solar system.", false, false);
    Question q7 = new Question("Earth takes 365 days to orbit the sun", false, true);
    Question q8 = new Question("The Earth's atmosphere is mostly made up of nitrogen.", false, true);
    Question q9 = new Question("The Earth has more than one moon", false, true);
    Question q10 = new Question("The Earth has 5 layers.", false, false);

    Button correctBTN, falseBTN, doneBTN;
    TextView questionTV;
    ImageView questionIV;

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
                Toast.makeText(MainActivity.this, R.string.toasts_correct_btn, Toast.LENGTH_SHORT).show();
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