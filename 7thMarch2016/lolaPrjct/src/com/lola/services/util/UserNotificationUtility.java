package com.lola.services.util;

import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.lola.dao.DealsnOffersNotiDao;
import com.lola.dao.NewArrivalNotiDaoImpl;
import com.lola.dao.DealsnOffersNotiDaoImpl;
import com.lola.dao.NewArrivalNotiDao;
import com.lola.dao.OnSaleNotificationDao;
import com.lola.dao.OnSaleNotificationDaoImpl;
import com.lola.dao.SpecialNotiDao;
import com.lola.dao.SpecialNotiDaoImpl;
import com.lola.dao.UserProfileDaoImpl;
import com.lola.model.UserProfile;

public class UserNotificationUtility {
	
	DealsnOffersNotiDao dealsnOffersNotiDaoImpl=new DealsnOffersNotiDaoImpl();
	NewArrivalNotiDao newArrivalNotiDaoImpl =new NewArrivalNotiDaoImpl();
	SpecialNotiDao specialNotiDaoImpl =new SpecialNotiDaoImpl();
	OnSaleNotificationDao onSaleNotificationDaoImpl =new OnSaleNotificationDaoImpl();
	UserProfileDaoImpl userProfileDaoImpl =new UserProfileDaoImpl();

	JSONArray jsonArray = new JSONArray();

	JSONObject obj =null; 
	int dnocount=0;
	public String getNotificationCount(int userid) throws Exception{
		
		try{
			
			 List<UserProfile> user=userProfileDaoImpl.findByuserid(userid);
			 for(UserProfile o:user){
				if( o.isDealnoffer())
				 dnocount=dealsnOffersNotiDaoImpl.getMyDealsnOffersCount(userid);
				else
					dnocount=0;
				System.out.println("dno"+   dnocount);
			 }
			System.out.println(" SP Count :"+specialNotiDaoImpl.getMySpecailsCount(userid)+" NA Count :"+newArrivalNotiDaoImpl.getMyNewArrivalsCount(userid)+" DNO Count :"+dealsnOffersNotiDaoImpl.getMyDealsnOffersCount(userid)+" OS Count :"+onSaleNotificationDaoImpl.getOnSaleNotificationCount(userid));
			obj=new JSONObject();
	int notification=	dealsnOffersNotiDaoImpl.getMyDealsnOffersCount(userid)+newArrivalNotiDaoImpl.getMyNewArrivalsCount(userid)+specialNotiDaoImpl.getMySpecailsCount(userid)+onSaleNotificationDaoImpl.getOnSaleNotificationCount(userid);
		String notificationCount=String.valueOf(notification);
		//obj.put("Status","Success");
		//obj.put("NotificationCount", notificationCount);
		return notificationCount;
		}
		catch(Exception e){
			JSONObject jsonError = new JSONObject();
			jsonError.put("Status", "Failure");
			//jsonError.put("Error Msg", e.toString());
			jsonError.put("Message", "No Records");
			
			return jsonError.toString();
		}
	}
	
	/*
		public static void main(String args[]) throws Exception {
			
			UserNotificationUtility userNotificationUtility=new  UserNotificationUtility();
		System.out.println(userNotificationUtility.getNotificationCount(2));	
			
		}*/
	
	

