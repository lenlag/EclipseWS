<%@page import="entity.ErrorItem"%>
<%@page import="service.ServiceDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Management</title>
<link rel="stylesheet" href="style/main.css" />
</head>
<body id="bodyCheckError">
	<%
		String label = request.getParameter("label");
		long id = Long.parseLong(request.getParameter("id"));
		
		ServiceDao myDao = new ServiceDao();
		ErrorItem error = myDao.findById(id);
		error.setStatus(ErrorItem.STATUS_READ);
	%>
	<h1>Error management</h1>
	<table border="1" width="50%" align="center" class="userTable">
		<tr>
		<th>Concerned error</th>
		<th>Comment</th>
		</tr>
		<tr>
			<td> <%=error.getLabel()%></td>
			<form action="addComment.jsp" method="get">
			<td><input type="text" name="comm" id="comm" value="<%=error.getCommentaire()%>" placeholder="put your comment here" style="width:99%"></td>
			<input type="hidden" name="id" value="<%=id%>" /> 			<!-- Champs "id" caché -->
		
		</tr>
	</table>
	<br />
	<br />
	<table align="center">
		<tr>
			<td><a href="index.jsp" style="text-decoration: none"><input type="button" value="Back" id="button"></a></td> <!-- BACK btn -->
			<td><input type="submit" value="Add comment" id="button">					<!-- ADD COMMENT btn -->
			</form>
			</td>
			<td><a href="errorProcessing.jsp?id=<%=id%>" style="text-decoration: none"><input
					type="submit" value="Process" id="button"></a></td>					<!-- PROCESS btn -->
		</tr>
	</table>



</body>
</html>