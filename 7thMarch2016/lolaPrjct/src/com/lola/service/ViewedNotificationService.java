package com.lola.service;

public interface ViewedNotificationService {
	public String userviewed(int userid,String dealsoffers,String newarrivals,String myspecials) throws Exception;
    
	public String uservieweddealsnoffers(int userid,String dealsoffers) throws Exception;
	public String userviewedMySpecials(int userid, String myspecials) throws Exception;

	public String userviewedNotification(int userid, String bucketids) throws Exception;
}
