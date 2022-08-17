package com.lola.services.util;

import java.util.Date;
import java.util.List;

import com.lola.dao.UserBrandloyalityPointsDao;
import com.lola.dao.UserBrandloyalityPointsDaoImpl;

public class UserBrandloyalityPointUtility {
	UserBrandloyalityPointsDao userBrandloyalityPointsDaoImpl=new UserBrandloyalityPointsDaoImpl();
	
	public int expiringPointsCal(int userid){
		
		
		
		List<Object[]> userbrandpoints=	userBrandloyalityPointsDaoImpl.getUserExpiringPointscal( userid);
		int totalExpiringPoints =0;
		if(userbrandpoints.size()>0){
		for(Object[] o:userbrandpoints){
			if(o[0]!=null && o[1]!=null)
			//if(o!=null)
			{
			
		
			long week = 60*60*24*7*1000;
			  
			//  Date expiryDate= new Date("2015/11/30");
			
			Date expiryDate = (Date) o[0];
			  
			  System.out.println("expiry date :"+expiryDate +"  millisecond :"+expiryDate.getTime());
			  
			  if(expiryDate.getTime()<new Date().getTime()){
			   System.out.println("Points Already Expired :"+o[1].toString()+"  Date :"+o[0].toString()); } 
			  else if((expiryDate.getTime()-new Date().getTime())<week){
				 
				  totalExpiringPoints = totalExpiringPoints +Integer.parseInt(o[1].toString());
				  System.out.println("Points Expiring Soon :"+o[1].toString()+"   Expiring Date: "+o[0].toString());
			  }
			  else
			   System.out.println("Points not expiring :"+o[1].toString()+"   Date :"+o[0].toString());
			  
			 
			}
			
	}}
		 System.out.println("totalExpiringPoints :"+totalExpiringPoints);
		 return totalExpiringPoints;
	}
	
	public int expiringPointsCal(int userid,int brandid){

		List<Object[]> userbrandpoints=	userBrandloyalityPointsDaoImpl.getUserExpiringPointsByBrandid(userid, brandid);
		int totalExpiringPoints =0;
		if(userbrandpoints.size()>0){
		for(Object[] o:userbrandpoints){
			
			if(o[0]!=null && o[1]!=null)
			{
			
		
			long week = 60*60*24*7*1000;
			  
			//  Date expiryDate= new Date("2015/11/30");
			
			Date expiryDate = (Date) o[0];
			  
			  System.out.println("expiry date :"+expiryDate +"  millisecond :"+expiryDate.getTime());
			  
			  if(expiryDate.getTime()<new Date().getTime()){
			   System.out.println("Points Already Expired :"+o[1].toString()+"  Date :"+o[0].toString()); } 
			  else if((expiryDate.getTime()-new Date().getTime())<week){
				  totalExpiringPoints = totalExpiringPoints +Integer.parseInt(o[1].toString());
				  System.out.println("Points Expiring Soon :"+o[1].toString()+"   Expiring Date: "+o[0].toString());
			  }
			  else
			   System.out.println("Points not expiring :"+o[1].toString()+"   Date :"+o[0].toString());
			  
			 
			}
			
	}}
		 System.out.println("totalExpiringPoints :"+totalExpiringPoints);
		 return totalExpiringPoints;
	}
		
	
	
	public static void main(String args[]){
		UserBrandloyalityPointUtility userBrandloyalityPointUtility=new UserBrandloyalityPointUtility();
		userBrandloyalityPointUtility.expiringPointsCal(4,4);
		
	}
	
		
	}

