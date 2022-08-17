package com.lola.service;

public interface BrandMySpecialsService {

	
	public String getMySpecialsbyUserId(int userid) throws Exception;
	
	public String getMySpecials(int userid,int categoryId) throws Exception;
	
//	public String getMySpecialsByCategoryId(int userid,int categoryId) throws Exception;
	
	public String getMySpecialsChildByCategoryId(int userid,int categoryId) throws Exception;
	
//	public String getMySpecialsbyBrandId(int brandId) throws Exception;
}
