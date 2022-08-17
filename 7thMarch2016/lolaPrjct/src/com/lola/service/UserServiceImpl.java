package com.lola.service;


import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.lola.dao.UserDao;
import com.lola.dao.UserDaoImpl;
import com.lola.model.User;
import com.lola.services.util.SMSUtility;
import com.lola.services.util.UserUtility;





public class UserServiceImpl implements UserService{
	private static UserDao userDaoImpl;
	

	public UserServiceImpl() {
		userDaoImpl = new UserDaoImpl();
		
	}
	UserUtility UserUtility=new UserUtility();
	public String persist(String imageString,
			String salutation,
			String username,
			String password,
			String email,
			String location,
			String baseLocation,
			String mobile,
			String latitude,
			String longtitude)  throws Exception{

		
		return UserUtility.saveCustomer(imageString,salutation,username, password, email, location,baseLocation, mobile, latitude, longtitude).toString();
	}

	
	
	
	/*public void update(int userId, 
			String username,
			String password,
			String email,
			String location,
			String mobile
			) throws Exception {
		
	 UserUtility.updateCustomer(userId, username, password, email, location, mobile);
		
	}*/

	
	public String loginUser(String email, String password) throws Exception{
		
		return 	UserUtility.authUser(email, password);
			
		}
		
	
	public String forgotPassword(String email) throws Exception{
		
		return UserUtility.sendPasswordEmailAndSms(email);
		
	}
	
	public String resetPassword(String email, String newPassword) throws Exception{
		
		return UserUtility.resetPassword(email, newPassword);
		
	}
	
	public List<User> findByemailId(String email) {
		
		List<User> users = UserUtility.findByemailId(email);	
		
     return users;
	}


	public List<User> findByuserid(int userId) {
		
		List<User> user = UserUtility.findByuserid(userId);
		
		return user;
	}




	@Override
	public String getUserByEmailId(String email) throws Exception {
		
		return UserUtility.getUserByEmailId(email);
	}




	@Override
	public String resendOTP(int userId) throws Exception {
		
		return UserUtility.resendOTP(userId);
	}

	

}