	public String getUserNotificationDetails(int userId) throws Exception{
		JSONObject jsonObject = null;
		JSONArray jsonArray = null;;
		JSONObject parentObject = new JSONObject();		
	//	JSONArray jsonArray1 = new JSONArray();
	//	JSONArray jsonArray2 = new JSONArray();
	//	JSONObject jsonParent = new JSONObject();
	//	JSONObject jsonParent1 = new JSONObject();
	//	JSONObject jsonParent2 = new JSONObject();
	//	JSONArray jsonParentArray = new JSONArray();
	//	JSONArray jsonParentArray1 = new JSONArray();
	//	JSONArray jsonParentArray2 = new JSONArray();
		//String myDealsnOffers = "0";
		try{


			List<Object[]> dnoDetails=dealsnOffersNotiDaoImpl.getMyDealsnOffersDetails(userId);
			List<Object[]> naDetails=newArrivalNotiDaoImpl.getMyNewArrivalsDetails(userId);
			List<Object[]> sDetails=specialNotiDaoImpl.getMySpecailsDetails(userId);
			List<Object[]> osDetails=onSaleNotificationDaoImpl.getOnSaleNotificationDetails(userId);
			System.out.println("DNO :"+dnoDetails.size()+"  NA :"+naDetails.size()+" SPLS : "+sDetails.size()+"OS: "+osDetails.size());
			
			if(dnoDetails.size()>0){
				jsonArray = new JSONArray();
				for(Object[] o:dnoDetails){
					jsonObject = new JSONObject();
					String path1=null;
					jsonObject.put("tag","dealsnoffers");	
					jsonObject.put("dealandofferId",o[0].toString());	
					jsonObject.put("createdon",DateUtility.formatDate(o[1].toString()));	
					jsonObject.put("offermsg",o[2].toString());	
					jsonObject.put("dealDesc",o[3].toString());	
					jsonObject.put("brandId",o[4].toString());
					path1=LolaConstants.url+o[5].toString();
					jsonObject.put("offerImage",path1);
					jsonObject.put("content",o[6].toString());
					
					jsonArray.put(jsonObject);
				}
				parentObject.put("Deals_and_Offers", jsonArray);
			}
			
			else{
				jsonArray = new JSONArray();
				parentObject.put("Deals_and_Offers", jsonArray);
				
			
			}
			
			
			if(naDetails.size()>0){
				jsonArray = new JSONArray();
				for(Object[] o1:naDetails){
					jsonObject = new JSONObject();
					String path2=null;
					jsonObject.put("tag","newarrivals");
					jsonObject.put("newarrivalId",o1[0].toString());	
					jsonObject.put("createdon",DateUtility.formatDate(o1[1].toString()));	
					jsonObject.put("newarrivalmsg",o1[2].toString());	
					jsonObject.put("newarrivaldesc",o1[3].toString());
					jsonObject.put("brandId",o1[4].toString());
					path2=LolaConstants.url+o1[5].toString();
					jsonObject.put("arrivalImage",path2);
					jsonObject.put("content",o1[6].toString());	
					jsonArray.put(jsonObject);
				}
				parentObject.put("New_Arrivals", jsonArray);
			}

			else{
				jsonArray = new JSONArray();
				parentObject.put("New_Arrivals", jsonArray);
				
			}
			
			
			if(sDetails.size()>0)
			{
				jsonArray = new JSONArray();
				for(Object[] o2:sDetails){
					jsonObject = new JSONObject();
					String path3=null;
					jsonObject.put("tag","myspecials");
					jsonObject.put("brandspecialId",o2[0].toString());	
					jsonObject.put("createdon",DateUtility.formatDate(o2[1].toString()));	
					jsonObject.put("specialmsg",o2[2].toString());	
					jsonObject.put("specialdesc",o2[3].toString());	
					jsonObject.put("brandId",o2[4].toString());	
					jsonObject.put("myspecialchildId",o2[5].toString());
					path3=LolaConstants.url+o2[6].toString();
					jsonObject.put("childimagepath",path3);	
					jsonObject.put("content",o2[7].toString());	
					jsonArray.put(jsonObject);
				}
				
				parentObject.put("My_Specials", jsonArray);				
			}
			
			else{
				jsonArray = new JSONArray();
				parentObject.put("My_Specials", jsonArray);
				
			}
			
			
			if(osDetails.size()>0)
			{
				jsonArray = new JSONArray();
				for(Object[] o3:osDetails){
					jsonObject = new JSONObject();
					String path4=null;
					jsonObject.put("tag","onSale");
					jsonObject.put("onsaleId",o3[0].toString());
					jsonObject.put("createdon",DateUtility.formatDate(o3[1].toString()));	
					jsonObject.put("onsalemsg",o3[2].toString());	
					jsonObject.put("onsaledesc",o3[3].toString());	
					jsonObject.put("brandId",o3[4].toString());
					path4=LolaConstants.url+o3[5].toString();
					jsonObject.put("onsaleimage",path4);	
					jsonObject.put("content",o3[6].toString());	
					
					//jsonObject.put("childimagepath",o2[6].toString());	
					//jsonObject.put("content",o2[7].toString());	
					jsonArray.put(jsonObject);
				}
				
				parentObject.put("On_Sale", jsonArray);				
			}
			
			else{
				jsonArray = new JSONArray();
				parentObject.put("On_Sale", jsonArray);
				
			}
			
			
			
			
			
			if(dnoDetails.size()==0 && naDetails.size()==0 && sDetails.size()==0 && osDetails.size()==0)
			{
				parentObject.put("Status", "Failure");
				parentObject.put("Message", "No Records");			
			}
			else
			{
				parentObject.put("Status", "Success");
			}
		}catch(Exception e)
		{
			JSONObject jsonError = new JSONObject();
			jsonError.put("Status", "Failure");
			jsonError.put("Message", "No Records");
			System.out.println(e);
			return jsonError.toString();			
		}

		return parentObject.toString();
	}
	
	
	
