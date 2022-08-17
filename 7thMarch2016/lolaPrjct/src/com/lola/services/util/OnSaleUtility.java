package com.lola.services.util;

import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.lola.dao.BrandDao;
import com.lola.dao.BrandDaoImpl;
import com.lola.dao.BrandShowRoomDao;
import com.lola.dao.BrandShowRoomDaoImpl;
import com.lola.dao.OnSaleDao;
import com.lola.dao.OnSaleDaoImlp;
import com.lola.dao.UserDao;
import com.lola.dao.UserDaoImpl;

public class OnSaleUtility {
	OnSaleDao onSaleDaoImlp =new OnSaleDaoImlp();
	UserDao userDaoImpl=new UserDaoImpl();
	BrandShowRoomDao brandShowroomsDaoImpl=new BrandShowRoomDaoImpl();
	BrandDao brand = new BrandDaoImpl();
	
	
	public String getMyOnSale(int userId, int categoryId) throws Exception {
		
	JSONObject jsonObject = null;
	JSONArray jsonArray = new JSONArray();
	JSONObject jsonParent = new JSONObject();
	JSONArray jsonParentArray = new JSONArray();
	String myOnSale = "0";
	String path=null;
	try{


		List<Object[]> onsale=onSaleDaoImlp.getMyOnSale(userId, categoryId);
		if(onsale.size()>0){
			for(Object[] o:onsale){
				jsonObject = new JSONObject();					
				jsonObject.put("brandId",o[0].toString());	
				path=LolaConstants.url+o[1].toString();
				jsonObject.put("imagepath",path);
				jsonObject.put("desc",o[2].toString());
				//jsonObject.put("like",o[3].toString());
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
			jsonError.put("Message", "No Records");
		jsonParentArray.put(jsonError);
		return jsonParentArray.toString();			
	}

	return jsonParent.toString().replace("\\", "");

}
	
	
	
	//
	
	
	public String getOnSalebyUserId(int userId) throws Exception{
		
		String myDealsnOffers = "0";
		try{


			List<Object> onsale=onSaleDaoImlp.getOnSalebyUserId(userId);
			if(onsale.size()>0){
				for(Object o:onsale){
					
					myDealsnOffers = o.toString();
							
				}
				
			}
			else
			{
				
				return myDealsnOffers;
				
			}
		}catch(Exception e)
		{
			
			return myDealsnOffers;
		}

		return myDealsnOffers;
	}
	
	
	//
	

	
	public String getOnSalebyBrandId(int brandId, int userid) throws Exception{
		JSONObject jsonObject = null;
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonParent = new JSONObject();
		JSONArray jsonParentArray = new JSONArray();
		String myDealsnOffers = "0";
		String path1=null;
		String path2=null;
		String path3=null;
		
		String path ="";
		String brandName ="";
		try{

			String location = userDaoImpl.getUserLocation(userid);
			//List<Object[]> brandDealsandOffers=brandDealsandOffersDaoImpl.getMyDealsandOffersbyBrandId(brandId);
			 List<Object[]> brandCount=onSaleDaoImlp.getLikedAndUnlikedOnSalebyBrandId(brandId, userid);
			 List<Object[]> brandCount1=onSaleDaoImlp.getonSalebyBrandId(brandId);
			 List<Object[]> brandCount2=onSaleDaoImlp.getUnlikedOnSalebyBrandId(brandId, userid);
			List<Object[]> brandshowroomdetails=(List<Object[]>) brandShowroomsDaoImpl.getBrandShowroom(brandId);
			List<Object[]> brandDetails	=brand.getBrandLogo(brandId);
			
			if(brandDetails.size()>0){
				for(Object[] o : brandDetails){
					if(o[1]!=null)
					path = LolaConstants.url+o[1].toString(); 
					else
						path="";
				if(o[0]!=null)
					brandName = o[0].toString(); 
					else
						brandName="";
				System.out.println(path);
				jsonParent.put("Logopath",path);
				jsonParent.put("brandname",brandName);
				}
			}else{
				jsonParent.put("Logopath","");
			}
			
			if(brandshowroomdetails.size()>0){

				for(Object[] o: brandshowroomdetails){
					
						
						if(o[0]!=null)
							jsonParent.put("location",o[0].toString());
						else
							jsonParent.put("location","");
						
						if(o[2]!=null)
							jsonParent.put("address",o[1].toString());
						else
							jsonParent.put("address","");

						if(o[0]!=null)
							jsonParent.put("contact",o[3].toString());
						else
							jsonParent.put("contact","");
						if(o[1]!=null)
							jsonParent.put("email",o[2].toString());
						else
							jsonParent.put("email","");
						if(o[3]!=null)
							jsonParent.put("shoptimings",o[6].toString());
						else
							jsonParent.put("shoptimings","");
						if(o[4]!=null){
							jsonParent.put("lattitude",o[4].toString());
							System.out.println("Lat :"+o[4].toString());
						}
						else
							jsonParent.put("lattitude","");
						System.out.println("Lat :"+o[4].toString());
						if(o[5]!=null)
							jsonParent.put("longtitude",o[5].toString());
						else
							jsonParent.put("longtitude","");




				}


			}else{
				jsonParent.put("address","Guindy, Chennai");
				jsonParent.put("contact","91 8754300277");
				jsonParent.put("email","arulkumar.a@truetechsolutions.in");
				jsonParent.put("shoptimings","11:00AM to 10:30PM");
			}

			
			
			if(brandCount.size()>0){
				for(Object[] o:brandCount){
					jsonObject = new JSONObject();					
					jsonObject.put("brandId",o[1].toString());	
					path1=LolaConstants.url+o[2].toString();
					jsonObject.put("imagepath",path1);	
					jsonObject.put("content",o[3].toString());
					jsonObject.put("onsaleId",o[0].toString());
					jsonObject.put("desc",o[4].toString());
					jsonObject.put("like",o[5].toString());
					jsonObject.put("book",o[6].toString());
					jsonObject.put("available",o[7].toString());
					jsonObject.put("bookable",o[8].toString());
					jsonObject.put("brandshopid",o[9].toString());
					jsonArray.put(jsonObject);
				}
				if(brandCount2.size()>0){
					for(Object[] o:brandCount2){
						jsonObject = new JSONObject();					
						jsonObject.put("brandId",o[1].toString());	
						path2=LolaConstants.url+o[2].toString();
						jsonObject.put("imagepath",path2);	
						jsonObject.put("content",o[3].toString());
						jsonObject.put("onsaleId",o[0].toString());
						jsonObject.put("desc",o[4].toString());
						jsonObject.put("like","false");
						jsonObject.put("book","false");
						jsonObject.put("available",o[5].toString());
						jsonObject.put("bookable",o[6].toString());
						jsonObject.put("brandshopid",o[7].toString());
						jsonArray.put(jsonObject);
					}
				}
				
										
					jsonParent.put("Status", "Success");
					jsonParent.put("Data", jsonArray);
					
				jsonParentArray.put(jsonParent);
			}
			else
			{
				if(brandCount1.size()>0){
					for(Object[] o:brandCount1){
						jsonObject = new JSONObject();					
						jsonObject.put("brandId",o[0].toString());	
						path3=LolaConstants.url+o[1].toString();
						jsonObject.put("imagepath",path3);	
						jsonObject.put("content",o[2].toString());
						jsonObject.put("onsaleId",o[3].toString());
						jsonObject.put("desc",o[4].toString());
						jsonObject.put("like","false");
						jsonObject.put("book","false");
						jsonObject.put("available",o[5].toString());
						jsonObject.put("bookable",o[6].toString());
						jsonObject.put("brandshopid",o[7].toString());
						jsonArray.put(jsonObject);
					}
											
						jsonParent.put("Status", "Success");
						jsonParent.put("Data", jsonArray);
						
					jsonParentArray.put(jsonParent);
			}
		}}
		catch(Exception e)
		{
			JSONObject jsonError = new JSONObject();
				jsonError.put("Status", "Failure");
				jsonError.put("Message", "No Records");
			jsonParentArray.put(jsonError);
			return jsonParentArray.toString();			
		}

		return jsonParent.toString().replace("\\", "");
	}
	
	
	
	
	/*public String getOnSalebyBrandId(int brandId, int userId) throws Exception{
		JSONObject jsonObject = null;
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonParent = new JSONObject();
		JSONArray jsonParentArray = new JSONArray();
		
		String path1=null;
		String path2=null;
		
		String path ="";
		String brandName ="";
		try{

			String location = userDaoImpl.getUserLocation(userId);
			List<Object[]> onsale=onSaleDaoImlp.getOnSalebyBrandId(brandId, userId);
			List<Object[]> likedonsale=onSaleDaoImlp.getLikedOnSalebyBrandId(brandId, userId);
			List<Object[]> brandshowroomdetails=(List<Object[]>) brandShowroomsDaoImpl.getBrandShowroomDetails(brandId, location);
			List<Object[]> brandDetails	=brand.getBrandLogo(brandId);
			
			if(brandDetails.size()>0){
				for(Object[] o : brandDetails){
					if(o[1]!=null)
					path = LolaConstants.url+o[1].toString(); 
					else
						path="";
				if(o[0]!=null)
					brandName = o[0].toString(); 
					else
						brandName="";
				System.out.println(path);
				jsonParent.put("Logopath",path);
				jsonParent.put("brandname",brandName);
				}
			}else{
				jsonParent.put("Logopath","");
			}
			
			if(brandshowroomdetails.size()>0){

				for(Object[] o: brandshowroomdetails){
					if(o[2]!=null)
						jsonParent.put("address",o[2].toString());
					else
						jsonParent.put("address","");

					if(o[0]!=null)
						jsonParent.put("contact",o[0].toString());
					else
						jsonParent.put("contact","");
					if(o[1]!=null)
						jsonParent.put("email",o[1].toString());
					else
						jsonParent.put("email","");
					if(o[3]!=null)
						jsonParent.put("shoptimings",o[3].toString());
					else
						jsonParent.put("shoptimings","");


				}


			}else{
				jsonParent.put("address","Guindy, Chennai");
				jsonParent.put("contact","91 8754300277");
				jsonParent.put("email","arulkumar.a@truetechsolutions.in");
				jsonParent.put("shoptimings","11:00AM to 10:30PM");
			}

			
			if(onsale.size()>0 || likedonsale.size()>0){			
			
			if(onsale.size()>0){
				for(Object[] o:onsale){
					jsonObject = new JSONObject();		
					jsonObject.put("onSaleId",o[0].toString());
					jsonObject.put("brandId",o[1].toString());	
					path1=LolaConstants.url+o[2].toString();
					jsonObject.put("imagepath",path1);	
					jsonObject.put("content",o[3].toString());					
					jsonObject.put("desc",o[4].toString());
					jsonObject.put("like",o[5].toString());
					jsonArray.put(jsonObject);
				}
										
					
			}
			
			
			if(likedonsale.size()>0){
				for(Object[] o:likedonsale){
					jsonObject = new JSONObject();		
					jsonObject.put("onSaleId",o[0].toString());
					jsonObject.put("brandId",o[1].toString());	
					path2=LolaConstants.url+o[2].toString();
					jsonObject.put("imagepath",path2);	
					jsonObject.put("content",o[3].toString());					
					jsonObject.put("desc",o[4].toString());
					jsonObject.put("like",o[5].toString());
					jsonArray.put(jsonObject);
				}
										
					
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
				jsonError.put("Message", "No Records");
			jsonParentArray.put(jsonError);
			return jsonParentArray.toString();			
		}

		return jsonParent.toString().replace("\\", "");
	}*/
	public static void main(String[] args) throws Exception{
		OnSaleUtility OnSaleUtility= new OnSaleUtility();
		//System.out.println(OnSaleUtility.getMyOnSale(1, 2));
		//System.out.println(OnSaleUtility.getOnSalebyUserId(1));
		System.out.println(OnSaleUtility.getOnSalebyBrandId(2, 1));
	}
}