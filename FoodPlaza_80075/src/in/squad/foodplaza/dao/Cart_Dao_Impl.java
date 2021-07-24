package in.squad.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.sqaud.foodplaza.pojo.Cart;
import in.squad.foodplaza.dbUtil.DbUtil;



public class Cart_Dao_Impl implements Cart_Dao {
	 Connection con;
     PreparedStatement pstat;
     int flag;
     ResultSet rs;
	public boolean AddToCart(Cart cart) throws ClassNotFoundException, SQLException {
		
		     con=DbUtil.getCon();
		     pstat=con.prepareStatement("insert into Cart_80075 (cart_id, food_id,cust_email,quantity)values(?,?,?,?)");
		    pstat.setInt(1, cart.getCart_id());
		    pstat.setInt(2, cart.getFood_id());
		    pstat.setString(3, cart.getCust_email());
		    pstat.setInt(4, cart.getQuantity());
		     flag=pstat.executeUpdate();
		     
		     if(flag!=0)
		    	 return true;
		     else
				return false;
			}
	@Override
	public Cart SearchByEmail(String email) throws ClassNotFoundException, SQLException {
		
		con=DbUtil.getCon();
		pstat=con.prepareStatement("select * from Cart_80075 where cust_email=?");
		pstat.setString(1, email);
		rs=pstat.executeQuery();
		
		
		Cart c=new Cart();
		while(rs.next()) {
			c.setCart_id(rs.getInt(1));
			c.setFood_id(rs.getInt(2));
			c.setCust_email(rs.getString(3));
			c.setQuantity(rs.getInt(4));
		}
		
		
		return c;
	}
	@Override
	public List<Cart> ShowAll() throws ClassNotFoundException, SQLException {
		
		con=DbUtil.getCon();
		pstat=con.prepareStatement("select * from Cart_80075");
		rs=pstat.executeQuery();
		
		List<Cart>li= new ArrayList();
	
		while(rs.next()) {
			Cart c=new Cart();
			c.setCart_id(rs.getInt(1));
			c.setFood_id(rs.getInt(2));
			c.setCust_email(rs.getString(3));
			c.setQuantity(rs.getInt(4));
			li.add(c);
		}
		return li;
	}
	@Override
	public boolean Delete_Cart(String email) throws ClassNotFoundException, SQLException {
		con=DbUtil.getCon();
		pstat=con.prepareStatement("Delete from Cart_80075 where cust_email=? ");
		pstat.setString(1, email);
		 flag=pstat.executeUpdate();
		 
	     if(flag!=0)
	    	 return true;
	     else
			return false;
		
	}
	@Override
	public boolean Delete_CartById(int foodId) throws ClassNotFoundException, SQLException {
		con=DbUtil.getCon();
		pstat=con.prepareStatement("Delete from Cart_80075 where food_id=? ");
		pstat.setInt(1, foodId);
 flag=pstat.executeUpdate();
		 
	     if(flag!=0)
	    	 return true;
	     else
			return false;
	}
	@Override
	public boolean DeleteFromCart(int cartId) throws ClassNotFoundException, SQLException {
		con=DbUtil.getCon();
		pstat=con.prepareStatement("Delete from Cart_80075 where cart_id=? ");
		pstat.setInt(1, cartId);
 flag=pstat.executeUpdate();
		 
	     if(flag!=0)
	    	 return true;
	     else
			return false;
	}
	@Override
	public boolean ClearCart() throws ClassNotFoundException, SQLException {
		con=DbUtil.getCon();
		pstat=con.prepareStatement("Delete from Cart_80075");
		
 flag=pstat.executeUpdate();
		 
	     if(flag!=0)
	    	 return true;
	     else
			return false;
	}
	@Override
	public List<Cart> ShowMyCart(String email) throws ClassNotFoundException, SQLException {

		con = DbUtil.getCon();
		String query = "select f.food_id, f.food_name,f.food_price, c.cart_id, c.food_id, c.cust_email, c.quantity from Food_80075 f inner join Cart_80075 c on f.food_id=c.food_id and cust_email=?";
		pstat = con.prepareStatement(query);
		pstat.setString(1, email);
		rs = pstat.executeQuery();

		List<Cart> cartlist = new ArrayList();

		while (rs.next()) {
			Cart cart = new Cart();

			cart.setCart_id(rs.getInt("cart_id"));
			cart.setFood_id(rs.getInt("food_id"));
			cart.setCust_email(rs.getString("cust_email"));
			cart.setQuantity(rs.getInt("quantity"));
			cart.setFood_name(rs.getString("food_name"));
			cart.setFood_price(rs.getInt("food_price"));
			cartlist.add(cart);

		}
		return cartlist;
	}


}
