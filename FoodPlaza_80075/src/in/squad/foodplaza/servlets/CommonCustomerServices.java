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

import in.sqaud.foodplaza.pojo.Customer;
import in.sqaud.foodplaza.pojo.Food;
import in.squad.foodplaza.dao.Customer_Dao_Impl;

@WebServlet("/CommonCustomerServices")
public class CommonCustomerServices extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Customer customer = new Customer();
	Customer_Dao_Impl custDaoImpl = new Customer_Dao_Impl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String operation = request.getParameter("action");

		try {
			if (operation != null && operation.equalsIgnoreCase("edit")) {
				String emailId = request.getParameter("emailId");
				Customer customer = custDaoImpl.Search_Customer(emailId);

				request.setAttribute("custDetails", customer);
				RequestDispatcher rd = request.getRequestDispatcher("updateCustomer.jsp");
				rd.forward(request, response);

			} else {
				List<Customer> custlist = custDaoImpl.ViewAll_CustomerList();
				request.setAttribute("custlist", custlist);
				RequestDispatcher rd = request.getRequestDispatcher("customerList.jsp");
				rd.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String operation = request.getParameter("action");

			if (operation != null && operation.equalsIgnoreCase("registerCustomer")) {

				String customername = request.getParameter("cname");
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				String address = request.getParameter("address");
				String contact = request.getParameter("contact");

				customer.setCustname(customername);
				customer.setCustemail(email);
				customer.setCustpassword(password);
				customer.setCustadd(address);
				customer.setCustcontact(contact);

				boolean isCustAdded = custDaoImpl.Register_Customer(customer);
				if (isCustAdded) {
					request.setAttribute("RegistrationSuccess", "Registration Successfull!! Please Login");
					RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					rd.forward(request, response);

					// response.sendRedirect("CommonCustomerServices?action=null");
				} else {

					request.setAttribute("RegistrationFail", "Registration failed!! Please reenter credentials");
					RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
					rd.forward(request, response);
					// response.sendRedirect("CommonCustomerServices?action=null");
					// response.sendRedirect("fail.jsp");
				}
			}
			 else if(operation!=null&&operation.equalsIgnoreCase("UpdateCustomer")){
		    
				
				 String customername = request.getParameter("user");
					String email = request.getParameter("email");
				
					String address = request.getParameter("address");
					String contact = request.getParameter("contact");
		    		
					customer.setCustname(customername);
					customer.setCustemail(email);
			
					customer.setCustadd(address);
					customer.setCustcontact(contact);
		    		   boolean isUpdate=custDaoImpl.Update_Customer(customer, email);
					
		    		   if(isUpdate){
		    				request.setAttribute("UpdateCustomer",  customername+": Your Updation is Successfull!!");
							RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
							rd.forward(request, response);
		    		    	
						}
		    		   else{
		    				request.setAttribute("UpdateCustomer",  customername+": Your Updation Failed!!");
							RequestDispatcher rd= request.getRequestDispatcher("updateCustomer.jsp");
							rd.forward(request, response);
		    		   }
			 }	

			else {

				List<Customer> custl = custDaoImpl.ViewAll_CustomerList();
				request.setAttribute("custlist", custl);

				RequestDispatcher rds = request.getRequestDispatcher("customerList.jsp");
				rds.forward(request, response);

			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
