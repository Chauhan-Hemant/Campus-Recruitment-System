package com.example.hemant.campusrecruitment_company;

import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import java.sql.*;

public class View_Profile extends AppCompatActivity {
    private static Button View_profile_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__profile);
        ViewButton();
    }
    public void ViewButton(){
        View_profile_button = (Button)findViewById(R.id.button6);
        View_profile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    Database conn1 = new Database();
                    conn1.CONN();
                    String sql = "SELECT * FROM crs.COMPANY WHERE COMPANY_NAME = '"+Login.Username+"';";
                    Statement stat = conn1.conn.createStatement();
                    ResultSet rs = stat.executeQuery(sql);
                    StringBuffer buffer = new StringBuffer();

                    while(rs.next())
                    {
                        buffer.append("Company Name :"+rs.getString(0)+"\n");
                        buffer.append("Address :"+rs.getString(1)+"\n");
                        buffer.append("City :"+rs.getString(2)+"\n");
                        buffer.append("Contact Number :"+rs.getString(3)+"\n");
                        buffer.append("Password :"+rs.getString(4)+"\n\n");
                    }
                    showMessage("Data",buffer.toString());

                }
                catch(Exception ex)
                {
                }
            }
        });
    }
    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();


    }

}
