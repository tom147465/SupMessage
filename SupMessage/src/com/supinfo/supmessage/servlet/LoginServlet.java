package com.supinfo.supmessage.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supmessage.dao.ContactDao;
import com.supinfo.supmessage.dao.DaoFactory;
import com.supinfo.supmessage.dao.UserDao;
import com.supinfo.supmessage.entity.Contact;
import com.supinfo.supmessage.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDao ud =  DaoFactory.retrieveUserDao();
        User _user = ud.finUser(username);

        if(_user == null)
        {
        	String alert = "The user does not exist !!";
        	request.setAttribute("alert", alert);
        	RequestDispatcher rd = request.getRequestDispatcher("/jsp/login.jsp");
            rd.forward(request, response);
        }
        else 
        {
        	if(_user.getPassword().equals(password))
        	{
        		if(_user.getUsername().equals("admin"))
        		{
        			request.getSession().setAttribute("name_admin", username);
        			response.sendRedirect(request.getContextPath() + "/AdminMessageListServlet");
        		}
        		else
        		{
        			request.getSession().setAttribute("User", _user);
        			response.sendRedirect(request.getContextPath() + "/ListContactServlet?username=" + username );
        		}
        	}
        	else
        	{
        		String alert = "The password is wrong !!";
            	request.setAttribute("alert", alert);
            	RequestDispatcher rd = request.getRequestDispatcher("/jsp/login.jsp");
                rd.forward(request, response);
        	}
        }

	}

}
