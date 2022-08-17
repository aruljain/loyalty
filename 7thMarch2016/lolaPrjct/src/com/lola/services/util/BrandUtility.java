package com.lola.services.util;

import com.lola.service.BrandServiceImpl;
import com.lola.dao.BrandDao;
import com.lola.dao.BrandDaoImpl;
import com.lola.dao.BrandImagesDataDao;
import com.lola.dao.BrandImagesDataDaoImpl;

import com.lola.dao.BrandShowRoomDaoImpl;
import com.lola.model.Brand;

import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

public class BrandUtility {
	
	
	
	 BrandDao brandDaoImpl=new BrandDaoImpl();
	 
	 BrandImagesDataDao brandImagesDataDaoImpl = new BrandImagesDataDaoImpl();
	 
	 
	 JSONObject jsonObject = null;
	 JSONObject jsonObject1 = null;
	  JSONArray jsonArray = new JSONArray();
	  JSONObject jsonParent = new JSONObject();
	  JSONArray jsonParentArray = new JSONArray();
	  
	 
	public String getMyBrandsByCategoryId(int userid, int categoryid) throws Exception{
		 String path1=null;
		
		  try{
			
		List<Object[]> brands  =brandImagesDataDaoImpl.getMyBrandsByCategoryId(userid, categoryid);
		
		
		/*int i=0;
		while(i<brands.size()){
			 jsonObject = new JSONObject();
			
			 jsonObject.put("logo",brands.get(i).toString());
			  
			  jsonArray.put(jsonObject);
			 i++;
			
		}*/
		if (brands.size()>0){
			
		for(Object i[]:brands){
			jsonObject = new JSONObject();
			 jsonObject.put("brandId", i[0].toString());
			 path1=LolaConstants.url+i[1].toString();
			 jsonObject.put("imagepath", path1);
			 jsonObject.put("brandName",i[2].toString());
			 jsonArray.put(jsonObject);
			
			
		}
		jsonParent.put("Status", "Success");
		 jsonParent.put("Data", jsonArray);
		  
		  //jsonParentArray.put(jsonParent);
		}
		else{
			jsonParent.put("Status", "Failure");
			jsonParent.put("Message", "No records for MyBrands");
			// jsonParentArray.put(jsonParent);
		}
		  }catch(Exception e)
			 {
		  JSONObject jsonError = new JSONObject();
		  jsonError.put("Status", "Failure");
		 // jsonError.put("Message", e.toString());
		  jsonError.put("Message", "No records for MyBrands");
		  //jsonParentArray.put(jsonError);
		  return jsonError.toString();
		  
		 }
		//return jsonParentArray.toString();
		return jsonParent.toString();
	}

	
	/*public String getAllBrandsByCategoryId(int userid, int categoryid,int start,int offset) throws Exception{
		
		
		  try{
			 
		List<Object[]> brands  =brandImagesDataDaoImpl.getAllBrandsByCategoryId(userid, categoryid,start,offset);
		int i=0;
		while(i<brands.size()){
			 jsonObject = new JSONObject();
			// Brand brand = (Brand) brands.get(i);
			 jsonObject.put("logo",brands.get(i).toString());
			  
			  jsonArray.put(jsonObject);
			 i++;
			
		String path=null;
		if (brands.size()>0){
		for(Object i[]:brands){
			 jsonObject = new JSONObject();
			 jsonObject.put("brandId", i[0].toString());
			 path=LolaConstants.url+i[1].toString();
			 jsonObject.put("imagepath", path);
			 jsonArray.put(jsonObject);
			
		}
		 jsonParent.put("Status", "Success");
		 jsonParent.put("Data", jsonArray);
		 
		  //jsonParentArray.put(jsonParent);
		
		  
		  }else{
			  jsonParent.put("Status", "Failure");
			  jsonParent.put("Message", brands.size()+" records for Brands");
			 // jsonParentArray.put(jsonParent);
		  }
		}
		catch(Exception e)
			 {
		  JSONObject jsonError = new JSONObject();
		  jsonError.put("Status", "Failure");
		  jsonError.put("Message", e.toString());
		 // jsonParentArray.put(jsonError);
		  return jsonError.toString();
		 }
		return jsonParent.toString();
	}
	
	
	public String getTotalBrands() throws Exception {
		String total = "0";
		try{
		 total=brandDaoImpl.getTotalBrands();
		 jsonObject = new JSONObject();
		 jsonObject.put("TotalBrands",total );
		  jsonArray.put(jsonObject);
		  
		  jsonParent.put("Status", "Success");
		  jsonParent.put("Data", jsonArray);
		 
		  jsonParentArray.put(jsonParent);
		}catch(Exception e){
			
			  jsonParent.put("Status", "Failure");
			  jsonParent.put("Message", e.toString());
			  jsonParentArray.put(jsonParent);
			  return jsonParentArray.toString();
			return total;
		}
		return total;
	}
*/
	
	
	public String getAllBrandsByCategoryId(int userid, int categoryid) throws Exception{
		
		
		  try{
			 
		List<Object[]> brands  =brandImagesDataDaoImpl.getAllBrandsByCategoryId(userid, categoryid);
		/*int i=0;
		while(i<brands.size()){
			 jsonObject = new JSONObject();
			// Brand brand = (Brand) brands.get(i);
			 jsonObject.put("logo",brands.get(i).toString());
			  
			  jsonArray.put(jsonObject);
			 i++;*/
			
		String path=null;
		if (brands.size()>0){
		for(Object o[]:brands){
			 jsonObject = new JSONObject();
			 jsonObject.put("brandId", o[0].toString());
			 path=LolaConstants.url+o[1].toString();
			 jsonObject.put("imagepath", path);
			 jsonObject.put("brandName",o[2].toString());
			 jsonArray.put(jsonObject);
			
		}
		 jsonParent.put("Status", "Success");
		 jsonParent.put("Data", jsonArray);
		 
		  //jsonParentArray.put(jsonParent);
		
		  
		  }else{
			  jsonParent.put("Status", "Failure");
			  jsonParent.put("Message", brands.size()+" records for Brands");
			 // jsonParentArray.put(jsonParent);
		  }
		}
		catch(Exception e)
			 {
		  JSONObject jsonError = new JSONObject();
		  jsonError.put("Status", "Failure");
		  jsonError.put("Message", "No Brands");
		 // jsonParentArray.put(jsonError);
		  return jsonError.toString();
		 }
		return jsonParent.toString();
	}
	
	
	public String getTotalBrands() throws Exception {
		String total = "0";
		try{
		 total=brandDaoImpl.getTotalBrands();
		/* jsonObject = new JSONObject();
		 jsonObject.put("TotalBrands",total );
		  jsonArray.put(jsonObject);
		  
		  jsonParent.put("Status", "Success");
		  jsonParent.put("Data", jsonArray);
		 
		  jsonParentArray.put(jsonParent);*/
		}catch(Exception e){
			
			 /* jsonParent.put("Status", "Failure");
			  jsonParent.put("Message", e.toString());
			  jsonParentArray.put(jsonParent);
			  return jsonParentArray.toString();*/
			return total;
		}
		return total;
	}
	
	
	public String getBrandsByCategoryId(int categoryid) throws Exception{
		jsonObject1=new JSONObject();
		try{
		List<Object[]> branddetail=brandDaoImpl.getBrandNamesByCategoryId(categoryid);
		
		if(branddetail.size()>0){
			 
		for(Object[] o:branddetail) {
			
			
			 jsonObject = new JSONObject();
			 jsonObject.put("brandId", o[0].toString());
			 jsonObject.put("brandName", o[1].toString());
			 jsonArray.put(jsonObject);
 
		}
		jsonObject1.put("Status", "Success");
		 jsonObject1.put("Data", jsonArray);
		}else{
			jsonObject1 = new JSONObject();
			jsonObject1.put("Message","No brands");}
		//return jsonObject1.toString();
	}catch (Exception e){
		jsonObject = new JSONObject();
		 jsonObject.put("Status", "Failure");
		 jsonObject.put("Message", "No brands");
		 return jsonObject.toString();
	}
		
		return jsonObject1.toString();
		
	
	}
	
