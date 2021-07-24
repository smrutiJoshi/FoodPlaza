package in.squad.foodplaza.dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

	public static Connection getCon() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/FoodPlaza_80075";
		String username="root";
		String password="root";
		Connection con=DriverManager.getConnection(url,username,password);
		return con;
	}
	
}
