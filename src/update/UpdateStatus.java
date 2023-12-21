package update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateStatus implements Update{
    public void updateData(String id, String status, String type){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restomanagement","root","");
			PreparedStatement pst = con.prepareStatement("update tablelist set status = ? where id = ? and type = ?");
			pst.setString(1, status);
            pst.setString(2, id);
            pst.setString(3, type);
			if(pst.executeUpdate() != 0) System.out.println("\nTable has been checkout");
			else System.out.println("\nError, Table has not been checkout");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
    }
}
