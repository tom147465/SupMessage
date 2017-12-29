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

/**
 * Servlet implementation class ListContactServlet
 */
@WebServlet("/ListContactServlet")
public class ListContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ContactDao cd =  DaoFactory.retrieveContactDao();
		
		String username = (String) request.getParameter("username");
		System.out.println(username + "1111111111111111111");
		
		List<Contact> _contact = cd.listContact(username);
		 for (Iterator it = _contact.iterator(); it.hasNext();) {
            Contact str = (Contact)it.next();
            System.out.println(str.getC_user());
        }
		request.getSession().setAttribute("ContactList", _contact);
		request.getSession().removeAttribute("temp_user");
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/index.jsp");
        rd.forward(request, response);
        
	}



}
