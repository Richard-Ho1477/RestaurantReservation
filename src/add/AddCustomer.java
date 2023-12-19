package add;

import java.sql.*;

public class AddCustomer implements AddUser{
    public void addData(String id, String name, String cabang) {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restomanagement","root","");
			PreparedStatement pst = con.prepareStatement("insert into customerlist (id,name,cabang) values (?,?,?)");
			pst.setString(1, id);
			pst.setString(2, name);
			pst.setString(3, cabang);
			if(pst.executeUpdate() != 0) System.out.println("\nCustomer data added");
			else System.out.println("\nError, Customer data is not added");
            con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
