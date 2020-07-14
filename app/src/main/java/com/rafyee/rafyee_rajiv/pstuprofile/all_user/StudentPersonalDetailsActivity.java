package com.rafyee.rafyee_rajiv.pstuprofile.all_user;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.rafyee.rafyee_rajiv.pstuprofile.R;

public class StudentPersonalDetailsActivity extends AppCompatActivity {

    private ImageView backButton;
    private TextView studentName, studentID, studentRegistration, studentFaculty, studentBatch,
            studentContact, studentEmail;
    private String name, id_no, registration_no, password, faculty, batch, contact, email;
    private LinearLayout call, sendSMS, sendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_personal_details_activity);
        getSupportActionBar().hide();

        backButton = findViewById(R.id.studentPersonalDetails_backButton);
        studentName = findViewById(R.id.studentPersonalDetails_studentName);
        studentID = findViewById(R.id.studentPersonalDetails_studentIDNo);
        studentRegistration = findViewById(R.id.studentPersonalDetails_studentRegistrationNo);
        studentFaculty = findViewById(R.id.studentPersonalDetails_studentFaculty);
        studentBatch = findViewById(R.id.studentPersonalDetails_studentBatch);
        studentContact = findViewById(R.id.studentPersonalDetails_studentContactNo);
        studentEmail = findViewById(R.id.studentPersonalDetails_studentEmailAddress);
        call = findViewById(R.id.btnCall);
        sendSMS = findViewById(R.id.studentPersonalDetails_sendSMS);
        sendEmail = findViewById(R.id.btnEmail);

        Intent intent = getIntent();
        name = intent.getExtras().getString("name");
        id_no = intent.getExtras().getString("Id_no");
        registration_no = intent.getExtras().getString("reg_no");
        password = intent.getExtras().getString("pass");
        faculty = intent.getExtras().getString("faculty");
        batch = intent.getExtras().getString("batch");
        contact = intent.getExtras().getString("contact");
        email = intent.getExtras().getString("email");

        studentName.setText(name);
        studentID.setText(id_no + " (ক্যাম্পাস আইডি)");
        studentRegistration.setText(registration_no + " (রেজিস্ট্রেশন নম্বর)");
        studentFaculty.setText(faculty);
        studentBatch.setText(batch);
        studentContact.setText(contact);
        studentEmail.setText(email);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(StudentPersonalDetailsActivity.this, ShowAllStudentsActivity.class);
                startActivity(backIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_right,R.anim.slideout_from_left);
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
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {email} );
                intent.putExtra(Intent.EXTRA_SUBJECT, "Email Subject");
                intent.putExtra(Intent.EXTRA_TEXT, "Email Body");
                intent.setType("message/rfc822");
                Intent chooser = Intent.createChooser(intent,"Choose One...");
                startActivity(chooser);
            }
        });
    }

    public void onBackPressed() {
        Intent intent = new Intent(StudentPersonalDetailsActivity.this, ShowAllStudentsActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.slide_from_right,R.anim.slideout_from_left);
        super.onBackPressed();
    }
}