package org.baltimorecityschools.yeatquizrc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
}