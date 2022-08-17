package com.lola.service;

import com.lola.services.util.BrandDealsandOffersUtility;
import com.lola.services.util.BrandNewArrivalsUtility;

public class BrandNewArrivalsServiceImpl implements BrandNewArrivalsService{
	
	private static BrandNewArrivalsUtility brandNewArrivalsUtility;

	public BrandNewArrivalsServiceImpl() {
		brandNewArrivalsUtility = new BrandNewArrivalsUtility();
	}

	public String getNewArrivalsbyBrandId(int brandId, int userId) throws Exception{

		

		return	brandNewArrivalsUtility.getNewArrivalsbyBrandId(brandId,userId).toString();		
	}

	/*@Override
	public String saveNewArrivalsLeavePage(int userId, int newarrivalId) throws Exception {
		// TODO Auto-generated method stub
		return brandNewArrivalsUtility.saveNewArrivalsLeavePage(userId, newarrivalId);
	}
	*/
	
}
