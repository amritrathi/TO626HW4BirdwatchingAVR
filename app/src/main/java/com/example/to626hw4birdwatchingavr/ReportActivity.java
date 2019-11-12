package com.example.to626hw4birdwatchingavr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ReportActivity extends AppCompatActivity {

    Button buttonSubmit;
    EditText editTextbirdname, editTextzipcode, editTextpersonname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSubmit = findViewById(R.id.buttonSubmit);

        editTextbirdname = findViewById(R.id.editTextbirdname);
        editTextzipcode = findViewById(R.id.editTextpersonname);
        editTextpersonname = findViewById(R.id.editTextpersonname);
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
