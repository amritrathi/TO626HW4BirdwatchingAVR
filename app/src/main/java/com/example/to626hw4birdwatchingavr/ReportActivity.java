package com.example.to626hw4birdwatchingavr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ReportActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonSubmit;
    EditText editTextbirdname, editTextzipcode, editTextpersonname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSubmit = findViewById(R.id.buttonSubmit);

        editTextbirdname = findViewById(R.id.editTextbirdname);
        editTextzipcode = findViewById(R.id.editTextzipcode);
        editTextpersonname = findViewById(R.id.editTextpersonname);

        buttonSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("Birdsightings");

        if (view == buttonSubmit){

            String createBirdname = editTextbirdname.getText().toString();
            String createZipcode = editTextzipcode.getText().toString();
            String createPersonName = editTextpersonname.getText().toString();

            Birdsighting createBirdsighting = new Birdsighting(createBirdname, createZipcode, createPersonName);

            myRef.push().setValue(createBirdsighting);
        } else {

        }
    }

    //Code to bring in menu file to report activity page
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.mainmenu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    //Code to navigate menu items when selected
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.itemReport) {
            Toast.makeText(this, "You are already in Report page.", Toast.LENGTH_SHORT).show();
        } else if(item.getItemId() == R.id.itemSearch) {
            Intent searchIntent = new Intent(this, SearchActivity.class);
            startActivity(searchIntent);
        }

        return super.onOptionsItemSelected(item);
    }

}
