package com.lola.service;

import java.util.List;

import com.lola.model.User;

public interface UserService {
	
	public String persist(String imageString,
			String username,
			String salutation,
			String password,
			String email,
			String location,
			String baseLocation,
			String mobile,
			String latitude,
			String longtitude) throws Exception;
	
	
	/*public String update(int userId, 
			String username,
			String password,
			String email,
			String location,
			String mobile,
			int createdby) throws Exception ;*/
	
	
	
	public String loginUser(String email, String password) throws Exception;
	
	public String forgotPassword(String email) throws Exception;
	
	public String resetPassword(String email, String newPassword) throws Exception;
	
	public List<User> findByemailId(String email);
	
	public List<User> findByuserid(int userId);
	
	public String getUserByEmailId(String email ) throws Exception;
	
	 public String resendOTP(int userId) throws Exception;
	
}
