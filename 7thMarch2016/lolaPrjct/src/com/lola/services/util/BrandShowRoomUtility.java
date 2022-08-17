package com.lola.services.util;



import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.lola.dao.BrandShowRoomDao;
import com.lola.dao.BrandShowRoomDaoImpl;
import com.lola.model.BrandShowRoom;

public class BrandShowRoomUtility {

	BrandShowRoomDao brandShowRoomDaoImpl=new BrandShowRoomDaoImpl();
	JSONObject jsonObject = null;
	  JSONArray jsonArray = new JSONArray();
	  JSONObject jsonParent = new JSONObject();
	  JSONArray jsonParentArray = new JSONArray();
	  
	  public String getLolaContact() throws Exception {
		 
			try{
				List<Object[]> details=brandShowRoomDaoImpl.getLolaContact();
				if(details.size()>0){
					 jsonObject = new JSONObject();
					 jsonObject.put("Status", "Success");
					 for(Object[] o:details){
						 if(o[0].toString()!=null)
						 jsonObject.put("shopname",o[0].toString());
						 else
							 jsonObject.put("shopname"," ");
						 if(o[1].toString()!=null)
						 jsonObject.put("phonenumber",o[1].toString());
						 else
							 jsonObject.put("phonenumber"," ");
						 if(o[2].toString()!=null)
						 jsonObject.put("emailId",o[2].toString());
						 else
							 jsonObject.put("emailId"," "); 
						 if(o[3].toString()!=null)
						 jsonObject.put("website",o[3].toString());
						 else
							 jsonObject.put("website"," ");
						 if(o[4].toString()!=null)
						 jsonObject.put("description",o[4].toString());
						 else
							 jsonObject.put("description"," ssssss  "); 
							  
				}
					
			 
			  }
			else
				jsonObject.put("Status", "Failure");
			}catch(Exception e){
				
				jsonObject.put("Status", "Failure");
				//jsonObject.put("Message", e.toString());
				jsonObject.put("Message", "No Records");
				 
				  return jsonObject.toString();
			}
			 return jsonObject.toString();
		}
	  
	  
	  
	  public String checkPin(int brandId,double lat,double lng,String pin) throws Exception{
		  JSONObject jsonObject = null;
		  try{
		  BrandShowRoomDaoImpl brandShowRoomDaoImpl=new  BrandShowRoomDaoImpl();
		  List<BrandShowRoom> brandshowroomsdetails =brandShowRoomDaoImpl.getBrandShowroomDetail(brandId, lat, lng, pin);
		  
		  if(brandshowroomsdetails.size()>0){
			  jsonObject = new JSONObject();
			  jsonObject.put("Status", "Success");
			  jsonObject.put("Message", "true");
			  
		  }else{
			  jsonObject = new JSONObject();
			  jsonObject.put("Status", "Failure");
			  jsonObject.put("Message", "false"); 
		  }
		  return jsonObject.toString();
		  }catch(Exception e){
			  jsonObject = new JSONObject();
			  jsonObject.put("Status", "Failure");
			  jsonObject.put("Message", "No records");
			  return jsonObject.toString();
			  
		  }
		  
		  
	  }
	  public static  void main(String args[]) throws Exception{
		  BrandShowRoomUtility brandShowRoomUtility=new BrandShowRoomUtility();
			
			
			System.out.println(brandShowRoomUtility.checkPin(2, 12.9758, 80.2205, "987654676"));
			
		}
	
}
