<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="in.sqaud.foodplaza.pojo.Customer"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer list</title>
</head>
<body>
<div id="templatemo_container">
		<jsp:include page="header.jsp"></jsp:include>
	
<% List <Customer>custl=(List<Customer>)request.getAttribute("custlist"); 
  
  
%>
	<center>
		<h1 style="color: Grey">
			<I>Customer List </I>
		</h1>
		<hr width="400px">
		<form action="CommonCustomerServices" >
		
			<table style="background-color: Pink" border="1">
				<tr>
					<th><h3>Sr.No:</h3></th>
					<th><h3>Name:</h3></th>
					<th><h3>Contact:</h3></th>
					<th><h3>Email:</h3></th>
					<th><h3>Address:</h3></th>
				</tr>
				<% int i=0;
					for (Customer c : custl) {
				%>
					<tr>
					<td><%=++i%></td>
					<td><%=c.getCustname()%></td>
					<td><%=c.getCustemail()%></td>
					<td><%=c.getCustadd()%></td>
					<td><%=c.getCustcontact()%></td>
					
			
				<%
					}
				%>
					</tr>
				</table>
				</form>
				</center>
	<jsp:include page="footer.jsp"></jsp:include>
		<!-- end of footer -->
	</div>


</body>
</html>