package in.squad.foodplaza.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import in.sqaud.foodplaza.pojo.Customer;

public interface Customer_Dao {

	public boolean Register_Customer(Customer cust) throws ClassNotFoundException, SQLException;
	public boolean Update_Customer(Customer cust, String x) throws ClassNotFoundException, SQLException;
	public void ViewAll_Customer()throws ClassNotFoundException, SQLException;
	public boolean Delete_Customer(String x)throws ClassNotFoundException, SQLException;
	public Customer Search_Customer( String x)throws ClassNotFoundException, SQLException;
	public List<Customer> ViewAll_CustomerList()throws ClassNotFoundException, SQLException;

}
