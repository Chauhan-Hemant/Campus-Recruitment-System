package com.example.hemant.campusrecruitment_company;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.*;
import java.sql.*;

public class View_Students extends AppCompatActivity {
    private static Button Show_data_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__students);
        ViewData();
    }
    public void ViewData(){
        Show_data_button = (Button)findViewById(R.id.button5);
        Show_data_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    Database conn1 = new Database();
                    conn1.CONN();
                    String sql = "SELECT * FROM crs.STUDENT ;";
                    Statement stat = conn1.conn.createStatement();
                    ResultSet rs = stat.executeQuery(sql);
                    String alldata="";
                    while(rs.next())
                    {
                        String name = rs.getString(1);
                        alldata = alldata + name +"\n";
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
                    TextView tv = (TextView) findViewById(R.id.textView15);
                    tv.setText(alldata);
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
