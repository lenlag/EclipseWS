<%@page import="business.entity.Animal"%>
<%@page import="java.util.ArrayList"%>
<%@page import="business.entity.Person"%>
<%@page import="service.ServiceDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Process</title>
</head>
<body>
	<%
		
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String age = request.getParameter("age");
		ServiceDao service = new ServiceDao();
		Person p1 = new Person(lastName, firstName, Integer.valueOf(age), 0, new ArrayList<Animal>());
		service.createPerson(p1);

		response.sendRedirect("index.jsp"); //rediriger vers la page initiale
	%>
</body>
</html>