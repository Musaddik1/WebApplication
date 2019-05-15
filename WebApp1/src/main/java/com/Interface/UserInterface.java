package com.Interface;

import com.pojo.Login;

public interface UserInterface {

	public boolean login(String username,String password);
	
	public boolean register(Login login);
	
	public boolean update(String password,String confirm,String username);
}
