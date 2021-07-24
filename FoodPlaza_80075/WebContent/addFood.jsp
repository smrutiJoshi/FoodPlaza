<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Food</title>
<script type="text/javascript" src="validation.js"></script>
</head>
<body>
	<%
		String AddFoodSuccess = (String) request.getAttribute("AddFoodSuccess");
		String AddFoodFail = (String) request.getAttribute("AddFoodFail");
	%>
	<div id="templatemo_container">
		<jsp:include page="header.jsp"></jsp:include>
		<center>
			<h1 style="color: Grey">
				<%
					if (AddFoodSuccess != null) {
						out.print(AddFoodSuccess);
					}
					if (AddFoodFail != null) {
						out.print(AddFoodFail);
					}
				%>
				<I>FOOD REGISTRATION</I>
			</h1>
			<hr width="400px">
			<form action="CommonFoodServlet" method="Post"
				onsubmit="return validateAddFood()">
				<input type="hidden" name="action" value="AddFood">
				<table style="background-color: Pink">
					<tr>
						<th><h3>Food Category:</h3></th>
						<td><select id="Food_Category" name="fcategory"
							oninput="HideMsg()">
								<option value="0">Select Category</option>
								<option value="veg">Veg</option>
								<option value="nonveg">Non-Veg</option>

						</select></td>
						<td><span id="Food_CategoryError"></span></td>
					</tr>
					<tr>
						<th><h3>Food Name:</h3></th>
						<td><input type="text" name="fname" id="Food_Name"
							oninput="HideMsg()"></td>

						<td><span id="Food_NameError"></span></td>
					</tr>
					<tr>
						<th><h3>Food Price:</h3></th>
						<td><input type="text" name="fprice" id="Food_Price"
							oninput="HideMsg()" /></td>
						<td><span id="Food_PriceError"></span></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Save"></td>
					</tr>
				</table>
			</form>
		</center>
		<jsp:include page="footer.jsp"></jsp:include>
		<!-- end of footer -->
	</div>


</body>
</html>