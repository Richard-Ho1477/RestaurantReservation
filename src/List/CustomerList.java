package List;

import java.sql.*;

public class CustomerList implements CheckList{
    public boolean listNull(String cabang){
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restomanagement","root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from customerlist");
            if(!rs.next()) return true;
            while(rs.next()){
                if(cabang.compareTo(rs.getString("cabang")) == 0) return false;
            }
            con.close();
            return true;
		} catch (Exception e) {
			System.out.println(e);
		}

        return true;
    }
}
