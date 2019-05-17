package implementInterface;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.bouncycastle.asn1.x509.UserNotice;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.HibernateUtil;
import model.User;
import userInterface.Userin;

public class Userimpl implements Userin {

	public static Userimpl userimpl=null;
	private Session session=HibernateUtil.getSession();

	
	public static Userimpl getInstance()
	{
		if(userimpl==null)
		{
			userimpl=new Userimpl();
		}
		
		return userimpl;
		
	}




	public boolean login(String username,String password) {
	
		User user=session.get(User.class, username);
		
		if(password.equals(user.getPassword()))
		{
			return true;
		}
		return false;
	}


	public boolean register(User user) {
		
		Transaction transaction=session.beginTransaction();
		if(user.getPassword().equals(user.getConfirm()))
		{
		session.save(user);
		transaction.commit();
		session.close();
		
		return true;	
		}
		return false;
		
	}


	public void update(String password,String confirm,String username)
	{
		
		Transaction transaction=session.beginTransaction();
		User user=session.get(User.class, username);
		user.setUsername(username);
		user.setPassword(password);
		user.setConfirm(confirm);
		
		session.update(user);
		transaction.commit();
		session.close();
		
		System.out.println("successfully....");
	
	}

}
