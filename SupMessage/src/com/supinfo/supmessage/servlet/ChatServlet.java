package com.supinfo.supmessage.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supmessage.dao.DaoFactory;
import com.supinfo.supmessage.dao.UserDao;
import com.supinfo.supmessage.entity.User;

/**
 * Servlet implementation class ChatServlet
 */
@WebServlet("/ChatServlet")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String c_user = request.getParameter("c_user");
		UserDao cd =  DaoFactory.retrieveUserDao();
		User _user = cd.finUser(c_user);
		
		request.getSession().setAttribute("temp_user", _user);
		
		
		response.sendRedirect(request.getContextPath() + "/ListHistoryServlet");
		
		
	}

}
