<%@page import="entity.ErrorItem"%>
<%@page import="service.ServiceDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error processing</title>
</head>
<body>
	<%
		long id = Long.parseLong(request.getParameter("id"));
	
		ServiceDao myDao = new ServiceDao();
		ErrorItem error = myDao.findById(id);
		error.setStatus(ErrorItem.STATUS_PROCESSED);
		
		response.sendRedirect("index.jsp");
	%>




</body>
</html>