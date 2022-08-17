package com.lola.service;

import com.lola.services.util.UserNotificationUtility;

public class UserNotificationServiceImpl implements UserNotificationService{
	
	UserNotificationUtility userNotificationUtility=new  UserNotificationUtility();
	
	public String getNotificationCount(int userid) throws Exception{
		return userNotificationUtility.getNotificationCount(userid);
		
	}
	
	@Override
	public String getUserNotificationDetails(int userid
			) throws Exception {

		
		
		return userNotificationUtility.getUserNotificationDetails(userid);
	}

	@Override
	public String getNotificationCountForDealsnOffers(int userid)
			throws Exception {
		// TODO Auto-generated method stub
		return userNotificationUtility.getNotificationCountForDealsnOffers(userid);
	}

	@Override
	public String getUserNotificationDetailsForDealsnOffers(int userId)
			throws Exception {
		// TODO Auto-generated method stub
		return userNotificationUtility.getUserNotificationDetailsForDealsnOffers(userId);
	}

	@Override
	public String getNotificationCountForMySpecials(int userid)
			throws Exception {
		// TODO Auto-generated method stub
		return userNotificationUtility.getNotificationCountForMySpecials(userid);
	}

	@Override
	public String getUserNotificationDetailsForMySpecials(int userId)
			throws Exception {
		// TODO Auto-generated method stub
		return userNotificationUtility.getUserNotificationDetailsForMySpecials(userId);
	}

	@Override
	public String getNotificationCountforParticularBrand(int userid, int brandid)
			throws Exception {
		// TODO Auto-generated method stub
		return userNotificationUtility.getNotificationCountforParticularBrand(userid, brandid);
	}

	@Override
	public String getUserNotificationDetailsForParticularBrand(int userId,
			int brandid) throws Exception {
		// TODO Auto-generated method stub
		return userNotificationUtility.getUserNotificationDetailsForParticularBrand(userId, brandid);
	}

}
