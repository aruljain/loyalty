package com.lola.services.util;

import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.lola.dao.BrandPhotoImagesDao;
import com.lola.dao.BrandPhotoImagesDaoImpl;

public class BrandPhotoImagesUtility {

	BrandPhotoImagesDao brandPhotoImagesDaoImpl = new BrandPhotoImagesDaoImpl();
	
	/*public String getaffinityCategoriesbyBrandId(int brandId) throws Exception{
		JSONObject jsonObject = null;
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonParent = new JSONObject();
		JSONArray jsonParentArray = new JSONArray();
		try{

			String path = null;
			List<Object[]> brandPhotoImages=brandPhotoImagesDaoImpl.getaffinityCategoriesbyBrandId(brandId);
			if(brandPhotoImages.size()>0){
				for(Object[] o:brandPhotoImages){
					jsonObject = new JSONObject();					
					jsonObject.put("affinityCategories",o[0].toString());	
					jsonObject.put("photoid",o[1].toString());
					path=LolaConstants.url+o[3].toString();
					jsonObject.put("imagepath",path);
					jsonArray.put(jsonObject);
				}
										
					jsonParent.put("Status", "Success");
					jsonParent.put("Data", jsonArray);
					
				jsonParentArray.put(jsonParent);
			}
			else
			{
				jsonParent.put("Status", "Failure");
				jsonParent.put("Message", "No Records");
				jsonParentArray.put(jsonParent);
			}
		}catch(Exception e)
		{
			JSONObject jsonError = new JSONObject();
				jsonError.put("Status", "Failure");
				//jsonError.put("Error Msg", e.toString());
				jsonError.put("Message", "No Records");
			jsonParentArray.put(jsonError);
			return jsonParentArray.toString();			
		}

		return jsonParentArray.toString().replace("\\", "");
	}*/
	
	public static void main(String args[]) throws Exception
	{

		BrandPhotoImagesUtility brandPhotoImagesUtility = new BrandPhotoImagesUtility();
		
		/*List<Object[]> images = brandPhotoImagesUtility.getaffinityCategoriesbyBrandId(3);
		if(images.size()>0){
		for(Object[] i : images)
		{
			System.out.println(i[0]+"    "+i[1]+"    "+i[2]);
		}
		}
		else
			System.out.println("No records");*/
		//hibernateUtil.closeCurrentSession();
		//System.out.println(brandPhotoImagesUtility.getaffinityCategoriesbyBrandId(2));
	}
		

	

	
}
