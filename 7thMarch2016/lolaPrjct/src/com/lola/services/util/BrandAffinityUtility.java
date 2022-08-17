package com.lola.services.util;

import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.lola.dao.BrandBannerDao;
import com.lola.dao.BrandBannerDaoImpl;
import com.lola.dao.BrandBucketDao;
import com.lola.dao.BrandBucketDaoImpl;
import com.lola.dao.BrandDao;
import com.lola.dao.BrandDaoImpl;
import com.lola.dao.BrandShowRoomDao;
import com.lola.dao.BrandShowRoomDaoImpl;
import com.lola.dao.BucketMasterDao;
import com.lola.dao.BucketMasterDaoImpl;
import com.lola.dao.UserBrandDao;
import com.lola.dao.UserBrandDaoImpl;
import com.lola.dao.UserDao;
import com.lola.dao.UserDaoImpl;
import com.lola.model.BrandShowRoom;
import com.lola.model.User;

public class BrandAffinityUtility {

	LolaConstants lolaConstants =new LolaConstants();
	UserBrandDao userbrandDaoImpl= new UserBrandDaoImpl();
	UserDao userDaoImpl=new UserDaoImpl();
	BrandBannerDao brandBannerDaoImpl =new BrandBannerDaoImpl();
	BrandDao brand = new BrandDaoImpl();
	BrandBucketDao brandBucketDaoImpl=new BrandBucketDaoImpl();
	BrandShowRoomDao brandShowroomsDaoImpl=new BrandShowRoomDaoImpl();
	BucketMasterDao bucketMasterDaoImpl=new BucketMasterDaoImpl();
	UserBrandloyalityPointUtility userBrandloyalityPointUtility=new UserBrandloyalityPointUtility();


