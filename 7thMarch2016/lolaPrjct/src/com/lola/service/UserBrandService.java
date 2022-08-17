package com.lola.service;

public interface UserBrandService {
	public String saveUserBrand(int userid,String newbrandids) throws Exception;
	
	public String getMyBrandPoints(int userid) throws Exception;
	
	public String unlikeUserBrand(int userid,String newbrandids) throws Exception;
	
	public String getMyBrandsCountByCategoryId(int userid, int categoryid) throws Exception;
	
	public String brandPreferenceNoti(int userId,int brandId) throws Exception;

}
