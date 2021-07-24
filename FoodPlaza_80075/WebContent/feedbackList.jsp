<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="in.sqaud.foodplaza.pojo.Feedback"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FEEDBACK LIST</title>
</head>
<body>
<div id="templatemo_container">
		<jsp:include page="header.jsp"></jsp:include>
		<center>

			<%
				List<Feedback> feedbacklist = (List<Feedback>) request.getAttribute("feedbacklist");
		
			%>
			<h2 style="color: blue">
				<%
					if (feedbacklist.isEmpty()) {
						out.print("No feedbacks to display!");
					} else {
				%>
			</h2>
			<br>
			<h1 style="color: Grey">
			FEEDBACK LIST</h1>
			<table style="background-color: Pink" border="1">
				<tr>
					<th>Sr.No.</th>
					<th>Email</th>
					<th>Message</th>
				</tr>
				<%
					for (Feedback feedback : feedbacklist) {
				%>

				<tr>
					<td><%=feedback.getFid()%></td>
					<td><%=feedback.getCustomerEmail()%></td>
					<td><%=feedback.getMessage()%></td>
				</tr>
				<%
					}
				%>
			</table>
			<%
				}
			%>
		</center>
			<jsp:include page="footer.jsp"></jsp:include>
		<!-- end of footer -->
	</div>
</body>
</html>
