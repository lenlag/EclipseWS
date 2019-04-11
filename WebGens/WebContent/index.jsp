<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Homepage</title>
</head>
<body>
<h1> Homepage</h1>
<form action="rajoutListe.jsp" method="get" id="rajoutListe">
<input type="text" name="nom" value="" placeholder="Enter name here">
<input type="submit" value="add">
</form>
<br />
<br />
<a href="liste.jsp" style="text-decoration:none"><input type="button" value="Voir liste"></a>

</body>
</html>