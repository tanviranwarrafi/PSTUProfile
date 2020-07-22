package com.rafyee.rafyee_rajiv.pstuprofile.AllTeachers;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.rafyee.rafyee_rajiv.pstuprofile.R;

public class TeacherDetails extends AppCompatActivity {

    private ImageView backButton;
    private TextView teacherName, teacherPost, teacherDepartment, teacherFaculty, teacherContact,
            teacherEmail;
    private String name, post, faculty, department, contact, email;
    private LinearLayout call, sendSMS, sendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_details);
        getSupportActionBar().hide();

        backButton = findViewById(R.id.teacherPersonalDetails_backButton);
        teacherName = findViewById(R.id.teacherPersonalDetails_teacherName);
        teacherPost = findViewById(R.id.teacherPersonalDetails_teacherPost);
        teacherDepartment = findViewById(R.id.teacherPersonalDetails_teacherDepartment);
        teacherFaculty = findViewById(R.id.teacherPersonalDetails_teacherFaculty);
        teacherContact = findViewById(R.id.teacherPersonalDetails_teacherContactNo);
        teacherEmail = findViewById(R.id.teacherPersonalDetails_teacherEmail);
        call = findViewById(R.id.teacherPersonalDetails_teacherCallBtn);
        sendSMS = findViewById(R.id.teacherPersonalDetails_sendSMS);
        sendEmail = findViewById(R.id.teacherPersonalDetails_teacherSendEmail);

        Intent intent = getIntent();
        name = intent.getExtras().getString("t_name");
        post = intent.getExtras().getString("t_post");
        faculty = intent.getExtras().getString("t_faculty");
        department = intent.getExtras().getString("t_dept");
        contact = intent.getExtras().getString("t_contact");
        email = intent.getExtras().getString("t_email");

        teacherName.setText(name);
        teacherPost.setText(post);
        teacherDepartment.setText(department);
        teacherFaculty.setText(faculty);
        teacherContact.setText(contact);
        teacherEmail.setText(email);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(TeacherDetails.this, AllTeachers.class);
                startActivity(backIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + contact)));
            }
        });

        sendSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendSMS = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + contact));
                startActivity(sendSMS);
            }
        });

        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Email Subject");
                intent.putExtra(Intent.EXTRA_TEXT, "Email Body");
                intent.setType("message/rfc822");
                Intent chooser = Intent.createChooser(intent, "Choose One...");
                startActivity(chooser);
            }
        });
    }

    public void onBackPressed() {
        Intent intent = new Intent(TeacherDetails.this, AllTeachers.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
        super.onBackPressed();
    }
}
