package com.lola.service;

import com.lola.services.util.BrandAffinityUtility;

public class BrandAffinityServiceImpl implements BrandAffinityService{
	BrandAffinityUtility brandAffinityUtility= new BrandAffinityUtility();

	@Override
	public String getBrandAffinityDetails(int userid,int brandid,double lat,double lng, float dist
			) throws Exception {
		// TODO Auto-generated method stub
		
		
		return brandAffinityUtility.getBrandAffinityDetails(userid, brandid, lat, lng, dist);
	}
}
