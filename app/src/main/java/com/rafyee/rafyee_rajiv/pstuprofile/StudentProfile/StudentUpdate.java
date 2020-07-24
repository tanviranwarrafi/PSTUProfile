package com.rafyee.rafyee_rajiv.pstuprofile.StudentProfile;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class StudentUpdate extends AppCompatActivity {

    private ImageView backButton;
    private EditText studentName, studentPassword, studentContactNo, studentEmail;
    private LinearLayout updateStudent;
    private ProgressBar progressBar;
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
        studentEmail = findViewById(R.id.studentUpdate_newEmail);
        progressBar = findViewById(R.id.studentUpdate_progressbar);

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

        final String updateSuccess = getResources().getString(R.string.studentUpdate_updateSuccess);
        final String somethingWrong = getResources().getString(R.string.studentUpdate_somethingWrong);

        updateStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = studentName.getText().toString();
                contact = studentContactNo.getText().toString();
                password = studentPassword.getText().toString();
                email = studentEmail.getText().toString();

                progressBar.setVisibility(View.VISIBLE);
                RequestQueue requestQueue = Volley.newRequestQueue(StudentUpdate.this);
                StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.Student_Update,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                try {
                                    progressBar.setVisibility(View.GONE);
                                    JSONObject jsonObject = new JSONObject(response);
                                    String Response = jsonObject.getString("response");

                                    if (Response.equals("success")){
                                        Log.d("success", Response);
                                        Toast.makeText(StudentUpdate.this, updateSuccess, Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(StudentUpdate.this, StudentLoggedIn.class);
                                        intent.putExtra("Id_no", gotStudentId);
                                        startActivity(intent);
                                        finish();
                                        overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
                                    } else {
                                        Toast.makeText(StudentUpdate.this, somethingWrong, Toast.LENGTH_SHORT).show();
                                    }

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressBar.setVisibility(View.GONE);
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