<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/ChangeProfileServlet" method="post">
	 	<h1>${sessionScope.User.username }</h1>
	 	Password: <input type="text" value="${sessionScope.User.password }" name="password"><br><br>
	 	Nickname: <input type="text" value="${sessionScope.User.nickname }" name="nickname"> <br><br>
	 	E-mail: <input type="text" value="${sessionScope.User.email }" name="email"> <br><br>
	 	Address: <input type="text" value="${sessionScope.User.address }" name="address"> <br><br>
		<input type="submit" value="Submit">
	</form>

</body>
</html>