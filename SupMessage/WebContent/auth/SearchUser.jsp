<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search User</title>
</head>
<body>
	<br><h2>Search User</h2>
	<p style="color: red; font-weight: 900">${alert}<p>
	
	<form action="${pageContext.request.contextPath }/SearchUserServlet" method="post">
		<input type="text" name="sea_username">
		<input type="submit" value="Search">
	</form>
	
	<h1>---------------------------</h1>
</body>
</html>