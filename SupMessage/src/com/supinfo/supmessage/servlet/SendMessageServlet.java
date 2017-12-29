package com.supinfo.supmessage.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supmessage.dao.DaoFactory;
import com.supinfo.supmessage.dao.MessageDao;
import com.supinfo.supmessage.entity.Message;
import com.supinfo.supmessage.entity.User;

/**
 * Servlet implementation class SendMessageServlet
 */
@WebServlet("/SendMessageServlet")
public class SendMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminMessage = request.getParameter("adminMessage");
		if(adminMessage != null)
		{
			
			System.out.println(".........................................................");
			String sname = "tourist00";
			String dname = "admin";
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String time = dateFormat.format( new Date() ); 
			
			Message message = new Message(sname, dname, time, adminMessage);
			
			MessageDao md = DaoFactory.retrieveMessageDao();
			md.addMessage(message);
			
			System.out.println("111111111111111111111111111111111111111111111111111111111");
			response.sendRedirect(request.getContextPath() + "/CountServlet");
		}
		
		if(request.getSession().getAttribute("temp_user") != null)
		{
			System.out.println("xzczxc.........................................................");
			String sname = ((User) request.getSession().getAttribute("User")).getUsername();
			String dname = ((User) request.getSession().getAttribute("temp_user")).getUsername();
			String mess = request.getParameter(dname +"Message");
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String time = dateFormat.format( new Date() ); 
			
			Message message = new Message(sname, dname, time, mess);
			
			MessageDao md = DaoFactory.retrieveMessageDao();
			md.addMessage(message);
			
			response.sendRedirect(request.getContextPath() + "/ListHistoryServlet");
		}
		
	}
	
	
}
