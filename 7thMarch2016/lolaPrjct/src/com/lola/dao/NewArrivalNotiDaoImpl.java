package com.lola.dao;

import java.util.List;
import java.util.StringTokenizer;

import com.lola.model.NewArrivalNoti;

public class NewArrivalNotiDaoImpl implements NewArrivalNotiDao <NewArrivalNoti,String>{

	
	public NewArrivalNotiDaoImpl(){
		
	}
				public int getMyNewArrivalsCount(int userid)
				 {
					int newarrivalCount =0;
					//NewArrivalNotiDao newArrivalNoti= new NewArrivalNotiDaoImpl();
					
					 hibernateUtil.openCurrentSession();
					 List<Object> naCount = hibernateUtil.getCurrentSession().createQuery("select count(*) from BrandNewArrivals where newarrivalId not in(select newarrivalId from NewArrivalNoti where userId =("+userid+"))and brandid in (select brandid from UserBrand where userId ="+userid+" and liked=1 and onoffnoti=1)").setCacheable(false).list();
					hibernateUtil.closeCurrentSession();
					if(naCount.size()>0)
					{
						for(Object o : naCount)
						{
							newarrivalCount = Integer.parseInt((o.toString()));
						}
					}
					 
					 return newarrivalCount;
				 }	
				
				public List<Object[]> getMyNewArrivalsDetails(int userId)
				{
				
					
					hibernateUtil.openCurrentSession();
					 List<Object[]> brandCount = hibernateUtil.getCurrentSession().createQuery("select newarrivalId,createdon,newarrivalmsg,newarrivaldesc,brandId,arrivalImage,content from BrandNewArrivals where  newarrivalId not in(select newarrivalId from NewArrivalNoti where userId ="+userId+")and brandid in (select brandid from UserBrand where userId ="+userId+" and liked=1 and onoffnoti=1))").setCacheable(false).list();
					hibernateUtil.closeCurrentSession();		
					 
					 return brandCount;
					 
				}
				
				@Override
				public void persist(NewArrivalNoti entity) {
					// TODO Auto-generated method stub
				
					hibernateUtil.openCurrentSessionwithTransaction();
					hibernateUtil.getCurrentSession().saveOrUpdate(entity);
					hibernateUtil.closeCurrentSessionwithTransaction();
				}
				
				
				public String saveUserViewed1(int userid, String naids) throws Exception
				{
					


					StringTokenizer st = new StringTokenizer(naids);
					
						 
						for(int i=0;st.hasMoreTokens();i++)
						{
							NewArrivalNoti newArrivalNoti =new NewArrivalNoti();
							int noids = Integer.parseInt(st.nextToken(","));			
							newArrivalNoti.setUserId(userid);
							newArrivalNoti.setNewarrivalId(noids);
							NewArrivalNotiDaoImpl NewArrivalNotiDaoImpl=new NewArrivalNotiDaoImpl();	
							NewArrivalNotiDaoImpl.persist(newArrivalNoti);
						}
						
						return "save";
				}
				
				//This is for users particular brand NA count
				
				public int getMyNewArrivalsCount(int userid,int brandid)
				 {
					int newarrivalCount =0;
					NewArrivalNotiDao newArrivalNoti= new NewArrivalNotiDaoImpl();
					/*String brandids = dealsnOffersNoti.getMyDealsnOffersCount(userid).toString();
						if(brandids.equals(""))
							brandids="0";*/
					 hibernateUtil.openCurrentSession();
					 List<Object> naCount = hibernateUtil.getCurrentSession().createQuery("select count(*) from BrandNewArrivals where newarrivalId not in(select newarrivalId from NewArrivalNoti where userId ="+userid+")and brandid  ="+brandid).setCacheable(false).list();
					hibernateUtil.closeCurrentSession();
					if(naCount.size()>0)
					{
						for(Object o : naCount)
						{
							newarrivalCount = Integer.parseInt((o.toString()));
						}
					}
					 
					 return newarrivalCount;
				 }	
				
				public List<Object[]> getMyNewArrivalsDetails(int userId,int brandid)
				{
				
					
					hibernateUtil.openCurrentSession();
					 List<Object[]> brandCount = hibernateUtil.getCurrentSession().createQuery("select newarrivalId,createdon,newarrivalmsg,newarrivaldesc from BrandNewArrivals where newarrivalId not in(select newarrivalId from NewArrivalNoti where userId ="+userId+")and brandid ="+brandid).setCacheable(false).list();
					hibernateUtil.closeCurrentSession();		
					 
					 return brandCount;
					 
				}
				
				public static void main(String args[]) throws Exception
				{
					
					NewArrivalNotiDaoImpl newArrivalNotiDaoImpl = new NewArrivalNotiDaoImpl();
					
					//System.out.println(newArrivalNotiDaoImpl.getMyNewArrivalsCount(3));
					
					List<Object[]> images = newArrivalNotiDaoImpl.getMyNewArrivalsDetails(1);
					if(images.size()>0){
					for(Object[] i : images)
					{
						System.out.println(i[0].toString()+"   "+i[1].toString()+"    "+i[2].toString()+"    "+i[3].toString()+"     "+i[4].toString());
					}
					}
					else
						System.out.println("No records");
				
					
			//	System.out.println(newArrivalNotiDaoImpl.saveUserViewed1(1, "1,2,3"));	
				//	System.out.println(newArrivalNotiDaoImpl.getMyNewArrivalsCount(2));
				}
				
}
