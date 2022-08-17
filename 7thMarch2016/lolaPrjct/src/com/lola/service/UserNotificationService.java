package com.lola.service;

public interface UserNotificationService {
	public String getNotificationCount(int userid) throws Exception;
	
	public String getUserNotificationDetails(int userid) throws Exception;
	
	public String getNotificationCountForDealsnOffers(int userid) throws Exception;
	
	public String getUserNotificationDetailsForDealsnOffers(int userId) throws Exception;
	
	public String getNotificationCountForMySpecials(int userid) throws Exception;
	
	public String getUserNotificationDetailsForMySpecials(int userId) throws Exception;
	
	public String getNotificationCountforParticularBrand(int userid,int brandid) throws Exception;
	
	public String getUserNotificationDetailsForParticularBrand(int userId,int brandid) throws Exception;
	

}
