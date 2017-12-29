<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%

	if(request.getAttribute("usercount") == null)
		request.getRequestDispatcher("/CountServlet").forward(request,response);
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome SupMessage</title>
<jsp:include page="/jsp/header.jsp" />
</head>
<body>
<c:choose>
	<c:when test="${empty sessionScope.User}">
		<font>This is description of this website.</font><br>
		<font>you can register a new user .And then login , </font>
		<font>if you do that you can send message to you friends!!</font>
		<br>
		At present,there are <p style="color: red; font-weight: 900">${requestScope.usercount }<p>User has registered<br>
		And,there are <p style="color: red; font-weight: 900">${requestScope.messagecount }<p>Message has send
		<h1>---------------------------</h1>

	</c:when>
	<c:otherwise>
		<jsp:include page="/jsp/RegistedUser.jsp" />

	</c:otherwise>
</c:choose>
	
</body>
</html>