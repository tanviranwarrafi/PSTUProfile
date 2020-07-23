package com.rafyee.rafyee_rajiv.pstuprofile.TeacherProfile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
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
import com.rafyee.rafyee_rajiv.pstuprofile.Models.TeacherUnit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TeacherLoggedIn extends AppCompatActivity {

    private TextView teacherName, teacherPost, teacherFaculty, teacherDepartment, teacherPassword,
            teacherEmail, teacherContact;
    private LinearLayout goToTeacherUpdate;
    private String name, post, faculty, department, contact, email, password, gotTeacherEmail;
    private JSONArray jsonArray = null;
    public static final String JSON_ARRAY = "result";

    @Override
    protected void onStart() {
        super.onStart();
        loadteacherData();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_logged_in);
        getSupportActionBar().hide();

        teacherName = findViewById(R.id.teacherLoggedIn_teacherName);
        teacherPost = findViewById(R.id.teacherLoggedIn_teacherPost);
        teacherFaculty = findViewById(R.id.teacherLoggedIn_teacherFaculty);
        teacherDepartment = findViewById(R.id.teacherLoggedIn_teacherDepartment);
        teacherPassword = findViewById(R.id.teacherLoggedIn_teacherPassword);
        teacherEmail = findViewById(R.id.teacherLoggedIn_teacherEmail);
        teacherContact = findViewById(R.id.teacherLoggedIn_teacherContactNo);
        goToTeacherUpdate = findViewById(R.id.teacherLoggedIn_teacherUpdate);

        Intent intent = getIntent();
        gotTeacherEmail = intent.getExtras().getString("t_email");

        loadteacherData();

    }

    private void loadteacherData() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.Teacher_Details,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject jsonObject = null;
                        try {
                            jsonObject = new JSONObject(response);
                            jsonArray = jsonObject.getJSONArray(JSON_ARRAY);
                            if (jsonArray.length() == 0) {
                                Toast.makeText(TeacherLoggedIn.this, "No Data Recorded", Toast.LENGTH_SHORT).show();
                            } else {
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject object = jsonArray.getJSONObject(i);
                                    TeacherUnit teacherUnit = new TeacherUnit();
                                    teacherUnit.setT_name(object.getString("t_name"));
                                    teacherUnit.setT_post(object.getString("t_post"));
                                    teacherUnit.setT_faculty(object.getString("t_faculty"));
                                    teacherUnit.setT_dept(object.getString("t_dept"));
                                    teacherUnit.setT_pass(object.getString("t_pass"));
                                    teacherUnit.setT_email(object.getString("t_email"));
                                    teacherUnit.setT_contact(object.getString("t_contact"));

                                    name = teacherUnit.getT_name();
                                    post = teacherUnit.getT_post();
                                    faculty = teacherUnit.getT_faculty();
                                    department = teacherUnit.getT_dept();
                                    password = teacherUnit.getT_pass();
                                    email = teacherUnit.getT_email();
                                    contact = teacherUnit.getT_contact();

                                    teacherName.setText(name);
                                    teacherPost.setText(post);
                                    teacherFaculty.setText(faculty);
                                    teacherDepartment.setText(department);
                                    teacherPassword.setText(password);
                                    teacherEmail.setText(email);
                                    teacherContact.setText(contact);
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("t_email", gotTeacherEmail);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(TeacherLoggedIn.this);
        requestQueue.add(stringRequest);

        goToTeacherUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TeacherLoggedIn.this, TeacherUpdate.class);
                i.putExtra("teacher_name", teacherName.getText().toString());
                i.putExtra("teacher_post", teacherPost.getText().toString());
                i.putExtra("teacher_password", teacherPassword.getText().toString());
                i.putExtra("teacher_email", teacherEmail.getText().toString());
                i.putExtra("teacher_contact", teacherContact.getText().toString());
                startActivity(i);
            }
        });

    }

    public void onBackPressed() {
        Intent intent = new Intent(TeacherLoggedIn.this, MainActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
        super.onBackPressed();
    }
}