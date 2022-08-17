package com.lola.services.util;

import java.io.File;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.lola.dao.BrandShowRoomDao;
import com.lola.dao.BrandShowRoomDaoImpl;
import com.lola.dao.RateandReviewDao;
import com.lola.dao.RateandReviewDaoImpl;
import com.lola.dao.UserDao;
import com.lola.dao.UserDaoImpl;
import com.lola.model.RateandReview;
import com.lola.model.User;

public class RateandReviewUtility {


	private static RateandReviewDao rateandReviewDaoImpl;
	private static RateandReviewUtility rateandReviewUtility = new RateandReviewUtility();
	BrandShowRoomDao brandShowRoomDaoImpl = new BrandShowRoomDaoImpl();

	public RateandReviewUtility() {
		rateandReviewDaoImpl = new RateandReviewDaoImpl();

	}



	public String  saveUserRateReview(String rate,
			String review,	
			int userId,
			int brandid,
			int productid
			) throws Exception
	{


		JSONObject obj =new JSONObject();
		JSONArray jsonArray = new JSONArray();
		RateandReview entity= new RateandReview();

		entity.setRate(rate);
		entity.setReview(review);           
		entity.setUserId(userId);
		entity.setCreatedby(userId);
		entity.setLolaContact("8754300277");
		if(brandid!=0)           
			entity.setBrandId(brandid);
		else
			entity.setBrandId(LolaConstants.rootBrandId);
		if(productid!=0)           
			entity.setProductId(productid);
		else
			entity.setProductId(LolaConstants.rootProductId);
		entity.setIsactive(true);



		//entity.setCreatedon(new Date());

		rateandReviewDaoImpl.saveOrUpdate(entity);		
		obj.put("Status","Success");  
		//obj.put("Message","Your review has been submitted successfully"); 
		obj.put("Message","Thanks ! Your review has been submitted successfully !"); 
		return obj.toString();


	}

	public String  saveUserFeedback(		
			String feedback,
			int userId,
			int brandid,
			int productid
			) throws Exception
	{


		JSONObject obj =new JSONObject();
		JSONArray jsonArray = new JSONArray();
		RateandReview entity= new RateandReview();


		entity.setFeedback(feedback);
		entity.setUserId(userId);
		entity.setCreatedby(userId);
		entity.setLolaContact("8754300277");
		if(brandid!=0)           
			entity.setBrandId(brandid);
		else
			entity.setBrandId(LolaConstants.rootBrandId);
		if(productid!=0)           
			entity.setProductId(productid);
		else
			entity.setProductId(LolaConstants.rootProductId);
		entity.setIsactive(true);



		//entity.setCreatedon(new Date());

		rateandReviewDaoImpl.saveOrUpdate(entity);	
  
  /* List<Object> lolaid= brandShowRoomDaoImpl.getBrandShowroomEmailid(entity.getBrandId());
   for(Object o:lolaid){
	String s=o.toString();
	System.out.println(s.toString());
	}*/
	       int  x=entity.getBrandId();
		rateandReviewUtility.sendFeedbackMail(userId,feedback,brandid);



		obj.put("Status","Success");  
		//obj.put("Message","Your message has been saved successfully");
		obj.put("Message","Thanks for contacting us! We will get back to you shortly");
		return obj.toString();


	}
	
	
	public String  saveNotHere(				
			int userId,
			String brandName,
			String categoryName
			) throws Exception
	{


		JSONObject obj =new JSONObject();
		JSONArray jsonArray = new JSONArray();
		RateandReview entity= new RateandReview();

	
		entity.setUserId(userId);
		entity.setCreatedby(userId);
		entity.setLolaContact("8754300277");
		if(brandName!=null)           
			entity.setBrandnothere(brandName);
		else
			entity.setBrandnothere("BrandName not mentioned");
		if(categoryName!=null)           
			entity.setCategorynothere(categoryName);
		else
			entity.setCategorynothere("Category Not Mentioned");
		entity.setIsactive(true);



		//entity.setCreatedon(new Date());

		rateandReviewDaoImpl.saveOrUpdate(entity);	

		rateandReviewUtility.sendNotHereMail(userId, brandName, categoryName);



		obj.put("Status","Success");  
		//obj.put("Message","Your suggestion has been submitted successfully"); 
		obj.put("Message","Thanks! We will try to get your suggested brand here soon !");
		return obj.toString();


	}



