package org.baltimorecityschools.yeatquizrc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.snapshot.Index;

import java.util.ArrayList;

public class welc0meActivity extends AppCompatActivity {

    SharedPreferences.Editor spEditor;
    SharedPreferences myPrefs;
    final String sharedPrefFile= "org.baltimorecityschools.yeatquizrc";
    final String USER_KEY = "User";

    final String VIBRATE_KEY = "Vibrate";

    TextView rank1TV, rank2TV, rank3TV;

    Button yesBTN, noBTN, beginBTN;

    String username;

    EditText usernameET;

    FirebaseDatabase database;

    DatabaseReference myRef;

    final String TAG = "IDK";

    private ArrayList<HighScores> hsList;
    private int currentIndex;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welc0me);
        myPrefs = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        spEditor = myPrefs.edit();
        yesBTN = (Button) findViewById(R.id.yesBTN);
        noBTN = (Button) findViewById(R.id.noBTN);
        beginBTN = (Button) findViewById(R.id.beginBTN);
        rank1TV = (TextView) findViewById(R.id.rank1TV);
        rank2TV = (TextView) findViewById(R.id.rank2TV);
        rank3TV = (TextView) findViewById(R.id.rank3TV);
        usernameET = (EditText) findViewById(R.id.usernameET);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");

        //Create a new listener that gets all of the Customers in a single call to the database
        ValueEventListener allHighscoreQueryEventListener =
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                        //Initialize our customer array
                        hsList = new ArrayList<HighScores>();

// Iterate through all the children in the snapshot, this should be
// all the children in the "customers" object
                        for (DataSnapshot HSSnapShot : snapshot.getChildren()) {
                            //From our snapshot, get the value of our key/value pair. This value
                            //contains a customer object
                            HighScores newHS = HSSnapShot.getValue(HighScores.class);

                            Log.d("onDataChange()", "New Highscore: " + newHS.getName());
                            hsList.add(newHS);

                        }
                        //Check if we have any customers
                        if (hsList.size() > 0) {
                            //Set the current index to 0, which is the first entry in the array
                            //currentIndex = 0;
//                            //Get the first customer
//                            HighScores firstHS = hsList.get(currentIndex);
                            //Load the first customer into the view with our new function
                            rank1TV.setText(currentIndex+1 + ". " + hsList.get(currentIndex).getName() + " " + hsList.get(currentIndex).getScore());
                            currentIndex++;
                            if (hsList.size() > 1) {
                                    rank2TV.setText(currentIndex+1 + ". " + hsList.get(currentIndex).getName() + " " + hsList.get(currentIndex).getScore());
                                currentIndex++;
                                if (hsList.size() > 2) {
                                    rank3TV.setText(currentIndex+1 + ". " + hsList.get(currentIndex).getName() + " " + hsList.get(currentIndex).getScore());
                                }
                            }

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull @NotNull DatabaseError error) {
                    }
                };
                myRef.addValueEventListener(allHighscoreQueryEventListener);


        //public void loadUser(){
                //HighScores newUser =
                //rank1TV.setText(currentQuestion.getQuestion());
            //}


        // mkae a load leaderboard with some methods that will sort them
        //loadLeaderboard();









        //myRef.addValueEventListener(new ValueEventListener() {
            //@Override
            //public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //if (dataSnapshot.exists()){
                    //final String message = dataSnapshot.getValue(String.class);
                    //fireBaseTextView2.setText(message);
                //}
            //}

            //@Override
            //public void onCancelled(@NonNull DatabaseError databaseError) {

            //}
        //});
        yesBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            }


        });

        noBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }


        });

        beginBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                username = usernameET.getText().toString();
                spEditor.putString(USER_KEY, username);
                spEditor.apply();
                //myRef.setValue(username);

                Intent leaveIntent = new Intent(welc0meActivity.this, MainActivity.class);
                startActivity(leaveIntent);

            }


        });






    }
    private void loadHighscoreIntoView(int index) {
        //Get references for all of the views in this fragment

        //Set the values of the views based on the Customer object passed in to this method
//        rank1TV.setText(index+1 + ". " + hsList.get(index).getName() + " " + hsList.get(index).getScore());
        //rank2TV.setText("2. " + highScores.getName() + " " + highScores.getScore());
        //rank3TV.setText("3. " + HighScores.getName());



    }


}