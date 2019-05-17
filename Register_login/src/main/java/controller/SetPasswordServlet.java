package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import implementInterface.Userimpl;
import userInterface.Userin;


public class SetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String password=request.getParameter("password");
		String confirm=request.getParameter("confirm");
		Userin userin=Userimpl.getInstance();
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("username");
		System.out.println(username);
		userin.update(password,confirm,username);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
