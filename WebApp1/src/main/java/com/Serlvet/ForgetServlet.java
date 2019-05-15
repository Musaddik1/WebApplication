package com.Serlvet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.JDBCconnetion;

/**
 * Servlet implementation class ForgetServlet
 */
public class ForgetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Connection con=null;
       PreparedStatement stmt=null;
       ResultSet result=null;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String mobile=request.getParameter("mobile");
		HttpSession session=request.getSession();
		session.setAttribute("username", username);
		try 
		{
			con=JDBCconnetion.getConnection();
			stmt=con.prepareStatement("select * from userlogin where username=? and mobile=?");
			stmt.setString(1, username);
			stmt.setString(2, mobile);
			result=stmt.executeQuery();
			if(result.next())
			{
				response.sendRedirect("setpassword.jsp");
			}
			else
			{
				out.print("<html>");
				out.print("<font color='red'>username and password not present  Please enter again!!");
				request.getRequestDispatcher("forget.jsp").include(request, response);;
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
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
