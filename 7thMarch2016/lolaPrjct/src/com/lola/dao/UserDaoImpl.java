package com.lola.dao;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.lola.model.Brand;
import com.lola.model.User;





public class UserDaoImpl implements UserDao<User, String>{
	
	

	
	public UserDaoImpl() {
	
	}
	
	
	public void persist(User entity){
		hibernateUtil.openCurrentSessionwithTransaction();
		hibernateUtil.getCurrentSession().save(entity);	
		hibernateUtil.closeCurrentSessionwithTransaction();
	}
	
	
	public void update(User entity) {
		hibernateUtil.openCurrentSessionwithTransaction();
		hibernateUtil.getCurrentSession().update(entity);
		hibernateUtil.closeCurrentSessionwithTransaction();
	}	
		 
	@SuppressWarnings("unchecked")
	 public List<User> findByuserid(int userId) {
		 hibernateUtil.openCurrentSession();
	  List<User> user = (List<User>) hibernateUtil.getCurrentSession().createQuery("from User where userId='"+userId+"'and isactive=true").setCacheable(false).list();
	     hibernateUtil.closeCurrentSession();
	  return user;
	 }
	
	@SuppressWarnings("unchecked")
	 public List<User> findByMobile(String mobile) {
		hibernateUtil.openCurrentSession();
	  List<User> user = (List<User>) hibernateUtil.getCurrentSession().createQuery("from User where mobile='"+mobile+"' and isactive=true").setCacheable(false).list();
	    hibernateUtil.closeCurrentSession(); 
	  return user;
	 }
	
	@SuppressWarnings("unchecked")
	 public List<User> findByemailId(String email) {
		hibernateUtil.openCurrentSession();
	  List<User> user = (List<User>) hibernateUtil.getCurrentSession().createQuery("from User where email='"+email+"' and isactive=true").setCacheable(false).list();
	    hibernateUtil.closeCurrentSession(); 
	  return user;
	 }
	
	
	/*@SuppressWarnings("unchecked")
	 public Object getUserdata(int userId) {
		hibernateUtil.openCurrentSession();
	  List<User> user = (List<User>) hibernateUtil.getCurrentSession().createQuery("select userName from User where userId='"+userId+"' and isactive=true").setCacheable(false).list();
	    hibernateUtil.closeCurrentSession(); 
	  return user;
	 }
	*/
	
	

	@Override
	public String getUserLocation(int userid) {
		// TODO Auto-generated method stub
		String location = "";
		hibernateUtil.openCurrentSession();
		  List<Object> user = (List<Object>) hibernateUtil.getCurrentSession().createQuery("select location from User where userId='"+userid+"' and isactive=true").setCacheable(false).list();
		    hibernateUtil.closeCurrentSession(); 
		   
			if(user.size()>0){
			for(Object o:user){
				location=o.toString();
			}
			}
		return location;
	}

	
	
	
	
	public static void main(String args[])
	{
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		
		/*List<User> users = UserDaoImpl.findByemailId("arulkumar.a@truetechsolutions.in");
		for(int i=0;i<users.size();i++)
		{
			User user = (User)users.get(i);
			
			System.out.println(user.getEmail());
		}
		*/
		
			//System.out.println(userDaoImpl.getUserdata(1).toString());
		
	}


	
	
}
