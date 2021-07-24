package in.squad.foodplaza.dao;

import java.sql.SQLException;

public interface Login_Dao {

	boolean userLogin(String userName, String password, String userType)throws ClassNotFoundException, SQLException;
}
