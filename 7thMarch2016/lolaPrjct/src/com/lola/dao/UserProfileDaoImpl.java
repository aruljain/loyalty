package com.lola.dao;

import java.util.List;

import com.lola.model.User;
import com.lola.model.UserProfile;

public class UserProfileDaoImpl implements UserProfileDao <UserProfile, String>{
	
	
		
		public void persist(UserProfile entity){
			hibernateUtil.openCurrentSessionwithTransaction();
			hibernateUtil.getCurrentSession().save(entity);
			hibernateUtil.closeCurrentSessionwithTransaction();
		
		}
		
		public void saveorupdate(UserProfile entity) {			
			hibernateUtil.openCurrentSessionwithTransaction();
			hibernateUtil.getCurrentSession().saveOrUpdate(entity);
			hibernateUtil.closeCurrentSessionwithTransaction();
		}
		
		public void update(UserProfile entity) {			
			hibernateUtil.openCurrentSessionwithTransaction();
			hibernateUtil.getCurrentSession().update(entity);
			hibernateUtil.closeCurrentSessionwithTransaction();
		}
		 
		@SuppressWarnings("unchecked")
		 public List<UserProfile> findByuserid(int userId) {
			hibernateUtil.openCurrentSession();
		  List<UserProfile> user = (List<UserProfile>) hibernateUtil.getCurrentSession().createQuery("from UserProfile where userid='"+userId+"'").setCacheable(false).list();
		  hibernateUtil.closeCurrentSession();
		  return user;
		 }
		
		@SuppressWarnings("unchecked")
		 public int isUserProfileExist(int userId) {
			int userProfileId = 0;
			hibernateUtil.openCurrentSession();
		  List<Object[]> user =  hibernateUtil.getCurrentSession().createQuery("select profileid,userid from UserProfile where userid='"+userId+"'").setCacheable(false).list();
		  hibernateUtil.closeCurrentSession();		  
		  List<Object[]> userProf = user;
		  if(userProf.size()>0){
		  for(Object[] o : userProf)
		  {
			  userProfileId = Integer.parseInt(o[0].toString());
		  }
		  
		  }		 
				  		 
		  return userProfileId;
		 }
		
		
		@Override
		public Object getProfilepic(int userId) {
			hibernateUtil.openCurrentSession();
			  Object pic =  hibernateUtil.getCurrentSession().createQuery("select profilepic from UserProfile where userid='"+userId+"'").setCacheable(false).list();
			  hibernateUtil.closeCurrentSession();
			 
			return pic;
		}
		
				
		
		public static void main (String args[]){		
			UserProfileDaoImpl userProfileDaoImpl=new UserProfileDaoImpl();
			
		List<UserProfile>	user= userProfileDaoImpl.findByuserid(30);
		if(user.size()>0){
			
			for(int i=0; i < user.size();i++){
				UserProfile userProfile=(UserProfile)   user.get(i);
				System.out.println(userProfile.getUserid()+"   "+userProfile.getProfileid());
			}
		}
			System.out.println(userProfileDaoImpl.getProfilepic(28));
		}

		
		
		
}
