
package Desktop;


public class View_Jobs {
    private String company_name,job_title,job_description,job_requirement,key_responsibilities,salary_range;
    private int criteria;
    public View_Jobs(String Company_Name, String Job_Title, String Job_Description, String Job_Requirement, String Key_Responsibilities, String Salary_Range, int Criteria){
        this.company_name = Company_Name;
        this.job_title = Job_Title;
        this.job_description = Job_Description;
        this.job_requirement = Job_Requirement;
        this.key_responsibilities = Key_Responsibilities;
        this.salary_range = Salary_Range;
        this.criteria = Criteria;

        
    }
    public String getCompanyName(){
        return company_name;
    }
    public String getJobTitle(){
        return job_title;
    }
    public String getJobDescription(){
        return job_description;
    }
    public String getJobRequirement(){
        return job_requirement;
    }
    public String getKeyResponsibilities(){
        return key_responsibilities;
    }
    public String getSalaryRange(){
        return salary_range;
    }
    public int getCriteria(){
        return criteria;
    }
}
