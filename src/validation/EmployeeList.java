package validation;

import java.sql.*;

public class EmployeeList{
    public boolean listNull(String cabang){
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restomanagement","root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employeelist");
            
            if(cabang.compareTo("-") == 0){
                if(rs.next()) return false;
            }
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
