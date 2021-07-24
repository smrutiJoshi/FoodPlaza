package in.squad.foodplaza.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.sqaud.foodplaza.pojo.Cart;
import in.squad.foodplaza.dao.Cart_Dao_Impl;
import in.squad.foodplaza.dao.Order_Dao_Impl;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CommonCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Cart_Dao_Impl cartDaoImpl = new Cart_Dao_Impl();
	Order_Dao_Impl orderDaoImpl = new Order_Dao_Impl();
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		HttpSession session = request.getSession();
       
   		try {	String operation=request.getParameter("action");
       if(operation!=null && operation.equalsIgnoreCase("addtocart")){
    	   int foodId=Integer.parseInt(request.getParameter("foodid"));
    	   Cart cart=new Cart();
    	   cart.setFood_id(foodId);
    	   cart.setCust_email((String)session.getAttribute("custEmail"));
    	   cart.setQuantity(1);
    	   
			boolean isAdded=cartDaoImpl.AddToCart(cart);
			if(isAdded){
				request.setAttribute("addToCartSuccess", "Added to cart Successfully!!");
				RequestDispatcher rd=request.getRequestDispatcher("CommonFoodServlet");
				rd.forward(request, response);
			}
			else{
				request.setAttribute("addToCartFail", "Added to cart Failed!!");
				RequestDispatcher rd=request.getRequestDispatcher("CommonFoodServlet");
				rd.forward(request, response);
				
			}
		} 
       else  if(operation!=null && operation.equalsIgnoreCase("deleteFromCart")){
    	  int cartId=Integer.parseInt(request.getParameter("cartId"));
    	  boolean isDeleted=cartDaoImpl.DeleteFromCart(cartId);
    	  
    	   if(isDeleted){
    		   response.sendRedirect("CartServlet");
    	   }
    	   else{
    		   response.sendRedirect("CartServlet");
    	   }
		
		} 
       
       else{
			List<Cart>cartlist=cartDaoImpl.ShowMyCart((String)session.getAttribute("custEmail"));
			request.setAttribute("cartlist", cartlist);
			RequestDispatcher rd=request.getRequestDispatcher("cartList.jsp");
			rd.forward(request, response);
		}
       }
   		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       }


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
				  try {
   String operation=request.getParameter("action");
   double totalBill=0.0;
   String email=(String)session.getAttribute("custEmail");
   if(operation!=null && operation.equalsIgnoreCase("placeorder")){
   
	   String []foodPrice=request.getParameterValues("fprice");
      
       String []foodQuantity=request.getParameterValues("fqty");
     
       for(int i=0; i<foodPrice.length; i++){
    	   totalBill+=Integer.parseInt(foodPrice[i])*Integer.parseInt(foodQuantity[i]);
       }
    // System.out.println("total bill="+totalBill);
		int orderId=orderDaoImpl.placeOrder(totalBill, email);
		
		if(orderId>0){
			boolean isCleared=cartDaoImpl.Delete_Cart(email);
			if(isCleared){
				request.setAttribute("placeOrderSuccess", "Order has been placed successfully!! Your orderId="+orderId+" and total bill=" +totalBill);
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			else{
				
				request.setAttribute("placeOrderFailure", "Order placement Failed!!");
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		}
		
		
	}
		  }catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
		
	}

