package com.example.to626hw4birdwatchingavr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    //Code to bring in menu file to report activity pag
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    //Code to navigate menu items when selected
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.itemSearch) {
            Toast.makeText(this, "You are already in Search page.", Toast.LENGTH_SHORT).show();
        } else if(item.getItemId() == R.id.itemReport) {
            Intent reportIntent = new Intent(this, SearchActivity.class);
            startActivity(reportIntent);
        }

        return super.onOptionsItemSelected(item);
    }
}
