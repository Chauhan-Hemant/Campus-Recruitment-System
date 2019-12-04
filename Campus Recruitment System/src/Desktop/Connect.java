package Desktop;

import java.sql.*;

public class Connect {

    public static void main(String args[]) {
        Connection conn = null;
        try {
            String driverName = "net.sourceforge.jtds.jdbc.Driver";
            Class.forName(driverName);
            conn = DriverManager.getConnection("jdbc:jtds:sqlserver://122.168.195.107:1433/libDemo;user=Lib;password=admin_st");
            System.out.println("Successfully Connected to the Database!!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Coud not find the Database Driver" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Coud not connect to the Database " + ex.getMessage());
        }
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from student");
            while (rs.next()) {
                int no = rs.getInt(1);
                String name = rs.getString(2).toString();
                System.out.println("" + no + "   " + name);
            }
            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
