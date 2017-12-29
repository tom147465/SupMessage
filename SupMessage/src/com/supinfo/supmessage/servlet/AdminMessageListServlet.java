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
import com.supinfo.supmessage.entity.Message;

/**
 * Servlet implementation class AdminMessageListServlet
 */
@WebServlet("/AdminMessageListServlet")
public class AdminMessageListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MessageDao md = DaoFactory.retrieveMessageDao();
		List<Message> listmes = md.showhistroy("tourist00", "admin");
		request.setAttribute("MessageHistory", listmes);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/contactPage.jsp");
        rd.forward(request, response);
	}


}
