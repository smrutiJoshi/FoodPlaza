package in.squad.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.sqaud.foodplaza.pojo.Feedback;
import in.squad.foodplaza.dbUtil.DbUtil;

public class Feedback_Dao_Impl implements Feedback_Dao {
    Connection con;
    PreparedStatement pstat;
    ResultSet rs;
	
	
	@Override
	public List<Feedback> getAllFeedbacks() throws ClassNotFoundException, SQLException {
		con=DbUtil.getCon();
		pstat=con.prepareStatement("select * from Feedback_80075");
		List<Feedback>feedbacklist=new ArrayList();
		rs=pstat.executeQuery();
		while(rs.next()){
			Feedback feedback= new Feedback();
			feedback.setFid(Integer.parseInt((rs.getString("feedback_id"))));
			feedback.setCustomerEmail(rs.getString("cust_email"));
			feedback.setMessage(rs.getString("message"));
			feedbacklist.add(feedback);
		}
		
		return feedbacklist;
	}

	@Override
	public boolean setFeedback(String custEmail, String message)throws ClassNotFoundException, SQLException {
		con=DbUtil.getCon();
		int flag=0;
		pstat=con.prepareStatement("insert into Feedback_80075(cust_email,message)values(?,?)");
		pstat.setString(1, custEmail);
		pstat.setString(2, message);
		
		flag=pstat.executeUpdate();
		if(flag!=0){
			return true;
		}
		else
		return false;
	}

}
