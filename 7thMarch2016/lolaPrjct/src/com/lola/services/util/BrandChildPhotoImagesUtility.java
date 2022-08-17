package com.lola.services.util;

import java.util.Date;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.lola.dao.BrandChildPhotoImagesDao;
import com.lola.dao.BrandChildPhotoImagesDaoImpl;
import com.lola.dao.BrandDao;
import com.lola.dao.BrandDaoImpl;
import com.lola.dao.BrandPhotoImagesDao;
import com.lola.dao.BrandPhotoImagesDaoImpl;
import com.lola.dao.BrandShowRoomDao;
import com.lola.dao.BrandShowRoomDaoImpl;
import com.lola.dao.UserDao;
import com.lola.dao.UserDaoImpl;
import com.lola.model.BrandChildPhotoImages;
import com.lola.model.BrandDealsandOffers;

public class BrandChildPhotoImagesUtility {

	BrandPhotoImagesDao brandPhotoImagesDaoImpl = new BrandPhotoImagesDaoImpl();
	BrandChildPhotoImagesDao brandChildPhotoImagesDaoImpl =new BrandChildPhotoImagesDaoImpl();
	BrandShowRoomDao brandShowroomsDaoImpl=new BrandShowRoomDaoImpl();
	UserDao userDaoImpl=new UserDaoImpl();
	BrandDao brand = new BrandDaoImpl();
	

