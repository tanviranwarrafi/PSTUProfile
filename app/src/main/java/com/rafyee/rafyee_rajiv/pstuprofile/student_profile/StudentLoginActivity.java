package com.rafyee.rafyee_rajiv.pstuprofile.student_profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rafyee.rafyee_rajiv.pstuprofile.R;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;
import com.rafyee.rafyee_rajiv.pstuprofile.Config;
import com.rafyee.rafyee_rajiv.pstuprofile.MainActivity;

import java.util.HashMap;
import java.util.Map;

public class StudentLoginActivity extends AppCompatActivity {

    private Button studentLoginBtn;
    private EditText studentId, studentPassword;
    private Snackbar snackbar;
    private ProgressBar progressBar;
    /* private CheckBox showPassword;*/
    private TextView signUpPlease;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.student_login_activity);
        getSupportActionBar().hide();

        studentId = findViewById(R.id.studentLogin_studentID);
        studentPassword = findViewById(R.id.studentLogin_studentPassword);
        progressBar = findViewById(R.id.studentLogin_progressbar);
        /*showPassword = findViewById(R.id.studentLogin_showPassword);*/
        studentLoginBtn = findViewById(R.id.studentLogin_loginBtn);
        signUpPlease = findViewById(R.id.studentLogin_studentSignUp);

        /*showPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    studentPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    studentPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });*/

        studentLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginRequest();
            }
        });

        signUpPlease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentLoginActivity.this, StudentSignUpActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });
    }

    public void onBackPressed() {
        Intent intent = new Intent(StudentLoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
        super.onBackPressed();
    }

    private void loginRequest() {
        if (studentId.getText().toString().equals("") &&
                studentPassword.getText().toString().equals("")) {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(this, "সঠিক আইডি ও পাসওয়ার্ড দিন", Toast.LENGTH_SHORT).show();
        } else {
            progressBar.setVisibility(View.VISIBLE);
            RequestQueue queue = Volley.newRequestQueue(this);
            String response = null;
            final String finalResponse = response;

            StringRequest postRequest = new StringRequest(Request.Method.POST, Config.Student_Login,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            progressBar.setVisibility(View.GONE);

                            if (response.equals("Success")) {
                                Intent intent = new Intent(StudentLoginActivity.this, StudentLoggedInActivity.class);
                                intent.putExtra("Id_no", studentId.getText().toString());
                                startActivity(intent);
                                finish();
                            }else {
                                showSnackbar();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(StudentLoginActivity.this, "লগইন ব্যর্থ হয়েছে। আবার চেষ্টা করুন", Toast.LENGTH_SHORT).show();
                        }
                    }
            ) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("Id_no", studentId.getText().toString());
                    params.put("pass", studentPassword.getText().toString());
                    return params;
                }
            };
            postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            queue.add(postRequest);
        }
    }

    public void showSnackbar() {
        snackbar.make(findViewById(android.R.id.content), "লগইন ব্যর্থ হয়েছে। আবার চেষ্টা করুন", Snackbar.LENGTH_SHORT)
                .setBackgroundTint(getResources().getColor(R.color.colorPrimary))
                .show();
    }
}