package com.supinfo.supmessage.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supmessage.dao.DaoFactory;
import com.supinfo.supmessage.dao.UserDao;
import com.supinfo.supmessage.entity.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(
		urlPatterns = { "/RegisterServlet" }, 
		initParams = { 
				@WebInitParam(name = "Register", value = "")
		})
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/register.jsp");
        rd.forward(request, response);
	}
        
        
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
        User user = new User(username, password, nickname, email, address);

        UserDao cd =  DaoFactory.retrieveUserDao();
        User _user = cd.finUser(username);
        if(_user == null)
        {
        	cd.addUser(user);
        	request.getSession().setAttribute("User", user);
        	
        	//response.sendRedirect(request.getContextPath() + "/ListContactServlet?username=" + username );
        	
        	response.getWriter().print("<h1>successlly !!</h1><a href='"+
        			request.getContextPath() + "/ListContactServlet?username=" + username +"'>click here to Login£¡</a>");
        	//RequestDispatcher rd = request.getRequestDispatcher("/jsp/RegistedUser.jsp");
            //rd.forward(request, response);
        }
        else 
        {
        	String alert = "This username had been registed, Please input a other one !!";
        	request.setAttribute("alert", alert);
        	RequestDispatcher rd = request.getRequestDispatcher("/jsp/register.jsp");
            rd.forward(request, response);
        }
	}

}
