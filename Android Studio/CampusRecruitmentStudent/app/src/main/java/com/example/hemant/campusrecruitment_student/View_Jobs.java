package com.example.hemant.campusrecruitment_student;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import java.sql.*;

public class View_Jobs extends AppCompatActivity {
    private static Button Get_data_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__jobs);
        GetDataButton();
    }
    public void GetDataButton(){
        Get_data_Button = (Button)findViewById(R.id.button3);
        Get_data_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    Database conn1 = new Database();
                    conn1.CONN();
                    String sql ="select * from crs.JOB";
                    Statement stat = conn1.conn.createStatement();
                    ResultSet rs = stat.executeQuery(sql);
                    String alldata="";
                    while(rs.next())
                    {
                        String name = rs.getString(1);
                        alldata = alldata + name +"\n";
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
}
