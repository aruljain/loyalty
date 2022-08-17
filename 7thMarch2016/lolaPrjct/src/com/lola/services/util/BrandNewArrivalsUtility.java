package com.lola.services.util;

import java.util.List;

import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONArray;

import com.lola.dao.BrandDao;
import com.lola.dao.BrandDaoImpl;
import com.lola.dao.BrandNewArrivalsDao;
import com.lola.dao.BrandNewArrivalsDaoImpl;
import com.lola.dao.BrandShowRoomDao;
import com.lola.dao.BrandShowRoomDaoImpl;
import com.lola.dao.UserDao;
import com.lola.dao.UserDaoImpl;
import com.lola.model.BrandDealsandOffers;
import com.lola.model.BrandNewArrivals;

public class BrandNewArrivalsUtility {

	BrandNewArrivalsDao brandNewArrivalsDaoImpl = new BrandNewArrivalsDaoImpl();

	BrandShowRoomDao brandShowroomsDaoImpl=new BrandShowRoomDaoImpl();

	UserDao userDaoImpl=new UserDaoImpl();
	BrandDao brand = new BrandDaoImpl();

	public String getNewArrivalsbyBrandId(int brandId, int userId) throws Exception{
		JSONObject jsonObject = null;
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonParent = new JSONObject();
		JSONArray jsonParentArray = new JSONArray();
		String myDealsnOffers = "0";
		try{

			String path=null;
			String path1=null;
			String path2=null;
			String path3=null;
			String brandName=null;

			String location = userDaoImpl.getUserLocation(userId);
			
			List<Object[]> brandshowroomdetails=(List<Object[]>) brandShowroomsDaoImpl.getBrandShowroom(brandId);
			List<Object[]> brandDetails	=brand.getBrandLogo(brandId);
			List<Object[]> brandNewArrivals=brandNewArrivalsDaoImpl.getNewArrivalsbyBrandId(brandId);
			List<Object[]> brandNewArrivals1=brandNewArrivalsDaoImpl.getLikedaAndUnlikedNewArrivalsbyBrandId(brandId,userId);
			List<Object[]> brandNewArrivals2=brandNewArrivalsDaoImpl.getUnlikedNewArrivalsbyBrandId(brandId,userId);
System.out.println("show room size :"+brandshowroomdetails.size());
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
			if(brandNewArrivals1.size()>0){
				for(Object[] o:brandNewArrivals1){
					jsonObject = new JSONObject();					
					jsonObject.put("brandId",o[1].toString());	
					path1=LolaConstants.url+o[2].toString();
					jsonObject.put("imagepath",path1);	
					jsonObject.put("content",o[3].toString());
					jsonObject.put("newarrivalId",o[0].toString());
					jsonObject.put("desc",o[4].toString());
					jsonObject.put("like",o[5].toString());
					jsonObject.put("book",o[6].toString());
					jsonObject.put("available",o[7].toString());
					jsonObject.put("bookable",o[8].toString());
					jsonObject.put("brandshopid",o[9].toString());
					jsonArray.put(jsonObject);
				}
				if(brandNewArrivals2.size()>0){
					for(Object[] o:brandNewArrivals2){
						jsonObject = new JSONObject();					
						jsonObject.put("brandId",o[1].toString());	
						path2=LolaConstants.url+o[2].toString();
						jsonObject.put("imagepath",path2);	
						jsonObject.put("content",o[3].toString());
						jsonObject.put("newarrivalId",o[0].toString());
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
				if(brandNewArrivals.size()>0){
					for(Object[] o:brandNewArrivals){
						jsonObject = new JSONObject();					
						jsonObject.put("brandId",o[0].toString());	
						path3=LolaConstants.url+o[1].toString();
						jsonObject.put("imagepath",path3);	
						jsonObject.put("content",o[2].toString());
						jsonObject.put("newarrivalId",o[3].toString());
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

		return jsonParent.toString().replace("\\", "");
	}

	/*public String saveNewArrivalsLeavePage(int userId,int newarrivalId) throws Exception{
		JSONObject jsonObject = null;
		String Msg=null;
		try{

			List<BrandNewArrivals> brandNewArrivals=brandNewArrivalsDaoImpl.findBynewarrivalId(newarrivalId);
		if(brandNewArrivals.size()>0){
			for(BrandNewArrivals entity:brandNewArrivals){

				entity.setUserId(userId);
				//entity.setMyspecialchildId(myspecialchildId);
				if(entity.isLiked()){
				entity.setLiked(false);
				Msg="Unliked";
				}
				else{
					entity.setLiked(true);
				 Msg="Liked";
				 }
				brandNewArrivalsDaoImpl.update(entity);
			}

		}
		jsonObject =new JSONObject();
		jsonObject.put("Status","Success");
		jsonObject.put("Message",Msg);
		return jsonObject.toString();
	}
		catch(Exception e){
			jsonObject =new JSONObject();
			jsonObject.put("Status", "Failure");
			jsonObject.put("Message",e);
			return jsonObject.toString();

	}
		}*/

	public static void main(String args[]) throws Exception
	{

		BrandNewArrivalsUtility brandNewArrivalsUtility = new BrandNewArrivalsUtility();

		//	System.out.println( brandNewArrivalsUtility.saveNewArrivalsLeavePage(297, 1));

		System.out.println(brandNewArrivalsUtility.getNewArrivalsbyBrandId(2,41));

	}

}
