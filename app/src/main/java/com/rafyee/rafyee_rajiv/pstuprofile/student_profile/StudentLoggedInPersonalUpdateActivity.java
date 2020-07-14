package com.rafyee.rafyee_rajiv.pstuprofile.student_profile;

import android.content.Intent;
import android.os.Bundle;
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

import java.util.HashMap;
import java.util.Map;

public class StudentLoggedInPersonalUpdateActivity extends AppCompatActivity {

    private ImageView backButton;
    private EditText studentName, studentPassword, studentContactNo, studentEmail;
    private LinearLayout updateStudent;
    private String name, password, contact, email,
            gotStudentId, gotNmae, gotPassword, gotContact, gotEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_logged_in_personal_update_activity);
        getSupportActionBar().hide();

        Intent intent = getIntent();
        gotStudentId = intent.getExtras().getString("id_no");
        gotNmae = intent.getExtras().getString("name");
        gotPassword = intent.getExtras().getString("password");
        gotContact = intent.getExtras().getString("contact");
        gotEmail = intent.getExtras().getString("email");

        backButton = findViewById(R.id.studentLoggedInPersonalUpdate_studentBackButton);
        updateStudent = findViewById(R.id.studentLoggedInPersonalUpdate_studentUpdateBtn);
        studentName = findViewById(R.id.studentLoggedInPersonalUpdate_studentName);
        studentPassword = findViewById(R.id.studentLoggedInPersonalUpdate_studentPassword);
        studentContactNo = findViewById(R.id.studentLoggedInPersonalUpdate_studentContactNo);
        studentEmail = findViewById(R.id.studentLoggedInPersonalUpdate_studentEmailAddress);

        studentName.setText(gotNmae);
        studentPassword.setText(gotPassword);
        studentContactNo.setText(gotContact);
        studentEmail.setText(gotEmail);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(StudentLoggedInPersonalUpdateActivity.this, StudentLoggedInActivity.class);
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

                RequestQueue requestQueue = Volley.newRequestQueue(StudentLoggedInPersonalUpdateActivity.this);
                StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.student_personal_update,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(StudentLoggedInPersonalUpdateActivity.this, response, Toast.LENGTH_SHORT).show();
                            }
                        }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(StudentLoggedInPersonalUpdateActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
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
                Intent in = new Intent(StudentLoggedInPersonalUpdateActivity.this, StudentLoggedInActivity.class);
                startActivity(in);
            }
        });
    }
}