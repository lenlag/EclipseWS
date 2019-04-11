<%@page import="org.apache.catalina.Session"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mysql.fabric.Response"%>
<%@page import="persistence.dao.PersonDao"%>
<%@page import="business.entity.Person"%>
<%@page import="service.ServiceDao"%>
<%@page import="java.security.Provider.Service"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" type="text/css" href="style/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Person</title>

<script type="text/javascript">
	function mySubmit(id) {
		document.getElementById("myId").value = id; // id = paramètre, on stocke l'identifiant dans chps caché, on remplit la valeur pour le champs "hidden"
		document.getElementById("myForm").submit(); //on envoie le formul avec le champs cc
	}
	
	 function deletePerson(id) {
		var conf = confirm("Are you sure you want to delete this person?"); //pop-up window confirm
		if (conf == true){
		document.getElementById("idPerson").value = id;
		document.getElementById("deleteForm").submit();
		
	//window.location ="delete.jsp?id="+id; // rediriger vers une page delete
		} else {			// button Annuler
			return;
		} 
		
	} 

	 
</script>
</head>

<body>
	<form action="deconnect.jsp" method="get" id="deconnect" align="right">
		<input type="submit" value="Disconnect" class="btn-disconnect"
			style="float: right;">
		<!-- DISCONNECT button -->
	</form>
	<%
		String login = (String) session.getAttribute("user"); //pour proteger le site 
		if ((login == null) || (login.length() == 0)) { //impossible d'acceder aux autres pages si login n'est pas saisi
			response.sendRedirect("index.jsp"); // // impossible si login vide
			return;
		}
	%>
	<p>
	<h1>
		Hello,
		<%=login%></h1>
	</p>
	<h2>Welcome to Bestioles Website&nbsp;!</h2>
	<h3>Bienvenue&nbsp;!</h3>
	<h4>Добро пожаловать!</h4>

	<table class="table">
		<!-- TABLE -->
		<%
			ServiceDao service = new ServiceDao();
			PersonDao pDao = new PersonDao();
			List<Person> list = new ArrayList<>();

			try {
				list = service.list();
			} catch (Exception e) {
				e.printStackTrace();
				response.sendRedirect("error.jsp"); // Error Page
				return;
			}
			if (list == null) {
				response.sendRedirect("error.jsp"); // Error Page
				return;
			}
		%>
		<tr>
			<th>Id</th>
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
		<tr>
			<td><%=p.getId()%></td>
			<td><%=p.getLastName()%></td>
			<td><%=p.getFirstName()%></td>
			<td><%=p.getAge()%></td>
			<td><a href="javascript:mySubmit(<%=p.getId()%>)"><%=p.getAnimaux().size()%></a></td>

			<td><a href="create.jsp?id=<%=p.getId()%>"><img
					src="img/update.png" alt="update button"
					style="width: 20px; height: 20px;" /></a></td>
			<!-- UPDATE button -->

			<td><img onclick="javascript:deletePerson(<%=p.getId()%>);"
				src="img/delete.png" alt="delete button"
				style="width: 20px; height: 20px;" /></td>
			<!-- DELETE button -->
		</tr>
		<%
			}
		%>
		<form action="delete.jsp" method="post" id="deleteForm">
			<!-- form pour DELETE button -->
			<input type="hidden" id="idPerson" name="idPerson" value="">
		</form>

	</table>
	<!-- TABLE -->

	<form action="Animal.jsp" method="get" id="myForm">
		<!-- Form pour le lien vers la Liste des Animaux -->
		<!-- method GET pour le dév -->
		<input type="hidden" name="id" id="myId" value="">
	</form>
	<br />
	<table>
		<tr>
			<td>Create</td>
		</tr>
		<tr>
			<td>
				<form action="create.jsp" method="get" id="create">
					<!-- CREATE Button -->
					<input type="image" src="img/add.jpg" alt="create button"
						style="width: 40px; height: 40px;" />
				</form>
			</td>
		</tr>
	</table>
</body>
</html>