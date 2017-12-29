<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<% 

%>

</head>
<body>
	<h1>Register</h1>
	
	<p style="color: red; font-weight: 900">${alert}<p>
	
<%--${pageContext.request.contextPath }/RegisterServlet --%>
	<form action="${pageContext.request.contextPath }/RegisterServlet" method="post">
	 	Username: <input type="text" name="username"> 
	 	Password: <input type="password" name="password">
	 	Nickname: <input type="text" name="nickname"> 
	 	E-mail: <input type="text" name="email"> 
	 	Address: <input type="text" name="address"> 
		<input type="submit" value="Submit">
	</form>
</body>
</html>