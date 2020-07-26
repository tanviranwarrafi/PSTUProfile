package com.rafyee.rafyee_rajiv.pstuprofile;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.rafyee.rafyee_rajiv.pstuprofile.Dean.Dean;
import com.rafyee.rafyee_rajiv.pstuprofile.AllStudents.AllStudents;
import com.rafyee.rafyee_rajiv.pstuprofile.AllTeachers.AllTeachers;
import com.rafyee.rafyee_rajiv.pstuprofile.Cources.CourseFaculty;
import com.rafyee.rafyee_rajiv.pstuprofile.Developer.Developer;
import com.rafyee.rafyee_rajiv.pstuprofile.StudentProfile.StudentLogin;
import com.rafyee.rafyee_rajiv.pstuprofile.TeacherProfile.TeacherLogin;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageSlider imageSlider;
    private LinearLayout studentLogin;
    private LinearLayout showAllStudents;
    private LinearLayout teacherLogin;
    private LinearLayout showAllTeachers;
    private LinearLayout cources;
    private LinearLayout viceChancellor;
    private LinearLayout developer;
    private LinearLayout dean;
    private LinearLayout website;

    private String pstu_website_link, websitepage_actionbar;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        Window window = this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.colorFlower));

        imageSlider = findViewById(R.id.mainActivity_imageSlider);
        studentLogin = findViewById(R.id.mainActivity_studentLogin);
        showAllStudents = findViewById(R.id.courseFaculty_newFaculty);
        teacherLogin = findViewById(R.id.mainActivity_teacherLogin);
        showAllTeachers = findViewById(R.id.mainActivity_showAllTeacher);
        cources = findViewById(R.id.mainActivity_showCourses);
        viceChancellor = findViewById(R.id.mainActivity_viceChancellor);
        developer = findViewById(R.id.mainActivity_developer);
        dean = findViewById(R.id.mainActivity_dean);
        website = findViewById(R.id.mainActivity_pstuWebsite);

        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.pstu_one, ""));
        slideModels.add(new SlideModel(R.drawable.pstu_twoo, ""));
        slideModels.add(new SlideModel(R.drawable.pstu_three, ""));
        slideModels.add(new SlideModel(R.drawable.pstu_four, ""));
        slideModels.add(new SlideModel(R.drawable.pstu_five, ""));
        slideModels.add(new SlideModel(R.drawable.pstu_six, ""));
        slideModels.add(new SlideModel(R.drawable.pstu_seven, ""));
        slideModels.add(new SlideModel(R.drawable.pstu_eight, ""));
        slideModels.add(new SlideModel(R.drawable.pstu_nine, ""));
        imageSlider.setImageList(slideModels, true);

        viceChancellor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vcIntent = new Intent(MainActivity.this, ViceChancellor.class);
                startActivity(vcIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });

        dean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vcIntent = new Intent(MainActivity.this, Dean.class);
                startActivity(vcIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });

        studentLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent studentLoginIntent = new Intent(MainActivity.this, StudentLogin.class);
                startActivity(studentLoginIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });

        showAllStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent allStudentsIntent = new Intent(MainActivity.this, AllStudents.class);
                startActivity(allStudentsIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });

        teacherLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent teacherLoginIntent = new Intent(MainActivity.this, TeacherLogin.class);
                startActivity(teacherLoginIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });

        showAllTeachers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent allTeachersIntent = new Intent(MainActivity.this, AllTeachers.class);
                startActivity(allTeachersIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });

        cources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent courcesIntent = new Intent(MainActivity.this, CourseFaculty.class);
                startActivity(courcesIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });

        developer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent developerIntent = new Intent(MainActivity.this, Developer.class);
                startActivity(developerIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });

        pstu_website_link = getResources().getString(R.string.pstu_website_link);
        websitepage_actionbar = getResources().getString(R.string.mainActivity_pstu_website_title);
        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent websiteIntent = new Intent(MainActivity.this, Website.class);
                websiteIntent.putExtra("link", pstu_website_link);
                websiteIntent.putExtra("actionbar_title", websitepage_actionbar);
                startActivity(websiteIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
