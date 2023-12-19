package add;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddTable implements Add{
    public void addData(String id, String type, String status) {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restomanagement","root","");
			PreparedStatement pst = con.prepareStatement("insert into tablelist (id,type,status) values (?,?,?)");
			pst.setString(1, id);
			pst.setString(2, type);
			pst.setString(3, status);
			if(pst.executeUpdate() != 0) System.out.println("Table data added");
			else System.out.println("Error, Table data is not added");
            con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
