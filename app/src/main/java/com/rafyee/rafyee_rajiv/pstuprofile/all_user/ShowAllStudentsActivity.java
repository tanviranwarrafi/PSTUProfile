package com.rafyee.rafyee_rajiv.pstuprofile.all_user;

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
import com.rafyee.rafyee_rajiv.pstuprofile.adapters.StudentAdapter;
import com.rafyee.rafyee_rajiv.pstuprofile.models.StudentUnit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowAllStudentsActivity extends AppCompatActivity {

    private ImageView backButton;
    private Spinner studentFaculty, studentBatch;
    private String faculty, batch;
    private ListView listView;
    private ProgressBar progressBar;
    private Button showStudents;
    private StudentAdapter studentAdapter;
    private List<StudentUnit> studentUnitList = new ArrayList<StudentUnit>();
    private JSONArray jsonArray = null;
    public static final String JSON_ARRAY = "result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_all_students_activity);
        getSupportActionBar().hide();

        backButton = findViewById(R.id.showAllStudents_backButton);
        studentFaculty = findViewById(R.id.showAllStudents_studentFaculty);
        studentBatch = findViewById(R.id.showAllStudents_studentBatch);
        progressBar = findViewById(R.id.showAllStudents_progressBar);
        showStudents = findViewById(R.id.showAllStudents_showStudentsBtn);
        listView = findViewById(R.id.showAllStudents_studentListview);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(ShowAllStudentsActivity.this, MainActivity.class);
                startActivity(backIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
            }
        });

        /* FACULTY SPINNER */
        ArrayAdapter Faculty_adapter = ArrayAdapter.createFromResource(ShowAllStudentsActivity.this, R.array.facultys, android.R.layout.simple_spinner_dropdown_item);
        Faculty_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        studentFaculty.setAdapter(Faculty_adapter);

        studentFaculty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                faculty = parent.getItemAtPosition(position).toString();
                //Toast.makeText(StudentRegistration.this, position , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(ShowAllStudentsActivity.this, "Please Select One...", Toast.LENGTH_SHORT).show();
            }
        });

        /* BATCH SPINNER */
        ArrayAdapter BATCH_adapter = ArrayAdapter.createFromResource(ShowAllStudentsActivity.this, R.array.batchs, android.R.layout.simple_spinner_dropdown_item);
        BATCH_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        studentBatch.setAdapter(BATCH_adapter);

        studentBatch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                batch = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(ShowAllStudentsActivity.this, "Please Select One...", Toast.LENGTH_SHORT).show();
            }
        });

        showStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAllStudent();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ShowAllStudentsActivity.this, StudentPersonalDetailsActivity.class);
                StudentUnit me = studentUnitList.get(position);
                intent.putExtra("name", me.getName());
                intent.putExtra("Id_no", me.getId_no());
                intent.putExtra("reg_no", me.getReg_no());
                intent.putExtra("pass", me.getPass());
                intent.putExtra("faculty", me.getFaculty());
                intent.putExtra("batch", me.getBatch());
                intent.putExtra("contact", me.getContact());
                intent.putExtra("email", me.getEmail());
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });
    }

    public void onBackPressed() {
        Intent intent = new Intent(ShowAllStudentsActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
        super.onBackPressed();
    }

    private void showAllStudent() {
        progressBar.setVisibility(View.VISIBLE);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.Show_Students,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressBar.setVisibility(View.GONE);
                        JSONObject jsonObject = null;
                        studentUnitList.clear();
                        try {
                            jsonObject = new JSONObject(response);
                            jsonArray = jsonObject.getJSONArray(JSON_ARRAY);
                            if (jsonArray.length() == 0) {
                                Toast.makeText(ShowAllStudentsActivity.this, "No Data Recorded", Toast.LENGTH_SHORT).show();
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

                                    studentUnitList.add(stdUnit);
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        studentAdapter = new StudentAdapter(ShowAllStudentsActivity.this, studentUnitList);
                        listView.setAdapter(studentAdapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(ShowAllStudentsActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("batch", batch);
                params.put("faculty", faculty);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(ShowAllStudentsActivity.this);
        requestQueue.add(stringRequest);
    }
}