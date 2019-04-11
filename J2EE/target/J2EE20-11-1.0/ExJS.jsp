<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
        function JSFunction(MyString) {
        alert(MyString);
        }
     
    </script>
</head>
<body>
<button type="button" onclick="JSFunction('Coucou')"> Click here!</button>
<button type="button" onclick="JSFunction('Blabla')"> Click again!</button>
<button type="button" onclick="JSFunction('Père-Noel')"> Click one more time!</button>

<br/>
<br/>

<% String a = "Paris";
String b = "La Défence";
String c = "Sacre-Coeur";
%>
<button type="button" onclick="alert('<%=a%>')"> Button 1 </button>
<button type="button" onclick="alert('<%=b%>')"> Button 2 </button>
<button type="button" onclick="alert('<%=c%>')"> Button 3</button>


</body>
</html>