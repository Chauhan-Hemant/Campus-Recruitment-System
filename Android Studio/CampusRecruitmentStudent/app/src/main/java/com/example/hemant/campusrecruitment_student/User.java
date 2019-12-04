package com.example.hemant.campusrecruitment_student;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class User extends AppCompatActivity {
    private static Button View_Profile_Button,Logout_button,ViewJobs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        LogoutButton();
        ViewJobs();
        ViewAll();
    }
    public void LogoutButton(){
        Logout_button = (Button)findViewById(R.id.Logout);
        Logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent y = new Intent(getApplicationContext(),Login.class);
                startActivity(y);
            }
        });
    }
    public void ViewJobs(){
        ViewJobs = (Button)findViewById(R.id.View_jobs);
        ViewJobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getApplicationContext(),View_Jobs.class);
                startActivity(a);
            }
        });
    }
    public void ViewAll(){
        View_Profile_Button = (Button)findViewById(R.id.view_profile);
        View_Profile_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),View_Profile.class);
                startActivity(intent1);
            }
        });
    }
}
