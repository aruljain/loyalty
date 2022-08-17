package com.lola.dao;

import java.util.List;
import java.util.StringTokenizer;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import com.lola.model.BrandImages;
import com.lola.model.BrandShowRoom;
import com.lola.services.util.LolaConstants;

public class BrandShowRoomDaoImpl implements BrandShowRoomDao<BrandShowRoom, String>{

	
	public BrandShowRoomDaoImpl() {
		
	}
	
	@Override
	public List<BrandShowRoom> getBrandShowroomDetails(int brandId, double lat,double lng,float dist) {
		List<BrandShowRoom> commonBrandshowroomsdetailsloctn = null;
		
		
		
		hibernateUtil.openCurrentSession();
		//List<Object[]> brandshowroomsdetailsloctn1 = hibernateUtil.getCurrentSession().createQuery("select phonenumber,emailId,address,shoptimings,lattitude,longtitude  from BrandShowRoom where brandid="+brandId+" and lattitude='"+latti+"' and longtitude='"+longi+"'").list();
		//SELECT phonenumber,emailId,address,shoptimings,lattitude,longtitude,location,  3956 * 2 * ASIN(SQRT(POWER(SIN((12.9758 -ABS(lattitude)) * PI()/180 / 2),2) + COS(12.9758* PI()/180 ) * COS(ABS(lattitude) *  PI()/180) * POWER(SIN((80.2205 - ABS(longtitude)) *  PI()/180 / 2), 2))) AS distance	FROM tbl_brandshowrooms WHERE brandid=2	HAVING distance < 0.5 ORDER BY distance LIMIT 1;
		//List<Object[]> brandshowroomsdetailsloctn1 = hibernateUtil.getCurrentSession().createQuery("select phonenumber,emailId,address,shoptimings,lattitude,longtitude,location, 3956 * 2 * ASIN(SQRT(POWER(SIN(("+lat+"-ABS(lattitude)) * PI()/180 / 2),2) + COS("+lat+"* PI()/180 ) * COS(ABS(lattitude) *  PI()/180) * POWER(SIN(("+lng+"-ABS(longtitude)) *  PI()/180 / 2), 2)))  AS distance from BrandShowRoom WHERE brandid=2 HAVING distance < "+dist+" ORDER BY distance LIMIT 1").list();
		System.out.println("Inside");
		
		Session session = hibernateUtil.getCurrentSession();
		 String sql="SELECT dest.*,  3956 * 2 * ASIN(SQRT(POWER(SIN((:lat -ABS(dest.lattitude)) * PI()/180 / 2),2) + COS(:lat* PI()/180 ) * COS(ABS(dest.lattitude) *  PI()/180) * POWER(SIN((:lng - ABS(dest.longtitude)) *  PI()/180 / 2), 2))) AS distance	FROM tbl_brandshowrooms AS dest WHERE brandid=:brandid	HAVING distance < :dist ORDER BY distance LIMIT 1";
		 Query query = session.createSQLQuery(sql).addEntity(BrandShowRoom.class);
		query.setParameter("brandid", brandId);
		query.setParameter("dist", dist);
		query.setParameter("lat", lat);
        query.setParameter("lng", lng);
         List<BrandShowRoom> brandShowRoom = query.list();
         //return brandShowRoom;
		// List<Object[]> brandshowroomsdetailsloctn1 = hibernateUtil.getCurrentSession().createQuery("SELECT phonenumber,emailId,address,shoptimings,lattitude,longtitude,location,  3956 * 2 * ASIN(SQRT(POWER(SIN((12.9758 -ABS(lattitude)) * PI()/180 / 2),2) + COS(12.9758* PI()/180 ) * COS(ABS(lattitude) *  PI()/180) * POWER(SIN((80.2205 - ABS(longtitude)) *  PI()/180 / 2), 2))) AS distance	FROM BrandShowRoom WHERE brandid=2	HAVING distance < 0.5 ORDER BY distance LIMIT 1").list();
		commonBrandshowroomsdetailsloctn = brandShowRoom;
		if(brandShowRoom.size()==0)
		{
		List<BrandShowRoom> brandshowroomsdetailsloctn2 = hibernateUtil.getCurrentSession().createQuery(" from BrandShowRoom where brandid="+brandId).setCacheable(false).list();
		commonBrandshowroomsdetailsloctn = brandshowroomsdetailsloctn2;
		}
		
		hibernateUtil.closeCurrentSession();
		return commonBrandshowroomsdetailsloctn;
	}
	
