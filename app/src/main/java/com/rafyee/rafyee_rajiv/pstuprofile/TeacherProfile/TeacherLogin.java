package com.rafyee.rafyee_rajiv.pstuprofile.TeacherProfile;

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

public class TeacherLogin extends AppCompatActivity {

    private EditText teacherEmail, teacherPassword;
    private Button teacherLoginBtn;
    private TextView teacherRegistration;
    private Snackbar snackbar;
    private ProgressBar progressBar;
//    private CheckBox showPassword;
    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_login);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        teacherEmail = findViewById(R.id.teacherLogin_teacherEmail);
        teacherPassword = findViewById(R.id.teacherLogin_teacherPassword);
        progressBar = findViewById(R.id.teacherLogin_progressbar);
        /*showPassword = findViewById(R.id.teacherLogin_showPassword);*/
        teacherLoginBtn = findViewById(R.id.teacherLogin_LoginBtn);
        teacherRegistration = findViewById(R.id.teacherLogin_teacherSignUp);

        /*showPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    teacherPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }else {
                    teacherPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });*/

        teacherLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teacherLogin();
            }
        });

        teacherRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeacherLogin.this, TeacherSignUp.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.slide_from_left,R.anim.slideout_from_right);
            }
        });
    }

    public void onBackPressed() {
        Intent intent = new Intent(TeacherLogin.this, MainActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.slide_from_right,R.anim.slideout_from_left);
        super.onBackPressed();
    }

    private void teacherLogin() {
        if (teacherEmail.getText().toString().equals("") &&
                teacherPassword.getText().toString().equals("")) {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(this, "সঠিক ই-মেইল ও পাসওয়ার্ড দিন", Toast.LENGTH_SHORT).show();

        } else {
            if (teacherEmail.getText().toString().matches(emailPattern)){
                progressBar.setVisibility(View.VISIBLE);
                RequestQueue queue = Volley.newRequestQueue(TeacherLogin.this);
                String response = null;
                final String finalResponse = response;

                StringRequest postRequest = new StringRequest(Request.Method.POST, Config.Teacher_Login,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                progressBar.setVisibility(View.GONE);

                                if (response.equals("Success")) {
                                    Intent intent = new Intent(TeacherLogin.this, TeacherLoggedIn.class);
                                    intent.putExtra("t_email", teacherEmail.getText().toString());
                                    startActivity(intent);
                                } else {
                                    showSnackbar("লগইন ব্যর্থ হয়েছে। আবার চেষ্টা করুন");
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                progressBar.setVisibility(View.GONE);
                                Toast.makeText(TeacherLogin.this, "লগইন ব্যর্থ হয়েছে। আবার চেষ্টা করুন", Toast.LENGTH_SHORT).show();
                            }
                        }
                ) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("t_email", teacherEmail.getText().toString());
                        params.put("t_pass", teacherPassword.getText().toString());
                        return params;
                    }
                };
                postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                queue.add(postRequest);
            }else {
                showSnackbar("আপনার ই-মেইল এডড্রেসটি সঠিক নয়");
            }
        }
    }

    public void showSnackbar(String stringSnackbar) {
        snackbar.make(findViewById(android.R.id.content), stringSnackbar, Snackbar.LENGTH_SHORT)
                .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                .setBackgroundTint(getResources().getColor(R.color.colorPrimary))
                .show();
    }
}

