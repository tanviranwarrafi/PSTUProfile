package com.rafyee.rafyee_rajiv.pstuprofile.Cources;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.rafyee.rafyee_rajiv.pstuprofile.R;
import com.rafyee.rafyee_rajiv.pstuprofile.MainActivity;

public class CourseFaculty extends AppCompatActivity {

    private ImageView backButton;
    private CardView agriculture, computerScience, businessAdministration, nutrationAndFood,
            desastarManagement, landManagement, animalHusbandary, vetenaryMedecine, fisharies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_faculty);
        getSupportActionBar().hide();

        backButton = findViewById(R.id.courseFaculty_backButton);
        agriculture = findViewById(R.id.courseFaculty_agriculture);
        computerScience = findViewById(R.id.courseFaculty_cse);
        businessAdministration = findViewById(R.id.courseFaculty_bba);
        nutrationAndFood = findViewById(R.id.courseFaculty_nfs);
        desastarManagement = findViewById(R.id.courseFaculty_esdm);
        landManagement = findViewById(R.id.courseFaculty_nfslandManagement);
        animalHusbandary = findViewById(R.id.courseFaculty_animalHusbandary);
        vetenaryMedecine = findViewById(R.id.courseFaculty_dvm);
        fisharies = findViewById(R.id.courseFaculty_fisharies);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(CourseFaculty.this, MainActivity.class);
                startActivity(backIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
            }
        });

        agriculture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CourseFaculty.this, CourseDetails.class);
                i.putExtra("faculty", "Agriculture");
                i.putExtra("faculty_name", "এগ্রিকালচার অনুষদ");
                startActivity(i);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });

        computerScience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CourseFaculty.this, CourseDetails.class);
                i.putExtra("faculty", "Computer Science and Engineering");
                i.putExtra("faculty_name", "সিএসই অনুষদ");
                startActivity(i);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });

        businessAdministration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CourseFaculty.this, CourseDetails.class);
                i.putExtra("faculty", "Business Administration and Management");
                i.putExtra("faculty_name", "বিবিএ অনুষদ");
                startActivity(i);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });

        nutrationAndFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CourseFaculty.this, CourseDetails.class);
                i.putExtra("faculty", "Nutrition and Food Science");
                i.putExtra("faculty_name", "এনএফএস অনুষদ");
                startActivity(i);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });

        desastarManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CourseFaculty.this, CourseDetails.class);
                i.putExtra("faculty", "Disaster Management");
                i.putExtra("faculty_name", "ডিজাস্টার ম্যানেজমেন্ট");
                startActivity(i);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });

        landManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CourseFaculty.this, CourseDetails.class);
                i.putExtra("faculty", "Land Management");
                i.putExtra("faculty_name", "ল্যান্ড ম্যানেজমেন্ট");
                startActivity(i);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });

        animalHusbandary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CourseFaculty.this, CourseDetails.class);
                i.putExtra("faculty", "Animal Husbandry");
                i.putExtra("faculty_name", "এনিম্যাল হাজবেন্ডারী");
                startActivity(i);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });

        vetenaryMedecine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CourseFaculty.this, CourseDetails.class);
                i.putExtra("faculty", "Doctor of Veterinary Medicine");
                i.putExtra("faculty_name", "ডক্টর অব ভ্যাটেনারি মেডিসিন");
                startActivity(i);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });

        fisharies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CourseFaculty.this, CourseDetails.class);
                i.putExtra("faculty", "Fisharies");
                i.putExtra("faculty_name", "ফিসারিজ অনুষদ");
                startActivity(i);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });
    }

    public void onBackPressed() {
        Intent intent = new Intent(CourseFaculty.this, MainActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
        super.onBackPressed();
    }
}