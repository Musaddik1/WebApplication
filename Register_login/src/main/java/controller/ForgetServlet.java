package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.HibernateUtil;
import model.User;

/**
 * Servlet implementation class ForgetServlet
 */
public class ForgetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String mobile=request.getParameter("mobile");
		HttpSession session1=request.getSession();
		session1.setAttribute("username", username);
		Session session=HibernateUtil.getSession();
		Transaction transaction=session.beginTransaction();
		User user=session.get(User.class, username);
		if(user.getMobile().compareTo(mobile)==0)
		{
			response.sendRedirect("setpassword.jsp");
		}
		else
		{
			out.print("<html>");
			out.print("<font color='red'>Please valid username and mobile number");
			request.getRequestDispatcher("forget.jsp").include(request, response);
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
