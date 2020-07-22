package com.rafyee.rafyee_rajiv.pstuprofile.StudentProfile;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
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
import com.rafyee.rafyee_rajiv.pstuprofile.MainActivity;

import java.util.HashMap;
import java.util.Map;

public class StudentSignUp extends AppCompatActivity {

    private EditText studentName, studentID, studentRegistrationNo, studentPassword,
            studentContact, studentEmail;
    private Spinner studentFaculty, studentBatch;
    private ProgressBar progressBar;
    private LinearLayout SignUp;
    private TextView gotoSignIn;
    private String name, id_no, registration_no, password, faculty, batch, contact_no, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.student_sign_up);
        getSupportActionBar().hide();

        studentName = findViewById(R.id.studentSignUp_studentName);
        studentID = findViewById(R.id.studentSignUp_studentID);
        studentRegistrationNo = findViewById(R.id.studentSignUp_studentRegistrationNo);
        studentPassword = findViewById(R.id.studentSignUp_studentPassword);
        studentContact = findViewById(R.id.studentSignUp_studentContactNo);
        studentEmail = findViewById(R.id.studentSignUp_studentEmailAddress);
        progressBar = findViewById(R.id.studentSignUp_progressBar);
        SignUp = findViewById(R.id.studentSignUp_signUpBtn);
        gotoSignIn = findViewById(R.id.studentSignUp_signIn);

        studentFaculty = findViewById(R.id.studentSignUp_studentFaculty);
        studentBatch = findViewById(R.id.studentSignUp_studentBatch);

        gotoSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentSignUp.this, StudentLogin.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
            }
        });

        /* FACULTY SPINNER */
        ArrayAdapter Faculty_adapter = ArrayAdapter.createFromResource(this, R.array.facultys, android.R.layout.simple_spinner_dropdown_item);
        Faculty_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        studentFaculty.setAdapter(Faculty_adapter);

        studentFaculty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                faculty = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(StudentSignUp.this, "Please Select One...", Toast.LENGTH_SHORT).show();
            }
        });

        /* BATCH SPINNER */
        ArrayAdapter BATCH_adapter = ArrayAdapter.createFromResource(this, R.array.batchs, android.R.layout.simple_spinner_dropdown_item);
        BATCH_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        studentBatch.setAdapter(BATCH_adapter);

        studentBatch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                batch = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(StudentSignUp.this, "Please Select One...", Toast.LENGTH_SHORT).show();
            }
        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUpStudent();
            }
        });
    }

    private void signUpStudent() {
        if (studentName.getText().toString().equals("") &&
                studentID.getText().toString().equals("") &&
                studentRegistrationNo.getText().toString().equals("") &&
                studentPassword.getText().toString().equals("") &&
                studentContact.getText().toString().equals("") &&
                studentEmail.getText().toString().equals("")) {

            Toast.makeText(StudentSignUp.this, "অনুগ্রহ পূর্বক সব তথ্য পূরণ করুন", Toast.LENGTH_SHORT).show();
        } else {
            name = studentName.getText().toString();
            id_no = studentID.getText().toString();
            registration_no = studentRegistrationNo.getText().toString();
            password = studentPassword.getText().toString();
            contact_no = studentContact.getText().toString();
            email = studentEmail.getText().toString();

            progressBar.setVisibility(View.VISIBLE);
            RequestQueue requestQueue = Volley.newRequestQueue(StudentSignUp.this);
            StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.Student_Registration,
                    new Response.Listener<String>() {

                        @Override
                        public void onResponse(String response) {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(StudentSignUp.this, response, Toast.LENGTH_SHORT).show();
                            Log.d("response", response);
                            if (response == "Success") {
                                Intent intent = new Intent(StudentSignUp.this, MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(StudentSignUp.this, response, Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(StudentSignUp.this, "সাইন আপ ব্যর্থ হয়েছে। অনুগ্রহ পূর্বক সব তথ্য পূরণ করুন", Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("name", name);
                    params.put("Id_no", id_no);
                    params.put("reg_no", registration_no);
                    params.put("pass", password);
                    params.put("faculty", faculty);
                    params.put("batch", batch);
                    params.put("contact", contact_no);
                    params.put("email", email);
                    return params;
                }
            };
            requestQueue.add(stringRequest);
        }
    }

    public void onBackPressed() {
        Intent intent = new Intent(StudentSignUp.this, StudentLogin.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
        super.onBackPressed();
    }
}