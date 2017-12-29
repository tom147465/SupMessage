<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>



<body>
<c:choose>
	<c:when test="${empty sessionScope.temp_user}">
		<c:forEach items="${sessionScope.ContactList}" var="contact">
			<tr>
				<td><c:out value="${contact.c_user}" /></td>
				<td>
				<a href="${pageContext.request.contextPath}/ChatServlet?c_user=${contact.c_user}">Chat</a>
				</td>
			</tr>
			<br>
		</c:forEach>
		<br>
		<a href="<%=application.getContextPath()%>/auth/SearchUser.jsp"><button>Add Contact</button></a>
	</c:when>
	<c:otherwise>
			
		<div>
		<h1>---------------------------</h1>
		<br><a href="${pageContext.request.contextPath}/ListContactServlet?username=${sessionScope.User.username}">Go Home</a>
		<h1>${sessionScope.temp_user.username }</h1>
		<br>${sessionScope.temp_user.nickname }
		<br>${sessionScope.temp_user.email }
		<br>${sessionScope.temp_user.address }
		
		<h1>---------------------------</h1>
		</div>
		<div>
		<br>
		<table>
			<c:forEach items="${requestScope.MessageHistory}" var="history">
				<tr>
					<td><c:out value="${history.sname}      ${history.time}" /></td>
					
				</tr>
				<tr>
					<td><c:out value="  ${history.message}" /></td>
				</tr>
				
				<br>
			</c:forEach>
		</table>
		
		<br>
		<h1>---------------------------</h1>
		</div>
		<form action="${pageContext.request.contextPath }/SendMessageServlet" method="post">
			<textarea rows="5" cols="20" name="${sessionScope.temp_user.username }Message"></textarea>
			<input type="submit" value="Submit">
		</form>
	</c:otherwise>
</c:choose>

</body>
</html>