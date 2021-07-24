<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Feedback Form</title>
<script type="text/javascript" src="validation.js"></script>
</head>
<body>
	<div id="templatemo_container">
		<jsp:include page="header.jsp"></jsp:include>
	<center>
	<% String feedbackFailure=(String)request.getAttribute("feedbackFailure"); %>
		
		<h2>	<% if(feedbackFailure!=null){
					out.print(feedbackFailure);
				}
					
				%>
				</h2>
		
		<h1 style="color: Grey">
			<I>Feedback Form</I>
		</h1>
		<hr width="400px">
		<form action="FeedbackServlet" method="Post" onsubmit="return validateFeedbackForm()">
			<table style="background-color: Pink">

				<tr>
					<th>Email Id:</th>
					<td><input type="text" id="email" name="email"
						oninput="HideMsgForFeeback()"></td>
					<td><span id="emailError"></span></td>
				</tr>
				<tr>
					<th>Feedback Message:</th>

					<td><textarea id="message" name="message"
							oninput="HideMsgForFeeback()"></textarea></td>
					<td><span id="msgError"></span></td>
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