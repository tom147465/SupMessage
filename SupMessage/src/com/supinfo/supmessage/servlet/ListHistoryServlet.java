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

import com.supinfo.supmessage.dao.DaoFactory;
import com.supinfo.supmessage.dao.MessageDao;
import com.supinfo.supmessage.entity.Contact;
import com.supinfo.supmessage.entity.Message;
import com.supinfo.supmessage.entity.User;

/**
 * Servlet implementation class ListHistoryServlet
 */
@WebServlet("/ListHistoryServlet")
public class ListHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sname = ((User) request.getSession().getAttribute("User")).getUsername();
		String dname = ((User) request.getSession().getAttribute("temp_user")).getUsername();
		
		MessageDao md = DaoFactory.retrieveMessageDao();
		List<Message> listmes = md.showhistroy(sname, dname);
		
		 for (Iterator it = listmes.iterator(); it.hasNext();) {
			 	Message str = (Message)it.next();
	            System.out.println(str.getMessage());
	        }
		
		 request.setAttribute("MessageHistory", listmes);
		
		RequestDispatcher rd = request.getRequestDispatcher("/auth/chatPage.jsp");
	    rd.forward(request, response);
		 
	}

}
