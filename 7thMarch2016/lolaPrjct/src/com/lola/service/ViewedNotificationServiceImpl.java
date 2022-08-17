package com.lola.service;

import com.lola.services.util.ViewedNotificationUtility;

public class ViewedNotificationServiceImpl implements ViewedNotificationService{
	ViewedNotificationUtility viewedNotificationUtility=new  ViewedNotificationUtility();
	public String userviewed(int userid,String dealsoffers,String newarrivals,String myspecials) throws Exception{
	return	viewedNotificationUtility.userviewed(userid, dealsoffers, newarrivals, myspecials);
		
	}
	@Override
	public String uservieweddealsnoffers(int userid, String dealsoffers)
			throws Exception {
		// TODO Auto-generated method stub
		return viewedNotificationUtility.uservieweddealsnoffers(userid, dealsoffers);
	}
	
	
	@Override
	public String userviewedMySpecials(int userid, String myspecials)
			throws Exception {
		// TODO Auto-generated method stub
		return viewedNotificationUtility.userviewedMySpecials(userid, myspecials);
	}
	
	@Override
	public String userviewedNotification(int userid, String bucketids) throws Exception
	{
		return viewedNotificationUtility.userviewedNotification(userid, bucketids);
	}

}
