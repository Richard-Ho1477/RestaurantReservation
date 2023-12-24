package update;

import java.sql.*;

public class UpdateTable {
    public void updateData(String id, String order, String status, String type) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restomanagement","root","");
			PreparedStatement pst = con.prepareStatement("update tablelist set `order` = ?, status = ? where id = ? and type = ?");
			pst.setString(1, order);
			pst.setString(2, status);
            pst.setString(3, id);
            pst.setString(4, type);
			if(pst.executeUpdate() != 0) System.out.println("\nTable data changed");
			else System.out.println("\nError, Table data is not changed");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
    }
}
