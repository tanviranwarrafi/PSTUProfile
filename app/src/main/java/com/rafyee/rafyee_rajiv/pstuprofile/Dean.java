package com.rafyee.rafyee_rajiv.pstuprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Dean extends AppCompatActivity {

    private LinearLayout agricultureDean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dean);
        getSupportActionBar().hide();

        agricultureDean = findViewById(R.id.agricultureDean);

        agricultureDean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent agricultureDeanIntent = new Intent(Dean.this, DeanDetails.class);
                agricultureDeanIntent.putExtra("dean_name", "প্রোফেসর মোঃ জামাল হোসেন");
                startActivity(agricultureDeanIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });
    }
}