package com.lola.services.util;

import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.lola.dao.AdvtBrandsDao;
import com.lola.dao.AdvtBrandsDaoImpl;
import com.lola.dao.UserBrandDao;
import com.lola.dao.UserBrandDaoImpl;
import com.lola.dao.UserProfileDaoImpl;
import com.lola.model.UserProfile;

public class LolaHomeUtility {
	
	UserBrandDao userbrandDaoImpl= new UserBrandDaoImpl();
	BrandDealsandOffersUtility brandImagesUtility = new BrandDealsandOffersUtility();
	BrandMySpecialsUtility brandMySpecialsUtility = new BrandMySpecialsUtility();	
	BrandUtility brandUtility=new BrandUtility();
	UserBrandloyalityPointUtility userBrandloyalityPointUtility=new UserBrandloyalityPointUtility();
	AdvtBrandsDao advtBrandsDaoImpl =new AdvtBrandsDaoImpl();
	
	OnSaleUtility onSaleUtility =new OnSaleUtility();
	
	public String getHomeScreenDetails(int userid) throws Exception{
		
		UserNotificationUtility userNotificationUtility=new UserNotificationUtility();
		JSONObject jsonObject = null;

		JSONArray jsonArray = new JSONArray();

		JSONObject jsonParent = new JSONObject();
		JSONObject jsonObject1 = null;
		JSONObject jsonObject2 = null;
		JSONObject jsonObject3 = null;
		JSONObject jsonObject4 = null;
		JSONObject jsonObject5 = null;
		JSONArray jsonArray1 = null;
		JSONArray jsonArray2 = null;
		JSONArray jsonArray3 = null;
		JSONArray jsonArray4 = null;
		JSONArray jsonArray5 = null;
		JSONArray jsonArray6 = null;
		
		JSONArray jsonParentArray = new JSONArray();
		String userBrands="0";
		String TotalPoints="0";

        String path=null;
        String path1=null;
        String path2=null;
        String path3=null;
        String path4=null;
		try{

			List<Object[]> userbrands = userbrandDaoImpl.getUserBrandPoints(userid);


			int  expiringpoints=userBrandloyalityPointUtility.expiringPointsCal(userid);
			String myDealsnOffers = brandImagesUtility.getMyDealsandOffersbyUserId(userid);
			String mySpecials = brandMySpecialsUtility.getMySpecialsbyUserId(userid);
			String totalBrands = brandUtility.getTotalBrands();
			String onsale=onSaleUtility.getOnSalebyUserId(userid);
			
			jsonObject1 = new JSONObject();
			jsonObject2=new  JSONObject();
			jsonObject3=new  JSONObject();
			jsonObject4=new  JSONObject();
			jsonObject5=new  JSONObject();
			jsonArray1 = new JSONArray();
			jsonArray2 = new JSONArray();
			jsonArray3 = new JSONArray();
			jsonArray4 = new JSONArray();
			jsonArray5 = new JSONArray();
			jsonArray6 = new JSONArray();

			for(Object o[]:userbrands){

				jsonObject = new JSONObject();
				if(o[0]!=null){
					userBrands=o[0].toString();
					jsonObject.put("UserBrands",userBrands);
				}
				else
					jsonObject.put("UserBrands",userBrands);	
					
				if(o[1]!=null){
					TotalPoints=o[1].toString();
					jsonObject.put("TotalPoints",TotalPoints);
				}
				else
					jsonObject.put("TotalPoints",TotalPoints);	
					
			}


			if(expiringpoints!=0)
				jsonObject.put("ExpiringPoints",expiringpoints);
			else
				jsonObject.put("ExpiringPoints",expiringpoints);	
			
			   jsonArray.put(jsonObject);
			   
			  

			List<Object[]> adImages = advtBrandsDaoImpl.getAdImageDetails();		
			int i=1;
			if(adImages.size()==5){
			for(Object[] o : adImages)
			{		
				
				if(i==1){			
				jsonObject1.put("My_Brands_Points",userBrands);
				path=LolaConstants.url+o[0].toString();
				jsonObject1.put("ImagePath",path);
				
			}
			if(i==2){
				jsonObject2.put("My_Specials_Points",mySpecials);
				path1=LolaConstants.url+o[0].toString();
				jsonObject2.put("ImagePath",path1);
				
			}
			if(i==3){
				jsonObject3.put("My_DealsnOffers_Points",myDealsnOffers);
				path2=LolaConstants.url+o[0].toString();
				jsonObject3.put("ImagePath",path2);
				
			}
			if(i==4){
				jsonObject4.put("All_Brands_Points",totalBrands);
				path3=LolaConstants.url+o[0].toString();
				jsonObject4.put("ImagePath",path3);
				}
			if(i==5){
				jsonObject5.put("On_Sale_Points",onsale);
				path4=LolaConstants.url+o[0].toString();
				jsonObject5.put("ImagePath",path4);
				}
				i++;
				//jsonObject1.put("Add Image",o[0].toString());
				
				
				
				
				
			
			}
			jsonArray1.put(jsonObject1);
			jsonArray2.put(jsonObject2);
			jsonArray3.put(jsonObject3);
			jsonArray4.put(jsonObject4);
			jsonArray5.put(jsonObject5);
			//jsonArray6.put(userNotificationUtility.getNotificationCount(userid));
			
		//	System.out.println(jsonArray.toString().replace("\\", ""));
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
		
	
		
		
		jsonParent.put("Status", "Success");
		jsonParent.put("Point Details", jsonArray);
		jsonParent.put("My_Brands", jsonArray1);
		jsonParent.put("My_Specials", jsonArray2);
		jsonParent.put("My_DealsnOffers", jsonArray3);
		jsonParent.put("All_Brands", jsonArray4);
		jsonParent.put("On_Sale", jsonArray5);
		jsonParent.put("Notification_Count", userNotificationUtility.getNotificationCount(userid));
		
	
		
		
	 // jsonParentArray.put(jsonParent);		
		//jsonArray1.put(jsonObject1);		
	//	jsonParentArray.put(jsonArray);

		
		return jsonParent.toString().replace("\\", "");
	}

	
	
	public String getProfilepic(int userId) throws Exception{
		String pic="";
		String fileName=""+userId;
		UserProfileDaoImpl userProfileDaoImpl=new UserProfileDaoImpl();
		pic=userProfileDaoImpl.getProfilepic(userId).toString();
		if(!pic.equals(""))
		{
			ImageUtility.writeByteArraytoImageFile(pic, fileName);
		}
		JSONObject jsonObject = null;
		jsonObject=new JSONObject();
		jsonObject.put("pic", pic.toString());
		return jsonObject.toString();
	}
	public static void main(String args[]) throws Exception{
		LolaHomeUtility lolaHomeBrandUtility=new LolaHomeUtility();
		System.out.println(lolaHomeBrandUtility.getHomeScreenDetails(1));
		
		//System.out.println(lolaHomeBrandUtility.getProfilepic(28));
		
	}

}
