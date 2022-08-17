package com.lola.services.util;

import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.lola.dao.BrandMySpecialsDao;
import com.lola.dao.BrandMySpecialsDaoImpl;

public class BrandMySpecialsUtility {
	BrandMySpecialsDao brandMySpecialsDaoImpl=new BrandMySpecialsDaoImpl();
	
	
	public String getMySpecialsbyUserId(int userid) throws Exception{
		/*JSONObject jsonObject = null;
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonParent = new JSONObject();
		JSONArray jsonParentArray = new JSONArray();*/
		String mySpecials = "0";

		try{


			List<Object> brandSpecials=brandMySpecialsDaoImpl.getMySpecialsbyUserId(userid);
			if(brandSpecials.size()>0){
			for(Object o:brandSpecials){
				/*jsonObject = new JSONObject();

				jsonObject.put("BrandSpecials",o.toString());	*/
				
				mySpecials = o.toString();
			}
			/*jsonArray.put(jsonObject);
			jsonParent.put("Data", jsonArray);
			jsonParent.put("Status", "Success");
			jsonParentArray.put(jsonParent);*/
			}
			else
			{
				/*jsonObject = new JSONObject();

				jsonObject.put("BrandSpecials","0");	
				jsonArray.put(jsonObject);
				jsonParent.put("Data", jsonArray);
				jsonParent.put("Status", "Success");
				jsonParentArray.put(jsonParent);*/
				return mySpecials;
			}
		}catch(Exception e)
		{
			/*JSONObject jsonError = new JSONObject();
			jsonError.put("Status", "Failure");
			jsonError.put("Error Msg", e.toString());
			jsonParentArray.put(jsonError);
			return jsonParentArray.toString();*/
			return mySpecials;
		}

		//return jsonParentArray.toString();
		return mySpecials;
	}
	
