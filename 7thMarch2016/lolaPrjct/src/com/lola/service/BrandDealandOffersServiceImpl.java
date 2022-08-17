package com.lola.service;

import com.lola.services.util.BrandDealsandOffersUtility;
import com.lola.services.util.BrandImagesUtility;
import com.lola.services.util.UserBrandUtility;

public class BrandDealandOffersServiceImpl implements BrandDealsandOffersService{
	
	private static BrandDealsandOffersUtility brandDealandOffersUtility;
	
	public BrandDealandOffersServiceImpl() {
		brandDealandOffersUtility = new BrandDealsandOffersUtility();
	}

	public String getAllbrandsDealsandOffersByCategoryIdWithLimit(int categoryId, int start,
			int offset) throws Exception{
		
		
		
		 
		
		
		return  brandDealandOffersUtility.getAllbrandsDealsandOffersByCategoryIdWithLimit(categoryId, start, offset);
	}
	
	public String getMyDealsandOffersbyUserId(int userid) throws Exception{

		//BrandDealsandOffersUtility brandDealsandOffersUtility=new BrandDealsandOffersUtility();

		return	brandDealandOffersUtility.getMyDealsandOffersbyUserId(userid).toString();		
	}
	
	public String getMyDealsandOffers(int userid,int categoryId) throws Exception{

		//BrandDealsandOffersUtility brandDealsandOffersUtility=new BrandDealsandOffersUtility();

		return	brandDealandOffersUtility.getMyDealsandOffers(userid,categoryId).toString();		
	}
	
	public String getMyDealsandOffersbyBrandId(int brandId, int userId) throws Exception{
	
		//BrandDealsandOffersUtility brandDealsandOffersUtility=new BrandDealsandOffersUtility();
	
			return	brandDealandOffersUtility.getMyDealsandOffersbyBrandId(brandId,userId).toString();		
	}

	/*@Override
	public String saveDealsAndOffersLeavePage(int userId, int dealandofferId)
			throws Exception {
		// TODO Auto-generated method stub
		return brandDealandOffersUtility.saveDealsAndOffersLeavePage(userId, dealandofferId);
	}
*/
}
