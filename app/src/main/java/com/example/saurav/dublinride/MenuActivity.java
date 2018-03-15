package com.example.saurav.dublinride;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Saurav Sharma (16573)on 13/03/2018.
 */

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    //onClick method on list view button to open list main activity
    public void displayListView (View view){

        startActivity(new Intent(MenuActivity.this,ListMainActivity.class));

    }

    //onClick method on Map view button to open Map activity
    public void displayMapView (View view){

        startActivity(new Intent(MenuActivity.this,MapsActivity.class));

    }

    //onClick method on About view button to open about activity
    public void displayAboutView (View view){

        startActivity(new Intent(MenuActivity.this,About.class));

    }


}
