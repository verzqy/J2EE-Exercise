<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Servlet" method="POST">
		<h2>Add Student</h2>
		<label>Name :</label><input name="name"> <input type="submit" value="Add">
	</form>
	<ol>
	<%
		if(request.getSession() != null) {
			for(String c: request.getSession().getValueNames()) {
				out.print("<li>"+ request.getSession().getAttribute(c) +"</li>");
			}
		}
	%>
	</ol>

	<form action="Servlet" method="GET"><input type="submit" value="Remove"></form>
</body>
</html>