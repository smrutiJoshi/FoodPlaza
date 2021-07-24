<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="in.sqaud.foodplaza.pojo.Food"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UPDATE FOOD</title>
</head>
<body>
<%
		Food f = (Food) request.getAttribute("food");

	%>
	<center>
		<h1 style="color: Grey">
			<I>UPDATE FOOD </I>
		</h1>
		<hr width="400px">
		<form action="CommonFoodServlet" method="Post">
			<input type="hidden" name="action" value="UpdateFood">
			<table style="background-color: Pink">
				<tr>
					<th>Food Id:</th>
					<td><input type="text" name="fid" value="<%=f.getFood_id() %>"readonly="readonly"></td>
				</tr>

				<tr>
					<th><h3>Food Category:</h3></th>
					<td><select name="fcategory" >
							<option  value=<%=f.getFood_category() %>><%=f.getFood_category() %></option>
							<!-- <option value="veg">Veg</option>
							<option value="nonveg">Non-Veg</option>
 -->
					</select></td>
				</tr>
				<tr>
					<th><h3>Food Name:</h3></th>
					<td><input type="text" name="fname" value="<%=f.getFood_name() %>"></td>
				</tr>
				<tr>
					<th><h3>Food Price:</h3></th>
					<td><input type="text" name="fprice" value="<%=f.getFood_price() %>"></td>
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