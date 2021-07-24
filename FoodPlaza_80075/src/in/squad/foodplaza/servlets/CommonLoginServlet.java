package in.squad.foodplaza.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.squad.foodplaza.dao.Login_Dao_Impl;

/**
 * Servlet implementation class CommonLoginServlet
 */
@WebServlet("/CommonLoginServlet")
public class CommonLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Login_Dao_Impl loginDaoImpl = new Login_Dao_Impl();
	HttpSession session;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession();
		session.invalidate();
		response.sendRedirect("index.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userType = request.getParameter("user");
		String userName = request.getParameter("cname");
		String userPassword = request.getParameter("password");

		session = request.getSession();
		try {
			boolean isLogin = loginDaoImpl.userLogin(userName, userPassword, userType);
			if (isLogin) {
				

				if (userType.equalsIgnoreCase("admin")) {

					session.setAttribute("adminEmail", userName);
					request.setAttribute("AdminloginSuccess", "Login Successfull!! Welcome "+userName);
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
	              rd.forward(request, response);
				}
				if (userType.equalsIgnoreCase("customer")) {
					session.setAttribute("custEmail", userName);
					request.setAttribute("CustomerloginSuccess", "Login Successfull!! Welcome "+userName);
					RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		              rd.forward(request, response);
				}
			} else {
				response.sendRedirect("login.jsp");

			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
