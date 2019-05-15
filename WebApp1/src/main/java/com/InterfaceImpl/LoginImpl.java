package com.InterfaceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Interface.UserInterface;
import com.connection.JDBCconnetion;
import com.pojo.Login;

public class LoginImpl implements UserInterface{
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet result=null;
	@Override
	public boolean login(String username, String password) {
		
		try
		{
			con=JDBCconnetion.getConnection();
			stmt=con.prepareStatement("select * from userlogin where username=? and password=?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			result=stmt.executeQuery();	
			if(result.next())
			{
				return true;
			}
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean register(Login login)
	{
		
		 try 
		 {
			 con=JDBCconnetion.getConnection();
			  stmt=con.prepareStatement("insert into userlogin values(?,?,?,?,?,?,?,?)");
			  
			 System.out.println(login.getLastname());
			  stmt.setString(1, login.getUsername());
			  stmt.setString(2, login.getPassword());
			  stmt.setString(3, login.getConfirm());
			  stmt.setString(4,login.getFirstname()); 
			  stmt.setString(5, login.getLastname()); 
			  stmt.setString(6, login.getDOB()); 
			  stmt.setString(7,login.getMobile()); 
			  stmt.setString(8, login.getMobile()); 
			  if(login.getPassword().equals(login.getConfirm()))
			  {
				  int number=stmt.executeUpdate(); 
				  System.out.println(number+ "  Record Inserted :");
				  return true;
			  }
		}
		 catch (Exception e) {
			// TODO: handle exception
		}
		  return false;
		
	}

	@Override
	public boolean update(String password, String confirm, String username) {
		
		try 
		{
			con=JDBCconnetion.getConnection();
			stmt=con.prepareStatement(" update userlogin set password=? , confirm=? where username=? ");
			stmt.setString(1, password);
			stmt.setString(2, confirm);
			stmt.setString(3, username);
			int number=stmt.executeUpdate();
			if(password.equals(confirm))
			{
				return true;
			}
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
		return false;
	}
	
	
	

}
