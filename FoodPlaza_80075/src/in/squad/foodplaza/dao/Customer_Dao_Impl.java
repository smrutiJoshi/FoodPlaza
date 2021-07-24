package in.squad.foodplaza.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import in.sqaud.foodplaza.pojo.Customer;
import in.squad.foodplaza.dbUtil.DbUtil;

public class Customer_Dao_Impl implements Customer_Dao {
	Connection con;
	PreparedStatement pstat;
	int flag;
	ResultSet rs;

	@Override
	public boolean Register_Customer(Customer cust) throws ClassNotFoundException, SQLException {
		con = DbUtil.getCon();
		pstat = con.prepareStatement(
				"insert into Customer_80075 (cust_name,cust_email,cust_add, cust_contact,cust_password) values(?,?,?,?,?)");

		pstat.setString(1, cust.getCustname());
		pstat.setString(2, cust.getCustemail());
		pstat.setString(3, cust.getCustadd());
		pstat.setString(4, cust.getCustcontact());
		pstat.setString(5, cust.getCustpassword());

		flag = pstat.executeUpdate();
		if (flag != 0)
			return true;
		else
			return false;

	}

	@Override
	public boolean Update_Customer(Customer cust, String x) throws ClassNotFoundException, SQLException {
		con = DbUtil.getCon();
		pstat = con.prepareStatement(
				"update Customer_80075 set cust_name =?,cust_add=?,cust_contact=? where cust_email=?");

		pstat.setString(1, cust.getCustname());
			pstat.setString(2, cust.getCustadd());
		pstat.setString(3, cust.getCustcontact());
	

		pstat.setString(4, x);

		flag = pstat.executeUpdate();
		if (flag != 0)
			return true;
		else
			return false;

	}

	@Override
	public void ViewAll_Customer() throws ClassNotFoundException, SQLException {
		con = DbUtil.getCon();
		pstat = con.prepareStatement("select * from Customer_80075 ");

		rs = pstat.executeQuery();

		while (rs.next()) {

			System.out.println("\ncustid=\t" + rs.getInt(1) + "\tcustname=\t" + rs.getString(2) + "\tcustemail=\t"
					+ rs.getString(3) + " \tcustadd=\t" + rs.getString(4) + " \t custcontact=\t" + rs.getString(5)
					+ " \t custpassword=\t" + rs.getString(6));

		}

	}

	@Override
	public boolean Delete_Customer(String x) throws ClassNotFoundException, SQLException {
		con = DbUtil.getCon();
		pstat = con.prepareStatement("Delete from Customer_80075 where cust_email=?");
		pstat.setString(1, x);

		flag = pstat.executeUpdate();
		if (flag != 0)
			return true;
		else
			return false;

	}

	@Override
	public Customer Search_Customer(String x) throws ClassNotFoundException, SQLException {
		con = DbUtil.getCon();
		pstat = con.prepareStatement("select * from Customer_80075 where cust_email=?");
		pstat.setString(1, x);
		rs = pstat.executeQuery();

		Customer cust = new Customer();
		while (rs.next()) {

			/*
			 * System.out.println( "\ncustid=\t"
			 * +rs.getInt(1)+"\tcustname=\t"+rs.getString(2)+ "\tcustemail=\t"
			 * +rs.getString(3)+ " \tcustadd=\t" + rs.getString(4) +
			 * " \t custcontact=\t" + rs.getString(5) + " \t custpassword=\t" +
			 * rs.getString(6) + " \tcustgender=\t" + rs.getString(7) );
			 */

			cust.setId(rs.getInt(1));
			cust.setCustname(rs.getString(2));
			cust.setCustemail(rs.getString(3));

			cust.setCustadd(rs.getString(4));
			cust.setCustcontact(rs.getString(5));
			
			cust.setCustpassword(rs.getString(6));

		}
		return cust;
	}

	@Override
	public List<Customer> ViewAll_CustomerList() throws ClassNotFoundException, SQLException {
		con = DbUtil.getCon();
		pstat = con.prepareStatement("select * from Customer_80075 ");
		rs = pstat.executeQuery();

		List<Customer> li = new ArrayList();
		while (rs.next()) {
			Customer cust = new Customer();
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String add = rs.getString(3);

			String contact = rs.getString(4);
			String email = rs.getString(5);

			String password = rs.getString(6);
			cust.setId(id);
			cust.setCustname(name);

			cust.setCustadd(add);
			cust.setCustcontact(contact);
			cust.setCustemail(email);

			cust.setCustpassword(password);
			li.add(cust);

		}
		return li;
	}

}
