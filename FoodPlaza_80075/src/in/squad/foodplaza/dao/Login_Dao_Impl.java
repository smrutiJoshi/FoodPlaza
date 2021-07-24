package in.squad.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.squad.foodplaza.dbUtil.DbUtil;

public class Login_Dao_Impl implements Login_Dao {

	Connection con;
	PreparedStatement pstat;
	ResultSet rs;
	
	@Override
	public boolean userLogin(String userName, String userPassword, String userType) throws ClassNotFoundException, SQLException {
		
  con=DbUtil.getCon();
	
  if(userType.equalsIgnoreCase("admin")){
	  pstat=con.prepareStatement("select adminemail,adminpassword  from Admin_80075 where adminemail=? and adminpassword=? ");
  }
  if(userType.equalsIgnoreCase("customer")){
	  pstat=con.prepareStatement("select cust_email,cust_password  from Customer_80075 where cust_email=? and cust_password=? ");
  }
  pstat.setString(1, userName);
  pstat.setString(2, userPassword);
  rs=pstat.executeQuery();
  if(rs.next())
	  return true;
  else
  
  return false;
	}

}
