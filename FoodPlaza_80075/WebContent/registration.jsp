<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration form</title>
<script type="text/javascript" src="validation.js"></script>
</head>
<body>
<%String RegistrationFail=(String)request.getAttribute("RegistrationFail");
	
	%>
	<div id="templatemo_container">
		<jsp:include page="header.jsp"></jsp:include>
	<center>
		<h1 style="color: Grey">
			<I>REGISTRATION</I>
				<% if(RegistrationFail!=null) {
			  out.print(RegistrationFail);
			}
			
			
			%>
		</h1>
		<hr width="400px">
		<form action="CommonCustomerServices" method="Post" onsubmit="return validateRegistration()">
			<input type=hidden name=action value="registerCustomer">
			<table style="background-color: Pink">

				<tr>
					<th>Name:</th>
					<td><input type="text" id="cname" name="cname" oninput="HideRegMsg()"></td>
						<td><span id="cnameError"></span></td>
				</tr>
				<tr>
					<th>Email Id:</th>
					<td><input type="text" id="email" name="email" oninput="HideRegMsg()"></td>
						<td><span id="emailError"></span></td>
				</tr>
				<tr>
					<th>Password:</th>
					<td><input type="password" id="password" name="password" oninput="HideRegMsg()"></td>
						<td><span id="passwordError"></span></td>
				</tr>
				
				<tr>
					<th>Address:</th>
					<td><input type="textarea" id="address" name="address" oninput="HideRegMsg()"></td>
						<td><span id="addressError"></span></td>
				</tr>
				<tr>
					<th>Contact No:</th>
					<td><input type="text" id="contact" name="contact" oninput="HideRegMsg()"></td>
						<td><span id="contactError"></span></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="register"></td>
				</tr>
			</table>
		</form>
	</center>
	<jsp:include page="footer.jsp"></jsp:include>
		<!-- end of footer -->
	</div>


</body>
</html>