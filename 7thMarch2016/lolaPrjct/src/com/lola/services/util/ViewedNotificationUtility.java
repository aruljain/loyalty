package com.lola.services.util;

import java.util.StringTokenizer;

import org.codehaus.jettison.json.JSONObject;

import com.lola.dao.DealsnOffersNotiDao;
import com.lola.dao.DealsnOffersNotiDaoImpl;
import com.lola.dao.NewArrivalNotiDao;
import com.lola.dao.NewArrivalNotiDaoImpl;
import com.lola.dao.OnSaleNotificationDao;
import com.lola.dao.OnSaleNotificationDaoImpl;
import com.lola.dao.SpecialNotiDao;
import com.lola.dao.SpecialNotiDaoImpl;
import com.lola.model.DealsnOffersNoti;
import com.lola.model.NewArrivalNoti;
import com.lola.model.UserBrand;

public class ViewedNotificationUtility {
	
	NewArrivalNotiDao newArrivalNotiDaoImpl=new NewArrivalNotiDaoImpl();
	DealsnOffersNotiDao dealsnOffersNotiDaoImpl=new  DealsnOffersNotiDaoImpl();
	SpecialNotiDao specialNotiDaoImpl =new SpecialNotiDaoImpl();
	OnSaleNotificationDao onSaleNotificationDaoImpl=new OnSaleNotificationDaoImpl();
	
	public String userviewed(int userid,String dealsoffers,String newarrivals,String myspecials) throws Exception{
		JSONObject jsonObject = null;
		try{
			if(dealsoffers!=null)
			dealsnOffersNotiDaoImpl.saveUserViewed(userid, dealsoffers);
			if(newarrivals!=null)
			newArrivalNotiDaoImpl.saveUserViewed1(userid, newarrivals);
			if(myspecials!=null)
			specialNotiDaoImpl.saveUserViewed(userid, myspecials);
			
			jsonObject =new JSONObject();
			jsonObject.put("Status","Success");
			jsonObject.put("Message","Successfully Saved");
			
		}catch(Exception e){
			jsonObject.put("Status","Failure");
			jsonObject.put("Message","No Records");
			return jsonObject.toString();
		}
		
		return jsonObject.toString();
	}
	
	public String userviewedNotification(int userid, String bucketids) throws Exception{
		JSONObject jsonObject = null;
		String dealsoffers = "";
		String newarrivals = "";
		String myspecials = "";
		String onsale = "";
		int countSpecial =0,countNew=0,countDeals=0,countOnsale=0;
		StringTokenizer newList = new StringTokenizer(bucketids);
		
		try{
			
			for(int i=0;newList.hasMoreTokens();i++)
			{
				
				String tempStr = newList.nextToken(",");	
				long tempInt = Integer.parseInt(tempStr);
				if(tempInt <= 100000)
				{
					if(countSpecial==0)
					{
					myspecials=myspecials+tempInt;
					countSpecial++;
					}
					else
						myspecials=myspecials+","+tempInt;
				}
				if(tempInt <=300000 && tempInt >= 200000)
				{
					if(countNew==0)
					{
					newarrivals=newarrivals+tempInt;
					countNew++;
					}
					else
						newarrivals=newarrivals+","+tempInt;
				}
				if(tempInt <= 600000 && tempInt >= 500000)
				{
					if(countDeals==0)
					{
						dealsoffers=dealsoffers+tempInt;
					countDeals++;
					}
					else
						dealsoffers=dealsoffers+","+tempInt;
										
				}
				if(tempInt <= 800000 && tempInt >= 700000)
				{
					if(countOnsale==0)
					{
						onsale=onsale+tempInt;
						countOnsale++;
					}
					else
						onsale=onsale+","+tempInt;
										
				}
				
				
				
			}
			
			System.out.println("myspecials:"+myspecials);
			System.out.println("newarrivals:"+newarrivals);
			System.out.println("dealsoffers:"+dealsoffers);
			
		dealsnOffersNotiDaoImpl.saveUserViewed(userid, dealsoffers);
			newArrivalNotiDaoImpl.saveUserViewed1(userid, newarrivals);
		specialNotiDaoImpl.saveUserViewed(userid, myspecials);
		onSaleNotificationDaoImpl.saveUserViewed(userid, onsale);
			
		jsonObject =new JSONObject();
		jsonObject.put("Status","Success");
		jsonObject.put("Message","Successfully Saved");
		
	}catch(Exception e){
		jsonObject.put("Status","Failure");
		jsonObject.put("Message","No Records");
		return jsonObject.toString();
	}
	
	return jsonObject.toString();
	}
	
	
	//user viewed notification for dealsandoffers
	
	public String uservieweddealsnoffers(int userid,String dealsoffers) throws Exception{
		JSONObject jsonObject = null;
		try{
			if(dealsoffers!=null)
			dealsnOffersNotiDaoImpl.saveUserViewed(userid, dealsoffers);
			
			
			jsonObject =new JSONObject();
			jsonObject.put("Status","Success");
			jsonObject.put("Message","Successfully Saved");
			
		}catch(Exception e){
			jsonObject.put("Status","Failure");
			//jsonObject.put("Message",e.toString());
			jsonObject.put("Message","No Records");
			return jsonObject.toString();
		}
		
		return jsonObject.toString();
	}
	
	//user viewed notification for MySpecials
	
	public String userviewedMySpecials(int userid, String myspecials) throws Exception{
		JSONObject jsonObject = null;
		try{
			
			if(myspecials!=null)
			specialNotiDaoImpl.saveUserViewed(userid, myspecials);
			
			jsonObject =new JSONObject();
			jsonObject.put("Status","Success");
			jsonObject.put("Message","Successfully Saved");
			
		}catch(Exception e){
			jsonObject.put("Status","Failure");
			//jsonObject.put("Message",e.toString());
			jsonObject.put("Message","Not saved");
			return jsonObject.toString();
		}
		
		return jsonObject.toString();
	}
	
public static void main(String args[]) throws Exception{
	ViewedNotificationUtility dealsnOffersNotiUtility=new  ViewedNotificationUtility();
	//System.out.println(dealsnOffersNotiUtility.userviewed(2, "2,3", "2,4", "3"));
	//System.out.println(dealsnOffersNotiUtility.uservieweddealsnoffers(3, "2,3"));
	System.out.println(dealsnOffersNotiUtility.userviewedNotification(1, "500000,500003,10002,200002,700001"));
	
}
	
	

}
