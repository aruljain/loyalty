package com.lola.service;

import com.lola.services.util.LolaHomeUtility;

public class LolaHomeServiceImpl implements  LolaHomeService {
	LolaHomeUtility lolaHomeUtility=new LolaHomeUtility();
	public String getHomeScreenDetails(int userid) throws Exception{
	return	lolaHomeUtility.getHomeScreenDetails(userid);
		
	}
		
	
}