	public String getBrandAffinityDetails(int userid,int brandid,double lat,double lng, float dist) throws Exception{
		String path ="";
		String brandName ="";
		String colortheme ="";
		JSONObject jsonObject = null;
		JSONObject jsonObject1 = null;
		//JSONObject jsonObject2 = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonParent = new JSONObject();
		JSONArray jsonParentArray = new JSONArray();



		//String location = userDaoImpl.getUserLocation(userid);

		String brandids = userbrandDaoImpl.getBrandidsByUserId(userid);
		List<BrandShowRoom> brandshowroomdetails=(List<BrandShowRoom>) brandShowroomsDaoImpl.getBrandShowroomDetails(brandid, lat,lng,dist);
		List<Object[]> brandDetails	=brand.getBrandLogo(brandid);
		List<Object> userbrands = userbrandDaoImpl.getUserPointsByBrandid(userid, brandid);
		int  expiringpoints=userBrandloyalityPointUtility.expiringPointsCal(userid, brandid);
		List<Object[]> bannerimage=brandBannerDaoImpl.getBrandBanner(brandid);
		List<Object[]>	bucketDetails=(List<Object[]>) bucketMasterDaoImpl.getBucketDetails(brandid);
		String s=null;
		String bannerim=null;
		try{
			jsonObject=	new JSONObject();
			if(brandids.equals(""))
			{
				jsonObject.put("Status", "Failure");
				jsonObject.put("Message", "User has no brands");
			}
			else
			{
				jsonObject.put("Status", "Success");
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
					//System.out.println(path);
					
					
					if(o[5]!=null)
						colortheme = o[5].toString(); 
						else
							colortheme="";
					
					
					jsonObject.put("Logopath",path);
					jsonObject.put("brandname",brandName);
					jsonObject.put("colortheme",colortheme);
					}
				}else
					jsonObject.put("Logopath","");

				
				if(brandshowroomdetails.size()>0){
					
					 for(BrandShowRoom o:brandshowroomdetails){
						   System.out.println(o.getLocation()+"   "+o.getLattitude()+"    "+o.getLongtitude()+"   "+o.getBrandid());  
						   if(o.getAddress()!=null)
								jsonObject.put("address",o.getAddress().toString());
							else
								jsonObject.put("address","");
						   if(o.getPhonenumber()!=null)
								jsonObject.put("contact",o.getPhonenumber().toString());
							else
								jsonObject.put("contact","");
						   if(o.getEmailId()!=null)
								jsonObject.put("email",o.getEmailId().toString());
							else
								jsonObject.put("email","");
						   if(o.getShoptimings()!=null)
								jsonObject.put("shoptimings",o.getShoptimings().toString());
							else
								jsonObject.put("shoptimings","");
						   
						   if(o.getLattitude()!=null)
								jsonObject.put("lattitude",o.getLattitude());
							else
								jsonObject.put("lattitude","");
							if(o.getLongtitude()!=null)
								jsonObject.put("longtitude",o.getLongtitude().toString());
							else
								jsonObject.put("longtitude","");
							
							if(o.getLocation()!=null)
								jsonObject.put("location",o.getLocation().toString());
							else
								jsonObject.put("location","");
							if(o.getPin()!=null)
								jsonObject.put("pin",o.getPin().toString());
							else
								jsonObject.put("pin","");
							
							if(o.getState()!=null)
								jsonObject.put("state",o.getState().toString());
							else
								jsonObject.put("state","");
							
							if(o.getWebsite()!=null)
								jsonObject.put("website",o.getWebsite().toString());
							else
								jsonObject.put("website","");
							
							if(o.getCountry()!=null)
								jsonObject.put("country",o.getCountry().toString());
							else
								jsonObject.put("country","");
							
							
						   
					   }

					
				}else{
					jsonObject.put("address","Guindy, Chennai");
					jsonObject.put("contact","91 8754300277");
					jsonObject.put("email","arulkumar.a@truetechsolutions.in");
					jsonObject.put("shoptimings","11:00AM to 10:30PM");
				}


				String TotalPoints="0";





				for(Object o:userbrands){



					if(o!=null){
						TotalPoints=o.toString();
						jsonObject.put("totalpoints",TotalPoints);
					}
					else
						jsonObject.put("totalpoints",TotalPoints);					
				}


				if(expiringpoints!=0)
					jsonObject.put("points about to expire",expiringpoints);
				else
					jsonObject.put("points about to expire",expiringpoints);	




				if(bannerimage.size()>0){

					for(Object[] i:bannerimage)
					{
						bannerim=LolaConstants.url+i[1].toString();
						jsonObject.put("bannerimage",bannerim);	

						break;
					}	

				}else
					jsonObject.put("bannerimage","");


				if(bucketDetails.size()>0){
					for(Object[] o:bucketDetails) {
						jsonObject1=new JSONObject(); 
						if(o[0]!=null)
							jsonObject1.put("bucketname",o[0].toString());
						else
							jsonObject1.put("bucketname","");
						if(o[1]!=null){
							s=LolaConstants.url+o[1].toString();
							jsonObject1.put("imagepath",s);}
						else
							jsonObject1.put("imagepath","");
						jsonArray.put(jsonObject1);
					}

				}else{
					jsonObject1=new JSONObject(); 
					jsonObject1.put("bucketname","");
					jsonObject1.put("imagepath","");
					jsonArray.put(jsonObject1);
				}

				jsonObject.put("buckets", jsonArray);

			}
			//jsonObject.put("Status", "Failure");

			//return jsonObject.toString();

		}
		catch(Exception e)
		{
			JSONObject jsonError = new JSONObject();
			jsonError.put("Status", "Failure");
			//jsonError.put("Error Msg", e.toString());
			jsonError.put("Message", "No Brands");
			return jsonError.toString();
		}


		//jsonObject.put("buckets", jsonArray);

		return jsonObject.toString().replace("\\", "");
	}

	public static void main(String args[]) throws Exception{
		BrandAffinityUtility brandAffinityUtility=new BrandAffinityUtility();
		System.out.println(brandAffinityUtility.getBrandAffinityDetails(41, 2,12.9758,80.2205,1));	
	}

}