	public String getimagepathbyBrandId(int brandId,int userid) throws Exception{
		JSONObject jsonObject = null;
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonParent = new JSONObject();
		JSONArray jsonParentArray = new JSONArray();

		String parent = "";	
		String photoid ="";
		JSONArray jsonNewParentArray = new JSONArray();
		JSONObject jsonParentObject = null;
		JSONArray childArray =null;
		JSONArray childArray2 =null;
		try{
			
			String path = null;
			 String path1 = null;
	          String brandName=null;
	          
	          String location = userDaoImpl.getUserLocation(userid);
			
			//List<Object[]> brandPhotoImages=brandPhotoImagesDaoImpl.getaffinityCategoriesbyBrandId(brandId);
			List<Object[]> brandshowroomdetails=(List<Object[]>) brandShowroomsDaoImpl.getBrandShowroom(brandId);
			List<Object[]> brandDetails	=brand.getBrandLogo(brandId);
			List<Object[]> brandPhotoImages=brandPhotoImagesDaoImpl.getAffinityCategoriesbyBrandId(brandId,userid);
			List<Object[]> likedBrandPhotoImages=brandPhotoImagesDaoImpl.getLikedAffinityCategoriesbyBrandId(brandId,userid);

			int i=0;
			int c=0;
			
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
			
			
			if(brandPhotoImages.size()>0 || likedBrandPhotoImages.size()>0){
			
			
			if(brandPhotoImages.size()>0){
				for(Object[] o:brandPhotoImages){

					
					if(i==0)						
					{

						parent = o[0].toString();	
						photoid = o[1].toString();

						//jsonParentObject.put("affinityCategories",parent);
						//System.out.println(jsonParentObject);
						if(c==0){
							jsonParentObject = new JSONObject();	
							jsonParentObject.put("affinityCategories",parent);	
							childArray = new JSONArray();
						}
					}			
					if(photoid.equals(o[2].toString())){
						JSONObject childObject = new JSONObject();

						path=LolaConstants.url+o[3].toString();
						childObject.put("imagepath",path);
						childObject.put("content",o[4].toString());
						childObject.put("childphotoimageid",o[5].toString());						
						childObject.put("desc",o[6].toString());
						childObject.put("like", o[7].toString());
						childArray.put(childObject);
						if(c==0){
							jsonParentObject.put(parent+"_CHILD", childArray);	
							jsonNewParentArray.put(jsonParentObject);
						}		
						i=1;
						c=1;
					}						


					else{
						parent = o[0].toString();	
						photoid = o[1].toString();						 
						//jsonParentObject.put("affinityCategories",parent);
						//System.out.println(jsonParentObject);
						if(c==1){
							jsonParentObject = new JSONObject();	
							jsonParentObject.put("affinityCategories",parent);	
							childArray = new JSONArray();
						}

						if(photoid.equals(o[2].toString())){
							JSONObject childObject = new JSONObject();
							path=LolaConstants.url+o[3].toString();
							childObject.put("imagepath",path);
							childObject.put("content",o[4].toString());
							childObject.put("childphotoimageid",o[5].toString());
							childArray.put(childObject);		
							if(c==1){
								jsonParentObject.put(parent+"_CHILD", childArray);
								jsonNewParentArray.put(jsonParentObject);
							}
						}
						i=0;
						//c=0;
					}
					//	System.out.println(jsonNewParentArray+"\n\n");

				}


				

			}
			
			
			if(likedBrandPhotoImages.size()>0){
				for(Object[] o:likedBrandPhotoImages){

					
					if(i==0)						
					{

						parent = o[0].toString();	
						photoid = o[1].toString();

						//jsonParentObject.put("affinityCategories",parent);
						//System.out.println(jsonParentObject);
						if(c==0){
							jsonParentObject = new JSONObject();	
							jsonParentObject.put("affinityCategories",parent);	
							childArray = new JSONArray();
						}
					}			
					if(photoid.equals(o[2].toString())){
						JSONObject childObject = new JSONObject();

						path=LolaConstants.url+o[3].toString();
						childObject.put("imagepath",path);
						childObject.put("content",o[4].toString());
						childObject.put("childphotoimageid",o[5].toString());						
						childObject.put("desc",o[6].toString());
						childObject.put("like", o[7].toString());
						childArray.put(childObject);
						if(c==0){
							jsonParentObject.put(parent+"_CHILD", childArray);	
							jsonNewParentArray.put(jsonParentObject);
						}		
						i=1;
						c=1;
					}						


					else{
						parent = o[0].toString();	
						photoid = o[1].toString();						 
						//jsonParentObject.put("affinityCategories",parent);
						//System.out.println(jsonParentObject);
						if(c==1){
							jsonParentObject = new JSONObject();	
							jsonParentObject.put("affinityCategories",parent);	
							childArray = new JSONArray();
						}

						if(photoid.equals(o[2].toString())){
							JSONObject childObject = new JSONObject();
							path=LolaConstants.url+o[3].toString();
							childObject.put("imagepath",path);
							childObject.put("content",o[4].toString());
							childObject.put("childphotoimageid",o[5].toString());
							childArray.put(childObject);		
							if(c==1){
								jsonParentObject.put(parent+"_CHILD", childArray);
								jsonNewParentArray.put(jsonParentObject);
							}
						}
						i=0;
						//c=0;
					}
					//	System.out.println(jsonNewParentArray+"\n\n");

				}


				
			}
			jsonParent.put("Status", "Success");
			jsonParent.put("Data", jsonNewParentArray);

			
			}
			
			else
			{
				jsonParent.put("Status", "Failure");
				jsonParent.put("Message", "No Records");
				jsonParentArray.put(jsonParent);
			}
		}catch(Exception e)
		{
			//System.out.println(jsonParentArray.toString().replace("\\", ""));

			JSONObject jsonError = new JSONObject();
			jsonError.put("Status", "Failure");
			jsonParent.put("Message", "No Records");
			//jsonError.put("Error Msg", e.toString());
			jsonParentArray.put(jsonError);
			return jsonNewParentArray.toString();			
		}

		return jsonParent.toString().replace("\\", "");
	}
	
	/*public String saveBrandChildPhotoImagesLeafPage(int userId,int childphotoimageId) throws Exception{
		JSONObject jsonObject = null;
		String Msg=null;
		try{
			List<BrandChildPhotoImages> brandChildPhotoImages=brandChildPhotoImagesDaoImpl.findBychildphotoimageId(childphotoimageId);
		if(brandChildPhotoImages.size()>0){
			for(BrandChildPhotoImages entity:brandChildPhotoImages){
				entity.setUserId(userId);
				//entity.setMyspecialchildId(myspecialchildId);
				if(entity.isLiked()){
				entity.setLiked(false);
				Msg="Unliked";}
				else{
					entity.setLiked(true);
				 Msg="Liked";}
				brandChildPhotoImagesDaoImpl.update(entity);
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
		}
*/

	public static void main(String args[]) throws Exception
	{

		BrandChildPhotoImagesUtility brandChildPhotoImagesUtility = new BrandChildPhotoImagesUtility();

		System.out.println(brandChildPhotoImagesUtility.getimagepathbyBrandId(2,1));
	//	System.out.println(brandChildPhotoImagesUtility.saveBrandChildPhotoImagesLeafPage(297, 1));


		/*Date dob = new Date("2015/12/21");
		if(dob.getTime()>=new Date().getTime())
			System.out.println("Not allowed");*/
	}


}
