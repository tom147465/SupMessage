<%@page import="com.supinfo.supmessage.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	User user = (User)request.getAttribute("User");
	pageContext.setAttribute("c_user", user.getUsername());
%>

		<p style="color: red; font-weight: 900">${requestScope.alert}</p>
		<table border="0">
			<tr>
				<th>Username:</th>
				<th><% out.print(user.getUsername()); %></th>
			</tr>
			<tr>
				<th>nickname:</th>
				<th><% out.print(user.getNickname()); %></th>
			</tr>
			<tr>
				<th>E-mail:</th>
				<th><% out.print(user.getEmail()); %></th>
			</tr>
			<tr>
				<th>Address:</th>
				<th><% out.print(user.getAddress()); %></th>
			</tr>
		</table>
			
		<a href="<%=application.getContextPath()%>/AddContactServlet?c_user=<%=user.getUsername() %>" ><button>Add Him/She to Contact</button></a>
		<a href="${pageContext.request.contextPath}/ChatServlet?c_user=<%=user.getUsername() %>">Chat With him/she</a>
		
</body>
</html>