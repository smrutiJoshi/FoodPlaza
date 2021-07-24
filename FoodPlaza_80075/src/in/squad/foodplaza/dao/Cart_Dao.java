package in.squad.foodplaza.dao;

import java.sql.SQLException;
import java.util.List;

import in.sqaud.foodplaza.pojo.Cart;

public interface Cart_Dao {
	
	public boolean AddToCart(Cart cart) throws ClassNotFoundException, SQLException;
	public Cart SearchByEmail(String email) throws ClassNotFoundException, SQLException;
	public List<Cart>ShowAll()throws ClassNotFoundException, SQLException;
	public List<Cart>ShowMyCart(String email)throws ClassNotFoundException, SQLException;
	public boolean Delete_Cart(String x)throws ClassNotFoundException, SQLException;
	public boolean Delete_CartById(int foodId)throws ClassNotFoundException, SQLException;
	public boolean ClearCart()throws ClassNotFoundException, SQLException;
	boolean DeleteFromCart(int cartId) throws ClassNotFoundException, SQLException;
}
