package com.lola.dao;

import java.util.List;
import java.util.StringTokenizer;

import org.codehaus.jettison.json.JSONObject;

import com.lola.model.DealsnOffersNoti;
import com.lola.model.BrandDealsandOffers;
import com.lola.model.UserBrand;


public class DealsnOffersNotiDaoImpl implements DealsnOffersNotiDao <DealsnOffersNoti,String> {

	
			public DealsnOffersNotiDaoImpl(){
					
				}
			
			
			public int getMyDealsnOffersCount(int userid)
			 {
				int dealnofferCount =0;
				DealsnOffersNotiDao dealsnOffersNoti= new DealsnOffersNotiDaoImpl();
				
				 hibernateUtil.openCurrentSession();
				 List<Object> dnoCount = hibernateUtil.getCurrentSession().createQuery("select count(*) from BrandDealsandOffers where dealandofferId not in(select dealandofferId from DealsnOffersNoti where userId ="+userid+")and brandid in (select brandid from UserBrand where userId ="+userid+" and liked=1 and onoffnoti=1)").setCacheable(false).list();
				hibernateUtil.closeCurrentSession();		
				if(dnoCount.size()>0)
				{
					for(Object o : dnoCount)
					{
						dealnofferCount = Integer.parseInt((o.toString()));
					}
				}
								 
				 return dealnofferCount;
			 }	
			
		
			public List<Object[]> getMyDealsnOffersDetails(int userId)
			{
			
				
				hibernateUtil.openCurrentSession();
				 //List<Object[]> brandCount = hibernateUtil.getCurrentSession().createQuery("select dealandofferId,createdon,offermsg,dealDesc,brandId from BrandDealsandOffers where liked=0  and  dealandofferId not in(select dealandofferId from DealsnOffersNoti where userId ="+userId+")and brandid in (select brandid from UserBrand where userId ="+userId+" and liked=1)").setCacheable(false).list();
				 List<Object[]> brandCount = hibernateUtil.getCurrentSession().createQuery("select dealandofferId,createdon,offermsg,dealDesc,brandId,offerImage,content from BrandDealsandOffers where   dealandofferId not in(select dealandofferId from DealsnOffersNoti where userId ="+userId+")and brandid in (select brandid from UserBrand where userId ="+userId+" and liked=1 and onoffnoti=1)").setCacheable(false).list();
				hibernateUtil.closeCurrentSession();		
				 
				 return brandCount;
				 
			}
			
			

			@Override
			public void persist(DealsnOffersNoti entity) {
				// TODO Auto-generated method stub
				hibernateUtil.openCurrentSessionwithTransaction();
				hibernateUtil.getCurrentSession().saveOrUpdate(entity);
				hibernateUtil.closeCurrentSessionwithTransaction();
			}
			public String saveUserViewed(int userid, String dnoids) throws Exception
			{
				


				StringTokenizer st = new StringTokenizer(dnoids);
				
					
					for(int i=0;st.hasMoreTokens();i++)
					{
						DealsnOffersNoti dealsnOffersNoti = new DealsnOffersNoti();
						int dnoid = Integer.parseInt(st.nextToken(","));			
						dealsnOffersNoti.setUserId(userid);
						dealsnOffersNoti.setDealandofferId(dnoid);;
						DealsnOffersNotiDao dealsnOffersNotiDaoImpl=new  DealsnOffersNotiDaoImpl();
						dealsnOffersNotiDaoImpl.persist(dealsnOffersNoti);
							
					}

				return "save";
				}
				
			
			
			 //This is for users particular brand D&O count
			
			   public int getMyDealsnOffersCount(int userid, int brandid)
			    {
			    int dealnofferCount =0;
			    DealsnOffersNotiDao dealsnOffersNoti= new DealsnOffersNotiDaoImpl();
			    
			     hibernateUtil.openCurrentSession();
			     List<Object> dnoCount = hibernateUtil.getCurrentSession().createQuery("select count(*) from BrandDealsandOffers where dealandofferId not in(select dealandofferId from DealsnOffersNoti where userId ="+userid+")and brandid="+brandid).setCacheable(false).list();
			    hibernateUtil.closeCurrentSession();  
			    if(dnoCount.size()>0)
			    {
			     for(Object o : dnoCount)
			     {
			      dealnofferCount = Integer.parseInt((o.toString()));
			     }
			    }
			         
			     return dealnofferCount;
			    } 
			   
			   //This is for users particular brand D&O Details
			   
			   public List<Object[]> getMyDealsnOffersDetails(int userId, int brandid)
			   {
			   
			    
			    hibernateUtil.openCurrentSession();
			     List<Object[]> brandCount = hibernateUtil.getCurrentSession().createQuery("select dealandofferId,createdon,offermsg,dealDesc from BrandDealsandOffers where dealandofferId not in(select dealandofferId from DealsnOffersNoti where userId ="+userId+")and brandid="+brandid).setCacheable(false).list();
			    hibernateUtil.closeCurrentSession();  
			     
			     return brandCount;
			     
			   }
			
			

			public static void main(String args[]) throws Exception
			{
				
				DealsnOffersNotiDaoImpl dealsnOffersNotiDaoImpl = new DealsnOffersNotiDaoImpl();
				
				//System.out.println(dealsnOffersNotiDaoImpl.getMyDealsnOffersCount(3));
				
				List<Object[]> images = dealsnOffersNotiDaoImpl.getMyDealsnOffersDetails(1);
				if(images.size()>0){
				for(Object[] i : images)
				{
					System.out.println(i[0].toString()+"   "+i[1].toString()+"    "+i[2].toString()+"    "+i[3].toString()+"    "+i[4].toString());
				}
				}
				else
					System.out.println("No records");
				//hibernateUtil.closeCurrentSession();
		

			//	System.out.println(dealsnOffersNotiDaoImpl.saveUserViewed(1, "1,2,3"));
			//System.out.println(dealsnOffersNotiDaoImpl.getMyDealsnOffersCount(1, 3));
			
			}		
      
}

