<%@page import="business.entity.Animal"%>
<%@page import="java.util.List"%>
<%@page import="service.ServiceDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Animal</title>
</head>
<body>
	<%
		String login = (String) session.getAttribute("user"); // protection de la page
		if ((login == null) || (login.length()==0)) { // impossible si login n'était pas renseigné ou si vide
			response.sendRedirect("index.jsp");
			return;
		}
	%>
	<p>
		Hello,
		<%=login%></p>

	<%
		ServiceDao servicedao = new ServiceDao();
		String id = request.getParameter("id"); // on recup le name des chmps du form, name="id"
		if (id == null) {
			response.sendRedirect("error.jsp");
			return;
		}
		List<Animal> animalList = null;

		try {
			animalList = servicedao.animalList(Long.parseLong(id));
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
			return;
		}
		if (animalList == null) {
			response.sendRedirect("error.jsp");
			return;
		}
	%>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Coat Color</th>
			<th>Sex</th>
			<th>Specie</th>
		</tr>
		<%
			for (Animal a : animalList) {
				if (animalList == null) {
					response.sendRedirect("error.jsp");
				}
		%>
		<tr>
			<td><%=a.getName()%></td>
			<td><%=a.getCoatColor()%></td>
			<td><%=a.getSex()%></td>
			<td><%=a.getSpecie().getCommonName()%></td>
		</tr>
		<%
			}
		%>

	</table>
	<br />
	<br />
	<button type="button">
		<a href="person.jsp" style="text-decoration: none"> Back </a>
	</button>

</body>
</html>