	public boolean sendFeedbackMail(int userid,String feedBack,int brandid) throws Exception
	{
		boolean status = true;
		String email = "";
		String mobile = "";
		String name = "";
		String regards = "";
		String lolaMailid = "";
		
		RateandReview entity= new RateandReview();
		RateandReviewUtility rateandReviewUtility = new RateandReviewUtility();

		UserDao userDaoImpl = new UserDaoImpl();

		List<User> users =  userDaoImpl.findByuserid(userid);

		for(int i=0;i<users.size();i++)
		{
			User user = (User) users.get(i);
			email = user.getEmail();
			mobile = user.getMobile();
			name = user.getUserName();

		}

		regards = "\n\n\n\n\n"+name+",\n"+mobile;
		feedBack = feedBack+regards;
		System.out.println(feedBack);
		 /* rateandReviewDaoImpl.saveOrUpdate(entity);
		  
		 List<Object> lolaid= brandShowRoomDaoImpl.getBrandShowroomEmailid(entity.getBrandId());
		   for(Object o:lolaid){
			String s=o.toString();
			System.out.println(s.toString());
			}*/
		     
		//lolaMailid = getLolaMailid();
		if(brandid!=0)
		    lolaMailid = getBrandShoeroomMailid(brandid);
		else
			lolaMailid = getBrandShoeroomMailid(LolaConstants.rootBrandId);
		//System.out.println(lolaMailid);
		EmailUtility.sendEmail("smtp.critsend.com", "587", "noreply@myshareindia.com", "JxRApreLseNR", lolaMailid, "Customer feedback", feedBack);
		//EmailUtility.sendEmail("smtp.critsend.com", "587", "noreply@myshareindia.com", "JxRApreLseNR", lolaMailid, "User feedback", feedBack);
		
		
		

		return status;
	}
	
	
	public boolean sendNotHereMail(int userid,String brandName, String categoryName) throws Exception
	{
		boolean status = true;
		String email = "";
		String mobile = "";
		String name = "";
		String regards = "";
		String lolaMailid = "";
		String msg="Following brand is not available\n";
		String mailBody="";
		RateandReview entity= new RateandReview();

		UserDao userDaoImpl = new UserDaoImpl();

		List<User> users =  userDaoImpl.findByuserid(userid);

		for(int i=0;i<users.size();i++)
		{
			User user = (User) users.get(i);
			email = user.getEmail();
			mobile = user.getMobile();
			name = user.getUserName();

		}
		
		if(brandName==null)
			brandName="";
		if(categoryName==null)
			categoryName="";

		regards = "\n\n\n\n\n"+name+",\n"+mobile;
		mailBody= msg+"\nBrand Name :"+brandName+"\nCategory Name :"+categoryName+"\n\n\n"+regards;
		
		
		//System.out.println(mailBody);
		
		lolaMailid = getLolaMailid();

		EmailUtility.sendEmail("smtp.critsend.com", "587", "noreply@myshareindia.com", "JxRApreLseNR", lolaMailid, "From Customer - Brand/Product/Category not here", mailBody);
		//EmailUtility.sendEmail("smtp.critsend.com", "587", "noreply@myshareindia.com", "JxRApreLseNR", lolaMailid, "User feedback", feedBack);
		
		
		

		return status;
	}
	
	  public static boolean deleteDir(File dir) {
	      if (dir.isDirectory()) {
	         String[] children = dir.list();
	         for (int i = 0; i < children.length; i++) {
	            boolean success = deleteDir
	            (new File(dir, children[i]));
	            if (!success) {
	               return false;
	            }
	         }
	      }
	      return dir.delete();
	     
	  }

	

	public String getLolaMailid()
	{
		String lolaMailid = "";
		BrandShowRoomDao brandShowRoomDaoImpl=new BrandShowRoomDaoImpl();
		List<Object[]> details=brandShowRoomDaoImpl.getLolaContact();
		if(details.size()>0){

			for(Object[] o:details){
				lolaMailid = o[2].toString();
			}
		}
		
		return lolaMailid;
	}
   
	
	public String getBrandShoeroomMailid(int brandId ){
		String mail="";
		  List<Object> lolaid= brandShowRoomDaoImpl.getBrandShowroomEmailid( brandId);
		   for(Object o:lolaid){
			String s=o.toString();
			  mail=s.toString();
			}
		  
		   return mail;
	}
	
	
	public String saveUserUnLike(int userid, int brandid)
	{
		System.out.println("Refreshing :"+LolaConstants.url+"repo");
		deleteDir(new File(LolaConstants.CONTEXT));
		return "";
	}
  
	public static void main(String args[]) throws Exception
	{
		RateandReviewUtility rateandReviewUtility = new RateandReviewUtility();
		//System.out.println("Rate & Review :"+rateandReviewUtility.saveUserRateReview("5.0","Very Good",2,1,1));
		//System.out.println(rateandReviewUtility.saveUserFeedback("Excellt", 3,0,0));
		System.out.println(rateandReviewUtility.saveUserUnLike(2,2));
		
	}


}
