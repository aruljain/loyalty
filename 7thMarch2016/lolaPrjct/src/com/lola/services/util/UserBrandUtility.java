package com.lola.services.util;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.lola.dao.UserBrandDao;
import com.lola.dao.UserBrandDaoImpl;
import com.lola.dao.UserDaoImpl;
import com.lola.hibernate.HibernateUtil;
import com.lola.model.MySpecialLeafPage;
import com.lola.model.User;
import com.lola.model.UserBrand;

public class UserBrandUtility {

	UserBrandDao userbrandDaoImpl= new UserBrandDaoImpl();
	UserBrandloyalityPointUtility userBrandloyalityPointUtility=new UserBrandloyalityPointUtility();
	/*BrandDealsandOffersUtility brandImagesUtility = new BrandDealsandOffersUtility();
	BrandMySpecialsUtility brandMySpecialsUtility = new BrandMySpecialsUtility();	
	BrandUtility brandUtility=new BrandUtility();
	
	AdvtBrandsDao advtBrandsDaoImpl =new AdvtBrandsDaoImpl();
*/




	
// getUserBrandPointsDetails() not needed

	public String getUserBrandPointsDetails(int userid) throws Exception{
		JSONObject jsonObject = null;

		JSONArray jsonArray = new JSONArray();

		JSONObject jsonParent = new JSONObject();
		JSONObject jsonObject1 = null;
		JSONArray jsonArray1 = null;
		
		JSONArray jsonParentArray = new JSONArray();
		String userBrands="0";
		String TotalPoints="0";


		try{

			List<Object[]> userbrands = userbrandDaoImpl.getUserBrandPoints(userid);


			int  expiringpoints=userBrandloyalityPointUtility.expiringPointsCal(userid);
			/*String myDealsnOffers = brandImagesUtility.getMyDealsandOffersbyUserId(userid);
			String mySpecials = brandMySpecialsUtility.getMySpecialsbyUserId(userid);
			String totalBrands = brandUtility.getTotalBrands();*/
              if(userbrands.size()>0){
			for(Object o[]:userbrands){

				//jsonObject = new JSONObject();
				if(o[0]!=null){
					userBrands=o[0].toString();
					//jsonObject.put("UserBrands",userBrands);
				}
				else
					//jsonObject.put("UserBrands",userBrands);	
					return userBrands;
				
				if(o[1]!=null){
					TotalPoints=o[1].toString();
					//jsonObject.put("TotalPoints",TotalPoints);
				}
				else
					//jsonObject.put("TotalPoints",TotalPoints);	
					return TotalPoints;
			}
              }else
            	  
            	  return userBrands+"  "+TotalPoints+"hiiii";
			if(expiringpoints!=0)
				jsonObject.put("ExpiringPoints",expiringpoints);
			else
				jsonObject.put("ExpiringPoints",expiringpoints);	

			/*List<Object[]> adImages = advtBrandsDaoImpl.getAdImageDetails();		
			int i=1;
			if(adImages.size()==4){
			for(Object[] o : adImages)
			{		
				jsonObject1 = new JSONObject();		
				jsonArray1 = new JSONArray();		
				switch(i){
			case 1:
				jsonObject1.put("My Brands",userBrands);
				break;
			case 2:
				jsonObject1.put("My Specials",mySpecials);
				break;
			case 3:
				jsonObject1.put("My DealsnOffers",myDealsnOffers);
				break;
			case 4:
				jsonObject1.put("All Brands",totalBrands);				
				}
				i++;
				jsonObject1.put("Add Image",o[0].toString());				
				
				jsonArray1.put(jsonObject1);
				jsonParentArray.put(jsonArray1);
			}
			*/
			
		//	System.out.println(jsonArray.toString().replace("\\", ""));
			


		}catch(Exception e)
		{
			JSONObject jsonError = new JSONObject();
			jsonError.put("Status", "Failure");
			//jsonError.put("Error Msg", e.toString());
			jsonError.put("Message","No Records");
			jsonParentArray.put(jsonError);
			return jsonParentArray.toString();
			
		}
		
	//	jsonObject.put("Data", jsonArray);
	//	jsonObject.put("Status", "Success");
	 // jsonArray.put(jsonObject);		
		//jsonArray1.put(jsonObject1);		
		//jsonParentArray.put(jsonArray);

		//return userBrands +" "+TotalPoints;
		return userBrands+"  "+TotalPoints;
	}
	
	
	
