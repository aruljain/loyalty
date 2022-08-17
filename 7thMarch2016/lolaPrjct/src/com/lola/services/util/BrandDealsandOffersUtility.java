package com.lola.services.util;

import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.lola.dao.BrandDao;
import com.lola.dao.BrandDaoImpl;
import com.lola.dao.BrandDealsandOffersDao;
import com.lola.dao.BrandDealsandOffersDaoImpl;
import com.lola.dao.BrandShowRoomDao;
import com.lola.dao.BrandShowRoomDaoImpl;
import com.lola.dao.UserBrandDao;
import com.lola.dao.UserBrandDaoImpl;
import com.lola.dao.UserDao;
import com.lola.dao.UserDaoImpl;
import com.lola.model.BrandDealsandOffers;
import com.lola.model.MySpecialsChild;

public class BrandDealsandOffersUtility {


	BrandDealsandOffersDao brandDealsandOffersDaoImpl= new BrandDealsandOffersDaoImpl();
BrandShowRoomDao brandShowroomsDaoImpl=new BrandShowRoomDaoImpl();
	
	UserDao userDaoImpl=new UserDaoImpl();
	BrandDao brand = new BrandDaoImpl();
	
	

	public String getAllbrandsDealsandOffersByCategoryIdWithLimit(int categoryId, int start, int offset) throws Exception
	{
		JSONObject jsonObject = null;
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonParent = new JSONObject();

		try{
			BrandDealsandOffersDao  brandDealsandOffersDaoImpl=new BrandDealsandOffersDaoImpl();

			List<BrandDealsandOffers> brandDealsandOffers = brandDealsandOffersDaoImpl.getAllbrandsDealsandOffersByCategoryIdWithLimit(categoryId,start,offset);

			if(brandDealsandOffers.size()>0){

				for(int i=0;i<brandDealsandOffers.size();i++)
				{
					jsonObject = new JSONObject();
					BrandDealsandOffers branddealsandoffers = (BrandDealsandOffers) brandDealsandOffers.get(i);
					jsonObject.put("brandId",branddealsandoffers.getBrandId());
					jsonObject.put("imagepath",branddealsandoffers.getOfferImage());

					jsonArray.put(jsonObject);

				}
				jsonParent.put("Data", jsonArray);
				jsonParent.put("Status", "Success");
			}else{


				jsonParent.put("Status", "Failure");
				jsonParent.put("Message", "No Records for BrandDealsandOffers");

			}
		}
		catch(Exception e)
		{
			JSONObject jsonError = new JSONObject();
			jsonError.put("Status", "Failed");
			//jsonError.put("Error Msg", e.toString());
			jsonError.put("Message", "No Records for BrandDealsandOffers");
			return jsonError.toString();
		}

		return  jsonParent.toString();
	}

	public String getMyDealsandOffersbyUserId(int userid) throws Exception{
		/*JSONObject jsonObject = null;
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonParent = new JSONObject();
		JSONArray jsonParentArray = new JSONArray();*/
		String myDealsnOffers = "0";
		try{


			List<Object> brandDealsandOffers=brandDealsandOffersDaoImpl.getMyDealsandOffersbyUserId(userid);
			if(brandDealsandOffers.size()>0){
				for(Object o:brandDealsandOffers){
					//jsonObject = new JSONObject();
					myDealsnOffers = o.toString();
					//	jsonObject.put("MyDealsandOffers",o.toString());		
				}
				//	jsonArray.put(jsonObject);
				//	jsonParent.put("Data", jsonArray);
				//	jsonParent.put("Status", "Success");
				//jsonParentArray.put(jsonParent);
			}
			else
			{
				//jsonObject = new JSONObject();
				return myDealsnOffers;
				//jsonObject.put("MyDealsandOffers","0");	
				//	jsonArray.put(jsonObject);
				//	jsonParent.put("Data", jsonArray);
				//	jsonParent.put("Status", "Success");
				//jsonParentArray.put(jsonParent);
			}
		}catch(Exception e)
		{
			//JSONObject jsonError = new JSONObject();
			//	jsonError.put("Status", "Failure");
			//	jsonError.put("Error Msg", e.toString());
		//	jsonParentArray.put(jsonError);
		//	return jsonParentArray.toString();
			return myDealsnOffers;
		}

		return myDealsnOffers;
	}
	
