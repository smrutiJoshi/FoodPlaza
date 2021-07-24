package in.squad.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.squad.foodplaza.dbUtil.DbUtil;

public class Admin_Dao_Impl implements Admin_Dao{
	Connection con = null;
	PreparedStatement pstat = null;
	ResultSet re = null;

	@Override
	public boolean adminLogin(String EmailId, String Password) throws SQLException, ClassNotFoundException {
		con = DbUtil.getCon();
		pstat = con.prepareStatement("select * from Admin_80075 where adminemail=? and adminpassword=?");
		pstat.setString(1, EmailId);
		pstat.setString(2, Password);
		re = pstat.executeQuery();
		if (re.next()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean changepassword(String OldPassword, String newPass, String AdminEmail) throws ClassNotFoundException, SQLException {
		con = DbUtil.getCon();
        pstat=con.prepareStatement("update Admin_80075 set adminpassword=? where adminemail=? and adminpassword=?");
		
		pstat.setString(1,newPass );
		pstat.setString(2,AdminEmail);
		pstat.setString(3, OldPassword);
		int res=pstat.executeUpdate();
		if(res>0)
		{
			return true;
		}
		return false;
	}

}
