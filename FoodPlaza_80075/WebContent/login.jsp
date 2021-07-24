<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<script type="text/javascript" src="validation.js"></script>
</head>
<body>
	<%String RegistrationSuccess=(String)request.getAttribute("RegistrationSuccess");
	
	%>
	
	<div id="templatemo_container">
		<jsp:include page="header.jsp"></jsp:include>
	<center>
	

		<h1 style="color: Grey">
			<I>LOGIN</I>
			<% if(RegistrationSuccess!=null) {
			  out.print(RegistrationSuccess);
			}
	%>
		</h1>
		<hr width="400px">
		<form action="CommonLoginServlet" method=Post onsubmit="return validateLogin()">  
			<table style="background-color: Pink">

				<tr>
					<th>User Type:</th>
					<td><select id="user" name="user" oninput="HideLogin()">
							<option value="0">Select User</option>
							<option value="admin">Admin</option>
							<option value="customer">Customer</option>

					</select></td>
					<td><span id="userError"></span></td>
				</tr>
				<tr>
					<th>User Name:</th>
					<td><input type="text" name="cname" id="cname" oninput="HideLogin()"></td>
					<td><span id="cnameError"></span></td>
				</tr>
				<tr>
					<th>Password:</th>
					<td><input type="password" id="password" name="password" oninput="HideLogin()"></td>
					<td><span id="passwordError"></span></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Login"></td>
				</tr>
			</table>
		</form>
	</center>
		<jsp:include page="footer.jsp"></jsp:include>
		<!-- end of footer -->
	</div>

	
</body>
</html>