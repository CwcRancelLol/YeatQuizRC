package org.baltimorecityschools.yeatquizrc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class scoreActivity extends AppCompatActivity {

    TextView scoreTV;
    EditText emailET;
    Intent incomingIntent;
    int score;

    Button scoreBTN, uploadBTN;

    //userScore2 is for firebase

    String userEmail, userScore2;

    String userScore, username;
    FirebaseDatabase database;

    DatabaseReference myRef;

    HighScores newHS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        scoreTV = (TextView) findViewById(R.id.scoreTV);
        scoreBTN = (Button) findViewById(R.id.scoreBTN);
        uploadBTN = (Button) findViewById(R.id.uploadBTN);
        emailET = (EditText) findViewById(R.id.emailET);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");
        emailET.setText("");
        score = 0;
        incomingIntent = getIntent();
        score = incomingIntent.getIntExtra("score", score);
        scoreTV.setText(score + "");


        scoreBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userEmail = emailET.getText().toString();
                userScore = "Your score: " + score;
                if (userEmail.equals("")) {
                    Toast.makeText(scoreActivity.this, R.string.enter_email_toast, Toast.LENGTH_SHORT).show();
                } else {
                    composeEmail(userEmail, "World Quiz App Score", userScore);
                }

            }

        });

        uploadBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                newHS = new HighScores( ,score);

                myRef.setValue(newHS);


            }

        });
    }
    public void composeEmail(String userEmail, String subject, String userScore) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:" + userEmail)); // Only email apps handle this.
        intent.putExtra(Intent.EXTRA_TEXT, userScore);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.setType("message/rfc822");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(intent, "Choose email client:"));
        }
        else {
            Toast.makeText(this, "No email app found!", Toast.LENGTH_SHORT).show();

            }
        }

    public static class WelcomeActivity {
    }
}