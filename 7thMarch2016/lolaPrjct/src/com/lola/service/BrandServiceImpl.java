package com.lola.service;

import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.lola.dao.BrandDao;
import com.lola.dao.BrandDaoImpl;
import com.lola.dao.HibernateUtilDao;
import com.lola.model.Brand;
import com.lola.services.util.BrandUtility;

public class BrandServiceImpl implements  BrandService{

	
	BrandUtility brandUtility =new BrandUtility();
	
/*public String getMyBrandsByCategoryId(int userid, int categoryid,int start,int offset) throws Exception{
	
	   return brandUtility.getMyBrandsByCategoryId(userid, categoryid, start, offset);
	 
}*/
	
	public String getMyBrandsByCategoryId(int userid, int categoryid) throws Exception{
		
		   return brandUtility.getMyBrandsByCategoryId(userid, categoryid);
		 
	}

public String getAllBrandsByCategoryId(int userid, int categoryid) throws Exception{
		
	return brandUtility.getAllBrandsByCategoryId(userid, categoryid).replace("\\", "");

}

public String getTotalBrands() throws Exception{
	
	
	return brandUtility.getTotalBrands();
}

@Override
public String getBrandsByCategoryId(int categoryid) throws Exception {
	// TODO Auto-generated method stub
	return brandUtility.getBrandsByCategoryId(categoryid);
}
public static void main(String args[]) throws Exception{
	BrandServiceImpl brandService=new BrandServiceImpl();
	/*
	List<Object> brands	=brandService.getMyBrandsByCategoryId(3, 1);
	 int i=0;
	 while(i<brands.size())		 
	 {
		System.out.println(brands.get(i).toString());
		i++;
	 }	*/ 
	//System.out.println(brandService.getAllBrandsByCategoryId(3, 1,0,5));
	System.out.println(brandService.getBrandsByCategoryId(2));
	
}

public String getAllBrandsCountByCategory(int userid, int categoryid)  throws Exception
{
	return brandUtility.getAllBrandsCountByCategory(userid, categoryid);
}

@Override
public String getBrandHomepage(int brandId) throws Exception {
	
	return brandUtility.getBrandHomepage(brandId);
}


}


