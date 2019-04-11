

<%@page import="org.apache.catalina.Session"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mysql.fabric.Response"%>
<%@page import="persistence.dao.PersonDao"%>
<%@page import="business.entity.Person"%>
<%@page import="service.ServiceDao"%>
<%@page import="java.security.Provider.Service"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Person</title>
<script type="text/javascript">
	function mySubmit(id) {
		document.getElementById("myId").value = id; // id = paramètre, on stocke l'identifiant dans chps caché, on remplit la valeur pour le champs "hidden"
		document.getElementById("myForm").submit(); //on envoie le formul avec le champs cc
	}
	
	 function deletePerson() {
		var conf = confirm("Are you sure you want to delete this person?"); //pop-up window confirm
		if (conf == true){
		
			//String id = request.getParameter();
			//ServiceDao servicedao = new ServiceDao();
			//servicedao.deletePerson(id);
		} else {
			return;
		} 
	} 
	
	
</script>
</head>
<body>
<form action="deconnect.jsp" method="get" id="deconnect" align="right">
<input type="submit" value="Disconnection">
</form>
	<%
		String login = (String) session.getAttribute("user"); //pour proteger le site 
		if ((login == null) || (login.length() == 0)) { //impossible d'acceder aux autres pages si login n'est pas saisi
			response.sendRedirect("index.jsp"); // // impossible si login vide
			return;
		}
	%>
	<p>
		Hello,
		<%=login%></p>

	<form action="Animal.jsp" method="get" id="myForm">
		<!-- method GET pour le dév -->
		<table border="1">
			<%
				ServiceDao service = new ServiceDao();
				PersonDao pDao = new PersonDao();
				List<Person> list = new ArrayList<>();
			%>
			<%
				try {
					list = service.list();
				} catch (Exception e) {
					e.printStackTrace();
					response.sendRedirect("error.jsp");
					return;
				}
				if (list == null) {
					response.sendRedirect("error.jsp");
					return;
				}
			%>
			<tr><th>Id</th>
				<th>Last Name</th>
				<th>First Name</th>
				<th>Age</th>
				<th>Animals</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
			<%
				for (Person p : list) {
			%>
			<tr><td><%=p.getId()%></td>
				<td><%=p.getLastName()%></td>
				<td><%=p.getFirstName()%></td>
				<td><%=p.getAge()%></td>
		<td><a href="javascript:mySubmit(<%=p.getId()%>)"><%=p.getAnimaux().size()%></a></td>
		
		<td><a href="create.jsp"><img src="img/update.png" alt="update button" style="width:20px;height:20px;"/></a></td>
		<td><img onclick="deletePerson();" src="img/delete.png" alt="delete button" style="width:20px;height:20px;"/></td>
	</tr>
	<%
		}
	%>
	</table>
		<input type="hidden" name="id" id="myId" value="">
	</form>
	<br/>
	<table>
	<tr>
	<td>Create</td>
	</tr>
	<tr>
	<td>
	<form action="create.jsp" method="get" id="create">
	<input type="image" src="img/add.jpg" alt="create button" style="width:40px;height:40px;"/>
	</form>
	</td>
	</tr>
	</table>
</body>
</html>