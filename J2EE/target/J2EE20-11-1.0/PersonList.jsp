

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
<title>Insert title here</title>
</head>
<body>

<%ServiceDao service = new ServiceDao(); %>
<%List<Person> list = service.list();
PersonDao pDao = new PersonDao();
%>

<table border = "1">
<tr>
<th>Last Name</th>
<th>First Name</th>
<th>Age</th>
<th>Id</th>
<th>Animals</th>
</tr>
<%for(Person p: list) { %>
<tr>
<td><%=p.getLastName()%></td>
<td><%=p.getFirstName()%></td>
<td><%=p.getAge()%></td>
<td><%=p.getId()%></td>
<td><a href="Animal.jsp?ballon=<%=p.getId() %>"><%=p.getAnimaux().size() %></a></td>
</tr>
<%}%>
</table>
</body>
</html>