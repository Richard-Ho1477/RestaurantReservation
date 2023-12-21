package delete;

import java.sql.*;

public class DeleteEmployee implements Delete{
    public void deleteData(String id){
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restomanagement","root","");
			PreparedStatement pst = con.prepareStatement("delete from employeelist where id = ?");
			pst.setString(1, id);
			if(pst.executeUpdate() != 0) System.out.println("\nEmployee data deleted");
			else System.out.println("\nError, Employee data is not deleted");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
