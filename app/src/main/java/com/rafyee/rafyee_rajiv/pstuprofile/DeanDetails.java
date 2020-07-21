package com.rafyee.rafyee_rajiv.pstuprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DeanDetails extends AppCompatActivity {

    private TextView deanName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dean_details);
        getSupportActionBar().hide();

        Intent intent = getIntent();
        String dean_name = intent.getExtras().getString("dean_name");

        deanName = findViewById(R.id.deanDetails_deanName);

        deanName.setText(dean_name);

    }
}