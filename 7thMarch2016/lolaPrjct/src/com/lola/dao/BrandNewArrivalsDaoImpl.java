package com.lola.dao;

import java.util.Date;
import java.util.List;

import com.lola.model.BrandDealsandOffers;
import com.lola.model.BrandNewArrivals;

public class BrandNewArrivalsDaoImpl implements BrandNewArrivalsDao <BrandNewArrivals,String> {


	public BrandNewArrivalsDaoImpl(){


	}
	
	
	

	public List<Object> getNewArrivalCountByBrandId(int brandId)
	{

		BrandNewArrivalsDao brandNewArrivals= new BrandNewArrivalsDaoImpl();
		hibernateUtil.openCurrentSession();
		List<Object> brandCount = hibernateUtil.getCurrentSession().createQuery("select brandId, arrivalImage from BrandNewArrivals where brandid in("+brandId+")").setCacheable(false).list();
		hibernateUtil.closeCurrentSession();		

		return brandCount;		 
	}

	@Override
	public void persist(BrandNewArrivals entity) {
		hibernateUtil.openCurrentSessionwithTransaction();
		hibernateUtil.getCurrentSession().save(entity);	
		hibernateUtil.closeCurrentSessionwithTransaction();


	}

	@Override
	public void update(BrandNewArrivals entity) {
		hibernateUtil.openCurrentSessionwithTransaction();
		hibernateUtil.getCurrentSession().update(entity);
		hibernateUtil.closeCurrentSessionwithTransaction();
	}

	@Override
	public List<BrandNewArrivals> findBynewarrivalId(int newarrivalId) {
		hibernateUtil.openCurrentSession();
		List<BrandNewArrivals> brandNewArrivals = (List<BrandNewArrivals>) hibernateUtil.getCurrentSession().createQuery("from BrandNewArrivals where newarrivalId='"+newarrivalId+"'").setCacheable(false).list();
		hibernateUtil.closeCurrentSession();
		return brandNewArrivals;		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BrandNewArrivals> findAllNewArrivals(String searchString)
	{
		 
		if(searchString==null)
			searchString="";	
		hibernateUtil.openCurrentSession();			
		List<BrandNewArrivals> brandNewArrivals = (List<BrandNewArrivals>) hibernateUtil.getCurrentSession().createQuery("from BrandNewArrivals where newarrivaldesc LIKE '%"+searchString+"%' OR newarrivalmsg LIKE '%"+searchString+"%' OR content LIKE '%"+searchString+"%' and expirydate >= CURDATE()").setCacheable(false).list();		
		hibernateUtil.closeCurrentSession();
		return brandNewArrivals;		
	}


	




	@Override
	public List<Object[]> getNewArrivalsbyBrandId(int brandId) {
		
		 hibernateUtil.openCurrentSession();
		 List<Object[]> brandCount = hibernateUtil.getCurrentSession().createQuery("select brandId,arrivalImage,content,newarrivalId,newarrivaldesc,available,bookable,brandshopid from BrandNewArrivals where brandId="+brandId).setCacheable(false).list();
		hibernateUtil.closeCurrentSession();		
		 
		return brandCount;
	}




	@Override
	public List<Object[]> getLikedaAndUnlikedNewArrivalsbyBrandId(int brandId,
			int userId) {
		
		
		
	     hibernateUtil.openCurrentSession();
		
		 List<Object[]> brandCount1 = hibernateUtil.getCurrentSession().createQuery("select distinct(p.newarrivalId),p.brandId, p.arrivalImage,p.content,p.newarrivaldesc,c.liked,c.book,p.available,p.bookable,p.brandshopid from BrandNewArrivals p,NewarrivalsLeafPage c where p.newarrivalId =c.newarrivalId  and userid="+userId+" and brandId="+brandId).setCacheable(false).list();
		  hibernateUtil.closeCurrentSession();	
		return brandCount1;
	}




	@Override
	public List<Object[]> getUnlikedNewArrivalsbyBrandId(int brandId, int userId) {
		hibernateUtil.openCurrentSession();
		
		List<Object[]> brandCount2 = hibernateUtil.getCurrentSession().createQuery("select distinct(p.newarrivalId),p.brandId, p.arrivalImage,p.content,p.newarrivaldesc,p.available,p.bookable,p.brandshopid from BrandNewArrivals p,NewarrivalsLeafPage c  where p.brandId="+brandId+" and p.newarrivalId NOT IN (select newarrivalId FROM NewarrivalsLeafPage WHERE userId="+userId+")").setCacheable(false).list();
		  hibernateUtil.closeCurrentSession();	
		return brandCount2;
	}

	@Override
	public List<BrandNewArrivals> findAllAvailableNewArrivals(int brandId) {
		hibernateUtil.openCurrentSession();
		List<BrandNewArrivals> brandNewArrivals = (List<BrandNewArrivals>) hibernateUtil.getCurrentSession().createQuery("from BrandNewArrivals where available=1 and brandId='"+brandId+"'").setCacheable(false).list();
		hibernateUtil.closeCurrentSession();
		return brandNewArrivals;
	}
	
	
	
	public static void main(String args[])
	{

		BrandNewArrivalsDaoImpl brandNewArrivalsDaoImpl = new BrandNewArrivalsDaoImpl();
		//hibernateUtil.openCurrentSession();
		//List<Object[]> images = brandNewArrivalsDaoImpl.getLikedaAndUnlikedNewArrivalsbyBrandId(4, 61);
		List<BrandNewArrivals> images = brandNewArrivalsDaoImpl.findAllAvailableNewArrivals(2);
		if(images.size()>0){
		for(BrandNewArrivals i : images)
		{
			System.out.println(i.getBrandshopid()+"   "+i.getContent()+"   "+i.getNewarrivalmsg());
		}
		}
		else
			System.out.println("No records");
		//hibernateUtil.closeCurrentSession();
		/*List<Object[]> brandNewArrivals=brandNewArrivalsDaoImpl.getLikedNewArrivalsbyBrandId(2,1);
		for(Object[] i : brandNewArrivals)
		{
			System.out.println(i[0].toString()+"    "+i[4].toString()+"   "+i[5].toString());//+"   "+i.getNewarrivalId()+"   "+i.getArrivalImage()+"    "+i.getNewarrivaldesc()+"   "+i.getContent());

		}*/



	}




	
}
