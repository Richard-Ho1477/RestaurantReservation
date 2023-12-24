package delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteMenu {
    public void deleteData(String name, String cabang){
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restomanagement","root","");
			PreparedStatement pst = con.prepareStatement("delete from menulist where name = ? and cabang = ?");
			pst.setString(1, name);
			pst.setString(2, cabang);
			if(pst.executeUpdate() != 0) System.out.println("\nMenu data deleted");
			else System.out.println("\nError, Menu data is not deleted");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
