package com.rafyee.rafyee_rajiv.pstuprofile.Developer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.rafyee.rafyee_rajiv.pstuprofile.MainActivity;
import com.rafyee.rafyee_rajiv.pstuprofile.R;

public class Developer extends AppCompatActivity {

    private FrameLayout goBackToHome;
    private ImageView call, email;
    private ImageView facebook, git, linkedIn, instagram, skype;
    private ImageView pstuProfile, familyContact;
    private String phone_number, email_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.developer);
        getSupportActionBar().hide();

        goBackToHome = findViewById(R.id.developer_frameLayout);
        call = findViewById(R.id.developer_call);
        email = findViewById(R.id.developer_email);
        facebook = findViewById(R.id.developer_facebook);
        git = findViewById(R.id.developer_git);
        linkedIn = findViewById(R.id.developer_linkedIn);
        instagram = findViewById(R.id.developer_instagram);
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
                Intent facebookIntent = new Intent(Developer.this, DeveloperWebview.class);
                facebookIntent.putExtra("link", getResources().getString(R.string.facebook_account));
                facebookIntent.putExtra("actionbar_title", getResources().getString(R.string.facebook_account));
                facebookIntent.putExtra("status_bar_color", getResources().getColor(R.color.green_primary));
                startActivity(facebookIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });

        git.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gitIntent = new Intent(Developer.this, DeveloperWebview.class);
                gitIntent.putExtra("link", getResources().getString(R.string.git_account));
                gitIntent.putExtra("actionbar_title", getResources().getString(R.string.git_actonbar));
                startActivity(gitIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });

        linkedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent linkedInIntent = new Intent(Developer.this, DeveloperWebview.class);
                linkedInIntent.putExtra("link", getResources().getString(R.string.linkedIn_account));
                linkedInIntent.putExtra("actionbar_title", getResources().getString(R.string.linkedIn_actonbar));
                startActivity(linkedInIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent instagramIntent = new Intent(Developer.this, DeveloperWebview.class);
                instagramIntent.putExtra("link", getResources().getString(R.string.instagram_account));
                instagramIntent.putExtra("actionbar_title", getResources().getString(R.string.instagram_actonbar));
                startActivity(instagramIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });

        skype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent i = new Intent(Intent.ACTION_VIEW);
                i.setComponent(new ComponentName(
                        "com.skype.android.lite",
                        "com.skype.android.lite.SkypeActivity"
                ));
                startActivity(i);*/
            }
        });

        pstuProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pstuProfileIntent = new Intent(Developer.this, DeveloperWebview.class);
                pstuProfileIntent.putExtra("link", getResources().getString(R.string.pstuProfile_app));
                pstuProfileIntent.putExtra("actionbar_title", getResources().getString(R.string.pstuProfile_actonbar));
                startActivity(pstuProfileIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });

        familyContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent familyContactIntent = new Intent(Developer.this, DeveloperWebview.class);
                familyContactIntent.putExtra("link", getResources().getString(R.string.familyContact_app));
                familyContactIntent.putExtra("actionbar_title", getResources().getString(R.string.familyContact_actionbar));
                startActivity(familyContactIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
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
