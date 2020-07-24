package com.rafyee.rafyee_rajiv.pstuprofile.StudentProfile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rafyee.rafyee_rajiv.pstuprofile.MySingleton;
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
import com.rafyee.rafyee_rajiv.pstuprofile.TeacherProfile.TeacherLogin;
import com.rafyee.rafyee_rajiv.pstuprofile.TeacherProfile.TeacherSignUp;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class StudentSignUp extends AppCompatActivity {

    private EditText studentName, studentID, studentRegistrationNo, studentPassword,
            studentContact, studentEmail;
    private Spinner studentFaculty, studentBatch;
    private ProgressBar progressBar;
    private Button SignUp;
    private TextView gotoSignIn;

    private String faculty, batch;
    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";

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

        studentFaculty = findViewById(R.id.studentSignUp_FacultySpinner);
        studentBatch = findViewById(R.id.studentSignUp_BatchSpinner);

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

        studentName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        studentID.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        studentRegistrationNo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        studentPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        studentContact.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        studentEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUpStudent();
            }
        });
    }

    @SuppressLint("ResourceAsColor")
    private void checkInputs() {
        if (!TextUtils.isEmpty(studentName.getText())) {
            if (!TextUtils.isEmpty(studentID.getText())) {
                if (!TextUtils.isEmpty(studentRegistrationNo.getText())) {
                    if (!TextUtils.isEmpty(studentPassword.getText())) {
                        if (!TextUtils.isEmpty(studentContact.getText())){
                            if (!TextUtils.isEmpty(studentContact.getText())){
                                SignUp.setEnabled(true);
                            } else {
                                SignUp.setEnabled(false);
                            }
                        }else{
                            SignUp.setEnabled(false);
                        }
                    } else {
                        SignUp.setEnabled(false);
                    }
                } else {
                    SignUp.setEnabled(false);
                }
            }  else {
                SignUp.setEnabled(false);
            }
        }
    }

    private void signUpStudent() {

        String campusIdError = getResources().getString(R.string.studentSignUp_errorCampusId);
        String emailError = getResources().getString(R.string.studentSignUp_errorEmail);
        String contactError = getResources().getString(R.string.studentSignUp_errorContact);
        final String registeredId = getResources().getString(R.string.studentSignUp_registeredId);
        final String registrationSuccess = getResources().getString(R.string.studentSignUp_registrationSuccess);
        final String somethingWrong = getResources().getString(R.string.studentSignUp_somethingWrong);

        Drawable customErrorIcon = getResources().getDrawable(R.drawable.error_24);
        customErrorIcon.setBounds(0,0,customErrorIcon.getIntrinsicWidth(),customErrorIcon.getIntrinsicHeight());

        if (studentEmail.getText().toString().matches(emailPattern)){
            if(studentContact.length()>10 && studentContact.length()<12){
                if (studentID.length()>6 && studentID.length()<8){

                    progressBar.setVisibility(View.VISIBLE);
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.Student_Registration,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    try {
                                        progressBar.setVisibility(View.GONE);
                                        JSONObject jsonObject = new JSONObject(response);
                                        String Response = jsonObject.getString("response");

                                        if (Response.equals("registered")) {
                                            Toast.makeText(StudentSignUp.this, registeredId, Toast.LENGTH_SHORT).show();
                                        }else {
                                            if (Response.equals("success")){
                                                Toast.makeText(StudentSignUp.this, registrationSuccess, Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(StudentSignUp.this, StudentLogin.class);
                                                startActivity(intent);
                                                finish();
                                                overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
                                            } else {
                                                Toast.makeText(StudentSignUp.this, somethingWrong, Toast.LENGTH_SHORT).show();
                                            }
                                        }

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(StudentSignUp.this, somethingWrong, Toast.LENGTH_SHORT).show();
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<>();

                            params.put("name", studentName.getText().toString());
                            params.put("Id_no", studentID.getText().toString());
                            params.put("reg_no", studentRegistrationNo.getText().toString());
                            params.put("pass", studentPassword.getText().toString());
                            params.put("faculty", faculty);
                            params.put("batch", batch);
                            params.put("contact", studentContact.getText().toString());
                            params.put("email", studentEmail.getText().toString());

                            return params;
                        }
                    };

                    MySingleton.getInstance(StudentSignUp.this).addToRequestQueue(stringRequest);

                } else {
                    studentID.setError(campusIdError, customErrorIcon);
                }
            } else {
                studentContact.setError(contactError, customErrorIcon);
            }
        } else {
            studentEmail.setError(emailError, customErrorIcon);
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