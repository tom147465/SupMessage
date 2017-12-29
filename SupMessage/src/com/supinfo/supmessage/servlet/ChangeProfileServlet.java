package com.supinfo.supmessage.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supmessage.dao.DaoFactory;
import com.supinfo.supmessage.dao.UserDao;
import com.supinfo.supmessage.entity.User;

/**
 * Servlet implementation class ChangeProfileServlet
 */
@WebServlet("/ChangeProfileServlet")
public class ChangeProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User now_user = (User) request.getSession().getAttribute("User");
		
		String username = now_user.getUsername();
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		String address = request.getParameter("address");

		User user = new User(username, password, nickname, email, address);
		UserDao ud =  DaoFactory.retrieveUserDao();
		ud.UpdateUser(user);
        
		request.getSession().setAttribute("User", user);
		response.sendRedirect(request.getContextPath() + "/ListContactServlet?username=" + username );
	}

}
