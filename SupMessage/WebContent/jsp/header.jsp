<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<c:choose>
	<c:when test="${empty sessionScope.User}">
		<br>
		<a href="<%=application.getContextPath()%>/jsp/login.jsp">Login</a>
		<a href="<%=application.getContextPath()%>/jsp/register.jsp">Register</a>
		<a href="<%=application.getContextPath()%>/jsp/contactPage.jsp">Contact Page</a>
		<h1>---------------------------</h1>
	</c:when>
	<c:otherwise>
		Welcome!!!!!   <br>
		${sessionScope.User.username }<br>
		<!-- ${sessionScope.usrname} -->
		<a href="<%=application.getContextPath()%>/LogoutServlet">LogOut</a>
		<a href="<%=application.getContextPath()%>/auth/chatPage.jsp">Send New Message</a>
		<a href="<%=application.getContextPath()%>/auth/SearchUser.jsp">Search Contact</a>
		<a href="<%=application.getContextPath()%>/auth/profile.jsp">My Profile</a>
		<h1>---------------------------</h1>
	</c:otherwise>
</c:choose>

<br />
</html>