	//Notification Count for DealsAndOffers
	
	
public String getNotificationCountForDealsnOffers(int userid) throws Exception{
		
		try{
			obj=new JSONObject();
	int notification=	dealsnOffersNotiDaoImpl.getMyDealsnOffersCount(userid);
		String notificationCount=String.valueOf(notification);
		obj.put("Status","Success");
		obj.put("NotificationCount", notificationCount);
		return obj.toString();
		}
		catch(Exception e){
			JSONObject jsonError = new JSONObject();
			jsonError.put("Status", "Failure");
			jsonError.put("Error Msg", e.toString());
			
			return jsonError.toString();
		}
	}


public String getUserNotificationDetailsForDealsnOffers(int userId) throws Exception{
	JSONObject jsonObject = null;
	JSONArray jsonArray = null;;
	JSONObject parentObject = new JSONObject();		

	try{


		List<Object[]> dnoDetails=dealsnOffersNotiDaoImpl.getMyDealsnOffersDetails(userId);
		
		if(dnoDetails.size()>0){
			jsonArray = new JSONArray();
			for(Object[] o:dnoDetails){
				jsonObject = new JSONObject();					
				jsonObject.put("dealandofferId",o[0].toString());	
				jsonObject.put("createdon",o[1].toString());	
				jsonObject.put("offermsg",o[2].toString());	
				jsonObject.put("dealDesc",o[3].toString());	
				jsonObject.put("brandId",o[4].toString());	
				jsonArray.put(jsonObject);
			}
			parentObject.put("Deals_and_Offers", jsonArray);
		}
		if(dnoDetails.size()==0 )
		{
			parentObject.put("Status", "Failure");
			parentObject.put("Message", "No Records");			
		}
		else
		{
			parentObject.put("Status", "Success");
		}
	}catch(Exception e)
	{
		JSONObject jsonError = new JSONObject();
		jsonError.put("Status", "Failure");
		jsonError.put("Error Msg", e.toString());
		
		return jsonError.toString();			
	}

	return parentObject.toString();
}

//Notification Count for MySpecials

public String getNotificationCountForMySpecials(int userid) throws Exception{
	
	try{
		obj=new JSONObject();
int notification=	specialNotiDaoImpl.getMySpecailsCount(userid);
	String notificationCount=String.valueOf(notification);
	obj.put("Status","Success");
	obj.put("NotificationCount", notificationCount);
	return obj.toString();
	}
	catch(Exception e){
		JSONObject jsonError = new JSONObject();
		jsonError.put("Status", "Failure");
		jsonError.put("Error Msg", e.toString());
		
		return jsonError.toString();
	}
}


public String getUserNotificationDetailsForMySpecials(int userId) throws Exception{
JSONObject jsonObject = null;
JSONArray jsonArray = null;;
JSONObject parentObject = new JSONObject();		

try{


	List<Object[]> sDetails=specialNotiDaoImpl.getMySpecailsDetails(userId);
	
	if(sDetails.size()>0)
	{
		jsonArray = new JSONArray();
		for(Object[] o2:sDetails){
			jsonObject = new JSONObject();					
			jsonObject.put("brandspecialId",o2[0].toString());	
			jsonObject.put("createdon",o2[1].toString());	
			jsonObject.put("specialmsg",o2[2].toString());	
			jsonObject.put("specialdesc",o2[3].toString());	
			jsonObject.put("brandId",o2[4].toString());	
			jsonArray.put(jsonObject);
		}
		
		parentObject.put("My_Specials", jsonArray);				
	}
	if(  sDetails.size()==0)
	{
		parentObject.put("Status", "Failure");
		parentObject.put("Message", "No Records");			
	}
	else
	{
		parentObject.put("Status", "Success");
	}
}catch(Exception e)
{
	JSONObject jsonError = new JSONObject();
	jsonError.put("Status", "Failure");
	jsonError.put("Error Msg", e.toString());
	
	return jsonError.toString();			
}

return parentObject.toString();
}


//This is for users particular brand Notification count

//JSONArray jsonArray = new JSONArray();

//JSONObject obj =null; 

public String getNotificationCountforParticularBrand(int userid,int brandid) throws Exception{
	
	try{
		obj=new JSONObject();
int notification=	dealsnOffersNotiDaoImpl.getMyDealsnOffersCount(userid, brandid)+newArrivalNotiDaoImpl.getMyNewArrivalsCount(userid, brandid)+specialNotiDaoImpl.getMySpecailsCount(userid, brandid);
	String notificationCount=String.valueOf(notification);
	obj.put("Status","Success");
	obj.put("NotificationCount", notificationCount);
	
	return obj.toString();
	}
	catch(Exception e){
		JSONObject jsonError = new JSONObject();
		jsonError.put("Status", "Failure");
		jsonError.put("Error Msg", e.toString());
		
		return jsonError.toString();
	}
}



public String getUserNotificationDetailsForParticularBrand(int userId,int brandid) throws Exception{
	JSONObject jsonObject = null;
	JSONArray jsonArray = null;;
	JSONObject parentObject = new JSONObject();		
//	JSONArray jsonArray1 = new JSONArray();
//	JSONArray jsonArray2 = new JSONArray();
//	JSONObject jsonParent = new JSONObject();
//	JSONObject jsonParent1 = new JSONObject();
//	JSONObject jsonParent2 = new JSONObject();
//	JSONArray jsonParentArray = new JSONArray();
//	JSONArray jsonParentArray1 = new JSONArray();
//	JSONArray jsonParentArray2 = new JSONArray();
	//String myDealsnOffers = "0";
	try{


		List<Object[]> dnoDetails=dealsnOffersNotiDaoImpl.getMyDealsnOffersDetails(userId, brandid);
		List<Object[]> naDetails=newArrivalNotiDaoImpl.getMyNewArrivalsDetails(userId, brandid);
		List<Object[]> sDetails=specialNotiDaoImpl.getMySpecailsDetails(userId, brandid);
		
		if(dnoDetails.size()>0){
			jsonArray = new JSONArray();
			for(Object[] o:dnoDetails){
				jsonObject = new JSONObject();					
				jsonObject.put("dealandofferId",o[0].toString());	
				jsonObject.put("createdon",o[1].toString());	
				jsonObject.put("offermsg",o[2].toString());	
				jsonObject.put("dealDesc",o[3].toString());	
				jsonArray.put(jsonObject);
			}
			parentObject.put("Deals_and_Offers", jsonArray);
		}
		if(naDetails.size()>0){
			jsonArray = new JSONArray();
			for(Object[] o1:naDetails){
				jsonObject = new JSONObject();					
				jsonObject.put("newarrivalId",o1[0].toString());	
				jsonObject.put("createdon",o1[1].toString());	
				jsonObject.put("newarrivalmsg",o1[2].toString());	
				jsonObject.put("newarrivaldesc",o1[3].toString());	
				jsonArray.put(jsonObject);
			}
			parentObject.put("New_Arrivals", jsonArray);
		}

		if(sDetails.size()>0)
		{
			jsonArray = new JSONArray();
			for(Object[] o2:sDetails){
				jsonObject = new JSONObject();					
				jsonObject.put("brandspecialId",o2[0].toString());	
				jsonObject.put("createdon",o2[1].toString());	
				jsonObject.put("specialmsg",o2[2].toString());	
				jsonObject.put("specialdesc",o2[3].toString());	
				jsonArray.put(jsonObject);
			}
			
			parentObject.put("My_Specials", jsonArray);				
		}
		if(dnoDetails.size()==0 && naDetails.size()==0 && sDetails.size()==0)
		{
			parentObject.put("Status", "Failure");
			parentObject.put("Message", "No Records");			
		}
		else
		{
			parentObject.put("Status", "Success");
		}
	}catch(Exception e)
	{
		JSONObject jsonError = new JSONObject();
		jsonError.put("Status", "Failure");
		jsonError.put("Error Msg", e.toString());
		
		return jsonError.toString();			
	}

	return parentObject.toString();
}



	public static void main(String args[]) throws Exception
	{

		UserNotificationUtility userNotificationUtility = new UserNotificationUtility();
		System.out.println(userNotificationUtility.getNotificationCount(1));
		System.out.println("**** "+userNotificationUtility.getUserNotificationDetails(1));
		//System.out.println(userNotificationUtility.getUserNotificationDetailsForParticularBrand(1, 2));
	}
	
	
	
	
	
}
