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
		
		String lastName = request.getParameter("nom");
		String firstName = request.getParameter("prenom");
		String age = request.getParameter("age");
		String cmd = request.getParameter("cmd");
		String id = request.getParameter("id");
		
		ServiceDao service = new ServiceDao();
		
		if (cmd.equals("CREATE")){
		Person p1 = new Person(lastName, firstName, Integer.valueOf(age), 0, new ArrayList<Animal>());
		service.createPerson(p1);
		
		} else if (cmd.equals("UPDATE")) {
		Person p1 = new Person(lastName, firstName, Integer.valueOf(age), Long.parseLong(id), new ArrayList<Animal>());
		service.updatePerson(p1);
		}

		response.sendRedirect("person.jsp"); //rediriger vers la page person
	%>
</body>
</html>