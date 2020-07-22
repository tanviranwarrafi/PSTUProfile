package com.rafyee.rafyee_rajiv.pstuprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.rafyee.rafyee_rajiv.pstuprofile.Dean.Dean;
import com.rafyee.rafyee_rajiv.pstuprofile.Dean.DeanDetails;
import com.rafyee.rafyee_rajiv.pstuprofile.all_user.ShowAllStudentsActivity;
import com.rafyee.rafyee_rajiv.pstuprofile.all_user.StudentPersonalDetailsActivity;

public class ViceChancellor extends AppCompatActivity {

    private ImageView backButton;
    private LinearLayout call;
    private LinearLayout sms;
    private LinearLayout email;

    private String vc_contactNo, vc_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vice_chancellor);
        getSupportActionBar().hide();

        backButton = findViewById(R.id.viceChancellor_backButton);
        call = findViewById(R.id.viceChancellor_call);
        sms = findViewById(R.id.viceChancellor_sms);
        email = findViewById(R.id.viceChancellor_email);

        vc_contactNo = "01552429714";
        vc_email ="vc@pstu.ac.bd";

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + vc_contactNo)));
            }
        });

        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendSMS = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + vc_contactNo));
                startActivity(sendSMS);
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {vc_email} );
                intent.putExtra(Intent.EXTRA_SUBJECT, "ই-মেইল সাবজেক্ট");
                intent.putExtra(Intent.EXTRA_TEXT, "ই-মেইল বডি");
                intent.setType("message/rfc822");
                Intent chooser = Intent.createChooser(intent,"ই-মেইল এ্যাপটি সিলেক্ট করুন...");
                startActivity(chooser);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(ViceChancellor.this, MainActivity.class);
                startActivity(backIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_right,R.anim.slideout_from_left);
            }
        });
    }

    public void onBackPressed() {
        Intent intent = new Intent(ViceChancellor.this, MainActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
        super.onBackPressed();
    }
}