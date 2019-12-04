package com.example.hemant.campusrecruitment_company;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.*;

import java.sql.*;

public class Register extends AppCompatActivity {
    private static EditText Company_Name,Address,City,Contact_Number,Password;
    private static Button Register_button,Reset_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        RegisterButton();
        ResetButton();
    }

    public void RegisterButton(){
        Company_Name = (EditText) findViewById(R.id.editText3);
        Address = (EditText) findViewById(R.id.editText4);
        City = (EditText) findViewById(R.id.editText5);
        Contact_Number = (EditText) findViewById(R.id.editText6);
        Password = (EditText) findViewById(R.id.editText7);
        Register_button = (Button) findViewById(R.id.button);
        Register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = Company_Name.getText().toString();
                String add = Address.getText().toString();
                String city = City.getText().toString();
                String contact = Contact_Number.getText().toString();
                String password = Password.getText().toString();

                if(name.length()==0 || add.length()==0 || city.length()==0 || contact.length()==0 || password.length()==0)
                {
                    Toast.makeText(getApplicationContext(),
                            "Value cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                try
                {
                    Database conn1 = new Database();
                    conn1.CONN();
                    String sql = "INSERT INTO crs.COMPANY VALUES ('"+name+"','"+add+"','"+city+"',"+contact+",'"+password+"')";
                    Statement stat = conn1.conn.createStatement();
                    stat.execute(sql);
                    stat.close();
                    conn1.conn.close();
                    Toast.makeText(getApplicationContext(),
                            "Registered sucessfully...", Toast.LENGTH_SHORT).show();
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
        Reset_button = (Button)findViewById(R.id.button2);
        Reset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Company_Name.setText("");
                Address.setText("");
                City.setText("");
                Contact_Number.setText("");
                Password.setText("");
            }
        });
    }
}
