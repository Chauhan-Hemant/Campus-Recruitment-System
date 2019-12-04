package com.example.hemant.campusrecruitment_student;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.*;
import android.content.*;

import java.sql.Statement;

public class Login extends AppCompatActivity {
    private static EditText Student_ID,Password;
    private static Button Login_button,Register_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginButton();
    }
    public boolean checkLogin(String Student_ID, String Password) {
        Database conn1 = new Database();
        conn1.CONN();
        try {
            String c = "SELECT * FROM crs.STUDENT WHERE " + Student_ID + "=? AND" + Password + "=?";
            Statement stat = conn1.conn.createStatement();
            stat.execute(c);
            stat.close();
            conn1.conn.close();
            finish();
        }
        catch(Exception ex){
            Log.e("ERRO", ex.getMessage());
        }
        return true;
    }
    public void LoginButton(){
        Student_ID = (EditText)findViewById(R.id.editText);
        Password = (EditText)findViewById(R.id.editText2);
        Login_button = (Button)findViewById(R.id.button_signin);
        Login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Boolean validUser = checkLogin(Student_ID.getText().toString(), Password.getText().toString());

                if(validUser == true) {
                    Toast.makeText(Login.this, "The username and password is correct!!!",
                            Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), User.class);
                    startActivity(i);
                    Student_ID.setText("");
                    Password.setText("");
                } else {
                    Toast.makeText(getApplicationContext(), "The username and password is not correct!!!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        Register_button = (Button)findViewById(R.id.button_signup);
        Register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent y = new Intent(getApplicationContext(),Register.class);
                startActivity(y);
            }
        });
    }
}
