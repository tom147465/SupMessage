<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Login</h1>
	
	<p style="color: red; font-weight: 900">${requestScope.alert}<p>
	
		<form name="input" action="${pageContext.request.contextPath }/LoginServlet" method="post">
		Username: <input type="text" name="username"> 
		Password: <input type="password" name="password">
		<input type="submit" value="Submit">
		</form>
</body>
</html>