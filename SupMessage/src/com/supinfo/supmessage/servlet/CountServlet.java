package com.supinfo.supmessage.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supmessage.dao.DaoFactory;
import com.supinfo.supmessage.dao.MessageDao;
import com.supinfo.supmessage.dao.UserDao;
import com.supinfo.supmessage.entity.User;

/**
 * Servlet implementation class CountServlet
 */
@WebServlet("/CountServlet")
public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDao cd =  DaoFactory.retrieveUserDao();
		MessageDao md = DaoFactory.retrieveMessageDao();
		System.out.println("22222222222222222222222222222222222222222222222");
        Long countuser = cd.Countuser();
        Long countmessage = md.CountMessage();
        
        request.setAttribute("usercount", countuser);
        request.setAttribute("messagecount", countmessage);
        
        request.getRequestDispatcher("/jsp/index.jsp").forward(request,response);   
	}

}
