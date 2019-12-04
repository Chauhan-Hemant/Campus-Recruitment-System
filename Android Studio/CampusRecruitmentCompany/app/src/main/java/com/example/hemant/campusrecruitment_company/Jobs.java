package com.example.hemant.campusrecruitment_company;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import java.sql.*;

public class Jobs extends AppCompatActivity {
    private static EditText Company_Name,Job_Name,Job_description,Job_Requirement,Key_Response,Job_Criteria,Job_Salary;
    private static Button Save_button,Reset_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs);
        SaveButton();
        ResetButton();
    }
    public void SaveButton(){
        Company_Name = (EditText)findViewById(R.id.editText19);
        Job_Name = (EditText)findViewById(R.id.editText8);
        Job_description = (EditText)findViewById(R.id.editText9);
        Job_Requirement = (EditText)findViewById(R.id.editText10);
        Key_Response = (EditText)findViewById(R.id.editText11);
        Job_Criteria = (EditText)findViewById(R.id.editText12);
        Job_Salary  = (EditText)findViewById(R.id.editText13);
        Save_button = (Button)findViewById(R.id.button3);
        Save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = Company_Name.getText().toString();
                String jname = Job_Name.getText().toString();
                String jdescription = Job_description.getText().toString();
                String jrequirement = Job_Requirement.getText().toString();
                String keyresponse = Key_Response.getText().toString();
                String jcriteria = Job_Criteria.getText().toString();
                String jsalary = Job_Salary.getText().toString();


                if(name.length()==0 || jname.length()==0 || jdescription.length()==0 || jrequirement.length()==0 || keyresponse.length()==0
                        || jcriteria.length()==0 || jsalary.length()==0)
                {
                    Toast.makeText(getApplicationContext(),
                            "Value cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                try
                {
                    Database conn1 = new Database();
                    conn1.CONN();
                    String sql = "Insert into crs.JOB values('"+name+"','"+jname+"','"+jdescription+"','"+jrequirement+"','"+keyresponse+"','"
                            +jcriteria+"',"+jsalary+")";
                    Statement stat = conn1.conn.createStatement();
                    stat.execute(sql);
                    stat.close();
                    conn1.conn.close();
                    Toast.makeText(getApplicationContext(),
                            "Job Posted...", Toast.LENGTH_SHORT).show();
                    finish();
                }
                catch(Exception ex)
                {
                    Toast.makeText(getApplicationContext(),
                            ex.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    public void ResetButton(){
        Reset_button = (Button)findViewById(R.id.button4);
        Reset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Company_Name.setText("");
                Job_Name.setText("");
                Job_description.setText("");
                Job_Requirement.setText("");
                Key_Response.setText("");
                Job_Criteria.setText("");
                Job_Salary.setText("");
            }
        });
    }
}
