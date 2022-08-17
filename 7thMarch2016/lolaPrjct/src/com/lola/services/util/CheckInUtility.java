package com.lola.services.util;

import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.lola.dao.BrandDealsandOffersDao;
import com.lola.dao.BrandDealsandOffersDaoImpl;
import com.lola.dao.BrandMySpecialsDao;
import com.lola.dao.BrandMySpecialsDaoImpl;
import com.lola.dao.BrandNewArrivalsDao;
import com.lola.dao.BrandNewArrivalsDaoImpl;
import com.lola.dao.BrandShowRoomDao;
import com.lola.dao.BrandShowRoomDaoImpl;
import com.lola.dao.OnSaleDao;
import com.lola.dao.OnSaleDaoImlp;
import com.lola.model.BrandDealsandOffers;
import com.lola.model.BrandNewArrivals;
import com.lola.model.BrandShowRoom;
import com.lola.model.MySpecialsChild;
import com.lola.model.OnSale;

public class CheckInUtility {
	
	
	public String checkInUtility(int brandId,double lat,double lng) throws Exception{
		try{
		BrandShowRoomDao BrandShowRoomDaoImpl=new BrandShowRoomDaoImpl();
	    BrandMySpecialsDao brandMySpecialsDaoImpl=new  BrandMySpecialsDaoImpl();
		OnSaleDao onSaleDaoImlp =new OnSaleDaoImlp();
		BrandDealsandOffersDao brandDealsandOffersDaoImpl=new BrandDealsandOffersDaoImpl();
		BrandNewArrivalsDao brandNewArrivalsDaoImpl=new  BrandNewArrivalsDaoImpl();
		JSONObject jsonObject = null;
		JSONObject jsonObject1 = null;
		JSONArray jsonArray = new JSONArray();
		
		List<MySpecialsChild> myspecial =brandMySpecialsDaoImpl.findAllAvailableDeatilsOfMySpecial(brandId);
		List<OnSale> onsale=onSaleDaoImlp.findAllAvailableDetailsOfOnsale(brandId);
		List<BrandDealsandOffers> brandDealsandOffers=brandDealsandOffersDaoImpl.findAllAvailableDetailesOfDealsOffers(brandId);
		List<BrandNewArrivals> brandNewArrivals=brandNewArrivalsDaoImpl.findAllAvailableNewArrivals(brandId);
		List<BrandShowRoom> brandshowroomsdetails=BrandShowRoomDaoImpl.getBrandShowroomDetail(brandId,lat,lng);
		
		
		if (myspecial.size() != 0 || onsale.size() != 0
				|| brandNewArrivals.size() != 0
				|| brandDealsandOffers.size() != 0
				|| brandNewArrivals.size() != 0
				) {
		
		if(myspecial.size()>0){
			
		for(MySpecialsChild o:myspecial){
			
			//List<BrandShowRoom> brandshowroomsdetails=BrandShowRoomDaoImpl.getBrandShowroomDetail(brandId,lat,lng);
			jsonObject = new JSONObject();
			jsonObject.put("BrandId", o.getBrandId());
			jsonObject.put("Available", o.isAvailable());
			jsonObject.put("Bookable", o.isBookable());
			jsonObject.put("Content", o.getContent());
			jsonObject.put("shopId", o.getBrandshopid());
			jsonObject.put("myspecialchildid", o.getMyspecialchildId());
			
			jsonObject.put("Imagepath",LolaConstants.url+o.getChildimagepath());
			jsonArray.put(jsonObject);
			/*
			if(brandshowroomsdetails.size()>0){
			for(BrandShowRoom i:brandshowroomsdetails){
				jsonObject = new JSONObject();
				jsonObject.put("lat", i.getLattitude());
				jsonObject.put("lang", i.getLongtitude());
				jsonArray.put(jsonObject);
				
			}
			*/
			//}
			
		
		}
		
		}
		
		
		
		if(onsale.size()>0){
		
		for(OnSale o1:onsale){
			//List<BrandShowRoom> brandshowroomsdetails=BrandShowRoomDaoImpl.getBrandShowroomDetail(brandId,lat,lng);
			
			jsonObject = new JSONObject();
			jsonObject.put("BrandId", o1.getBrandId());
			jsonObject.put("Available", o1.isAvailable());
			jsonObject.put("Bookable", o1.isBookable());
			
			jsonObject.put("Content", o1.getContent());
			jsonObject.put("shopId", o1.getBrandshopid());
			jsonObject.put("onsaleid", o1.getOnsaleId());
			jsonObject.put("Imagepath",LolaConstants.url+o1.getOnsaleimage());
			
			jsonArray.put(jsonObject);
			
			
			/*if(brandshowroomsdetails.size()>0){
				for(BrandShowRoom i1:brandshowroomsdetails){
					jsonObject = new JSONObject();
					jsonObject.put("lat", i1.getLattitude());
					jsonObject.put("lang", i1.getLongtitude());
					jsonArray.put(jsonObject);
				}
				
			}*/
		}
		
		}
		
		
		
		
		if(brandDealsandOffers.size()>0){
		for(BrandDealsandOffers o2:brandDealsandOffers){
		
			//List<BrandShowRoom> brandshowroomsdetails=BrandShowRoomDaoImpl.getBrandShowroomDetail(brandId,lat,lng);
		
		jsonObject = new JSONObject();
		jsonObject.put("BrandId", o2.getBrandId());
		jsonObject.put("Available", o2.isAvailable());
		jsonObject.put("Bookable", o2.isBookable());
		jsonObject.put("Content", o2.getContent());
		jsonObject.put("shopId", o2.getBrandshopid());
		jsonObject.put("dealandofferid", o2.getDealandofferId());
		jsonObject.put("Imagepath",LolaConstants.url+o2.getOfferImage());
		jsonArray.put(jsonObject);
		
		
		/*if(brandshowroomsdetails.size()>0){
			for(BrandShowRoom i2:brandshowroomsdetails){
				jsonObject = new JSONObject();
				jsonObject.put("lat", i2.getLattitude());
				jsonObject.put("lang", i2.getLongtitude());
				jsonArray.put(jsonObject);
			}
			
		}*/
		}
		}
		
		
		
		if(brandNewArrivals.size()>0){
		for(BrandNewArrivals o3:brandNewArrivals){
			
			//
			jsonObject = new JSONObject();
			jsonObject.put("BrandId", o3.getBrandId());
			jsonObject.put("Available", o3.isAvailable());
			jsonObject.put("Bookable", o3.isBookable());
			jsonObject.put("Content", o3.getContent());
			jsonObject.put("shopId",o3.getBrandshopid());
			jsonObject.put("newarrivalid", o3.getNewarrivalId());
			jsonObject.put("Imagepath",LolaConstants.url+o3.getArrivalImage());
			jsonArray.put(jsonObject);
			
			
			
			
			}
		
		}
		
		if(brandshowroomsdetails.size()>0){
		for(BrandShowRoom i3:brandshowroomsdetails){
			jsonObject = new JSONObject();
			jsonObject.put("lat", i3.getLattitude());
			jsonObject.put("lang", i3.getLongtitude());
			jsonArray.put(jsonObject);
		}
		
	}
		jsonObject1 = new JSONObject();
		jsonObject1.put("Status", "Success");
		jsonObject1.put("Data", jsonArray);
		
		
		return jsonObject1.toString().replace("\\", "");
	
		}else{
			jsonObject1 = new JSONObject();
			jsonObject1.put("Status", "Success");
			jsonObject1.put("Data","No Records");
			return jsonObject1.toString().replace("\\", "");
		}
		}catch(Exception e){
			System.out.println(e.toString());
		 JSONObject jsonObject = null;
		jsonObject = new JSONObject();
		jsonObject.put("Status", "Failure");
		jsonObject.put("Message", "No brands");
		 return jsonObject.toString();
	}
	}
	
	
	public static void main(String args[]) throws Exception{
		CheckInUtility checkInUtility = new CheckInUtility();
		System.out.println(checkInUtility.checkInUtility(2,13.0063,80.2574));
		
		
		
	}
}