	//
	//
/*public String getUserPointsByBrandid(int userid,int brandid) throws Exception{
	JSONObject jsonObject = null;
	JSONArray jsonArray = new JSONArray();
	JSONObject jsonParent = new JSONObject();
	JSONArray jsonParentArray = new JSONArray();
	
	String TotalPoints="0";


try{

	List<Object> userbrands = userbrandDaoImpl.getUserPointsByBrandid(userid, brandid);


	int  expiringpoints=userBrandloyalityPointUtility.expiringPointsCal(userid, brandid);
	
	
	for(Object o:userbrands){
		
			jsonObject = new JSONObject();
					
			if(o!=null){
				TotalPoints=o.toString();
				jsonObject.put("TotalPoints",TotalPoints);
			}
			else
				jsonObject.put("TotalPoints",TotalPoints);					
	}
	

		if(expiringpoints!=0)
			jsonObject.put("ExpiringPoints",expiringpoints);
		else
			jsonObject.put("ExpiringPoints",expiringpoints);	

	
	
}catch(Exception e)
{
JSONObject jsonError = new JSONObject();
jsonError.put("Status", "Failure");
jsonError.put("Error Msg", e.toString());
//jsonParentArray.put(jsonError);
return jsonError.toString();
}
	jsonArray.put(jsonObject);
	jsonParent.put("Status", "Success");
	jsonParent.put("Data", jsonArray);
	
	//jsonParentArray.put(jsonParent);

	return jsonParent.toString();
}
	*/
	public String saveUserBrand(int userid,String newbrandids) throws Exception{
		
		StringTokenizer newList = new StringTokenizer(newbrandids);

		try{

			String dbList = userbrandDaoImpl.getUserBrandids(userid);


			for(int i=0;newList.hasMoreTokens();i++)
			{
				UserBrand userBrand=new UserBrand();
				String tempStr = newList.nextToken(",");				

				Boolean found = Arrays.asList(dbList.split(",")).contains(tempStr);

			
					int newBrandId = Integer.parseInt(tempStr);
					userBrand.setUserid(userid);
					userBrand.setBrandid(newBrandId);
					userBrand.setLiked(true);
					userBrand.setOnoffnoti(true);
					userBrand.setCreatedon(new Date());
					
					if(!found)
					{
					userbrandDaoImpl.persist(userBrand);

					userBrand.setCreatedby(userBrand.getUserid());
				userbrandDaoImpl.update(userBrand);
					}
					else
					{
						int userbrandIds=userbrandDaoImpl.getUserbrandId(userid,newBrandId);	
						userBrand.setUserbrandid(userbrandIds);
						userbrandDaoImpl.update(userBrand);
					}
					
					

				}
			
				


			
		}
		catch(Exception e)
		{
			JSONObject obj = new JSONObject();
			JSONArray jsonArray = new JSONArray();
			obj.put("Status", "Failure");
			//obj.put("Message", e.toString());
			obj.put("Message", "Insert userid ");
			jsonArray.put(obj);

			return jsonArray.toString().replace("\\","");
		}

		JSONObject obj = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		obj.put("Status", "Success");
		//obj.put("Message", "Your selections has been saved successfully");
		obj.put("Message", "We have added the brands you selected  to 'My Brands' !");
		jsonArray.put(obj);

		return jsonArray.toString().replace("\\","");


	}
	
	
	public String unlikeUserBrand(int userid,String brandids) throws Exception{

		StringTokenizer newList = new StringTokenizer(brandids);

		try{

		//	String userbrandIds=userbrandDaoImpl.getUserbrandIds(userid,brandids);		
		//	StringTokenizer userbrandIdList = new StringTokenizer(userbrandIds);
			
			for(int i=0;newList.hasMoreTokens();i++)
			{
				UserBrand userBrand=new UserBrand();
				String tempStr = newList.nextToken(",");						
				int newBrandId = Integer.parseInt(tempStr);
					userBrand.setBrandid(newBrandId);
					userBrand.setUserid(userid);
				//	userBrand.setUserbrandid();
					userBrand.setLiked(false);
					userBrand.setOnoffnoti(false);
					
					userBrand.setUpdatedon(new Date());

				//	userbrandDaoImpl.persist(userBrand);

			    	userBrand.setCreatedby(userBrand.getUserid());
					int userbrandId=userbrandDaoImpl.getUserbrandId(userid,newBrandId);
					if(userbrandId!=0){
					userBrand.setUserbrandid(userbrandId);
					userbrandDaoImpl.update(userBrand);
					}	

			}

		}
		catch(Exception e)
		{
			JSONObject obj = new JSONObject();
			JSONArray jsonArray = new JSONArray();
			obj.put("Status", "Failure");
		//	obj.put("Message", e.toString());
			obj.put("Message", "Your dislike notification to the retailer Failed");
			

			return obj.toString().replace("\\","");
		}

		JSONObject obj = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		obj.put("Status", "Success");
		//obj.put("Message", "Your dislike has been notified to the retailer successfully");
		obj.put("Message", "You have chosen to 'unlike' this brand. You will be able to add this brand back from the 'All Brands' section");
		

		return obj.toString().replace("\\","");


	}
	
