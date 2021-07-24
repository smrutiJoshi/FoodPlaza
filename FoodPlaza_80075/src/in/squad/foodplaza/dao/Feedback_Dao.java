package in.squad.foodplaza.dao;

import java.sql.SQLException;
import java.util.List;

import in.sqaud.foodplaza.pojo.Feedback;

public interface Feedback_Dao {

	public List<Feedback>getAllFeedbacks() throws ClassNotFoundException, SQLException;
	public boolean setFeedback(String custEmail,String message)throws ClassNotFoundException, SQLException;
}
