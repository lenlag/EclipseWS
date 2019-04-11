<%@page import="entity.ErrorItem"%>
<%@page import="java.util.List"%>
<%@page import="service.ServiceDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Homepage</title>
<link rel="stylesheet" href="style/main.css" />
</head>
<body>
	<%
		ServiceDao myDao = new ServiceDao();
		List<ErrorItem> list = myDao.findAll();
	%>
	<h1>Welcome to Error Manager HomePage !</h1>
	<br />
	<form action="checkError.jsp" method="get">
	<table class="mainTable">
		<tr>
		
			<th>Type</th>
			<th>Caption</th>
			<th>Level</th>
			<th>Comment</th>
			<th>Status</th>
		</tr>
		<tr>
		<%
			for (ErrorItem e : list) {
				
				int s = e.getStatus();
				if (s != ErrorItem.STATUS_PROCESSED ){ %>
					<td><%=e.getType()%></td>
					<td><%=e.getLabel()%></td>
					<td><%=e.getLevel()%></td>
					<td><%=e.getCommentaire() %></td>
					<td><%

					switch (s) {
					case ErrorItem.STATUS_UNREAD :
					%> 
					<label>U</label> 
					<% break; 
					
					case ErrorItem.STATUS_READ : %>
					<label>R</label>
					<% break; 
		
					case ErrorItem.STATUS_COMM  : %>
					<label>C</label> 
					<% break;						
					} %>
					</td>
					
						
			<td id="noborders" width="20px"><a href="checkError.jsp?id=<%=e.getId()%>&label=<%=e.getLabel()%>"
				style="text-decoration: none"><input type="button"
					value="Check error" id="button"></a></td>
																				<!-- CHECK error btn -->

			</tr>
			</form>
		<%
		}
			}
		%>
	</table>
	<br />
	<br />
	<a href="processedErrors.jsp"><button type="button" id="CPEbutton">Check processed errors</button></a>
</body>
</html>