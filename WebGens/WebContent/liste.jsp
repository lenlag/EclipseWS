<%@page import="entity.Nom"%>
<%@page import="java.util.List"%>
<%@page import="service.ListService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des noms</title>
</head>
<body>
	<%
		ListService service = new ListService();
		List<Nom> myList = service.list(session);
		int index = 0;
	%>
	<table class="table" border="1" style="width: 30%">
		<tr>
			<th>La liste des noms :</th>
		</tr>
		<%
			for (Nom n : myList) {
		%>
		<tr>
			<td><%=n.getName()%></td>
			<%index++; %>
		
			<td><a href="suppListe.jsp?index=<%=index %>"
				style="text-decoration: none; color: black;"><input
					type="button" value="Supprimer"></a></td>
		</tr>
		<%
			}
		%>
	</table>
	<br />
	<a href="index.jsp" style="text-decoration: none; color: black;"> <input
		type="button" value="Retour">
	</a>

</body>
</html>