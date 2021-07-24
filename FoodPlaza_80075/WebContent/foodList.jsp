<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="in.sqaud.foodplaza.pojo.Food"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FOOD List</title>
</head>
<body>
	<div id="templatemo_container">
		<jsp:include page="header.jsp"></jsp:include>
	
	
	<%  //add food to cart and search food 
		List<Food> flist = (List<Food>) request.getAttribute("foodlist");
	   String addToCartSuccess=(String)request.getAttribute("addToCartSuccess");
	   String addToCartFail=(String)request.getAttribute("addToCartFail");
	   
	%>
	  <% 
	  String adminEmail=(String)session.getAttribute("adminEmail");
    String custEmail=(String)session.getAttribute("custEmail");
    %>
	<center>
		<h1 style="color: Grey">
		<% if(addToCartSuccess!=null){
			out.print(addToCartSuccess);
			}
		 if(addToCartFail!=null){
				out.print(addToCartFail);
			}
		
		 //menu not available
		 if(flist.isEmpty()){
			out.print("Menu not available!!");
		}
		else{
		%>
		
		<br>
			<I>FOOD List </I>
		</h1>
		<hr width="400px">
		<form action="#">
			<table style="background-color: Pink" border="1">
				<tr>
					<th><h3>Sr.No</h3></th>
					<th><h3>Food Name</h3></th>
					<th><h3>Food Category</h3></th>
					<th><h3>Food Price</h3></th>
                    <%if(adminEmail!=null && custEmail==null){ %>
                    <th><h3>Edit</h3></th>
                    <th><h3>Delete</h3></th>
                     <%} %>  
                      <%if(adminEmail==null && custEmail!=null){ %>
                    <th><h3>Add To Cart</h3></th>
                     <%} %> 
				</tr>

				<% int i=0;
					for (Food f : flist) {
				%>
				<tr>
					<td><%=++i%></td>
					<td><%=f.getFood_name()%></td>
					<td><%=f.getFood_category()%></td>
					<td><%=f.getFood_price()%></td>
					    <%if(adminEmail!=null && custEmail==null){ %>
					<td><a href="CommonFoodServlet?foodid=<%=f.getFood_id()%>&action=edit">edit</a></td>
					<td><a href="CommonFoodServlet?foodid=<%=f.getFood_id()%>&action=delete">delete</a></td>
					 <%} %>  
                      <%if(adminEmail==null && custEmail!=null){ %>
					<td><a href="CartServlet?foodid=<%=f.getFood_id()%>&action=addtocart">add to cart</a></td>
					 <%} %> 
				</tr>
				<%
					}
		}
				%>
			</table>
		</form>




	</center>
		<jsp:include page="footer.jsp"></jsp:include>
		<!-- end of footer -->
	</div>

	

</body>
</html>