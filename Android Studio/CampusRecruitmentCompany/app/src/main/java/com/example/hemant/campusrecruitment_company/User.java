package com.example.hemant.campusrecruitment_company;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.*;

public class User extends AppCompatActivity {
    private static Button View_profile_button,Jobs,View_Students,Logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ViewProfileButton();
        JobsButton();
        ViewStudentsButton();
        LogoutButton();
    }
    public void ViewProfileButton(){
        View_profile_button = (Button)findViewById(R.id.view_profile);
        View_profile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),View_Profile.class);
                startActivity(intent);
            }
        });
    }
    public void JobsButton(){
        Jobs = (Button)findViewById(R.id.jobs);
        Jobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(),Jobs.class);
                startActivity(intent2);
            }
        });
    }
    public void ViewStudentsButton(){
        View_Students = (Button)findViewById(R.id.view_student_details);
        View_Students.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(),View_Students.class);
                startActivity(intent3);
            }
        });
    }
    public void LogoutButton(){
        Logout = (Button)findViewById(R.id.log_out);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(getApplicationContext(),Login.class);
                startActivity(intent4);
            }
        });
    }
}
