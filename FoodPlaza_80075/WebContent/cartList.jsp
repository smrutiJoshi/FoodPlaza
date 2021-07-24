<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="in.sqaud.foodplaza.pojo.Cart"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cart</title>
</head>
<body>
	<div id="templatemo_container">
		<jsp:include page="header.jsp"></jsp:include>
	<center>
	<%List<Cart> cartList = (List<Cart>) request.getAttribute("cartlist");
	
	%>
		<h2 style="color: blue">
				<%
					if (cartList.isEmpty()) {
						out.print("Cart is empty!");
					} else {
				%>
			</h2>
			
		<h1 style="color: Grey">
			<I>Cart List </I>
		</h1>
		<hr width="400px">
		<form action="CartServlet" method=Post>
			<input type="hidden" name="action" value="placeorder">
			<table style="background-color: Pink" border="1">
				<tr>
					<th><h3>Sr.No:</h3></th>
					<th><h3>Food Name:</h3></th>
					<th><h3>Quantity:</h3></th>
					<th><h3>Price:</h3></th>

				</tr>
	<%
						int i = 0;
							for (Cart cart : cartList) {
					%>
				<tr>
						<td><%=++i%></td>
						<td><%=cart.getFood_name()%></td>
						<td><%=cart.getFood_price()%></td>
						<td><input type="hidden" name="fprice" value="<%=cart.getFood_price()%>">
						<td><input type="number" name="fqty" value="<%=cart.getQuantity()%>"></td>
						<td><a
							href="CartServlet?action=deleteFromCart&cartId=<%=cart.getCart_id()%>">delete</a></td>
					</tr>

					<%
						}
					%>

			</table>
			<input type="submit" value="Place Order">
		</form>
		<%
				}
			%>
	</center>



	<jsp:include page="footer.jsp"></jsp:include>
		<!-- end of footer -->
	</div>




</body>
</html>