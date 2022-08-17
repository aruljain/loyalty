package com.lola.services.util;

import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.lola.dao.BrandDao;
import com.lola.dao.BrandDaoImpl;
import com.lola.dao.BrandShowRoomDao;
import com.lola.dao.BrandShowRoomDaoImpl;
import com.lola.dao.MySpecialsPhotoImagesDao;
import com.lola.dao.MySpecialsPhotoImagesDaoImpl;
import com.lola.dao.UserDao;
import com.lola.dao.UserDaoImpl;
import com.lola.model.MySpecialsChild;

public class MySpecialPhotoImagesUtility {

	MySpecialsPhotoImagesDao mySpecialsPhotoImagesDaoImpl = new MySpecialsPhotoImagesDaoImpl();
BrandShowRoomDao brandShowroomsDaoImpl=new BrandShowRoomDaoImpl();
	
	UserDao userDaoImpl=new UserDaoImpl();
	BrandDao brand = new BrandDaoImpl();
	

	public String getAllMySpecialsPhotoImages(String searchString) throws Exception{
		JSONObject jsonObject = null;
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonParent = new JSONObject();
		JSONArray jsonParentArray = new JSONArray();

		String parent = null;	
		String brandspecialId ="";
		JSONArray jsonNewParentArray = new JSONArray();
		JSONObject jsonParentObject = null;
		JSONArray childArray =null;
		JSONArray childArray2 =null;
		try{
			
			 String path=null;
	          String path1 = null;
	          String brandName=null;
	          
	         // String location = userDaoImpl.getUserLocation(userid);
	          
				//List<Object[]> brandMySpecials=brandMySpecialsDaoImpl.getMySpecialsbyBrandId(brandId);
				//List<Object[]> brandshowroomdetails=(List<Object[]>) brandShowroomsDaoImpl.getBrandShowroomDetails(brandId, location);
				//List<Object[]> brandDetails	=brand.getBrandLogo(brandId);
			List<Object[]> brandSpecialImages=mySpecialsPhotoImagesDaoImpl.getAllMySpecialsPhotoImages(searchString);

			int i=0;
			int c=0;
			
			/*if(brandDetails.size()>0){
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
			*/
			if(brandSpecialImages.size()>0){
				for(Object[] o:brandSpecialImages){

					//JSONObject jsonParentObject = null;
					// JSONArray childArray = null;


					if(i==0)						
					{
						parent=o[0].toString();
						//parent = o[1].toString();	
						brandspecialId = o[1].toString();

						//jsonParentObject.put("affinityCategories",parent);
						//System.out.println(jsonParentObject);
						if(c==0){
							jsonParentObject = new JSONObject();	
							jsonParentObject.put("image",parent);	
							childArray = new JSONArray();
						}
					}			
					if(brandspecialId.equals(o[2].toString())){
						JSONObject childObject = new JSONObject();

						path=LolaConstants.url+o[3].toString();
						childObject.put("imagepath",path);

						childArray.put(childObject);
						if(c==0){
							jsonParentObject.put("CHILD_IMAGE", childArray);	
							jsonNewParentArray.put(jsonParentObject);
						}		
						i=1;
						c=1;
					}						


					else{
						parent=o[0].toString();	
						brandspecialId = o[1].toString();						 
						//jsonParentObject.put("affinityCategories",parent);
						//System.out.println(jsonParentObject);
						if(c==1){
							jsonParentObject = new JSONObject();	
							jsonParentObject.put("image",parent);	
							childArray = new JSONArray();
						}

						if(brandspecialId.equals(o[2].toString())){
							JSONObject childObject = new JSONObject();
							path=o[3].toString();
							childObject.put("imagepath",path);
							childArray.put(childObject);		
							if(c==1){
								jsonParentObject.put("CHILD_IMAGE", childArray);
								jsonNewParentArray.put(jsonParentObject);
							}
						}
						i=0;
						//c=0;
					}



					//	System.out.println(jsonNewParentArray+"\n\n");

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
			jsonError.put("Error Msg", e.toString());
			jsonParentArray.put(jsonError);
			return jsonNewParentArray.toString();			
		}

		return jsonParent.toString().replace("\\", "");
	}
	
	
	public String getMySpecialsPhotoImages(int brandId, int userid) throws Exception{
		JSONObject jsonObject = null;
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonParent = new JSONObject();
		JSONArray jsonParentArray = new JSONArray();

		String parent = null;	
		String brandspecialId ="";
		JSONArray jsonNewParentArray = new JSONArray();
		JSONObject jsonParentObject = null;
		JSONArray childArray =null;
		JSONArray childArray2 =null;
		JSONArray jsonNewChildArray = new JSONArray();
		JSONObject jsonChildtObject = null;
		
		try{
			
			 String path=null;
	          String path1 = null;
	          String path2 = null;
	          String path3 = null;
	          String brandName=null;
	          
	         
	          
				//List<Object[]> brandMySpecials=brandMySpecialsDaoImpl.getMySpecialsbyBrandId(brandId);
				List<Object[]> brandshowroomdetails=(List<Object[]>) brandShowroomsDaoImpl.getBrandShowroom(brandId);
				List<Object[]> brandDetails	=brand.getBrandLogo(brandId);
			//List<Object[]> brandSpecialImages=mySpecialsPhotoImagesDaoImpl.getMySpecialsPhotoImages(brandId,userid);
			//List<Object[]> likedBrandSpecialImages=mySpecialsPhotoImagesDaoImpl.getLikedMySpecialsPhotoImages(brandId,userid);
				List<Object[]> brandSpecialImages=mySpecialsPhotoImagesDaoImpl.getMyspecialchildbyBrandId(brandId);
				List<Object[]> brandSpecialImages1=mySpecialsPhotoImagesDaoImpl.getLikedAndUnlikedMyspecialchildbyBrandId(brandId, userid);
				List<Object[]> brandSpecialImages2=mySpecialsPhotoImagesDaoImpl.getUnlikedMyspecialchildbyBrandId(brandId, userid);
				
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
			
			if(brandSpecialImages1.size()>0){
				for(Object[] o:brandSpecialImages1){
					jsonObject = new JSONObject();					
					jsonObject.put("brandId",o[1].toString());	
					path1=LolaConstants.url+o[2].toString();
					jsonObject.put("imagepath",path1);	
					jsonObject.put("content",o[3].toString());
					jsonObject.put("myspecialchildId",o[0].toString());
					jsonObject.put("desc",o[4].toString());
					jsonObject.put("like",o[5].toString());
					jsonObject.put("book",o[6].toString());
					jsonObject.put("available",o[7].toString());
					jsonObject.put("bookable",o[8].toString());
					jsonObject.put("brandshopid",o[9].toString());
					jsonArray.put(jsonObject);
				}
				if(brandSpecialImages2.size()>0){
					for(Object[] o:brandSpecialImages2){
						jsonObject = new JSONObject();					
						jsonObject.put("brandId",o[1].toString());	
						path2=LolaConstants.url+o[2].toString();
						jsonObject.put("imagepath",path2);	
						jsonObject.put("content",o[3].toString());
						jsonObject.put("myspecialchildId",o[0].toString());
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
				if(brandSpecialImages.size()>0){
					for(Object[] o:brandSpecialImages){
						jsonObject = new JSONObject();					
						jsonObject.put("brandId",o[0].toString());	
						path3=LolaConstants.url+o[1].toString();
						jsonObject.put("imagepath",path3);	
						jsonObject.put("content",o[2].toString());
						jsonObject.put("myspecialchildId",o[3].toString());
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
			//System.out.println(jsonParentArray.toString().replace("\\", ""));

			JSONObject jsonError = new JSONObject();
			jsonError.put("Status", "Failure");
			//jsonError.put("Error Msg", e.toString());
			jsonError.put("Message", "No Records");
			jsonParentArray.put(jsonError);
			return jsonNewParentArray.toString();			
		}

		return jsonParent.toString().replace("\\", "");
	}
 
	/*public String saveLeavePage(int userId,int myspecialchildId) throws Exception{
		JSONObject jsonObject = null;
		String Msg=null;
		try{
		List<MySpecialsChild> mySpecial=mySpecialsPhotoImagesDaoImpl.findBymyspecialchildId(myspecialchildId);
		if(mySpecial.size()>0){
			for(MySpecialsChild entity:mySpecial){
				
				entity.setUserId(userId);
				//entity.setMyspecialchildId(myspecialchildId);
				if(entity.isLiked()){
				entity.setLiked(false);
				Msg="Unliked";}
				else{
					entity.setLiked(true);
					Msg="Liked";
				}
				mySpecialsPhotoImagesDaoImpl.update(entity);
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
			jsonObject.put("Message"," ");
			return jsonObject.toString();
		
	}
		}*/

	public static void main(String args[]) throws Exception
	{

		MySpecialPhotoImagesUtility mySpecialPhotoImagesUtility = new MySpecialPhotoImagesUtility();

		//System.out.println(mySpecialPhotoImagesUtility.getMySpecialsPhotoImages(2,299));
		System.out.println(mySpecialPhotoImagesUtility.getMySpecialsPhotoImages(2,41));
		
		
	//	System.out.println(mySpecialPhotoImagesUtility.saveLeavePage(99, 1));
		

	}

	
	
}
