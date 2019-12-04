package com.example.hemant.campusrecruitment_company;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.*;

import java.sql.Statement;

public class Login extends AppCompatActivity {
    public static EditText Username,Password;
    private static Button button_Login,button_Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginButton();
        RegisterButton();
    }
    public boolean checkLogin(String username, String password) {
        Database conn1 = new Database();
        conn1.CONN();
        try {
            String c = "SELECT COMPANY_NAME,PASSWORD FROM crs.COMPANY WHERE COMPANY_NAME ='"+username+"' AND PASSWORD ='"+password+"';";
            Statement stat = conn1.conn.createStatement();
            stat.execute(c);
            stat.close();
            conn1.conn.close();
        }
        catch(Exception ex){
            Log.e("ERRO", ex.getMessage());
        }
        return true;
    }
    public void LoginButton(){
        Username = (EditText)findViewById(R.id.editText);
        Password = (EditText)findViewById(R.id.editText2);
        button_Login = (Button)findViewById(R.id.button_Login);
        button_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkLogin(Username.getText().toString(), Password.getText().toString())){
                    Toast.makeText(Login.this, "The username and password is correct!!!",
                            Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), User.class);
                    startActivity(i);
                    Username.setText("");
                    Password.setText("");
                }
                else{
                    Toast.makeText(getApplicationContext(), "The username and password is not correct!!!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void RegisterButton(){
        button_Register = (Button)findViewById(R.id.button_Register);
        button_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),Register.class);
                startActivity(intent1);
            }
        });
    }
}
