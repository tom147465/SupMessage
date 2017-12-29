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
 * Servlet implementation class SearchUserServlet
 */
@WebServlet("/SearchUserServlet")
public class SearchUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("sea_username");
		UserDao cd =  DaoFactory.retrieveUserDao();
        User _user = cd.finUser(username);
        if(_user == null)
        {
        	String alert = "The user does not exist !!";
        	request.setAttribute("alert", alert);
        	RequestDispatcher rd = request.getRequestDispatcher("/jsp/index.jsp");
            rd.forward(request, response);
        }
        else 
        {
        	request.setAttribute("User",_user);
        	RequestDispatcher rd = request.getRequestDispatcher("/auth/userdetail.jsp");
            rd.forward(request, response);
        }
		
		
	}

}
