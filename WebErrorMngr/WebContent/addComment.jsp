<%@page import="entity.ErrorItem"%>
<%@page import="service.ServiceDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add comment</title>
</head>
<body>
	<%	
		long id = Long.parseLong(request.getParameter("id"));
		String comment = request.getParameter("comm");
		if(comment.length() == 0) {
			response.sendRedirect("noComment.jsp?id=" + id);
		} else {
			
		
		ServiceDao dao = new ServiceDao();
		ErrorItem error = dao.findById(id);
		error.setCommentaire(comment);
		error.setStatus(ErrorItem.STATUS_COMM);
		response.sendRedirect("index.jsp");
		}
				
	%>
</body>
</html>