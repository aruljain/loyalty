package com.lola.service;

import com.lola.services.util.BrandShowRoomUtility;
import com.lola.services.util.BrandUtility;

public class BrandShowRoomServiceImpl implements  BrandShowRoomService{

	
	BrandShowRoomUtility brandUtility =new BrandShowRoomUtility();
	
	public String getLolaContact() throws Exception{
		
		
		return brandUtility.getLolaContact();
	}
	
	
}
