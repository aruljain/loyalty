package com.lola.services.util;

import java.net.URLEncoder;
import java.util.List;

import org.codehaus.jettison.json.JSONObject;

import com.lola.dao.BrandDealsandOffersDao;
import com.lola.dao.BrandDealsandOffersDaoImpl;
import com.lola.dao.BrandMySpecialsDao;
import com.lola.dao.BrandMySpecialsDaoImpl;
import com.lola.dao.BrandNewArrivalsDao;
import com.lola.dao.BrandNewArrivalsDaoImpl;
import com.lola.dao.BrandShowRoomDao;
import com.lola.dao.BrandShowRoomDaoImpl;
import com.lola.dao.DealsAndOffersLeafPageDao;
import com.lola.dao.DealsAndOffersLeafPageDaoImpl;
import com.lola.dao.MySpecialLeafPageDao;
import com.lola.dao.MySpecialLeafPageDaoImpl;
import com.lola.dao.NewarrivalsLeafPageDao;
import com.lola.dao.NewarrivalsLeafPageDaoImpl;
import com.lola.dao.OnSaleDao;
import com.lola.dao.OnSaleDaoImlp;
import com.lola.dao.OnSaleLeafPageDao;
import com.lola.dao.OnSaleLeafPageDaoImpl;
import com.lola.dao.UserDao;
import com.lola.dao.UserDaoImpl;
import com.lola.model.BrandDealsandOffers;
import com.lola.model.BrandMySpecials;
import com.lola.model.BrandNewArrivals;
import com.lola.model.DealsAndOffersLeafPage;
import com.lola.model.MySpecialLeafPage;
import com.lola.model.MySpecialsChild;
import com.lola.model.NewarrivalsLeafPage;
import com.lola.model.OnSale;
import com.lola.model.OnSaleLeafPage;
import com.lola.model.User;

