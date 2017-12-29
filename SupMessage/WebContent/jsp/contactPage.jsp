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
	<c:when test="${empty sessionScope.name_admin }">
		<form action="${pageContext.request.contextPath }/SendMessageServlet" method="post">
			<textarea rows="5" cols="20" name="adminMessage"></textarea>
			<input type="submit" value="Submit">
		</form>
	</c:when>
	<c:otherwise>
		<table>
			<c:forEach items="${requestScope.MessageHistory}" var="history">
				<tr>
					<td><c:out value=" ${history.time}" /></td>
				</tr>
				<tr>
					<td><c:out value="  ${history.message}" /></td>
				</tr>
				<br>
			</c:forEach>
		</table>
	</c:otherwise>
</c:choose>
	

</body>
</html>