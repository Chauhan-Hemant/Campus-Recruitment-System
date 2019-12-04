package com.example.hemant.campusrecruitment_student;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import java.sql.*;

public class Register extends AppCompatActivity {
    private static EditText Student_ID,Student_Name,Contact_Number,Email_ID,Gender,Date_of_Birth,Tenth_percentage,Tenth_board;
    private static EditText Tenth_Passing_Year,Twelve_percentage,Twelve_Board,Twelve_Passing_Year,Course,Aggregate,University,Password;
    private static Button Reset_Button,Save_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ResetButton();
        SaveButton();
    }
    public void ResetButton(){

        Student_ID = (EditText)findViewById(R.id.Student_ID);
        Student_Name = (EditText)findViewById(R.id.Student_name);
        Contact_Number = (EditText)findViewById(R.id.Contact_number);
        Email_ID = (EditText)findViewById(R.id.Email_ID);
        Gender = (EditText)findViewById(R.id.Gender);

        Date_of_Birth = (EditText)findViewById(R.id.Date_of_birth);
        Tenth_percentage = (EditText)findViewById(R.id.tenth_percentage);
        Tenth_board = (EditText)findViewById(R.id.tenth_board);
        Tenth_Passing_Year = (EditText)findViewById(R.id.tenth_passing_year);
        Twelve_percentage = (EditText)findViewById(R.id.twelve_percentage);

        Twelve_Board = (EditText)findViewById(R.id.twelve_Board);
        Twelve_Passing_Year = (EditText)findViewById(R.id.twelve_passing_year);
        Course = (EditText)findViewById(R.id.Course);
        Aggregate = (EditText)findViewById(R.id.Aggregate);
        University = (EditText)findViewById(R.id.University);
        Password = (EditText)findViewById(R.id.Password);
        Save_Button = (Button)findViewById(R.id.button);
        Reset_Button = (Button)findViewById(R.id.button2);

        Reset_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student_ID.setText("");
                Student_Name.setText("");
                Contact_Number.setText("");
                Email_ID.setText("");
                Gender.setText("");

                Date_of_Birth.setText("");
                Tenth_percentage.setText("");
                Tenth_board.setText("");
                Tenth_Passing_Year.setText("");
                Twelve_percentage.setText("");

                Twelve_Board.setText("");
                Twelve_Passing_Year.setText("");
                Course.setText("");
                Aggregate .setText("");
                University .setText("");
                Password.setText("");
            }
        });
    }
    public void SaveButton(){
        Save_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = Student_ID.getText().toString();
                String name = Student_Name.getText().toString();
                String number = Contact_Number.getText().toString();
                String email = Email_ID.getText().toString();
                String gender = Gender.getText().toString();
                String dob = Date_of_Birth.getText().toString();
                String tenthpercentage = Tenth_percentage.getText().toString();
                String tenthboard = Tenth_board.getText().toString();
                String tenthpassingyear = Tenth_Passing_Year.getText().toString();
                String twelvepercentage = Twelve_percentage.getText().toString();
                String twelveboard = Twelve_Board.getText().toString();
                String twelvepassingyear = Twelve_Passing_Year.getText().toString();
                String course = Course.getText().toString();
                String aggregate = Aggregate.getText().toString();
                String university = University.getText().toString();
                String password = Password.getText().toString();

                if(id.length()==0 || name.length()==0 || number.length()==0 || email.length()==0 || gender.length()==0
                        || dob.length()==0 || tenthpercentage.length()==0 || tenthboard.length()==0 || tenthpassingyear.length()==0
                        || twelvepercentage.length()==0 || twelveboard.length()==0 || twelvepassingyear.length()==0 || course.length()==0
                        || aggregate.length()==0 || university.length()==0 || password.length()==0)
                {
                    Toast.makeText(getApplicationContext(),
                            "Value cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                try
                {
                    Database conn1 = new Database();
                    conn1.CONN();
                    String sql = "Insert into crs.STUDENT VALUES('"+id+"','"+name+"',"+number+",'"+email+"','"+gender+"',"+dob+","+tenthpercentage+"," +
                            "'"+tenthboard+"',"+tenthpassingyear+","+twelvepercentage+",'"+twelveboard+"',"+twelvepassingyear+",'"+course+"'," +
                            ""+aggregate+",'"+university+"',"+password+")";
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
}
