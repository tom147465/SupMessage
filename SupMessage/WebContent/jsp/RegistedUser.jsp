<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<br><p style="color: red; font-weight: 900">${requestScope.alert}<p>
	
	<h1>Contact</h1>
	<table>
		<tr>
			<th>Name</th>
			<th>   </th>

		</tr>
		<c:choose>
			<c:when test="${empty sessionScope.ContactList}">
				There is no Contact yet !
			</c:when>
			<c:otherwise>
				<c:forEach items="${sessionScope.ContactList}" var="contact">
					<tr>
						<td><c:out value="${contact.c_user}" /></td>
						<td>
						<a href="${pageContext.request.contextPath}/ChatServlet?c_user=${contact.c_user}">Chat</a>
						</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>

	</table>
	<h1>---------------------------</h1>
	<br>
	<h1>---------------------------</h1>

</html>