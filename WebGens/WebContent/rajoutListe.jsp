<%@page import="entity.Nom"%>
<%@page import="java.util.List"%>
<%@page import="service.ListService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rajout Liste</title>
</head>
<body>
	<%
		String name = request.getParameter("nom");
		if (name.length() == 0) {
			response.sendRedirect("index.jsp");
		} else {
			Nom nom = new Nom(name);
			new ListService().add(session, nom);

			response.sendRedirect("liste.jsp");
		}
	%>

</body>
</html>