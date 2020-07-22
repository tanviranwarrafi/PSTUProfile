package com.rafyee.rafyee_rajiv.pstuprofile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.rafyee.rafyee_rajiv.pstuprofile.Dean.Dean;
import com.rafyee.rafyee_rajiv.pstuprofile.Dean.DeanDetails;

public class Developer extends AppCompatActivity {

    private FrameLayout goBackToHome;
    private ImageView call, email;
    private ImageView facebook, git, linkedIn, instagram, skype;
    private ImageView pstuProfile, familyContact;
    private String phone_number, email_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);
        getSupportActionBar().hide();

        goBackToHome = findViewById(R.id.developer_frameLayout);
        call = findViewById(R.id.developer_call);
        email = findViewById(R.id.developer_email);
        facebook = findViewById(R.id.developer_facebook);
        git = findViewById(R.id.developer_git);
        linkedIn = findViewById(R.id.developer_linkedIn);
        instagram = findViewById(R.id.developer_intagram);
        skype = findViewById(R.id.developer_skype);
        pstuProfile = findViewById(R.id.developer_pstuProfile);
        familyContact = findViewById(R.id.developer_familyContact);

        phone_number = "01521438885";
        email_address = "tanviranwarrafi@gmail.com";

        goBackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(Developer.this, MainActivity.class);
                startActivity(backIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone_number)));
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {email_address} );
                intent.putExtra(Intent.EXTRA_SUBJECT, "ই-মেইল সাবজেক্ট");
                intent.putExtra(Intent.EXTRA_TEXT, "ই-মেইল বডি");
                intent.setType("message/rfc822");
                Intent chooser = Intent.createChooser(intent,"ই-মেইল এ্যাপটি সিলেক্ট করুন...");
                startActivity(chooser);
            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        git.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        linkedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        skype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        pstuProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        familyContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void onBackPressed() {
        Intent intent = new Intent(Developer.this, MainActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
        super.onBackPressed();
    }

}
