package com.rafyee.rafyee_rajiv.pstuprofile.teacher_profile;

import android.content.Intent;
import android.os.Bundle;
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

import java.util.HashMap;
import java.util.Map;

public class TeachersSignUpActivity extends AppCompatActivity {

    private EditText teacherName, teacherEmail, teacherContact, teacherPassword;
    private Spinner teacherPost, teacherDepartment, teacherFaculty;
    private ProgressBar progressBar;
    private LinearLayout teacherSignUpBtn;
    private TextView gotoSignIn;
    private String teacher_name, teacher_post, teacher_faculty, teacher_department,
            teacher_email, teacher_contact, teacher_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.teachers_sign_up_activity);
        getSupportActionBar().hide();

        teacherName = findViewById(R.id.teacherSignUp_teacherName);
        teacherEmail = findViewById(R.id.teacherSignUp_email);
        teacherContact = findViewById(R.id.teacherSignUp_contactNo);
        teacherPassword = findViewById(R.id.teacherSignUp_password);
        teacherPost = findViewById(R.id.teacherSignUp__teacherPost);
        teacherDepartment = findViewById(R.id.teacherSignUp_teacherDepartment);
        teacherFaculty = findViewById(R.id.teacherSignUp_teacherFaculty);
        progressBar = findViewById(R.id.teacherSignUp_progressbar);
        teacherSignUpBtn = findViewById(R.id.SignUp_teacher);
        gotoSignIn = findViewById(R.id.teacherSignUp_signIn);

        gotoSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TeachersSignUpActivity.this, TeacherLoginActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
            }
        });

        /* AGRICULTURE ADAPTER */
        final ArrayAdapter AGRICULTURE_Adapter = ArrayAdapter.createFromResource(TeachersSignUpActivity.this, R.array.agriculture, android.R.layout.simple_spinner_dropdown_item);
        AGRICULTURE_Adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        //dept.setAdapter(AGRICULTURE_Adapter);

        /* CSE ADAPTER */
        final ArrayAdapter CSE_adapter = ArrayAdapter.createFromResource(TeachersSignUpActivity.this, R.array.CSE, android.R.layout.simple_spinner_dropdown_item);
        CSE_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        //dept.setAdapter(CSE_adapter);

        /* BBA ADAPTER */
        final ArrayAdapter BBA_adapter = ArrayAdapter.createFromResource(TeachersSignUpActivity.this, R.array.bba, android.R.layout.simple_spinner_dropdown_item);
        BBA_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        //dept.setAdapter(BBA_adapter);

        /* FISHARIES ADAPTER */
        final ArrayAdapter FISHARIES_adapter = ArrayAdapter.createFromResource(TeachersSignUpActivity.this, R.array.fisharies, android.R.layout.simple_spinner_dropdown_item);
        FISHARIES_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        //dept.setAdapter(FISHARIES_adapter);

        /* LAND ADAPTER */
        final ArrayAdapter LAND_adapter = ArrayAdapter.createFromResource(TeachersSignUpActivity.this, R.array.land_management, android.R.layout.simple_spinner_dropdown_item);
        LAND_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        //dept.setAdapter(LAND_adapter);

        /* NFS ADAPTER */
        final ArrayAdapter NFS_adapter = ArrayAdapter.createFromResource(TeachersSignUpActivity.this, R.array.nfs, android.R.layout.simple_spinner_dropdown_item);
        NFS_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        //dept.setAdapter(NFS_adapter);

        /* DISASTER ADAPTER */
        final ArrayAdapter DISASTER_adapter = ArrayAdapter.createFromResource(TeachersSignUpActivity.this, R.array.disaster_management, android.R.layout.simple_spinner_dropdown_item);
        DISASTER_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        //dept.setAdapter(DISASTER_adapter);

        /* DVM & ANIMAL ADAPTER */
        final ArrayAdapter DVM_adapter = ArrayAdapter.createFromResource(TeachersSignUpActivity.this, R.array.dvm, android.R.layout.simple_spinner_dropdown_item);
        DVM_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        //dept.setAdapter(DVM_adapter);

        /* TEACHER POST */
        ArrayAdapter Post_adapter = ArrayAdapter.createFromResource(TeachersSignUpActivity.this, R.array.posts, android.R.layout.simple_spinner_dropdown_item);
        Post_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        teacherPost.setAdapter(Post_adapter);

        teacherPost.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                teacher_post = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(TeachersSignUpActivity.this, "Please Select One...", Toast.LENGTH_SHORT).show();
            }
        });

        /* FACULTY */
        ArrayAdapter Faculty_adapter = ArrayAdapter.createFromResource(TeachersSignUpActivity.this, R.array.facultys, android.R.layout.simple_spinner_dropdown_item);
        Faculty_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        teacherFaculty.setAdapter(Faculty_adapter);

        teacherFaculty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                teacher_faculty = parent.getItemAtPosition(position).toString();

                if (teacher_faculty.equals("Computer Science and Engineering")) {
                    teacherDepartment.setAdapter(CSE_adapter);
                } else if (teacher_faculty.equals("Agriculture"))
                    teacherDepartment.setAdapter(AGRICULTURE_Adapter);
                else if (teacher_faculty.equals("Business Administration and Management"))
                    teacherDepartment.setAdapter(BBA_adapter);
                else if (teacher_faculty.equals("Fisharies"))
                    teacherDepartment.setAdapter(FISHARIES_adapter);
                else if (teacher_faculty.equals("Land Management"))
                    teacherDepartment.setAdapter(LAND_adapter);
                else if (teacher_faculty.equals("Nutrition and Food Science"))
                    teacherDepartment.setAdapter(NFS_adapter);
                else if (teacher_faculty.equals("Disaster Management"))
                    teacherDepartment.setAdapter(DISASTER_adapter);
                else if (teacher_faculty.equals("Animal Husbandury"))
                    teacherDepartment.setAdapter(DVM_adapter);
                else if (teacher_faculty.equals("Doctor of Veterinary Medicine"))
                    teacherDepartment.setAdapter(DVM_adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(TeachersSignUpActivity.this, "Please Select One...", Toast.LENGTH_SHORT).show();
            }
        });

        /*------------------DEPARTSMENTS-------------------*/
        ArrayAdapter Department_adapter = ArrayAdapter.createFromResource(TeachersSignUpActivity.this, R.array.departments, android.R.layout.simple_spinner_dropdown_item);
        Department_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        teacherDepartment.setAdapter(Department_adapter);

        teacherDepartment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                teacher_department = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(TeachersSignUpActivity.this, "Please Select One...", Toast.LENGTH_SHORT).show();
            }
        });

        teacherSignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teacherSignUp();
            }
        });
    }

    private void teacherSignUp() {

        if (teacherName.getText().toString().equals("") &&
                teacherEmail.getText().toString().equals("") &&
                teacherContact.getText().toString().equals("")) {
            Toast.makeText(TeachersSignUpActivity.this, "অনুগ্রহ পূর্বক সব তথ্য পূরণ করুন", Toast.LENGTH_SHORT).show();
        } else {
            teacher_name = teacherName.getText().toString();
            teacher_email = teacherEmail.getText().toString();
            teacher_contact = teacherContact.getText().toString();
            teacher_password = teacherPassword.getText().toString();

            progressBar.setVisibility(View.VISIBLE);
            RequestQueue requestQueue = Volley.newRequestQueue(TeachersSignUpActivity.this);
            StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.Teacher_Registration,
                    new Response.Listener<String>() {

                        @Override
                        public void onResponse(String response) {
                            progressBar.setVisibility(View.GONE);
                            /*Toast.makeText(TeachersSignUpActivity.this, response, Toast.LENGTH_SHORT).show();*/
                            if (response == "Success") {
                                Intent intent = new Intent(TeachersSignUpActivity.this, TeacherLoginActivity.class);
                                startActivity(intent);
                                finish();
                                overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
                            } else {
                                Toast.makeText(TeachersSignUpActivity.this, response, Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(TeachersSignUpActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("t_name", teacher_name);
                    params.put("t_post", teacher_post);
                    params.put("t_faculty", teacher_faculty);
                    params.put("t_dept", teacher_department);
                    params.put("t_pass", teacher_password);
                    params.put("t_email", teacher_email);
                    params.put("t_contact", teacher_contact);
                    return params;
                }
            };
            requestQueue.add(stringRequest);
        }
    }

    public void onBackPressed() {
        Intent intent = new Intent(TeachersSignUpActivity.this, TeacherLoginActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
        super.onBackPressed();
    }
}