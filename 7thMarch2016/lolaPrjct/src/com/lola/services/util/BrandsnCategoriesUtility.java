package com.lola.services.util;

import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.lola.dao.BrandDao;
import com.lola.dao.BrandDaoImpl;
import com.lola.dao.CategoryDao;
import com.lola.dao.CategoryDaoImpl;

public class BrandsnCategoriesUtility {
	
	
	 
	public String getBrandsAndCategories() throws Exception{
		
		CategoryDao categoryDaoImpl = new CategoryDaoImpl();
		BrandDao brand = new BrandDaoImpl();
		 JSONObject jsonObject = null;
		  JSONArray jsonArray = new JSONArray();
		  JSONObject jsonParent = new JSONObject();
		 
		 try{
		 List<Object[]> brandlist=brand.getBrandDetails();
		 List<Object[]> categorydetail=categoryDaoImpl.getcategoryDetails();
		// jsonParent.put("Status", "Success");
		 if(brandlist.size()>0){
			for(Object[] o:brandlist) {
				jsonObject = new JSONObject();
				String brandid=o[0].toString();
				String brandname=o[1].toString();

				jsonObject.put("brandId", brandid);
				jsonObject.put("brandName", brandname);
				jsonArray.put(jsonObject);
				
			}
			//jsonParent.put("BrandsDetails",jsonArray );
		 }
			
			/*for(Object[] o:categorydetail){
				jsonObject = new JSONObject();
				jsonObject.put("categoryId", o[0].toString());
				jsonObject.put("categoryName", o[1].toString());
				jsonArray.put(jsonObject);
				//jsonParent.put("CategoriesDetails",jsonArray );
				}
			*/
			
		 }catch (Exception e){
			 jsonObject=new JSONObject();
			 jsonObject.put("Status", "Failure");
			// jsonObject.put("Message", e.toString());
			 jsonObject.put("Message", "No Records");
			 return jsonObject.toString();
		 }
		 jsonParent.put("Status", "Success");
		 jsonParent.put("Brands",jsonArray );
		return jsonParent.toString();
	}
	
	public static void main(String args[])  throws Exception{
		BrandsnCategoriesUtility brandsnCategoriesUtility =new BrandsnCategoriesUtility();
	System.out.println(brandsnCategoriesUtility.getBrandsAndCategories());	
		
	}

}
