package com.rafyee.rafyee_rajiv.pstuprofile.StudentProfile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rafyee.rafyee_rajiv.pstuprofile.R;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.rafyee.rafyee_rajiv.pstuprofile.Config;
import com.rafyee.rafyee_rajiv.pstuprofile.TeacherProfile.TeacherLoggedIn;
import com.rafyee.rafyee_rajiv.pstuprofile.TeacherProfile.TeacherUpdate;

import java.util.HashMap;
import java.util.Map;

public class StudentUpdate extends AppCompatActivity {

    private ImageView backButton;
    private EditText studentName, studentPassword, studentContactNo, studentEmail;
    private LinearLayout updateStudent;
    private String name, password, contact, email,
            gotStudentId, gotNmae, gotPassword, gotContact, gotEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_update);
        getSupportActionBar().hide();

        Intent intent = getIntent();
        gotStudentId = intent.getExtras().getString("Id_no");
        gotNmae = intent.getExtras().getString("name");
        gotPassword = intent.getExtras().getString("password");
        gotContact = intent.getExtras().getString("contact");
        gotEmail = intent.getExtras().getString("email");

        backButton = findViewById(R.id.studentUpdate_backButton);
        updateStudent = findViewById(R.id.studentUpdate_studentUpdateBtn);
        studentName = findViewById(R.id.studentUpdate_newName);
        studentPassword = findViewById(R.id.studentUpdate_newPassword);
        studentContactNo = findViewById(R.id.studentUpdate_newContactNo);
        studentEmail = findViewById(R.id.studentUpdatestudentLoggedInPersonalUpdate_newEmail);

        studentName.setText(gotNmae);
        studentPassword.setText(gotPassword);
        studentContactNo.setText(gotContact);
        studentEmail.setText(gotEmail);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(StudentUpdate.this, StudentLoggedIn.class);
                backIntent.putExtra("Id_no", gotStudentId);
                startActivity(backIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
            }
        });

        updateStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = studentName.getText().toString();
                contact = studentContactNo.getText().toString();
                password = studentPassword.getText().toString();
                email = studentEmail.getText().toString();

                RequestQueue requestQueue = Volley.newRequestQueue(StudentUpdate.this);
                StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.Student_Update,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(StudentUpdate.this,  "আপডেট সফল হয়েছে", Toast.LENGTH_SHORT).show();
                            }
                        }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(StudentUpdate.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("name", name);
                        params.put("Id_no", gotStudentId);
                        params.put("contact", contact);
                        params.put("pass", password);
                        params.put("email", email);
                        return params;
                    }
                };
                requestQueue.add(stringRequest);
                Intent in = new Intent(StudentUpdate.this, StudentLoggedIn.class);
                in.putExtra("Id_no", gotStudentId);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
                startActivity(in);
            }
        });
    }

    public void onBackPressed() {
        Intent intent = new Intent(StudentUpdate.this, TeacherLoggedIn.class);
        intent.putExtra("Id_no", gotStudentId);
        Log.d("onBackPressed", gotStudentId);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
        super.onBackPressed();
    }
}