package com.lola.service;


import java.util.List;

import org.codehaus.jettison.json.JSONObject;

import com.lola.dao.UserProfileDaoImpl;
import com.lola.model.UserProfile;
import com.lola.services.util.UserProfileUtility;

public class UserProfileServiceImpl implements UserProfileService{

	UserProfileUtility userProfileUtility=new UserProfileUtility();

	@Override
	public String saveorupdate(int userid, String imageString, String salutation,String dob,
			String gender,String mycities, boolean maritalstatus, boolean veg, String weddinganv,String username,String location,String baseLocation,String email,String mobile,String password)
			throws Exception {
		// TODO Auto-generated method stub
		return userProfileUtility.saveorupdate(userid, imageString, salutation,dob, gender,mycities, maritalstatus, veg, weddinganv,username,location,baseLocation,email,mobile,password);
	}
	
	/*public String saveUserProfile(int userid,Date dob,String gender,boolean maritalstatus,boolean veg,Date weddinganv) throws Exception {
		//return userProfileUtility.persist(userid,dob, gender, maritalstatus, veg,weddinganv);
		return "";
		
	}
	*/
	
	public String findUserProfileByuserid(int userid) throws Exception{
		
		return userProfileUtility.findUserProfileByuserid(userid);
		
	}
	
public String getusercompletedetails(int userid) throws Exception{
		
		return userProfileUtility.getusercompletedetails(userid);
		
	}
		
	public static void main(String args[]) throws Exception{
		UserProfileServiceImpl userProfileServiceImpl=new UserProfileServiceImpl();
		/*Date dob= new Date("1980/05/14");
		Date weddingAniv= new Date("2016/05/29");
		System.out.println(userProfileServiceImpl.saveorupdate(15, "test", dob, "feamle", true, false, weddingAniv));*/
	
		System.out.println(userProfileServiceImpl.getusercompletedetails(3));
	}
		
		
		
}
