package com.lola.service;

public interface BrandService {
	
	//public String getMyBrandsByCategoryId(int userid, int categoryid,int start,int offset) throws Exception;
	
	public String getMyBrandsByCategoryId(int userid, int categoryid) throws Exception;
	
	public String getAllBrandsByCategoryId(int userid, int categoryid) throws Exception;
	
	public String getTotalBrands() throws Exception;
	
	public String getBrandsByCategoryId(int categoryid) throws Exception;
	
	public String getAllBrandsCountByCategory(int userid, int categoryid)  throws Exception;
	
	public String getBrandHomepage(int brandId) throws Exception;

}
