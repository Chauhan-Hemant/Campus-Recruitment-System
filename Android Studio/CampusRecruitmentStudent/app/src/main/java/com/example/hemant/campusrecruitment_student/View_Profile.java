package com.example.hemant.campusrecruitment_student;

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
    }
    public void ViewButton(){
        View_profile_button = (Button)findViewById(R.id.button4);
        View_profile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    Database conn1 = new Database();
                    conn1.CONN();
                    String sql ="select * from crs.STUDENT";
                    Statement stat = conn1.conn.createStatement();
                    ResultSet rs = stat.executeQuery(sql);
                    String alldata="";
                    while(rs.next())
                    {
                        String name = rs.getString(1);
                        alldata = alldata + name +"\n";
                    }

                    TextView tv = (TextView) findViewById(R.id.textView16);
                    tv.setText(alldata);
                }
                catch(Exception ex)
                {
                }
            }
        });
    }
}
