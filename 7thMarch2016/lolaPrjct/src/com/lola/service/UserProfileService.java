package com.lola.service;



public interface UserProfileService {
	public String saveorupdate(int userid,String imageString,String salutation,String dob,String gender,String mycities,boolean maritalstatus,boolean veg,String weddinganv,String username,String location,String baseLocation,String email,String mobile,String password) throws Exception;
	public String findUserProfileByuserid(int userid) throws Exception;
	public String getusercompletedetails(int userid) throws Exception;

}