public class BooknowUtility {
	
	
	
	
	public String SendBooknow(int userId,int bucketId,int brandId) throws Exception{
		
		OnSaleLeafPageDao onSaleLeafPageDaoImpl = new OnSaleLeafPageDaoImpl();
		JSONObject jsonObject = null;
		MySpecialLeafPageDao mySpecialLeafPageDaoImpl = new MySpecialLeafPageDaoImpl();
		NewarrivalsLeafPageDao newarrivalsLeafPageDaoImpl = new NewarrivalsLeafPageDaoImpl();
		DealsAndOffersLeafPageDao dealsAndOffersLeafPageDaoImpl = new DealsAndOffersLeafPageDaoImpl();
		UserDao userDaoImpl=new  UserDaoImpl();
		BrandShowRoomDaoImpl brandShowRoomDaoImpl=new BrandShowRoomDaoImpl();
		BrandDealsandOffersDao brandDealsandOffersDaoImpl=new BrandDealsandOffersDaoImpl();
		OnSaleDao onSaleDaoImpl=new  OnSaleDaoImlp();
		BrandNewArrivalsDao brandNewArrivalsDaoImpl =new BrandNewArrivalsDaoImpl();
		BrandMySpecialsDao brandMySpecialsDaoImpl =new BrandMySpecialsDaoImpl();
		SMSUtility smsUtility=new SMSUtility();
		String Msg=null;
		String message=null;
		String  msgcontent=null;
		String descp=null;
		try{
			if(bucketId <= 800000 && bucketId >= 700000){
			OnSaleLeafPage onSaleLeafPage = new  OnSaleLeafPage();
					List<OnSaleLeafPage> user =onSaleLeafPageDaoImpl.findByuserId(userId);
					List<OnSale> onsale=onSaleDaoImpl.findByOnSaleId(bucketId);
			if(user.size()>0){
					
						List<OnSaleLeafPage> user1=onSaleLeafPageDaoImpl.findByonSaleid(bucketId);
						if(user1.size()>0){
						
							for(OnSaleLeafPage entity:user1){
								entity.setUserId(userId);
								entity.setOnsaleid(bucketId);
								entity.setOnsaleleafpageId(entity.getOnsaleleafpageId());
								entity.setLiked(entity.isLiked());
						
						if(entity.isBook()){
							entity.setBook(true);
							Msg="Thanks for Booking this offer!";
							}
						else{
							entity.setBook(true);;
							Msg="Thanks for Booking this offer!";
							}
						
			
						onSaleLeafPageDaoImpl.update(entity);
						for(OnSale x:onsale)
							
							// descp=x.getOnsalemsg().toString();
						descp=x.getOnsaledesc().toString();
						
						}}
						else{
							onSaleLeafPage.setOnsaleid(bucketId);
							onSaleLeafPage.setUserId(userId);
							onSaleLeafPage.setLiked(onSaleLeafPage.isLiked());
							
							 if(onSaleLeafPage.isBook()){
								 onSaleLeafPage.setBook(true);;
									Msg="Thanks for Booking this offer!";
									}
								else{
									onSaleLeafPage.setBook(true);
									Msg="Thanks for Booking this offer!";
									}
							 onSaleLeafPageDaoImpl.persist(onSaleLeafPage);
							 for(OnSale x:onsale)
									
								// descp=x.getOnsalemsg().toString();
							 descp=x.getOnsaledesc().toString();
						}
					
						
					
			
			}else{
				onSaleLeafPage.setUserId(userId);
				onSaleLeafPage.setOnsaleid(bucketId);
				
				
				onSaleLeafPage.setBook(true);;
				
				onSaleLeafPageDaoImpl.persist(onSaleLeafPage);
				Msg="Thanks for Booking this offer!";
				for(OnSale x:onsale)
					
					 //descp=x.getOnsalemsg().toString();
					descp=x.getOnsaledesc().toString();
				      

			}
			
			}
			
			if(bucketId <=300000 && bucketId >= 200000){
				NewarrivalsLeafPage newarrivalsLeafPage = new  NewarrivalsLeafPage();
				List<NewarrivalsLeafPage> user =newarrivalsLeafPageDaoImpl.findByuserId(userId);
				List<BrandNewArrivals> brandNewArrivals=brandNewArrivalsDaoImpl.findBynewarrivalId(bucketId);
		if(user.size()>0){
				
					List<NewarrivalsLeafPage> user1=newarrivalsLeafPageDaoImpl.findBynewarrivalId(bucketId);
					if(user1.size()>0){
					
						for(NewarrivalsLeafPage entity:user1){
							entity.setUserId(userId);
							entity.setNewarrivalId(bucketId);
							entity.setNewarrivalsleafpageId(entity.getNewarrivalsleafpageId());
							entity.setLiked(entity.isLiked());
					
					if(entity.isBook()){
						entity.setBook(true);;
						Msg="Thanks for Booking this offer!";
						}
					else{
						entity.setBook(true);;
						Msg="Thanks for Booking this offer!";
						}
					
		
					newarrivalsLeafPageDaoImpl.update(entity);
					
					for(BrandNewArrivals x:brandNewArrivals)
						
						 //descp=x.getNewarrivalmsg().toString();
					     descp=x.getNewarrivaldesc().toString();
					}}
					else{
						newarrivalsLeafPage.setNewarrivalId(bucketId);
						newarrivalsLeafPage.setUserId(userId);
						newarrivalsLeafPage.setLiked(newarrivalsLeafPage.isLiked());
						
						 if(newarrivalsLeafPage.isBook()){
							 newarrivalsLeafPage.setBook(true);;
								Msg="Thanks for Booking this offer!";
								}
							else{
								newarrivalsLeafPage.setBook(true);;
								Msg="Thanks for Booking this offer!";
								}
						 newarrivalsLeafPageDaoImpl.persist(newarrivalsLeafPage);
						 for(BrandNewArrivals x:brandNewArrivals)
								
							 //descp=x.getNewarrivalmsg().toString();
						 descp=x.getNewarrivaldesc().toString();
						
					}
				
					
				
		
		}else{
			newarrivalsLeafPage.setUserId(userId);
			newarrivalsLeafPage.setNewarrivalId(bucketId);
			newarrivalsLeafPage.setLiked(newarrivalsLeafPage.isLiked());
			newarrivalsLeafPage.setBook(true);
			
			
			newarrivalsLeafPageDaoImpl.persist(newarrivalsLeafPage);
			Msg="Thanks for Booking this offer!";
			
			for(BrandNewArrivals x:brandNewArrivals)
				
				 //descp=x.getNewarrivalmsg().toString();
			     descp=x.getNewarrivaldesc().toString();
			


		}
			}
			
			if(bucketId <= 600000 && bucketId >= 500000){
				DealsAndOffersLeafPage dealsAndOffersLeafPage = new  DealsAndOffersLeafPage();
				List<DealsAndOffersLeafPage> user =dealsAndOffersLeafPageDaoImpl.findByuserId(userId);
				List<BrandDealsandOffers> brandDealsandOffers =brandDealsandOffersDaoImpl.findBydealandofferId(bucketId);
		if(user.size()>0){
				
					List<DealsAndOffersLeafPage> user1=dealsAndOffersLeafPageDaoImpl.findBydealsandofferid(bucketId);
					if(user1.size()>0){
					
						for(DealsAndOffersLeafPage entity:user1){
							entity.setUserid(userId);
							entity.setDealandofferid(bucketId);
							entity.setDealsandoffersleafId(entity.getDealsandoffersleafId());
							entity.setLiked(entity.isLiked());
					
					if(entity.isBook()){
						entity.setBook(true);
						Msg="Thanks for Booking this offer!";
						}
					else{
						entity.setBook(true);;
						Msg="Thanks for Booking this offer!";
						}
					
					dealsAndOffersLeafPageDaoImpl.update(entity);
					for(BrandDealsandOffers x:brandDealsandOffers)
						
					// descp=x.getOffermsg().toString();
					descp=x.getDealDesc().toString();
					
					}}
					else{
						dealsAndOffersLeafPage.setDealandofferid(bucketId);
						dealsAndOffersLeafPage.setUserid(userId);
						dealsAndOffersLeafPage.setLiked(dealsAndOffersLeafPage.isLiked());
						
						 if(dealsAndOffersLeafPage.isBook()){
							 dealsAndOffersLeafPage.setBook(true);;
								Msg="Thanks for Booking this offer!";
								}
							else{
								dealsAndOffersLeafPage.setBook(true);;
								Msg="Thanks for Booking this offer!";
								}
						 dealsAndOffersLeafPageDaoImpl.persist(dealsAndOffersLeafPage);
						 for(BrandDealsandOffers x:brandDealsandOffers)
								
							// descp=x.getOffermsg().toString();
						 descp=x.getDealDesc().toString();
						
					}
				
					
				
		
		}else{
			dealsAndOffersLeafPage.setUserid(userId);
			dealsAndOffersLeafPage.setDealandofferid(bucketId);;
			dealsAndOffersLeafPage.setLiked(dealsAndOffersLeafPage.isLiked());
			dealsAndOffersLeafPage.setBook(true);
			dealsAndOffersLeafPageDaoImpl.persist(dealsAndOffersLeafPage);
			Msg="Thanks for Booking this offer!";
			for(BrandDealsandOffers x:brandDealsandOffers)
				
				// descp=x.getOffermsg().toString();
				descp=x.getDealDesc().toString();
			
				

		}
				
			}
			if(bucketId <= 100000){
				
				MySpecialLeafPage mySpecialLeafPage = new  MySpecialLeafPage();
				List<MySpecialLeafPage> user =mySpecialLeafPageDaoImpl.findByuserId(userId);
				List<MySpecialsChild> myspecial =brandMySpecialsDaoImpl.findByMySpecialChildId(bucketId);
		if(user.size()>0){
				
					List<MySpecialLeafPage> user1=mySpecialLeafPageDaoImpl.findBymyspecialId(bucketId);
					if(user1.size()>0){
					
						for(MySpecialLeafPage entity:user1){
							entity.setUserId(userId);
							entity.setMyspecialchildId(bucketId);
							entity.setMyspecialleafId(entity.getMyspecialleafId());
							entity.setLiked(entity.isLiked());
					
					if(entity.isBook()){
						entity.setBook(true);
						Msg="Thanks for Booking this offer!";
						}
					else{
						entity.setBook(true);;
						Msg="Thanks for Booking this offer!";
						}
					
		
					mySpecialLeafPageDaoImpl.update(entity);
					for(MySpecialsChild x:myspecial)
						
						// descp=x.getContent().toString();
						descp=x.getSpecialDesc().toString();
						
					}
						}
					else{
						mySpecialLeafPage.setMyspecialchildId(bucketId);
						mySpecialLeafPage.setUserId(userId);
						mySpecialLeafPage.setLiked(mySpecialLeafPage.isLiked());
						
						 if(mySpecialLeafPage.isBook()){
							 mySpecialLeafPage.setBook(true);;
								Msg="Thanks for Booking this offer!";
								}
							else{
								mySpecialLeafPage.setBook(true);;
								Msg="Thanks for Booking this offer!";
								}
						mySpecialLeafPageDaoImpl.persist(mySpecialLeafPage);
						
						for(MySpecialsChild x:myspecial)
							
							// descp=x.getContent().toString();
						descp=x.getSpecialDesc().toString();
					}
				
					
				
		
		}else{
			mySpecialLeafPage.setUserId(userId);
			mySpecialLeafPage.setMyspecialchildId(bucketId);
			mySpecialLeafPage.setLiked(mySpecialLeafPage.isLiked());
			mySpecialLeafPage.setBook(true);
			
			mySpecialLeafPageDaoImpl.persist(mySpecialLeafPage);
			Msg="Thanks for Booking this offer!";
			for(MySpecialsChild x:myspecial)
				
				 //descp=x.getContent().toString();
			descp=x.getSpecialDesc().toString();

		}
				
			}
				
			int i=0;	
			String location =userDaoImpl.getUserLocation(userId);
			List<Object[]> commonBrandshowroomsdetailsloctn=brandShowRoomDaoImpl.getBrandShowroom(brandId);
			if(commonBrandshowroomsdetailsloctn.size()>0  ){
			for(Object[] o:commonBrandshowroomsdetailsloctn){
				if(i==0){
			message="Thanks for Booking this offer!";
			
			List<User> user=userDaoImpl.findByuserid(userId);
			
			for(User o1:user)
				  msgcontent=descp+" has been booked by  "+o1.getUserName()+"  .Please call or email them to convert the booking. For your reference, User Email id:"+o1.getEmail()+",User Phone No:"+o1.getMobile() ;
				String encodedMsg = URLEncoder.encode(msgcontent, "UTF-8");
			
				//Bucket name" has been booked by "User full name". Please call or email them to convert the booking. For your reference, User emai id: "Registered email id", User Phone No: "Registered Mobile number"
				smsUtility.sendSMS(o[3].toString(),encodedMsg);
		   
		        EmailUtility.sendEmail("smtp.critsend.com",
							"587", 
							"noreply@myshareindia.com", 
							"JxRApreLseNR", 
							o[2].toString(), "Lola Login crendentials", msgcontent);}
		        i++;
					
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
			System.out.println(e);
			return jsonObject.toString();
			
		
	}
		
		
	}
	
	
	
	
	
	//***************************************
	
public String Checked(int userId,int brandId) throws Exception{
		
		OnSaleLeafPageDao onSaleLeafPageDaoImpl = new OnSaleLeafPageDaoImpl();
		JSONObject jsonObject = null;
		MySpecialLeafPageDao mySpecialLeafPageDaoImpl = new MySpecialLeafPageDaoImpl();
		NewarrivalsLeafPageDao newarrivalsLeafPageDaoImpl = new NewarrivalsLeafPageDaoImpl();
		DealsAndOffersLeafPageDao dealsAndOffersLeafPageDaoImpl = new DealsAndOffersLeafPageDaoImpl();
		UserDao userDaoImpl=new  UserDaoImpl();
		BrandShowRoomDaoImpl brandShowRoomDaoImpl=new BrandShowRoomDaoImpl();
		BrandDealsandOffersDao brandDealsandOffersDaoImpl=new BrandDealsandOffersDaoImpl();
		OnSaleDao onSaleDaoImpl=new  OnSaleDaoImlp();
		BrandNewArrivalsDao brandNewArrivalsDaoImpl =new BrandNewArrivalsDaoImpl();
		BrandMySpecialsDao brandMySpecialsDaoImpl =new BrandMySpecialsDaoImpl();
		SMSUtility smsUtility=new SMSUtility();
		String Msg=null;
		String message=null;
		String  msgcontent=null;
		String descp=null;
		try{
			
			
	
				
			int i=0;	
			String location =userDaoImpl.getUserLocation(userId);
			List<Object[]> commonBrandshowroomsdetailsloctn=brandShowRoomDaoImpl.getBrandShowroom(brandId);
			if(commonBrandshowroomsdetailsloctn.size()>0  ){
			for(Object[] o:commonBrandshowroomsdetailsloctn){
				if(i==0){
			message="Thanks ";
			
			List<User> user=userDaoImpl.findByuserid(userId);
			
			for(User o1:user){
				  msgcontent=descp+" has been booked by  "+o1.getUserName()+"  .Please call or email them to convert the booking. For your reference, User Email id:"+o1.getEmail()+",User Phone No:"+o1.getMobile() ;
				String encodedMsg = URLEncoder.encode(msgcontent, "UTF-8");
			
				//Bucket name" has been booked by "User full name". Please call or email them to convert the booking. For your reference, User emai id: "Registered email id", User Phone No: "Registered Mobile number"
				smsUtility.sendSMS(o[3].toString(),encodedMsg);
		   
		        EmailUtility.sendEmail("smtp.critsend.com",
							"587", 
							"noreply@myshareindia.com", 
							"JxRApreLseNR", 
							o[2].toString(), "Lola Login crendentials", msgcontent);}
		        i++;
				}
				}
			}
		jsonObject =new JSONObject();
		jsonObject.put("Status","Success");
		jsonObject.put("Message",message);
		
		
		return jsonObject.toString();
			
			
		
			
			
			
			
			
			
		}
		catch(Exception e){
			jsonObject =new JSONObject();
			jsonObject.put("Status", "Failure");
			jsonObject.put("Message"," ");
			System.out.println(e);
			return jsonObject.toString();
			
		
	}
		
		
	}
	
	
	
public static void main(String[] args) throws Exception{
	
	BooknowUtility booknowUtility=new BooknowUtility();
	System.out.println(booknowUtility.SendBooknow(41, 700001, 3));
	
	
	
}
}