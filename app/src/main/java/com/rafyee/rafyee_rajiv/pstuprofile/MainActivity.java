package com.rafyee.rafyee_rajiv.pstuprofile;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.rafyee.rafyee_rajiv.pstuprofile.all_user.ShowAllStudentsActivity;
import com.rafyee.rafyee_rajiv.pstuprofile.all_user.ShowAllTeachersActivity;
import com.rafyee.rafyee_rajiv.pstuprofile.all_user.ShowCourseFacultyActivity;
import com.rafyee.rafyee_rajiv.pstuprofile.student_profile.StudentLoginActivity;
import com.rafyee.rafyee_rajiv.pstuprofile.teacher_profile.TeacherLoginActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        imageSlider = findViewById(R.id.imageSlider);
        studentLogin = findViewById(R.id.mainActivity_studentLogin);
        showAllStudents = findViewById(R.id.mainActivity_showAllStudent);
        teacherLogin = findViewById(R.id.mainActivity_teacherLogin);
        showAllTeachers = findViewById(R.id.mainActivity_showAllTeacher);
        cources = findViewById(R.id.mainActivity_showCourses);
        viceChancellor = findViewById(R.id.vice_chancellor);
        developer = findViewById(R.id.developer);
        dean = findViewById(R.id.dean);

        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.pstu_twoo, ""));
        slideModels.add(new SlideModel(R.drawable.pstu_twoo, ""));
        slideModels.add(new SlideModel(R.drawable.pstu_twoo, ""));
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
                Intent studentLoginIntent = new Intent(MainActivity.this, StudentLoginActivity.class);
                startActivity(studentLoginIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });

        showAllStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent allStudentsIntent = new Intent(MainActivity.this, ShowAllStudentsActivity.class);
                startActivity(allStudentsIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });

        teacherLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent teacherLoginIntent = new Intent(MainActivity.this, TeacherLoginActivity.class);
                startActivity(teacherLoginIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });

        showAllTeachers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent allTeachersIntent = new Intent(MainActivity.this, ShowAllTeachersActivity.class);
                startActivity(allTeachersIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });

        cources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent courcesIntent = new Intent(MainActivity.this, ShowCourseFacultyActivity.class);
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
    }

    private Boolean exit = false;

    @Override
    public void onBackPressed() {
        if (exit) {
            finish(); // finish activity
        } else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);
        }
    }
}