	public String getAllBrandsCountByCategory(int userid, int categoryid)  throws Exception
	{
		JSONObject obj = new JSONObject();
		try{
			
			int count = brandDaoImpl.getAllBrandsCountByCategory(userid, categoryid);
			obj.put("Status","Success");
			obj.put("count",""+count);
			obj.put("Message","AllBrand count for Category :"+categoryid);
			
		}catch(Exception exception)
		{
			obj.put("Status","Failure");
			obj.put("count",""+0);
			obj.put("Message","Unable to get AllBrand count for Category :"+categoryid);
			return obj.toString();
		}
		
		return obj.toString();
	}
	
	
	
	public String getBrandHomepage(int brandId) throws Exception{
		
		BrandShowRoomDaoImpl brandShowRoomDaoImpl = new BrandShowRoomDaoImpl();
		try{
		List<Object[]> logoimage=brandDaoImpl.getBrandLogo(brandId);
		
		 List<Object[]> brandlocation =brandShowRoomDaoImpl.getBrandShowroom(brandId);
		 JSONArray jsonArray = new JSONArray();
		 JSONArray jsonArray1 = new JSONArray();
		 
		 
		 if(logoimage.size()>0){
			 for(Object[] o:logoimage){
				 
			 jsonObject=new JSONObject();
			 
			 jsonObject.put("brandname", o[0].toString());
			 jsonObject.put("imagepath", LolaConstants.url+o[2].toString());
			 jsonObject.put("desc", o[3].toString());
			 jsonObject.put("aboutus", o[4].toString());
			 jsonArray.put(jsonObject);
		 }
			
			 
		 }
		 if(brandlocation.size()>0){
			 for(Object[] o1:brandlocation){
				 jsonObject=new JSONObject();
				 
				 jsonObject.put("location", o1[0].toString());
				 jsonObject.put("address", o1[1].toString());
				 jsonArray1.put(jsonObject);
			 }
		 }
		 
		    jsonObject1=new JSONObject();
			
			jsonObject1.put("Data",jsonArray);
			jsonObject1.put("Location", jsonArray1);
			
			 jsonObject1.put("Status","Success");
		
		}
		catch(Exception e){
			jsonObject=new JSONObject();
			 jsonObject.put("Status","Failure");
			 jsonObject.put("Message","No Brands");
			 
			 return jsonObject.toString();
		}
		
		 return jsonObject1.toString().replace("\\", "");
		
	}
	public static  void main(String args[]) throws Exception{
		BrandUtility brandUtility=new BrandUtility();
		
		System.out.println(brandUtility.getBrandHomepage(2));
		//System.out.println(brandUtility.getMyBrandsByCategoryId(96, 2));
		
	}
}
