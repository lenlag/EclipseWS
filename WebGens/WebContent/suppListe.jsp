<%@page import="service.ListService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Suppression</title>
</head>
<body>
<%
int index = Integer.parseInt(request.getParameter("index"));
new ListService().delete(session, index-1);
response.sendRedirect("liste.jsp");

%>
</body>
</html>