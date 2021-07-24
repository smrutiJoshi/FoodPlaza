<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="templatemo_container">

		<jsp:include page="header.jsp"></jsp:include>
		<center>
		<br>
		<form action="CommonFoodServlet" method="GET">
		<input type="hidden" name="action" value="searchFood">
		<input type="text" name="foodName">
		<input type="submit" name="search" value="Search">
		</form>
	</center>
		
<jsp:include page="footer.jsp"></jsp:include>
	</div>

</body>
</html>