	public String getMyBrandsCountByCategoryId(int userid, int categoryid)  throws Exception
	{
		JSONObject obj = new JSONObject();
		try{
			
			int count = userbrandDaoImpl.getMyBrandCountByCategoryId(userid, categoryid);
			obj.put("Status","Success");
			obj.put("count",""+count);
			obj.put("Message","UserBrand count for Category :"+categoryid);
			
		}catch(Exception exception)
		{
			obj.put("Status","Failure");
			obj.put("count",""+0);
			obj.put("Message","Unable to get UserBrand count for Category :"+categoryid);
			return obj.toString();
		}
		
		return obj.toString();
	}
	
	
	
	public String brandPreferenceNoti(int userId,int brandId) throws Exception{
		JSONObject jsonObject = null;
	    String Msg=null;
	try{
		UserDaoImpl userDaoImpl = new  UserDaoImpl();
		
		
			//UserBrand userBrand=new UserBrand();
			UserBrandDaoImpl userBrandDaoImpl=new UserBrandDaoImpl();
			List<UserBrand> userbrand=userBrandDaoImpl.findByuserId(userId);
			if(userbrand.size()>0){
				List<UserBrand> userbrandId=userBrandDaoImpl.findBybrandId(brandId);
				if(userbrandId.size()>0){
				for(UserBrand o:userbrandId){
				   o.setUserbrandid(o.getUserbrandid());
			       o.setBrandid(brandId);
			       o.setUserid(userId);
			       o.setLiked(o.isLiked());
			       o.setCummulativepoints(o.getCummulativepoints());
			       o.setCurrentloyaltylevel(o.getCurrentloyaltylevel());
			       o.setLoyaltyprogramid(o.getLoyaltyprogramid());
			       o.setBalancepoints(o.getBalancepoints());
			     
			       
							if(o.isOnoffnoti()){
					      o.setOnoffnoti(false);
					      Msg="off";
					
						
						}
					else{
						o.setOnoffnoti(true);
						Msg="on";
						}
							userBrandDaoImpl.update(o);
		
					
						
					}
				
					
			}
				}
			else{
				jsonObject =new JSONObject();
				jsonObject.put("Status","Success");
				jsonObject.put("Message","Select Somebrands");
				return jsonObject.toString();
			}
		
			jsonObject =new JSONObject();
			jsonObject.put("Status","Success");
			jsonObject.put("Message",Msg);
			return jsonObject.toString();
	}
	catch(Exception e){
		jsonObject =new JSONObject();
		jsonObject.put("Status", "Failure");
		jsonObject.put("Message"," ");
		System.out.println(e);
		return jsonObject.toString();
		
	
}
	

	}
	
	public static void main(String args[]) throws Exception{
		UserBrandUtility userBrandUtility=new UserBrandUtility();
		System.out.println(userBrandUtility.brandPreferenceNoti(41, 2));
		//System.out.println(userBrandUtility.unlikeUserBrand(10,"5"));


	}


}


