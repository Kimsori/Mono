package com.example.user.fuck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main8Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        setTitle("메인");


    }

    public void NextScene( View vi ) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }




    public void PB1 ( View view ) {

        Toast toast = Toast.makeText(getApplicationContext(), "This is Musical Ticket Reservation Service", Toast.LENGTH_SHORT);
        toast.show();
    }



}

