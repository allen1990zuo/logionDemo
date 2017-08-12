<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@page import="com.demo.Vo.User" %>
<%@page import="java.util.List"%>  
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>

    <table >  
    	<th>Register</th>
<form action="<%=basePath%>servlet/User" method="post" id='form'>  
<input type="hidden" name="action" value="addUser"/>      
        <tr>  
            <td>username:</td>
            <td><input id="username" type="text" name="username"></td>  
        </tr>  
  
        <tr>  
           <td>userpassword:</td>
            <td><input id='password' type="text" name="password"></td>  
        </tr>  
 </form>  
       
        <tr>  
           
            <td><input type="button" value="submit" onclick="submit()"> </td>
        </tr>  
    </table>  
 
<script>
  function submit(){
	  var username=document.getElementById('username').value
	  var password=document.getElementById('password').value
	  var regUsername=/^[A-Za-z0-9]{5,}$/
	  var regPassword=/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[A-Za-z0-9]{8,}/
	  if(regUsername.test(username)){
		 
			  if(regPassword.test(password)){
					document.getElementById('form').submit()
				}
				else{
					alert('The password has a minimum length of 8 characters and contains at least 1 number, 1 uppercase, and 1 lowercase character!')
				}
		 	
	  }
	  else{
		  alert("The username field accepts alpha-numeric values only and The username length is no less than 5 characters! ")
	  }
	  
  }

</script>
</body>
</html>