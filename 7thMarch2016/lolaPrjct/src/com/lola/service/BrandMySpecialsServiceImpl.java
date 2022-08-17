package com.lola.service;


import com.lola.services.util.BrandDealsandOffersUtility;
import com.lola.services.util.BrandMySpecialsUtility;

public class BrandMySpecialsServiceImpl implements BrandMySpecialsService{
	
	private static BrandMySpecialsUtility brandMySpecialsUtility;
	
	public BrandMySpecialsServiceImpl() {
		brandMySpecialsUtility = new BrandMySpecialsUtility();
	}

	public String getMySpecialsbyUserId(int userid) throws Exception{

		BrandMySpecialsUtility brandMySpecialsUtility=new BrandMySpecialsUtility();

		return	brandMySpecialsUtility.getMySpecialsbyUserId(userid).toString();		
	}
	
	public String getMySpecials(int userid,int categoryId) throws Exception{

		BrandMySpecialsUtility brandMySpecialsUtility=new BrandMySpecialsUtility();

		return	brandMySpecialsUtility.getMySpecials(userid,categoryId).toString();		
	}
	
/*	public String getMySpecialsbyBrandId(int brandId) throws Exception{
		
		BrandMySpecialsUtility brandMySpecialsUtility=new BrandMySpecialsUtility();
	
			return	brandMySpecialsUtility.getMySpecialsbyBrandId(brandId).toString();		
	}*/

	/*@Override
	public String getMySpecialsByCategoryId(int userid, int categoryId)
			throws Exception {
		BrandMySpecialsUtility brandMySpecialsUtility=new BrandMySpecialsUtility();
		
		return	brandMySpecialsUtility.getMySpecialsByCategoryId(userid, categoryId);		
}*/
	
	@Override
	public String getMySpecialsChildByCategoryId(int userid, int categoryId)
			throws Exception {
		BrandMySpecialsUtility brandMySpecialsUtility=new BrandMySpecialsUtility();
		
		return	brandMySpecialsUtility.getMySpecialsChildByCategoryId(userid, categoryId);		
}

	}

