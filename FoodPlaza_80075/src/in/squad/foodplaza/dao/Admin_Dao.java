package in.squad.foodplaza.dao;

import java.sql.SQLException;

public interface Admin_Dao {
	boolean adminLogin(String EmailId,String Password)throws SQLException, ClassNotFoundException;
	boolean changepassword(String OldPassword,String newPass,String AdminEmail)throws SQLException, ClassNotFoundException;
}
