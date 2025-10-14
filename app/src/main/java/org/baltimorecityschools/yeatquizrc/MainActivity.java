package org.baltimorecityschools.yeatquizrc;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    //Question q1 = new Question("The Earth is round.", false, true);
    //Question q2 = new Question("There are 3 contintents.", false, false);
    //Question q3 = new Question("Earth is the closest planet to the sun.", false, false);
    //Question q4 = new Question("The rain means God is crying.", false, false);
    //Question q5 = new Question("The Earth's atmosphere is made mostly of oxygen", false, false);
    //Question q6 = new Question("Earth is the biggest planet in our solar system.", false, false);
    //Question q7 = new Question("Earth takes 365 days to orbit the sun", false, true);
    //Question q8 = new Question("The Earth's atmosphere is mostly made up of nitrogen.", false, true);
    //Question q9 = new Question("The Earth has more than one moon", false, true);
    //Question q10 = new Question("The Earth has 5 layers.", false, false);

    Button trueBTN, falseBTN, doneBTN;
    TextView questionTV;
    int questionIndex = 0;
    int score;

    ImageView questionIV;

    Question[] questionsList = {
            new Question("The Earth is round.", false, true, R.drawable.flat_earth),
           new Question("There are 3 contintents.", false, false, R.drawable.supercontinent),
            new Question("Earth is the closest planet to the sun.", false, false, R.drawable.solarsystem),
            new Question("The rain means God is crying.", false, false, R.drawable.q4),
           new Question("The Earth's atmosphere is made mostly of oxygen", false, false, R.drawable.q5),
            new Question("Earth is the biggest planet in our solar system.", false, false, R.drawable.q6),
            new Question("Earth takes 365 days to orbit the sun", false, true, R.drawable.q7),
            new Question("The Earth's atmosphere is mostly made up of nitrogen.", false, true, R.drawable.q8),
            new Question("The Earth has more than one moon", false, true, R.drawable.q9),
           new Question("The Earth has 5 layers.", false, false, R.drawable.q10)
   };

    Question currentQuestion = questionsList[questionIndex];





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        trueBTN = (Button) findViewById(R.id.trueBTN);
        falseBTN = (Button) findViewById(R.id.falseBTN);
        doneBTN = (Button) findViewById(R.id.doneBTN);
        questionTV = (TextView) findViewById(R.id.questionTV);
        questionIV = (ImageView) findViewById(R.id.question_image);
        loadQuestion();

        questionTV.setText(currentQuestion.getQuestion());
        trueBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //make an if loop saying if its right make that toast, and other wise.
                Toast.makeText(MainActivity.this, R.string.toasts_correct_btn, Toast.LENGTH_SHORT).show();
                score += 1;
                questionIndex++;
                loadQuestion();

                //questionTV.setText(q2.toString());

            }
        });
        falseBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You got it wrong!", Toast.LENGTH_SHORT).show();
                TextView tv = (TextView) findViewById(R.id.questionTV);
                questionIndex++;
                loadQuestion();
                //questionTV.setText(q2.toString());
                //q2.setIsCorrect(true);
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
    public void loadQuestion(){
        if(questionIndex < questionsList.length) {
            Question currentQuestion = questionsList[questionIndex];
            questionTV.setText(currentQuestion.getQuestion());
            questionIV.setImageResource(currentQuestion.getImageResId());
        } else {
            Intent leaveIntent = new Intent(MainActivity.this, scoreActivity.class);
            leaveIntent.putExtra("score", score);
            startActivity(leaveIntent);
        }
    }

}


// for done button