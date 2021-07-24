package in.squad.foodplaza.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.sqaud.foodplaza.pojo.Order;
import in.squad.foodplaza.dao.Order_Dao_Impl;

/**
 * Servlet implementation class CommonOrderServlet
 */
@WebServlet("/CommonOrderServlet")
public class CommonOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Order_Dao_Impl orderDaoImpl = new Order_Dao_Impl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

    HttpSession session = request.getSession();
	List<Order> orderlist = new ArrayList<>();

	try {

		String operation = request.getParameter("action");

		if (operation != null && operation.equalsIgnoreCase("showMyOrders")) {
			String email = (String) session.getAttribute("custEmail");

			orderlist = orderDaoImpl.Search(email);

			request.setAttribute("orderlist", orderlist);
			RequestDispatcher rd = request.getRequestDispatcher("orderList.jsp");
			rd.forward(request, response);

		} else {
			orderlist = orderDaoImpl.viewAll();
           
			request.setAttribute("orderlist", orderlist);
			RequestDispatcher rd = request.getRequestDispatcher("orderList.jsp");
			rd.forward(request, response);
		}

	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
}


}
