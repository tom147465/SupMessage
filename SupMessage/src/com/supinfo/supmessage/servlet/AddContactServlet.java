package com.supinfo.supmessage.servlet;

import java.io.IOException;

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
 * Servlet implementation class AddContactServlet
 */
@WebServlet("/AddContactServlet")
public class AddContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String S_user = ((User) request.getSession().getAttribute("User")).getUsername();
		String C_user = (String) request.getParameter("c_user");
		
		if(S_user.equals(C_user))
		{
			System.out.println("ming zi yiyang le 1111111111111111111111111");
			String alert = "You Can not Add yourself to Contact !!";
        	request.setAttribute("alert", alert);
        	RequestDispatcher rd = request.getRequestDispatcher("/jsp/index.jsp");
            rd.forward(request, response);
			return;
		}
		Contact contact = new Contact( S_user, C_user);
		
		ContactDao cd =  DaoFactory.retrieveContactDao();
		Contact _contact = cd.finContact(S_user,C_user);
		if(_contact == null)
        {
        	cd.addContact(contact);
        	response.sendRedirect(request.getContextPath() + "/ListContactServlet?username=" + S_user );
        	
        }
        else 
        {
        	String alert = "You have been added "+ C_user +" to Contact !!";
        	request.setAttribute("alert", alert);
        	RequestDispatcher rd = request.getRequestDispatcher("/jsp/index.jsp");
            rd.forward(request, response);
        }
	        
	}

}
