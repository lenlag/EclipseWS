<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>No Comment</title>
<link rel="stylesheet" href="style/main.css" />
</head>
<body>

<%
long id = Long.parseLong(request.getParameter("id"));

%>
<h1> Your comment is empty. Please, enter a valid comment.</h1>
<div>
<a href="checkError.jsp?id=<%=id%>" style="text-decoration: none" id="commentButton"><input type="button" value="Put your comment" ></a>
</div>
</body>
</html>