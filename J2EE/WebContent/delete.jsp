<%@page import="service.ServiceDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete</title>
</head>
<body onload=>
	<%
		ServiceDao servicedao = new ServiceDao();
		String id = request.getParameter("idPerson");
		long idSupp = Long.parseLong(id);
		servicedao.deletePerson(idSupp);
		response.sendRedirect("person.jsp"); //rediriger vers la page person
	%>
</body>
</html>