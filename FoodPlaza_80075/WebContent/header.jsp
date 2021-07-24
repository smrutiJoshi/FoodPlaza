<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>

	<div id="templatemo_header">
    	<div id="site_title"></div>
    </div> <!-- end of header -->
    <% String adminEmail=(String)session.getAttribute("adminEmail");
    String custEmail=(String)session.getAttribute("custEmail");
    %>
    
    <!--displaying menu bar depend on user type= No user/Customer/Admin  -->
    <div id="templatemo_menu">
        <ul>
        	<li><a href="index.jsp"><b>Home</b></a></li>
            <li><a href="CommonFoodServlet"><b>Food Menu</b></a></li>
            <li><a href="Search.jsp"><b>Search</b></a></li>
            
            <%if(adminEmail==null && custEmail==null){ %>
            <li><a href="registration.jsp"><b>Register</b></a></li>
             <li ><a href="login.jsp"><b>Login</b></a></li>
              <li><a href="contact.jsp"><b>Contact Us</b></a></li>
         
        <%} %>
        
         <%if(adminEmail!=null && custEmail==null){ %>
      		  <li><a href="CommonCustomerServices"><b>Show Customer</b></a></li>
            <li><a href="addFood.jsp"><b>Add Food</b></a></li>
          <li><a href="CommonOrderServlet"><b>Show Orders</b></a></li>
                <li ><a href="FeedbackServlet"><b>Feedback</b></a></li>   
         <%} %>   
            
            <%if(adminEmail==null && custEmail!=null){ %>
            <li ><a href="CommonCustomerServices?action=edit&emailId=<%=custEmail%>"><b>Edit Profile</b></a></li>
            <li ><a href="CartServlet"><b>Show Cart</b></a></li>
                 <li ><a href="feedbackForm.jsp"><b>Feedback</b></a></li>
                   <li><a href="CommonOrderServlet?action=showMyOrders"><b>Show Orders</b></a></li>
          
           <%} %> 
            <%if(adminEmail!=null|| custEmail!=null){ %>  
     
            <li ><a href="CommonLoginServlet"><b>Logout</b></a></li>
   
            <%} %>   
        </ul>
    </div> <!-- end of menu -->
  

</body>
</html>