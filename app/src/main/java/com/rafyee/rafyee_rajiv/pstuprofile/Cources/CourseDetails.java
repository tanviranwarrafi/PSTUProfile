package com.rafyee.rafyee_rajiv.pstuprofile.Cources;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
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
import com.rafyee.rafyee_rajiv.pstuprofile.Adapters.CourseAdapter;
import com.rafyee.rafyee_rajiv.pstuprofile.Models.CourseUnit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseDetails extends AppCompatActivity {

    private ImageView backButton;
    private TextView facultyName;
    private Spinner semesterSpinner;
    private Button showCourse;
    private String semester;
    private ProgressBar progressBar;
    private ListView listview;
    private CourseAdapter courseAdapter;
    private List<CourseUnit> courseUnits = new ArrayList<CourseUnit>();
    private JSONArray jsonArray = null;
    public static final String JSON_ARRAY = "result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cources_details);
        getSupportActionBar().hide();

        backButton = findViewById(R.id.coureseDetails_backButton);
        facultyName = findViewById(R.id.courseDetails_facultyName);
        semesterSpinner = findViewById(R.id.coureseDetails_semester);
        progressBar = findViewById(R.id.courseDetails_progressBar);
        showCourse = findViewById(R.id.coureseDetails_showAllCourseBtn);
        listview = findViewById(R.id.coureseDetails_courseListView);

        Intent intent = getIntent();
        final String faculty = intent.getExtras().getString("faculty");
        final String faculty_name = intent.getExtras().getString("faculty_name");
        facultyName.setText(faculty_name);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(CourseDetails.this, CourseFaculty.class);
                startActivity(backIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
            }
        });

        ArrayAdapter Semester_adapter = ArrayAdapter.createFromResource(CourseDetails.this, R.array.semesters, android.R.layout.simple_spinner_dropdown_item);
        Semester_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        semesterSpinner.setAdapter(Semester_adapter);

        semesterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                semester = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(CourseDetails.this, "Please Select One...", Toast.LENGTH_SHORT).show();
            }
        });

        showCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.User_Show_Course,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                progressBar.setVisibility(View.GONE);
                                JSONObject jsonObject = null;
                                courseUnits.clear();
                                try {
                                    jsonObject = new JSONObject(response);
                                    jsonArray = jsonObject.getJSONArray(JSON_ARRAY);
                                    if (jsonArray.length() == 0) {
                                        Toast.makeText(CourseDetails.this, "No Data Recorded", Toast.LENGTH_SHORT).show();
                                    } else {
                                        for (int i = 0; i < jsonArray.length(); i++) {
                                            JSONObject object = jsonArray.getJSONObject(i);
                                            CourseUnit courseUnit = new CourseUnit();

                                            courseUnit.setCourse_title(object.getString("course_title"));
                                            courseUnit.setCourse_code(object.getString("course_code"));
                                            courseUnit.setCredit(object.getString("credit"));
                                            courseUnit.setFaculty(object.getString("faculty"));
                                            courseUnit.setFaculty(object.getString("semester"));

                                            courseUnits.add(courseUnit);
                                        }
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                courseAdapter = new CourseAdapter(CourseDetails.this, courseUnits);
                                listview.setAdapter(courseAdapter);
                            }
                        }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(CourseDetails.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }) {

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("faculty", faculty);
                        params.put("semester", semester);
                        return params;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(CourseDetails.this);
                requestQueue.add(stringRequest);
            }
        });
    }

    public void onBackPressed() {
        Intent intent = new Intent(CourseDetails.this, CourseFaculty.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
        super.onBackPressed();
    }
}

