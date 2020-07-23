package com.rafyee.rafyee_rajiv.pstuprofile.TeacherProfile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

public class TeacherUpdate extends AppCompatActivity {

    private ImageView backButton;
    private TextView teacherNameInTop;
    private EditText teacherName, teacherPassword, teacherContact;
    private Spinner teacherPost;
    private LinearLayout teacherUpdateBtn;
    private String name, post, contact, pass, gotTeacherEmail, gotName, gotPost, gotPassword, gotContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_update);
        getSupportActionBar().hide();

        Intent intent = getIntent();
        gotTeacherEmail = intent.getExtras().getString("teacher_email");
        gotName = intent.getExtras().getString("teacher_name");
        gotPost = intent.getExtras().getString("teacher_post");
        gotPassword = intent.getExtras().getString("teacher_password");
        gotContact = intent.getExtras().getString("teacher_contact");

        backButton = findViewById(R.id.teacherUpdate_backButton);
        teacherNameInTop = findViewById(R.id.teacherUpdate_nameTop);
        teacherName = findViewById(R.id.teacherUpdate_newName);
        teacherPassword = findViewById(R.id.teacherUpdate_newPassword);
        teacherContact = findViewById(R.id.teacherUpdate_newContact);
        teacherPost = findViewById(R.id.teacherUpdate_newPost);
        teacherUpdateBtn = findViewById(R.id.teacherUpdate_updateBtn);

        teacherNameInTop.setText(gotName);
        teacherName.setText(gotName);
        teacherPassword.setText(gotPassword);
        teacherContact.setText(gotContact);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(TeacherUpdate.this, TeacherLoggedIn.class);
                backIntent.putExtra("t_email", gotTeacherEmail);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
                startActivity(backIntent);
                finish();
            }
        });

        /* TEACHER POST */
        ArrayAdapter Post_adapter = ArrayAdapter.createFromResource(TeacherUpdate.this, R.array.posts, android.R.layout.simple_spinner_dropdown_item);
        Post_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        teacherPost.setAdapter(Post_adapter);

        teacherPost.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                post = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(TeacherUpdate.this, "Please Select One...", Toast.LENGTH_SHORT).show();
            }
        });

        teacherUpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = teacherName.getText().toString();
                pass = teacherPassword.getText().toString();
                contact = teacherContact.getText().toString();

                RequestQueue requestQueue = Volley.newRequestQueue(TeacherUpdate.this);
                StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.Teacher_Update,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(TeacherUpdate.this,  "আপডেট সফল হয়েছে", Toast.LENGTH_SHORT).show();
                            }
                        }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(TeacherUpdate.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("t_name", name);
                        params.put("t_post", post);
                        params.put("t_contact", contact);
                        params.put("t_email", gotTeacherEmail);
                        params.put("t_pass", pass);
                        return params;
                    }
                };
                requestQueue.add(stringRequest);
                Intent in = new Intent(TeacherUpdate.this, TeacherLoggedIn.class);
                in.putExtra("t_email", gotTeacherEmail);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
                startActivity(in);
            }
        });
    }

    public void onBackPressed() {
        Intent intent = new Intent(TeacherUpdate.this, TeacherLoggedIn.class);
        intent.putExtra("t_email", gotTeacherEmail);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
        super.onBackPressed();
    }

}