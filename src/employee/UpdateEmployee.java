package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateEmployee {
    public void updateEmployee(String id, String name, String cabang) {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restomanagement","root","");
			PreparedStatement pst = con.prepareStatement("update employeelist set name = ?, cabang = ? where id = ?");
			pst.setString(1, name);
			pst.setString(2, cabang);
            pst.setString(3, id);
			if(pst.executeUpdate() != 0) System.out.println("\nEmployee data changed");
			else System.out.println("\nError, Employee data is not changed");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
