package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.env.IModule.IService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.HibernateUtil;
import implementInterface.Userimpl;
import model.User;
import userInterface.Userin;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Userin userin=Userimpl.getInstance();
	  
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String confirm=request.getParameter("confirm");
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String DOB=request.getParameter("DOB");
		String mobile=request.getParameter("mobile");
		String email=request.getParameter("email");
		
		User user=new User(username, password, confirm, firstname, lastname, DOB, mobile, email);
		user.setUsername(username);
		user.setPassword(password);
		user.setConfirm(confirm);
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setDOB(DOB);
		user.setMobile(mobile);
		user.setMail(email);
		boolean result=userin.register(user);
		out.print("<html>");
		if(result)
		{
			out.print("<font color='green'>Successfully register user</font>");
			request.getRequestDispatcher("login.jsp").include(request, response);;
			
		}
		else
		{
			out.print("<font color='red'>Please insert all field correct</font></html>");
			request.getRequestDispatcher("Registration.jsp").include(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
