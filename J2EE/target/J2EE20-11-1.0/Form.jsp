<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulaire</title>
</head>
<body>
	<form>
	
	<%int len = 6;
	int id=0; %>
	<%for (int i=0; i<len; i++) { %>
			<label for="tel"> Téléphone <input type="text" name="tel"
			id="<%=i%>" placeholder="Votre numéro de téléphone"/>
		</label>id="<%=i%>"
		<br/>
		<br/>
	<%}%>

	</form>
</body>
</html>