	public String getMySpecials(int userid,int categoryId) throws Exception{
		JSONObject jsonObject = null;
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonParent = new JSONObject();
		JSONArray jsonParentArray = new JSONArray();
		String myDealsnOffers = "0";
		try{

                String path=null;      
			List<Object[]> brandSpecials=brandMySpecialsDaoImpl.getMySpecials(userid,categoryId);
			if(brandSpecials.size()>0){
				for(Object[] o:brandSpecials){
					jsonObject = new JSONObject();					
					jsonObject.put("brandId",o[0].toString());	
					path=LolaConstants.url+o[1].toString();
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
				jsonError.put("Message", "No Records");
			jsonParentArray.put(jsonError);
			return jsonParentArray.toString();			
		}

		return jsonParent.toString().replace("\\", "");
	}

	
	/*public String getMySpecialsbyBrandId(int brandId) throws Exception{
		JSONObject jsonObject = null;
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonParent = new JSONObject();
		JSONArray jsonParentArray = new JSONArray();
		String myDealsnOffers = "0";
		
		try{

          String path1=null;
			List<Object[]> brandMySpecials=brandMySpecialsDaoImpl.getMySpecialsbyBrandId(brandId);
			if(brandMySpecials.size()>0){
				for(Object[] o:brandMySpecials){
					jsonObject = new JSONObject();					
					jsonObject.put("brandId",o[0].toString());	
					path1=LolaConstants.url+o[1].toString();
					jsonObject.put("imagepath",path1);	
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
				jsonError.put("Error Msg", e.toString());
			jsonParentArray.put(jsonError);
			return jsonParentArray.toString();			
		}

		return jsonParent.toString().replace("\\", "");
	}*/

	
	/*public String getMySpecialsByCategoryId(int userid, int categoryId) throws Exception{
		JSONObject jsonObject = null;
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonParent = new JSONObject();
		JSONArray jsonParentArray = new JSONArray();

		String parent = null;
		String brandid = null;
		String desc = null;
		String brandspecialId ="";
		JSONArray jsonNewParentArray = new JSONArray();
		JSONObject jsonParentObject = null;
		JSONArray childArray =null;
		JSONArray childArray2 =null;
		try{
			
			 String path=null;
	          String path1 = null;
	          String brandName=null;
	          
	         
				List<Object[]> brandSpecial	=brandMySpecialsDaoImpl.getMySpecialsByCategoryId(userid, categoryId);
			

			int i=0;
			int c=0;
			
			
			
			if(brandSpecial.size()>0){
				for(Object[] o:brandSpecial){

					//JSONObject jsonParentObject = null;
					// JSONArray childArray = null;


					if(i==0)						
					{
						parent=LolaConstants.url+o[0].toString();
						//brandid=o[1].toString();
						//desc=o[2].toString();
						brandid=o[1].toString();
						desc=o[2].toString();
						//parent = o[1].toString();	
						brandspecialId = o[3].toString();

						//jsonParentObject.put("affinityCategories",parent);
						//System.out.println(jsonParentObject);
						if(c==0){
							jsonParentObject = new JSONObject();	
							jsonParentObject.put("image",parent);
							//jsonParentObject.put("bradid",brandid);
							//jsonParentObject.put("desc",desc);
							childArray = new JSONArray();
						}
					}			
					if(brandspecialId.equals(o[4].toString())){
						JSONObject childObject = new JSONObject();

						path=LolaConstants.url+o[5].toString();
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
						parent=LolaConstants.url+o[0].toString();
						//parent=LolaConstants.url+o[0].toString();
						brandid=o[1].toString();
						desc=o[2].toString();
						brandspecialId = o[3].toString();						 
						//jsonParentObject.put("affinityCategories",parent);
						//System.out.println(jsonParentObject);
						if(c==1){
							jsonParentObject = new JSONObject();	
							jsonParentObject.put("image",parent);	
							childArray = new JSONArray();
						}

						if(brandspecialId.equals(o[4].toString())){
							JSONObject childObject = new JSONObject();
							path=LolaConstants.url+o[5].toString();
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
				jsonParent.put("bradid",brandid);
				jsonParent.put("desc",desc);
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
	}*/
	
	public String getMySpecialsChildByCategoryId(int userid, int categoryId) throws Exception{
		
		JSONObject jsonParent = new JSONObject();		
		
		JSONArray jsonNewChildArray = new JSONArray();
		JSONObject jsonChildtObject = null;
		
		
		try{
			
			 String path=null;
	         	          
	         
				List<Object[]> brandSpecialChild	=brandMySpecialsDaoImpl.getMySpecialsChildByCategoryId(userid, categoryId);
			
			
			
			if(brandSpecialChild.size()>0){
				for(Object[] o:brandSpecialChild){

					jsonChildtObject = new JSONObject();
					jsonChildtObject.put("brandid", o[0].toString());
					jsonChildtObject.put("myspecialchildId", o[1].toString());
					
					path=LolaConstants.url+o[2].toString();
					jsonChildtObject.put("imagepath", path);
					jsonChildtObject.put("content", o[3].toString());
					//jsonChildtObject.put("like",o[4].toString());
					jsonChildtObject.put("desc",o[4].toString());

					jsonNewChildArray.put(jsonChildtObject);

				}


				jsonParent.put("Status", "Success");				
				jsonParent.put("Data", jsonNewChildArray);

			}
			else
			{
				jsonParent.put("Status", "Failure");
				jsonParent.put("Message", "No Records");
				
			}
			
		}catch(Exception e)
		{
			//System.out.println(jsonParentArray.toString().replace("\\", ""));

			JSONObject jsonError = new JSONObject();
			jsonError.put("Status", "Failure");
			jsonError.put("Message", "No Records");
			
			return jsonError.toString();			
		}

		return jsonParent.toString().replace("\\", "");
	}


	public static void main(String args[]) throws Exception
	{

		BrandMySpecialsUtility brandMySpecialsUtility = new BrandMySpecialsUtility();

		System.out.println( brandMySpecialsUtility.getMySpecialsChildByCategoryId(1, 2));
	}	
}
