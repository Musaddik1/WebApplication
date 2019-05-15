package com.Serlvet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Interface.UserInterface;
import com.InterfaceImpl.LoginImpl;
import com.pojo.Login;

/**
 * Servlet implementation class RegisterSerlvet
 */
public class RegisterSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
		  PrintWriter out=response.getWriter(); 
		  
		  String username=request.getParameter("username"); 
		  String password=request.getParameter("password");
		  String confirm=request.getParameter("confirm"); 
		  String first=request.getParameter("first"); 
		  String last=request.getParameter("last");
		  String DOB=request.getParameter("DOB");
		  String mobile=request.getParameter("mobile"); 
		 String email=request.getParameter("email"); 
		 
		 Login login=new Login(username, password, confirm, first, last, DOB, mobile, email);
			 UserInterface user=new LoginImpl();
			 boolean result=user.register(login);
			 out.print("<html>");
			  if(result)
			  {
				  out.print("<font color='green'>record inserted successfully...</font>");
				  request.getRequestDispatcher("index.jsp").include(request, response);
			  }
			  else
			  { 
				 
				  out.print("<font color='red'>Enter all field correct ");
				  out.print("</html>");
				  request.getRequestDispatcher("Registration.jsp").include(request, response);
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
