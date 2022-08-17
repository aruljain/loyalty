package com.lola.service;

public interface BrandDealsandOffersService {

	public String getAllbrandsDealsandOffersByCategoryIdWithLimit(int categoryId, int start, int offset) throws Exception;
	
	public String getMyDealsandOffersbyUserId(int userid) throws Exception;
	
	public String getMyDealsandOffers(int userid,int categoryId) throws Exception;
	
	public String getMyDealsandOffersbyBrandId(int brandId, int userId) throws Exception;
	
	//public String saveDealsAndOffersLeavePage(int userId,int dealandofferId) throws Exception;
}
