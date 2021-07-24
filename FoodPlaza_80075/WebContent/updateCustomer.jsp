<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="in.sqaud.foodplaza.pojo.Customer"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update form</title>
</head>
<body>
	<%
		Customer cust = (Customer) request.getAttribute("custDetails");
		//out.print(cust);
	%>
	<div id="templatemo_container">
		<jsp:include page="header.jsp"></jsp:include>
		<center>
			<h1 style="color: Grey">
				<I>Profile Update</I>
			</h1>
			<hr width="400px">
			<form action="CommonCustomerServices" method="Post">
				<input type=hidden name=action value="UpdateCustomer">
				<table style="background-color: Pink">

					<tr>
						<th>Name:</th>
						<td><input type="text" name="user" value="<%=cust.getCustname() %>"></td>
					</tr>
					<tr>
						<th>Email Id:</th>
						<td><input type="text" name="email"value="<%=cust.getCustemail() %>"readonly="readonly"></td>
					</tr>


					<tr>
						<th>Address:</th>
						<td><input type="text" name="address"value="<%=cust.getCustadd() %>"></td>
					</tr>
					<tr>
						<th>Contact No:</th>
						<td><input type="text" name="contact"value="<%=cust.getCustcontact() %>"></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Update"></td>
					</tr>
				</table>
			</form>
		</center>
		<jsp:include page="footer.jsp"></jsp:include>
		<!-- end of footer -->
	</div>


</body>
</html>