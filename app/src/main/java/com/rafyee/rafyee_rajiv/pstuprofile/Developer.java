package com.rafyee.rafyee_rajiv.pstuprofile;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.rafyee.rafyee_rajiv.pstuprofile.Dean.Dean;
import com.rafyee.rafyee_rajiv.pstuprofile.Dean.DeanDetails;

public class Developer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);
        getSupportActionBar().hide();
    }

    public void onBackPressed() {
        Intent intent = new Intent(Developer.this, MainActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
        super.onBackPressed();
    }

}
