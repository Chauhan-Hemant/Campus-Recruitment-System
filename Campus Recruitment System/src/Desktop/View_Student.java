
package Desktop;


public class View_Student {
    private String student_id, student_name, contact_number, email_id, gender, date_of_birth, tenth_percentage, tenth_board, tenth_passing_year,
            twelth_percentage, twelth_board, twelth_passing_year, course, aggregate, university, password;
    
    public View_Student(String Student_Id, String Student_Name, String Contact_Number, String Email_Id, String Gender, String Date_Of_Birth, String Tenth_Percentage, String Tenth_Board,
            String Tenth_Passing_Year, String Twelth_Percentage, String Twelth_Board, String Twelth_Passing_Year, String Course, String Aggregate, String University, String Password){
        
        this.student_id = Student_Id;
        this.student_name = Student_Name;
        this.contact_number = Contact_Number;
        this.email_id = Email_Id;
        this.gender = Gender;
        
        this.date_of_birth = Date_Of_Birth;
        this.tenth_percentage = Tenth_Percentage;
        this.tenth_board = Tenth_Board;
        this.tenth_passing_year = Tenth_Passing_Year;
        this.twelth_percentage = Twelth_Percentage;
        
        this.twelth_board = Twelth_Board;
        this.twelth_passing_year = Twelth_Passing_Year;
        this.course = Course;
        this.aggregate = Aggregate;
        this.university = University;
        this.password = Password;
    
    }
    
    public String getStudentId(){
        return student_id;
    }
    public String getStudentName(){
        return student_name;
    }
    public String getContactNumber(){
        return contact_number;
    }
    public String getEmailId(){
        return email_id;
    }
    public String getGender(){
        return gender;
    } 
    public String getDateOfBirth(){
        return date_of_birth;
    }
    public String getTenthPercentage(){
        return tenth_percentage;
    }
    public String getTenthBoard(){
        return tenth_board;
    }
    public String getTenthPassingYear(){
        return tenth_passing_year;
    }
    public String getTwelthPercentage(){
        return twelth_percentage;
    }
    public String getTwelthBoard(){
        return twelth_board;
    }
    public String getTwelthPassingYear(){
        return twelth_passing_year;
    }
    public String getCourse(){
        return course;
    }
    public String getAggregate(){
        return aggregate;
    }
    public String getUniversity(){
        return university;
    }
    public String getPassword(){
        return password;
    }
}