	@SuppressWarnings("unchecked")
	 public List<Object[]> getLolaContact() {
		
		/*String contact="";
		String con ="CompanyName,phone,email,website";
		StringTokenizer st = new StringTokenizer(con);*/
		String details="";
		 hibernateUtil.openCurrentSession();
	  List<Object[]> user = hibernateUtil.getCurrentSession().createQuery("select shopname,phonenumber,emailId,website,description from BrandShowRoom where brandid="+LolaConstants.rootBrandId).setCacheable(false).list();
	     hibernateUtil.closeCurrentSession();
	  
	   return user;
	 }
	
		@Override
		public List<Object> getBrandShowroomEmailid(int brandId) {
			 hibernateUtil.openCurrentSession();
			  List<Object> user = hibernateUtil.getCurrentSession().createQuery("select emailId from BrandShowRoom where brandid="+brandId).setCacheable(false).list();
			     hibernateUtil.closeCurrentSession();
			return user;
		}
	
		
		@Override
		public List<Object[]> getBrandShowroomDetails(int bucketId) {
			hibernateUtil.openCurrentSession();
			//List<Object[]> brandshowroomsdetails = hibernateUtil.getCurrentSession().createQuery("select phonenumber,emailId,address,shoptimings  from BrandShowRoom where brandid="+brandId+" and location='"+location+"'").list();
			List<Object[]> brandshowroomsdetails = hibernateUtil.getCurrentSession().createQuery("select phonenumber,emailId,address,shoptimings  from BrandShowRoom where bucketId="+bucketId).setCacheable(false).list();
			hibernateUtil.closeCurrentSession();
			return brandshowroomsdetails;
			
		}


		
		@Override
		public List<Object[]> getBrandShowroom(int brandId) {
			hibernateUtil.openCurrentSession();
			
			List<Object[]> brandshowroomsdetails = hibernateUtil.getCurrentSession().createQuery("select location,address,emailId,phonenumber,lattitude,longtitude,shoptimings  from BrandShowRoom where brandid="+brandId).setCacheable(false).list();
			hibernateUtil.closeCurrentSession();
			return brandshowroomsdetails;
			
		}
		
		
		
		@Override
		public List<BrandShowRoom>  getBrandShowroomDetail(int brandId,double lat,double lng) {
			hibernateUtil.openCurrentSession();
			
			List<BrandShowRoom> brandshowroomsdetails = hibernateUtil.getCurrentSession().createQuery(" from BrandShowRoom where brandid="+brandId+" and lattitude="+lat+" and longtitude="+lng).setCacheable(false).list();
			hibernateUtil.closeCurrentSession();
			return brandshowroomsdetails;
		}
		
		
		
	public static void main(String args[]) throws Exception
	{
		BrandShowRoomDaoImpl brandShowRoomDaoImpl = new BrandShowRoomDaoImpl();
		/*String location="tnagar, chennai";
		List<Object[]> brnds=brandShowRoomDaoImpl.getLolaContact();
		for(Object[] o:brnds){
			System.out.println(o[0].toString()+"  "+o[1].toString()+"  "+o[4].toString());
		}*/
		//BrandShowRoomDaoImpl brandShowRoomDaoImpl = new BrandShowRoomDaoImpl();
		List<BrandShowRoom> user=brandShowRoomDaoImpl.getBrandShowroomDetails(3,13.0063,80.2574,0);
		 if(user.size()>0){
			   for(BrandShowRoom o:user){
				   System.out.println(o.getLocation()+"   "+o.getLattitude()+"    "+o.getLongtitude()+"   "+o.getBrandid());  
				  
			   }
		   }
		
	}

	@Override
	public List<BrandShowRoom> getBrandShowroomDetail(int brandId, double lat,
			double lng, String pin) {
		hibernateUtil.openCurrentSession();
		
		List<BrandShowRoom> brandshowroomsdetails = hibernateUtil.getCurrentSession().createQuery("from BrandShowRoom where brandid="+brandId+" and lattitude="+lat+" and longtitude="+lng+" and pin="+pin+"").setCacheable(false).list();
		hibernateUtil.closeCurrentSession();
		return brandshowroomsdetails;
	}

	

	

	
}
