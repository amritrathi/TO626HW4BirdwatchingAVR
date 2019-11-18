package com.example.to626hw4birdwatchingavr;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonSearch;
    EditText editTextzipcodesearch;
    TextView textViewShowBirdName, textViewShowPersonName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        buttonSearch = findViewById(R.id.buttonSearch);

        editTextzipcodesearch = findViewById(R.id.editTextzipcodesearch);

        textViewShowBirdName = findViewById(R.id.textViewShowBirdName);
        textViewShowPersonName = findViewById(R.id.textViewShowPersonName);

        buttonSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("Birdsightings");

        if (view == buttonSearch) {
            String findZipcode = editTextzipcodesearch.getText().toString();

            myRef.orderByChild("createZipcode").equalTo(findZipcode).addChildEventListener(new ChildEventListener() {

                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    //String findZipcode = dataSnapshot.getKey();
                    Birdsighting foundBirdsighting = dataSnapshot.getValue(Birdsighting.class);
                    String findBirdname = foundBirdsighting.createBirdname;
                    String findPersonName = foundBirdsighting.createPersonName;

                    textViewShowBirdName.setText(findBirdname);
                    textViewShowPersonName.setText(findPersonName);

                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        } else {

        }

    }

    //Code to bring in menu file to report activity pag
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    //Code to navigate menu items when selected
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.itemSearch) {
            Toast.makeText(this, "You are already in Search page.", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.itemReport) {
            Intent reportIntent = new Intent(this, ReportActivity.class);
            startActivity(reportIntent);
        }

        return super.onOptionsItemSelected(item);
    }


}
