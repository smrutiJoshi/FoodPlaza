package in.squad.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import in.sqaud.foodplaza.pojo.Order;
import in.squad.foodplaza.dbUtil.DbUtil;

public class Order_Dao_Impl implements Order_Dao {
	  Connection con;
	     PreparedStatement pstat;
	     int flag;
	     ResultSet rs;
	@Override
	public boolean OrderByEmail(String email) throws ClassNotFoundException, SQLException {
		con=DbUtil.getCon();
		
	
		
      String date=new Date().toString();
      pstat=con.prepareStatement("select sum(Cart_80075.quantity*Food_80075.food_price) as temp from Cart_80075, Food_80075 where Cart_80075.food_id=Food_80075.food_id and cust_email=?");
      pstat.setString(1, email);
      rs=pstat.executeQuery();
      
      while(rs.next()) {
    	  double total_bill=rs.getDouble("temp");
    	  pstat=con.prepareStatement("insert into Order_80075r(cust_email, total_bill,Order_date)values(?,?,?)");
    	  pstat.setString(1, email);
    	  pstat.setDouble(2, total_bill);
    	  pstat.setString(3, date);
    	  flag=pstat.executeUpdate();
      }
   
        if(flag!=0)
        	return true;
        else 
        	return false;
      }
	@Override
	public List<Order> viewAll() throws ClassNotFoundException, SQLException {
		con=DbUtil.getCon();
		pstat=con.prepareStatement("Select * from Orderr_80075");
		rs=pstat.executeQuery();
		   List<Order>li=new ArrayList();
		   while(rs.next()) {
				Order o= new Order();
				o.setOrder_id(rs.getInt(1));
				o.setCust_email(rs.getString(2));
				o.setTotal_bill(rs.getDouble(3));
				o.setOrder_date(rs.getString(4));
				li.add(o);
		   }
		   return li;

	}
	@Override
	public Order searchByEmail(String email) throws ClassNotFoundException, SQLException {
		con=DbUtil.getCon();
		pstat=con.prepareStatement("select * from Orderr_80075 where cust_email=?");
		pstat.setString(1, email);
		 rs=pstat.executeQuery();
			Order o= new Order();
		 while(rs.next()) {
		
				o.setOrder_id(rs.getInt(1));
				o.setCust_email(rs.getString(2));
				o.setTotal_bill(rs.getDouble(3));
				o.setOrder_date(rs.getString(4));
			}
		return o;
	}
	@Override
	public int placeOrder(double totalBill,String email) throws ClassNotFoundException, SQLException {
		con=DbUtil.getCon();
	    String date=new Date().toString();
		pstat=con.prepareStatement("insert into Orderr_80075 (cust_email,total_bill,Order_date)values(?,?,?)");
		pstat.setString(1, email);
		pstat.setDouble(2, totalBill);
		pstat.setString(3, date);
	//	 rs=pstat.executeQuery();
			
		 int orderId=0;
		 int isPlaced=pstat.executeUpdate();
		if(isPlaced>0) {
		  pstat=con.prepareStatement("select Order_id from  Orderr_80075 where cust_email=? and Order_date=?");
		  pstat.setString(1, email);
		  pstat.setString(2, date);
		  ResultSet rs=pstat.executeQuery();
		  if(rs.next()){
			  orderId=rs.getInt("Order_id");
		  }
			}
		return orderId;
	}
	@Override
	public List<Order> Search(String email)throws ClassNotFoundException, SQLException {
	
		List<Order> orderlist=new ArrayList();
		con=DbUtil.getCon();
		pstat=con.prepareStatement("select * from Orderr_80075 where cust_email=? ");
		pstat.setString(1, email);
		rs=pstat.executeQuery();
		
		
		while(rs.next()){
			Order order= new Order();
			order.setOrder_id(rs.getInt(1));
			order.setCust_email(rs.getString(2));
			order.setTotal_bill(rs.getDouble(3));
			order.setOrder_date(rs.getString(4));
			orderlist.add(order);
		}
		return orderlist;
	}
   
		
        
		
	}


