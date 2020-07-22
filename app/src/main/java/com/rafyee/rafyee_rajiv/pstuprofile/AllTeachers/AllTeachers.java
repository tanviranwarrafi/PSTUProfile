package com.rafyee.rafyee_rajiv.pstuprofile.AllTeachers;

import android.content.Intent;
import android.net.Uri;
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
import com.rafyee.rafyee_rajiv.pstuprofile.Adapters.TeacherAdapter;
import com.rafyee.rafyee_rajiv.pstuprofile.Models.TeacherUnit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllTeachers extends AppCompatActivity {

    private ImageView backButton;
    private Spinner teacherDepartment, teacherFaculty;
    private ProgressBar progressBar;
    private Button showTeacherBtn;
    private String faculty, department;
    private ListView listView;
    private TeacherAdapter teacherAdapter;
    private List<TeacherUnit> teacherUnitList = new ArrayList<TeacherUnit>();
    private JSONArray jsonArray = null;
    public static final String JSON_ARRAY = "result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_teachers);
        getSupportActionBar().hide();

        backButton = findViewById(R.id.showAllTeachers_backButton);
        teacherDepartment = findViewById(R.id.showAllTeachers_teacherDepartment);
        teacherFaculty = findViewById(R.id.showAllTeachers_teacherFaculty);
        showTeacherBtn = findViewById(R.id.showAllTeachers_viewTeacherBtn);
        progressBar = findViewById(R.id.showAllTeachers_progressBar);
        listView = findViewById(R.id.showAllTeachers_teacherListview);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(AllTeachers.this, MainActivity.class);
                startActivity(backIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
            }
        });

        /* AGRICULTURE ADAPTER */
        final ArrayAdapter AGRICULTURE_Adapter = ArrayAdapter.createFromResource(AllTeachers.this, R.array.agriculture, android.R.layout.simple_spinner_dropdown_item);
        AGRICULTURE_Adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        //dept.setAdapter(AGRICULTURE_Adapter);

        /* CSE ADAPTER */
        final ArrayAdapter CSE_adapter = ArrayAdapter.createFromResource(AllTeachers.this, R.array.CSE, android.R.layout.simple_spinner_dropdown_item);
        CSE_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        //dept.setAdapter(CSE_adapter);

        /* BBA ADAPTER */
        final ArrayAdapter BBA_adapter = ArrayAdapter.createFromResource(AllTeachers.this, R.array.bba, android.R.layout.simple_spinner_dropdown_item);
        BBA_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        //dept.setAdapter(BBA_adapter);

        /* FISHARIES ADAPTER */
        final ArrayAdapter FISHARIES_adapter = ArrayAdapter.createFromResource(AllTeachers.this, R.array.fisharies, android.R.layout.simple_spinner_dropdown_item);
        FISHARIES_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        //dept.setAdapter(FISHARIES_adapter);

        /* LAND ADAPTER */
        final ArrayAdapter LAND_adapter = ArrayAdapter.createFromResource(AllTeachers.this, R.array.land_management, android.R.layout.simple_spinner_dropdown_item);
        LAND_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        //dept.setAdapter(LAND_adapter);

        /* NFS ADAPTER */
        final ArrayAdapter NFS_adapter = ArrayAdapter.createFromResource(AllTeachers.this, R.array.nfs, android.R.layout.simple_spinner_dropdown_item);
        NFS_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        //dept.setAdapter(NFS_adapter);

        /* DISASTER ADAPTER */
        final ArrayAdapter DISASTER_adapter = ArrayAdapter.createFromResource(AllTeachers.this, R.array.disaster_management, android.R.layout.simple_spinner_dropdown_item);
        DISASTER_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        //dept.setAdapter(DISASTER_adapter);

        /* DVM & ANIMAL ADAPTER */
        final ArrayAdapter DVM_adapter = ArrayAdapter.createFromResource(AllTeachers.this, R.array.dvm, android.R.layout.simple_spinner_dropdown_item);
        DVM_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        /* FACULTY */
        ArrayAdapter Faculty_adapter = ArrayAdapter.createFromResource(AllTeachers.this, R.array.facultys, android.R.layout.simple_spinner_dropdown_item);
        Faculty_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        teacherFaculty.setAdapter(Faculty_adapter);

        teacherFaculty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                faculty = parent.getItemAtPosition(position).toString();

                if (faculty.equals("Computer Science and Engineering")) {
                    teacherDepartment.setAdapter(CSE_adapter);
                } else if (faculty.equals("Agriculture"))
                    teacherDepartment.setAdapter(AGRICULTURE_Adapter);
                else if (faculty.equals("Business Administration and Management"))
                    teacherDepartment.setAdapter(BBA_adapter);
                else if (faculty.equals("Fisharies"))
                    teacherDepartment.setAdapter(FISHARIES_adapter);
                else if (faculty.equals("Land Management"))
                    teacherDepartment.setAdapter(LAND_adapter);
                else if (faculty.equals("Nutrition and Food Science"))
                    teacherDepartment.setAdapter(NFS_adapter);
                else if (faculty.equals("Disaster Management"))
                    teacherDepartment.setAdapter(DISASTER_adapter);
                else if (faculty.equals("Animal Husbandury"))
                    teacherDepartment.setAdapter(DVM_adapter);
                else if (faculty.equals("Doctor of Veterinary Medicine"))
                    teacherDepartment.setAdapter(DVM_adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(AllTeachers.this, "Please Select One...", Toast.LENGTH_SHORT).show();
            }
        });

        /*------------------DEPARTSMENTS-------------------*/
        ArrayAdapter Department_adapter = ArrayAdapter.createFromResource(AllTeachers.this, R.array.departments, android.R.layout.simple_spinner_dropdown_item);
        Department_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        teacherDepartment.setAdapter(Department_adapter);

        teacherDepartment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                department = parent.getItemAtPosition(position).toString();
                //Toast.makeText(StudentRegistration.this, position , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(AllTeachers.this, "Please Select One...", Toast.LENGTH_SHORT).show();
            }
        });

        showTeacherBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.Show_Teacher,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                progressBar.setVisibility(View.GONE);
                                JSONObject jsonObject = null;
                                teacherUnitList.clear();
                                try {
                                    jsonObject = new JSONObject(response);
                                    jsonArray = jsonObject.getJSONArray(JSON_ARRAY);
                                    if (jsonArray.length() == 0) {
                                        Toast.makeText(AllTeachers.this, "No Data Recorded", Toast.LENGTH_SHORT).show();
                                    } else {
                                        for (int i = 0; i < jsonArray.length(); i++) {
                                            JSONObject object = jsonArray.getJSONObject(i);
                                            TeacherUnit teacherUnit = new TeacherUnit();

                                            teacherUnit.setT_name(object.getString("t_name"));
                                            teacherUnit.setT_post(object.getString("t_post"));
                                            teacherUnit.setT_faculty(object.getString("t_faculty"));
                                            teacherUnit.setT_dept(object.getString("t_dept"));
                                            teacherUnit.setT_contact(object.getString("t_contact"));
                                            teacherUnit.setT_email(object.getString("t_email"));

                                            teacherUnitList.add(teacherUnit);
                                        }
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                teacherAdapter = new TeacherAdapter(AllTeachers.this, teacherUnitList);
                                listView.setAdapter(teacherAdapter);
                            }
                        }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(AllTeachers.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("t_faculty", faculty);
                        params.put("t_dept", department);
                        return params;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(AllTeachers.this);
                requestQueue.add(stringRequest);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TeacherUnit tu = teacherUnitList.get(position);
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + tu.getT_contact())));
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(AllTeachers.this, TeacherDetails.class);
                TeacherUnit teacher = teacherUnitList.get(position);
                intent.putExtra("t_name", teacher.getT_name());
                intent.putExtra("t_post", teacher.getT_post());
                intent.putExtra("t_faculty", teacher.getT_faculty());
                intent.putExtra("t_dept", teacher.getT_dept());
                intent.putExtra("t_contact", teacher.getT_contact());
                intent.putExtra("t_email", teacher.getT_email());
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });
    }

    public void onBackPressed() {
        Intent intent = new Intent(AllTeachers.this, MainActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
        super.onBackPressed();
    }
}