<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tableau</title>
</head>
<body>
	<table border = "1">

		<%
			int len = 12;
			int k = 0;
			int j = 100;
			List<String> myList = new ArrayList<String>();
			for (int i=0; i<12; i++) {
				myList.add("AAA" + i);
			}
			
			List<String> myList2 = new ArrayList<String>();
			for (int i=0; i<12; i++) {
				myList2.add("WWW" + i);
			}
		%>
		<%
			for (int i = 0; i < len; i++) {
				if(i == 5){ %>
				<tr>
			
				<td colspan="2">  Indice 5! </td>
				
			</tr>
			<%	} else { %>
		<tr>
			<td>Valeur<%=myList.get(i) %></td>
			<td>Valeur<%=myList2.get(i) %></td>
		</tr>
			<%} %>
		<%
			}
		%>

	</table>
</body>
</html>