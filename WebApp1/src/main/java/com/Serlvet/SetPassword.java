package com.Serlvet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Interface.UserInterface;
import com.InterfaceImpl.LoginImpl;

/**
 * Servlet implementation class SetPassword
 */
public class SetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String password=request.getParameter("password");
		String confirm=request.getParameter("confirm");
		String username=(String) session.getAttribute("username");
		UserInterface user=new LoginImpl();
		boolean result=user.update(password, confirm, username);
		if(result)
		{
			
				out.print("<html>");
				out.print("<font color='green'>You have  successfully changed password</font>");
				request.getRequestDispatcher("index.jsp").include(request, response);
				
			
		}
		else
		{
			out.print("<font color='red'>Please enter same password</font>");
			request.getRequestDispatcher("setpassword.jsp").include(request, response);
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
