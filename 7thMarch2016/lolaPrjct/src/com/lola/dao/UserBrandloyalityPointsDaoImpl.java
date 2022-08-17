package com.lola.dao;

import java.util.Date;
import java.util.List;

import com.lola.model.UserBrandloyalityPoints;

public class UserBrandloyalityPointsDaoImpl implements UserBrandloyalityPointsDao<UserBrandloyalityPoints,String>{

	@Override
	public List<Object> getUserExpiringPoints(int userid) {
		// TODO Auto-generated method stub
		hibernateUtil.openCurrentSession();
		 List<Object> points = hibernateUtil.getCurrentSession().createQuery("select sum(expiringpoint) from UserBrandloyalityPoints where userid="+userid).setCacheable(false).list();
		 hibernateUtil.closeCurrentSession();
		 return points;
	}
   
	@Override
	public List<Object[]> getUserExpiringPointscal(int userid) {
		// TODO Auto-generated method stub
		
		
		hibernateUtil.openCurrentSession();
		 List<Object[]> points = hibernateUtil.getCurrentSession().createQuery("select expirydate,expiringpoint from UserBrandloyalityPoints where userid="+userid).setCacheable(false).list();
		 hibernateUtil.closeCurrentSession();
		 return points;
		 
	}
	
	
	@Override
	public List<Object[]> getUserExpiringPointsByBrandid(int userid,int brandid) {
		// TODO Auto-generated method stub
		hibernateUtil.openCurrentSession();
		 List<Object[]> points = hibernateUtil.getCurrentSession().createQuery("select expirydate,expiringpoint from UserBrandloyalityPoints where userid="+userid+" and brandid="+brandid).setCacheable(false).list();
		 hibernateUtil.closeCurrentSession();
		 return points;
		 
		
	}
	
	
	public static void main(String args[]){
		UserBrandloyalityPointsDaoImpl userBrandloyalityPointsDaoImpl=new UserBrandloyalityPointsDaoImpl();
		//hibernateUtil.openCurrentSession();
		/*List<Object> userbrandpoints=userBrandloyalityPointsDaoImpl.getUserExpiringPoints(51);
		for(Object o:userbrandpoints){
			if(o!=null)
			System.out.println(o.toString());
		}*/
	//	hibernateUtil.closeCurrentSession();
		int totalExpiringPoints =0;
		
		List<Object[]> userbrandpoints=userBrandloyalityPointsDaoImpl.getUserExpiringPointsByBrandid(3, 1);
		for(Object[] o:userbrandpoints){
			if(o!=null)
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
			
	}
		 System.out.println("totalExpiringPoints :"+totalExpiringPoints);

	}

	
}
