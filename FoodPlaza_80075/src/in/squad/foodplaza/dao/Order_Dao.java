package in.squad.foodplaza.dao;

import java.sql.SQLException;
import java.util.List;

import in.sqaud.foodplaza.pojo.Order;



public interface Order_Dao {

	public boolean OrderByEmail(String email)throws ClassNotFoundException, SQLException;

	public List<Order> viewAll()throws ClassNotFoundException, SQLException;

	public Order searchByEmail(String email)throws ClassNotFoundException, SQLException;

	int placeOrder(double totalBill, String email) throws ClassNotFoundException, SQLException;

	List<Order> Search(String email) throws ClassNotFoundException, SQLException;

}
