package userInterface;



import model.User;

public interface Userin {

	public boolean login(String username,String password);
	public boolean register(User user);
	public void update(String password,String confirm,String username);
}