<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="in.sqaud.foodplaza.pojo.Order" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order List</title>
</head>
<body>
	<div id="templatemo_container">
		<jsp:include page="header.jsp"></jsp:include>
		<center>
			<%
				List<Order> orderlist = (List<Order>)request.getAttribute("orderlist");
		   out.print(orderlist);
			%>
			<h1 style="color: Grey">
				<I>Order List </I>
			</h1>
			<hr width="400px">
			<form action="#" method=Post>
				<table style="background-color: Pink" border="1">
					<tr>
						<th><h3>Sr.No:</h3></th>
						<th><h3>Email:</h3></th>
						<th><h3>Total Bill:</h3></th>
						<th><h3>Order Date:</h3></th>
					</tr>
					<%
					int i = 0;
						for (Order order : orderlist) {
				%>
				<tr>
					<td><%=i++%></td>
					<td><%=order.getCust_email()%></td>
					<td><%=order.getTotal_bill()%></td>
					<td><%=order.getOrder_date()%></td>
				</tr>
				<%
					}
				%>
				</table>
			</form>
		</center>
		<jsp:include page="footer.jsp"></jsp:include>
		<!-- end of footer -->
	</div>


</body>
</html>