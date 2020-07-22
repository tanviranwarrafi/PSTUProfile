package com.rafyee.rafyee_rajiv.pstuprofile.Dean;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rafyee.rafyee_rajiv.pstuprofile.R;

public class DeanDetails extends AppCompatActivity {

    private ImageView deanImage, backButton;
    private TextView deanName, deanDesignation;
    private ImageView call, sms, email, fax;
    private TextView deanContactNo, deanEmailAddress, deanFax, deanAddress;

    private String dean_name, dean_designation, dean_contact, dean_email, dean_fax, dean_address, dean_contact_english;
    private int dean_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dean_details);
        getSupportActionBar().hide();

        Intent intent = getIntent();
        dean_name = intent.getExtras().getString("dean_name");
        dean_designation = intent.getExtras().getString("dean_designation");
        dean_contact = intent.getExtras().getString("dean_contact");
        dean_email = intent.getExtras().getString("dean_email");
        dean_fax = intent.getExtras().getString("dean_fax");
        dean_address = intent.getExtras().getString("dean_address");

        int dean_image = intent.getExtras().getInt("dean_image");

        dean_contact_english = intent.getExtras().getString("dean_contact_english");

        deanImage = findViewById(R.id.deanDetails_deanImage);
        backButton = findViewById(R.id.deanDetails_backButton);
        deanName = findViewById(R.id.deanDetails_deanName);
        deanDesignation = findViewById(R.id.deanDetails_deanDesignation);
        call = findViewById(R.id.deanDetails_deanCall);
        sms = findViewById(R.id.deanDetails_deanSMS);
        email = findViewById(R.id.deanDetails_deanEmail);
        fax = findViewById(R.id.deanDetails_deanFax);
        deanContactNo = findViewById(R.id.deanDetails_contactNo);
        deanEmailAddress = findViewById(R.id.denaDetails_emailAddress);
        deanFax = findViewById(R.id.denaDetails_faxNumber);
        deanAddress = findViewById(R.id.denaDetails_address);

        deanImage.setImageResource(dean_image);
        deanName.setText(dean_name);
        deanDesignation.setText(dean_designation);
        deanContactNo.setText(dean_contact);
        deanEmailAddress.setText(dean_email);
        deanFax.setText(dean_fax + " ফ্যাক্স নম্বর");
        deanAddress.setText(dean_address);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + dean_contact_english)));
            }
        });

        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendSMS = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + dean_contact_english));
                startActivity(sendSMS);
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {dean_email} );
                intent.putExtra(Intent.EXTRA_SUBJECT, "ই-মেইল সাবজেক্ট");
                intent.putExtra(Intent.EXTRA_TEXT, "ই-মেইল বডি");
                intent.setType("message/rfc822");
                Intent chooser = Intent.createChooser(intent,"ই-মেইল এ্যাপটি সিলেক্ট করুন...");
                startActivity(chooser);
            }
        });

        fax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DeanDetails.this, "ফ্যাক্স ফিচারটি এখনো নির্মানাধীন", Toast.LENGTH_SHORT).show();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(DeanDetails.this, Dean.class);
                startActivity(backIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_right,R.anim.slideout_from_left);
            }
        });

    }

    public void onBackPressed() {
        Intent intent = new Intent(DeanDetails.this, Dean.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
        super.onBackPressed();
    }
}