	public String getMyDealsandOffers(int userid,int categoryId) throws Exception{
		JSONObject jsonObject = null;
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonParent = new JSONObject();
		JSONArray jsonParentArray = new JSONArray();
		String myDealsnOffers = "0";
		String path=null;
		try{


			List<Object[]> brandDealsandOffers=brandDealsandOffersDaoImpl.getMyDealsandOffers(userid,categoryId);
			if(brandDealsandOffers.size()>0){
				for(Object[] o:brandDealsandOffers){
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

	
	/*public String getMyDealsandOffersbyBrandId(int brandId, int userId) throws Exception{
		JSONObject jsonObject = null;
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonParent = new JSONObject();
		JSONArray jsonParentArray = new JSONArray();
		
		String path1=null;
		
		String path ="";
		String brandName ="";
		try{

			String location = userDaoImpl.getUserLocation(userId);
			List<Object[]> brandDealsandOffers=brandDealsandOffersDaoImpl.getMyDealsandOffersbyBrandId(brandId,userId);
			List<Object[]> likedBrandDealsandOffers=brandDealsandOffersDaoImpl.getLikedMyDealsandOffersbyBrandId(brandId,userId);
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

			
			if(brandDealsandOffers.size()>0 || likedBrandDealsandOffers.size()>0){			
			
			if(brandDealsandOffers.size()>0){
				for(Object[] o:brandDealsandOffers){
					jsonObject = new JSONObject();		
					jsonObject.put("dealandofferId",o[0].toString());
					jsonObject.put("brandId",o[1].toString());	
					path1=LolaConstants.url+o[2].toString();
					jsonObject.put("imagepath",path1);	
					jsonObject.put("content",o[3].toString());					
					jsonObject.put("desc",o[4].toString());
					jsonObject.put("like",o[5].toString());
					jsonArray.put(jsonObject);
				}
										
					
			}
			
			
			if(likedBrandDealsandOffers.size()>0){
				for(Object[] o:likedBrandDealsandOffers){
					jsonObject = new JSONObject();		
					jsonObject.put("dealandofferId",o[0].toString());
					jsonObject.put("brandId",o[1].toString());	
					path1=LolaConstants.url+o[2].toString();
					jsonObject.put("imagepath",path1);	
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
	}

	
	
	
	
	
	
	
	
	
	*/
	
	
	/////////////////////////////////////
	
	
	public String getMyDealsandOffersbyBrandId(int brandId, int userId) throws Exception{
		JSONObject jsonObject = null;
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonParent = new JSONObject();
		JSONArray jsonParentArray = new JSONArray();
		
		String path1=null;
		String path2=null;
		String path3=null;
		
		String path ="";
		String brandName ="";
		try{

			String location = userDaoImpl.getUserLocation(userId);
			List<Object[]> brandCount=brandDealsandOffersDaoImpl.getLikedAndUnlikedDealsOfferbyBrandId(brandId, userId);
			List<Object[]> brandCount1=brandDealsandOffersDaoImpl.getUnlikedDealAndOfferbyBrandId(brandId, userId);
			List<Object[]> brandCount2=brandDealsandOffersDaoImpl.getDealAndOfferbyBrandId(brandId);
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
					jsonObject.put("dealandofferId",o[0].toString());
					jsonObject.put("desc",o[4].toString());
					jsonObject.put("like",o[5].toString());
					jsonObject.put("book",o[6].toString());
					jsonObject.put("available",o[7].toString());
					jsonObject.put("bookable",o[8].toString());
					jsonObject.put("brandshopid",o[9].toString());
					
					jsonArray.put(jsonObject);
				}
				if(brandCount1.size()>0){
					for(Object[] o:brandCount1){
						jsonObject = new JSONObject();					
						jsonObject.put("brandId",o[1].toString());	
						path2=LolaConstants.url+o[2].toString();
						jsonObject.put("imagepath",path2);	
						jsonObject.put("content",o[3].toString());
						jsonObject.put("dealandofferId",o[0].toString());
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
				if(brandCount2.size()>0){
					for(Object[] o:brandCount2){
						jsonObject = new JSONObject();					
						jsonObject.put("brandId",o[0].toString());	
						path3=LolaConstants.url+o[1].toString();
						jsonObject.put("imagepath",path3);	
						jsonObject.put("content",o[2].toString());
						jsonObject.put("dealandofferId",o[3].toString());
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
	

	
	/*public String saveDealsAndOffersLeavePage(int userId,int dealandofferId) throws Exception{
		JSONObject jsonObject = null;
		String Msg=null;
		try{
			List<BrandDealsandOffers> brandDealsandOffers=brandDealsandOffersDaoImpl.findBydealandofferId(dealandofferId);
		if(brandDealsandOffers.size()>0){
			for(BrandDealsandOffers entity:brandDealsandOffers){
				entity.setUserId(userId);
				//entity.setMyspecialchildId(myspecialchildId);
				if(entity.isLiked()){
				entity.setLiked(false);
				Msg="Unliked";}
				else{
					entity.setLiked(true);
				 Msg="Liked";}
				brandDealsandOffersDaoImpl.update(entity);
			}
		
		}
		jsonObject =new JSONObject();
		jsonObject.put("Status","Success");
		//jsonObject
		jsonObject.put("Message",Msg);
		return jsonObject.toString();
	}
		catch(Exception e){
			jsonObject =new JSONObject();
			jsonObject.put("Status", "Failure");
			jsonObject.put("Message"," ");
			return jsonObject.toString();
		
	}
		}*/

	public static void main(String args[]) throws Exception
	{

		BrandDealsandOffersUtility brandImagesUtility = new BrandDealsandOffersUtility();

		System.out.println( brandImagesUtility.getMyDealsandOffersbyBrandId(2,41));
	//	System.out.println(brandImagesUtility.saveDealsAndOffersLeavePage(99, 3));
		//System.out.println( brandImagesUtility.getMyDealsandOffers(41, 2));
		
	}	

}
