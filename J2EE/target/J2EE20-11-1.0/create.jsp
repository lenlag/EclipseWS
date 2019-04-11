<%@page import="persistence.dao.PersonDao"%>
<%@page import="business.entity.Person"%>
<%@page import="service.ServiceDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create/Update person</title>
</head>
<body>
	<form action="process.jsp">
		<label for="lastName"> Last Name 
		<input type="text" name="lastName" id="age" placeholder="Enter last name here" value="" />
		</label> 
		<br />
		<label for="firstName"> First Name 
		<input type="text" name="firstName" id="age" placeholder="Enter first name here" value="" />
		</label> 
		<br /> 
		<label for="age"> Age 
		<input type="text" name="age" id="age" placeholder="Enter age here" value="" />
		</label> 
		<br /> 
		<br /> 
		<input type="submit" value="Submit"/>
		
	</form>

		
	
</body>
</html>