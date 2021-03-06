package com.rafyee.rafyee_rajiv.pstuprofile.StudentProfile;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.rafyee.rafyee_rajiv.pstuprofile.Config;
import com.rafyee.rafyee_rajiv.pstuprofile.MainActivity;
import com.rafyee.rafyee_rajiv.pstuprofile.Models.StudentUnit;
import com.rafyee.rafyee_rajiv.pstuprofile.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class StudentLoggedIn extends AppCompatActivity {

    private TextView studentName, studentID, studentRegistrationNo, studentPassword, studentFaculty,
            studentBatch, studentContact, studentEmail;
    private LinearLayout goToStudentUpdate;
    private String name, id_no, registration_no, password, faculty, batch, contact, email, gotID;
    private JSONArray jsonArray = null;
    public static final String JSON_ARRAY = "result";

    @Override
    protected void onStart() {
        super.onStart();
        loadStudentData();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_logged_in);
        getSupportActionBar().hide();

        studentName = findViewById(R.id.studentLoggedIn_studentName);
        studentID = findViewById(R.id.studentLoggedIn_studentID);
        studentRegistrationNo = findViewById(R.id.studentLoggedIn_studentRegistrationNo);
        studentPassword = findViewById(R.id.studentLoggedIn_studentPassword);
        studentFaculty = findViewById(R.id.studentLoggedIn_studentFaculty);
        studentBatch = findViewById(R.id.studentLoggedIn_studentBatch);
        studentContact = findViewById(R.id.studentLoggedIn_studentContact);
        studentEmail = findViewById(R.id.studentLoggedIn_studentEmailAddress);
        goToStudentUpdate = findViewById(R.id.studentLoggedIn_studentUpdateBtn);

        Intent intent = getIntent();
        gotID = intent.getExtras().getString("Id_no");
        Log.d("success", "id: " + gotID);

        loadStudentData();
    }

    private void loadStudentData() {

        final String noDataRecorded = getResources().getString(R.string.noDataRecorded);
        final String poorInternetConnection = getResources().getString(R.string.poorInternetConnection);


        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.Student_Details,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject jsonObject = null;
                        try {
                            jsonObject = new JSONObject(response);
                            jsonArray = jsonObject.getJSONArray(JSON_ARRAY);
                            if (jsonArray.length() == 0) {
                                Toast.makeText(StudentLoggedIn.this, noDataRecorded, Toast.LENGTH_SHORT).show();
                            } else {
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject object = jsonArray.getJSONObject(i);
                                    StudentUnit stdUnit = new StudentUnit();

                                    stdUnit.setName(object.getString("name"));
                                    stdUnit.setId_no(object.getString("Id_no"));
                                    stdUnit.setReg_no(object.getString("reg_no"));
                                    stdUnit.setPass(object.getString("pass"));
                                    stdUnit.setFaculty(object.getString("faculty"));
                                    stdUnit.setBatch(object.getString("batch"));
                                    stdUnit.setContact(object.getString("contact"));
                                    stdUnit.setEmail(object.getString("email"));

                                    name = stdUnit.getName();
                                    id_no = stdUnit.getId_no();
                                    registration_no = stdUnit.getReg_no();
                                    password = stdUnit.getPass();
                                    faculty = stdUnit.getFaculty();
                                    batch = stdUnit.getBatch();
                                    contact = stdUnit.getContact();
                                    email = stdUnit.getEmail();

                                    studentName.setText(name);
                                    studentID.setText(id_no + " (ক্যাম্পাস আইডি)");
                                    studentRegistrationNo.setText(registration_no + " (রেজিস্ট্রেশন নম্বর)");
                                    studentPassword.setText(password);
                                    studentFaculty.setText(faculty);
                                    studentBatch.setText(batch);
                                    studentContact.setText(contact);
                                    studentEmail.setText(email);
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
                        Toast.makeText(StudentLoggedIn.this, poorInternetConnection, Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Id_no", gotID);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(StudentLoggedIn.this);
        requestQueue.add(stringRequest);

        goToStudentUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StudentLoggedIn.this, StudentUpdate.class);
                i.putExtra("name", studentName.getText().toString());
                i.putExtra("Id_no", gotID);
                i.putExtra("password", studentPassword.getText().toString());
                i.putExtra("contact", studentContact.getText().toString());
                i.putExtra("email", studentEmail.getText().toString());
                startActivity(i);
            }
        });
    }

    public void onBackPressed() {
        Intent intent = new Intent(StudentLoggedIn.this, MainActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
        super.onBackPressed();
    }
}