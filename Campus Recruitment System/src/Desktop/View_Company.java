
package Desktop;


public class View_Company {
    private String company_name,address,city,contact_number, password;
    public View_Company(String Company_Name, String Address, String City, String Contact_Number, String Password){
        this.company_name = Company_Name;
        this.address = Address;
        this.city = City;
        this.contact_number = Contact_Number;
        this.password = Password;

        
    }
    public String getCompanyName(){
        return company_name;
    }
    public String getAddress(){
        return address;
    }
    public String getCity(){
        return city;
    }
    public String getContactNumber(){
        return contact_number;
    }
    public String getPassword(){
        return password;
    }
}
