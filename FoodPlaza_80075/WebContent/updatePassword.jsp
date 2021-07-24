<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Password Update</title>
</head>
<body>
	<div id="templatemo_container">
		<jsp:include page="header.jsp"></jsp:include>
<center>
		<h1 style="color: Grey">
			<I>Password Update</I>
		</h1>
		<hr width="400px">
		<form action="#" method=Post onsubmit="return checkForm()">
			<table style="background-color: Pink">
			
					<tr>
					<th>Email Id:</th>
					<td><input type="text" id="email" value="g23@gmail.com" name="email"readonly="readonly"></td>
				</tr>
				<tr>
					<th>Current Password:</th>
					<td><input type="password" id="cpassword"value="g@12345678G" name="cpassword" ></td>
				</tr>
				<tr>
					<th>Enter New Password:</th>
					<td><input type="password" id="npswd" name="npswd" ></td>
					<td><span id="npasswordError"></span></td>
				</tr>
				<tr>
					<th>Confirm Password:</th>
					<td><input type="password" id="confpswd" name="confpswd" placeholder="enter new password again" ></td>
				<td><span id="passwordError"></span></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Confirm"></td>
				</tr>
				</table>
				</form>
				</center>
					<jsp:include page="footer.jsp"></jsp:include>
		<!-- end of footer -->
	</div>

				
</body>
</html>