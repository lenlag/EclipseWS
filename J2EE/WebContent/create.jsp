<%@page import="persistence.dao.PersonDao"%>
<%@page import="business.entity.Person"%>
<%@page import="service.ServiceDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style/style.css"/>
<title>Create/Update person</title>
</head>
<body>

	<%
		String sId = request.getParameter("id");
		long id = 0L;
		ServiceDao service = new ServiceDao();
		if (sId != null && sId.length() != 0) {
			id = Long.parseLong(sId);
		}
		String nom = "";
		String prenom = "";
		String age = "";
		String cmd = "CREATE";
		if (id != 0) {
			Person p = service.findById(id);
			nom = p.getLastName();
			prenom = p.getFirstName();
			age = "" + p.getAge();
			cmd = "UPDATE";
		}
	%>
	
	<% if (id == 0) { %>
	<h2> Creation </h2>
	
	<% } else { %>
	<h2> Update </h2>
	<% } %>


	<form action="process.jsp" method="get">
		<table border="1">
			<tr>
				<td><label for="lastName"> Last Name </label></td>
				<td><input type="text" name="nom" id="lastName" placeholder="Enter last name here" value="<%=nom%>" /></td>
			</tr>
			<tr>
				<td><label for="firstName"> First Name </label></td>
				<td><input type="text" name="prenom" id="firstName" placeholder="Enter first name here" value="<%=prenom%>" /></td>
			</tr>
			<tr>
				<td><label for="age"> Age </td>
				<td><input type="text" name="age" id="personAge" placeholder="Enter age here" value="<%=age%>" /></td>
				</label>
			</tr>
		</table>
		<br />
		<table>
			<tr>
				<td><input type="submit" value="Submit" class="btn-submit" /> <!-- SUBMIT button -->
					<input type="hidden" name="id" value="<%=id%>" /> <!-- Champs "id" caché -->
					<input type="hidden" name="cmd"	value="<%=cmd%>" /> <!-- Champs cmd caché -->
					</form></td>
				<td>
					<form action="person.jsp">
						<input type="submit" value="Cancel" class="btn-cancel" />
						<!-- CANCEL button -->
					</form>
				</td>
			</tr>

		</table>
</body>
</html>