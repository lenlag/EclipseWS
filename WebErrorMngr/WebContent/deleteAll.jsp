<%@page import="java.util.ArrayList"%>
<%@page import="entity.ErrorItem"%>
<%@page import="java.util.List"%>
<%@page import="service.ServiceDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete All Processed Errors</title>
</head>
<body>
	<%
		ServiceDao myDao = new ServiceDao();
		List<ErrorItem> list = myDao.findAll();
		List<ErrorItem> processedList = new ArrayList();

		for (ErrorItem e : list) {
			int s = e.getStatus();
			if (s == ErrorItem.STATUS_PROCESSED) {
				processedList.add(e);
			}
		}

		list.removeAll(processedList);

		response.sendRedirect("index.jsp");
	%>
</body>
</html>