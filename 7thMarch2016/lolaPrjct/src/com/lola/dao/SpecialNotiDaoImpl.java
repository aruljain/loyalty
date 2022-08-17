package com.lola.dao;

import java.util.List;
import java.util.StringTokenizer;

import com.lola.model.DealsnOffersNoti;
import com.lola.model.SpecialNoti;

public class SpecialNotiDaoImpl implements SpecialNotiDao <SpecialNoti,String>{

	
	public SpecialNotiDaoImpl(){
		
	}
				public int getMySpecailsCount(int userid)
				 {
					int specialCount =0;
					//SpecialNotiDao specialNoti= new SpecialNotiDaoImpl();
				
					 hibernateUtil.openCurrentSession();
					// List<Object> sCount = hibernateUtil.getCurrentSession().createQuery("select count(*) from BrandMySpecials where brandspecialId not in(select brandspecialId from SpecialNoti where userId =("+userid+"))and brandid in (select brandid from UserBrand where userId ="+userid+" and liked=1)").setCacheable(false).list();
					 List<Object> sCount = hibernateUtil.getCurrentSession().createQuery("select count(*) from BrandMySpecials p, MySpecialsChild c where p.brandId=c.brandId and c.myspecialchildId not in(select myspecialchildId from SpecialNoti where userId ="+userid+") and p.brandId in (select brandid from UserBrand where userid ="+userid+" and liked=1 and onoffnoti=1)").setCacheable(false).list();
					 
					
					 //List<Object> sCount = hibernateUtil.getCurrentSession().createSQLQuery("CALL sp_myspecials(:userid)").setParameter("userid", userid).list();
					 hibernateUtil.closeCurrentSession();	
					if(sCount.size()>0)
					{
						for(Object o : sCount)
						{
							specialCount = Integer.parseInt((o.toString()));
						}
					}
					 
					 return specialCount;
				 }	
				
				

				/*public List<Object[]> getMySpecailsDetails(int userId)
				{
				
					
					hibernateUtil.openCurrentSession();
					 //List<Object[]> brandCount = hibernateUtil.getCurrentSession().createQuery("select brandspecialId,createdon,specialmsg,specialdesc,brandId from BrandMySpecials where brandspecialId not in(select brandspecialId from SpecialNoti where userId ="+userId+") and brandid in (select brandid from UserBrand where userid ="+userId+" and liked=1) and brandspecialId not in (select brandspecialid from MySpecialsChild where userId="+userId+" and liked=1)").setCacheable(false).list();
					 List<Object[]> brandCount = hibernateUtil.getCurrentSession().createQuery("select brandspecialId,createdon,specialmsg,specialdesc,brandId from BrandMySpecials where brandspecialId not in(select brandspecialId from SpecialNoti where userId ="+userId+") and brandid in (select brandid from UserBrand where userid ="+userId+" and liked=1)").setCacheable(false).list();
					hibernateUtil.closeCurrentSession();		
					 
					 return brandCount;
					 
				}*/
				
				
				public List<Object[]> getMySpecailsDetails(int userId)
				{
				
					
					hibernateUtil.openCurrentSession();
					 //List<Object[]> brandCount = hibernateUtil.getCurrentSession().createQuery("select brandspecialId,createdon,specialmsg,specialdesc,brandId from BrandMySpecials where brandspecialId not in(select brandspecialId from SpecialNoti where userId ="+userId+") and brandid in (select brandid from UserBrand where userid ="+userId+" and liked=1) and brandspecialId not in (select brandspecialid from MySpecialsChild where userId="+userId+" and liked=1)").setCacheable(false).list();
					 List<Object[]> brandCount = hibernateUtil.getCurrentSession().createQuery("select p.brandspecialId,p.createdon,p.specialmsg,p.specialdesc,p.brandId,c.myspecialchildId,c.childimagepath,c.content from BrandMySpecials p, MySpecialsChild c where p.brandId=c.brandId and c.myspecialchildId not in(select myspecialchildId from SpecialNoti where userId ="+userId+") and p.brandId in (select brandid from UserBrand where userid ="+userId+" and liked=1 and onoffnoti=1)").setCacheable(false).list();
					hibernateUtil.closeCurrentSession();		
					 
					 return brandCount;
					 
				}
				
				
				@Override
				public void persist(SpecialNoti entity) {
					// TODO Auto-generated method stub
					hibernateUtil.openCurrentSessionwithTransaction();
					//hibernateUtil.getCurrentSession().saveOrUpdate(entity);
					hibernateUtil.getCurrentSession().save(entity);
					hibernateUtil.closeCurrentSessionwithTransaction();
					
				}
				
				
				public String saveUserViewed(int userid, String sepids) throws Exception
				{
					


					StringTokenizer st = new StringTokenizer(sepids);
					
						
						for(int i=0;st.hasMoreTokens();i++)
						{
							SpecialNoti specialNoti = new SpecialNoti();
							int spoid = Integer.parseInt(st.nextToken(","));			
							specialNoti.setUserId(userid);
							
							specialNoti.setMyspecialchildId(spoid);
							
							SpecialNotiDaoImpl specialNotiDaoImpl=new SpecialNotiDaoImpl();
							specialNotiDaoImpl.persist(specialNoti);
								
						}

					return "save";
					}
					
				//This is for users particular brand MS count	
				
				public int getMySpecailsCount(int userid,int brandid)
				 {
					int specialCount =0;
					SpecialNotiDao specialNoti= new SpecialNotiDaoImpl();
				
					 hibernateUtil.openCurrentSession();
					 List<Object> sCount = hibernateUtil.getCurrentSession().createQuery("select count(*) from BrandMySpecials where brandspecialId not in(select brandspecialId from SpecialNoti where userId ="+userid+") and brandid="+brandid).setCacheable(false).list();
					hibernateUtil.closeCurrentSession();	
					if(sCount.size()>0)
					{
						for(Object o : sCount)
						{
							specialCount = Integer.parseInt((o.toString()));
						}
					}
					 
					 return specialCount;
				 }	
				
				

				public List<Object[]> getMySpecailsDetails(int userId,int brandid)
				{
				
					
					hibernateUtil.openCurrentSession();
					 List<Object[]> brandCount = hibernateUtil.getCurrentSession().createQuery("select brandspecialId,createdon,specialmsg,specialdesc from BrandMySpecials where brandspecialId not in(select brandspecialId from SpecialNoti where userId ="+userId+") and brandid ="+brandid).setCacheable(false).list();
					hibernateUtil.closeCurrentSession();		
					 
					 return brandCount;
					 
				}
				
				public static void main(String args[]) throws Exception
				{
					
					SpecialNotiDaoImpl specialNotiDaoImpl = new SpecialNotiDaoImpl();
					
					System.out.println(specialNotiDaoImpl.getMySpecailsCount(41));
					
					/*List<Object[]> images = specialNotiDaoImpl.getMySpecailsDetails(1);
					if(images.size()>0){
					for(Object[] i : images)
					{
						System.out.println(i[0].toString()+"   "+i[4].toString()+"    "+i[5].toString()+"   "+i[6].toString());
					}
					}
					else
						System.out.println("No records");*/
					
				//System.out.println(specialNotiDaoImpl.saveUserViewed(1, "1,3"));	
				//	System.out.println(specialNotiDaoImpl.getMySpecailsCount(1,2));
					
				}
				
}
