<%@page import="entity.ErrorItem"%>
<%@page import="java.util.List"%>
<%@page import="service.ServiceDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Processed errors</title>
<link rel="stylesheet" href="style/main.css" />
</head>
<body>
	<h1>Here is the list of all processed errors</h1>

	<%
		ServiceDao myDao = new ServiceDao();
		List<ErrorItem> list = myDao.findAll();
	%>
	
	
	<table class="PEtable" align="center">
		<tr>
			<th>Type</th>
			<th>Caption</th>
		</tr>
		<tr>
		<%
			for (ErrorItem e : list) {
				
				int s = e.getStatus();
				if (s == ErrorItem.STATUS_PROCESSED ){ %>
					<td><%=e.getType()%></td>
					<td><%=e.getLabel()%></td>
					<td id="noborders" width="20px"><a href="deleteError.jsp?id=<%=e.getId()%>" style="text-decoration: none"><input type="button" value="Delete" id="button"></a></a></td>
					
		</tr>
				<% }	
			}%>
			
	</table>
	<br />
	<br />
	<table align="center">		
			<tr>
			<td><a href="index.jsp" style="text-decoration: none"><input type="button" value="Back" id="button"></a></td>
			<td><a href="deleteAll.jsp" style="text-decoration: none"><input type="button" value="Delete All" id="button"></a></td>
			</tr>
	</table>
</body>
</html>