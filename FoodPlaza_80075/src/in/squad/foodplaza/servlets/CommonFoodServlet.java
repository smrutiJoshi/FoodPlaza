package in.squad.foodplaza.servlets;



import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.sqaud.foodplaza.pojo.Food;
import in.squad.foodplaza.dao.Food_Dao_Impl;


@WebServlet("/CommonFoodServlet")
public class CommonFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  Food food=new Food();
  Food_Dao_Impl foodDaoImpl=new Food_Dao_Impl();

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			
			String operation=request.getParameter("action");
		
			if(operation!=null&&operation.equalsIgnoreCase("edit")){
				int foodid=Integer.parseInt(request.getParameter("foodid"));
				
				food=foodDaoImpl.SearchById(foodid);
				request.setAttribute("food", food);
				RequestDispatcher rd= request.getRequestDispatcher("updateFood.jsp");
				rd.forward(request, response);
			}
			else if(operation!=null&& operation.equalsIgnoreCase("delete")){
				int foodid=Integer.parseInt(request.getParameter("foodid"));
				boolean isDeleted=foodDaoImpl.Delete_food(foodid);
				if(isDeleted){
					response.sendRedirect("CommonFoodServlet?action=null");
				}else{
					response.sendRedirect("CommonFoodServlet?action=null");
				}
			} else if (operation != null && operation.equalsIgnoreCase("searchFood")) {

				String foodName = request.getParameter("foodName");
				List<Food> foodlist = foodDaoImpl.searchFood(foodName);

				request.setAttribute("foodlist", foodlist);
				RequestDispatcher rd = request.getRequestDispatcher("foodList.jsp");
				rd.forward(request, response);
			}

			
			else{
			
			List<Food>foodlist=foodDaoImpl.getAllFood();
			request.setAttribute("foodlist", foodlist);
			RequestDispatcher rd= request.getRequestDispatcher("foodList.jsp");
			rd.forward(request, response);
			}		
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	    try {
	    	String operation=request.getParameter("action");
	    	
	    	
	    	if(operation!=null&&operation.equalsIgnoreCase("AddFood")){
	    		
	    		  String foodCatergory=request.getParameter("fcategory");
	    		    String foodName=request.getParameter("fname");
	    		    int foodPrice=Integer.parseInt(request.getParameter("fprice"));
	    		    
	    		    
	    		  
	    		    food.setFood_category(foodCatergory);
	    		    food.setFood_name(foodName);
	    		    food.setFood_price(foodPrice);
	    		  
	    		boolean isAdded=foodDaoImpl.Add_food(food);
				
				if(isAdded){
				
					request.setAttribute("AddFoodSuccess",  foodName+": Added Successfully!!");
					RequestDispatcher rd= request.getRequestDispatcher("addFood.jsp");
					rd.forward(request, response);
				}
				else{
					request.setAttribute("AddFoodFail",  foodName+": addition  failed!!");
					RequestDispatcher rd= request.getRequestDispatcher("addFood.jsp");
					rd.forward(request, response);
				}
	    	} else if(operation!=null&&operation.equalsIgnoreCase("UpdateFood")){
	    		
	    		int foodid=Integer.parseInt(request.getParameter("fid"));
	    		  String foodCatergory=request.getParameter("fcategory");
	    		    String foodName=request.getParameter("fname");
	    		    int foodPrice=Integer.parseInt(request.getParameter("fprice"));
	    		 
	    		    food.setFood_id(foodid);
	    		    food.setFood_category(foodCatergory);
	    		    food.setFood_name(foodName);
	    		    food.setFood_price(foodPrice);
	    		    boolean isUpdated=foodDaoImpl.Update_food(food, foodid);
	    		   
	    		    if(isUpdated){
	    		    	//response.sendRedirect("success.jsp");
					
	    		    	response.sendRedirect("CommonFoodServlet?action=null");
					}
					else{
						response.sendRedirect("CommonFoodServlet?action=null");
						//response.sendRedirect("fail.jsp");
					}   
	    	}
	    	else{
	    		List<Food>foodlist=foodDaoImpl.getAllFood();
				request.setAttribute("foodlist", foodlist);
				RequestDispatcher rd= request.getRequestDispatcher("foodList.jsp");
				rd.forward(request, response);
	    		
	    	}
		
			
		} catch (ClassNotFoundException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}
	}

}
