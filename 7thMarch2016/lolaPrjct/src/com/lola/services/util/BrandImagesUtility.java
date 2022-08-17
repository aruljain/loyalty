package com.lola.services.util;

import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.lola.dao.BrandImagesDao;
import com.lola.dao.BrandImagesDaoImpl;
import com.lola.dao.BrandImagesDataDao;
import com.lola.dao.BrandImagesDataDaoImpl;
import com.lola.dao.UserDao;
import com.lola.dao.UserDaoImpl;
import com.lola.model.BrandImages;
import com.lola.service.BrandImagesServiceImpl;


public class BrandImagesUtility {
	
	
	 BrandImagesDao  brandImagesDaoImpl=new BrandImagesDaoImpl();
	 //BrandImagesDataDao brandImagesDataDaoImpl=new BrandImagesDataDaoImpl();
	 
	 UserUtility userUtility = new UserUtility();

	public String findByCategoryIdWithLimit(int categoryId, int start, int offset) throws Exception
	{
		 JSONObject jsonObject = null;
		  JSONArray jsonArray = new JSONArray();
		  JSONObject jsonParent = new JSONObject();
		  JSONArray jsonParentArray = new JSONArray();
		  String path=null;
		  try{
			 
			  
			// Object username = userDaoImpl.getUserdata(userId);
			 
			 
			 List<BrandImages> brandimage = brandImagesDaoImpl.findByCategoryIdWithLimit(categoryId,start,offset);
			 
			 
			 if(brandimage.size()>0){
			 
			 for(int i=0;i<brandimage.size();i++)
			 {
			  jsonObject = new JSONObject();
			 
			 BrandImages brandimages = (BrandImages) brandimage.get(i);
			  jsonObject.put("brandId",brandimages.getBrandid());
			  jsonObject.put("desc",brandimages.getDesc().trim());
			 
			  
			  path=LolaConstants.url+brandimages.getImagepath();
			  jsonObject.put("imagepath",path);
			
			  
			 jsonArray.put(jsonObject);
			  
			 }
			 
			
			 //userUtility.
			//  jsonObject.put("username",username.toString());
			  jsonParent.put("Data", jsonArray);
			  jsonParent.put("Status", "Success");
			 
	}else{
		
		
		  jsonParent.put("Status", "Failure");
		  jsonParent.put("Message", "No Records for BrandImages");
		
	}
		  }
		  catch(Exception e)
			 {
		  JSONObject jsonError = new JSONObject();
		  jsonError.put("Status", "Failure");
		  //jsonError.put("Error Msg", e.toString());
		  jsonError.put("Message", "No Records for BrandImages");
		  return jsonError.toString();
		 }
		  
		    return  jsonParent.toString();
	}

public static void main(String args[]) throws Exception{
	BrandImagesUtility brandImagesUtility= new BrandImagesUtility();
	System.out.println(brandImagesUtility.findByCategoryIdWithLimit(2, 0,6));
}
}
