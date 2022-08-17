package com.lola.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.lola.model.BrandDealsandOffers;
import com.lola.model.BrandNewArrivals;
import com.lola.model.MySpecialsChild;

public class BrandDealsandOffersDaoImpl implements BrandDealsandOffersDao <BrandDealsandOffers,String>{

	
public BrandDealsandOffersDaoImpl(){
		
	}

	@Override
	public List<BrandDealsandOffers> getAllbrandsDealsandOffersByCategoryIdWithLimit(int categoryId, int start,
			int offset) {
		// TODO Auto-generated method stub
		hibernateUtil.openCurrentSession();
		Session session = hibernateUtil.getCurrentSession();
		Criteria criteria = session.createCriteria(BrandDealsandOffers.class);		
		criteria.setFirstResult(start).setMaxResults(offset);
		criteria.add(Restrictions.eq("categoryid",categoryId));
		List<BrandDealsandOffers> brandimages = (List<BrandDealsandOffers>) criteria.list();
		hibernateUtil.closeCurrentSession();

		
		return brandimages;
	}
	
	 public List<Object> getMyDealsandOffersbyUserId(int userid)
	 {
		 UserBrandDao userbrand= new UserBrandDaoImpl();
		 String brandids = userbrand.getBrandidsByUserId(userid);
			if(brandids.equals(""))
				brandids="0";
		 hibernateUtil.openCurrentSession();
		 List<Object> brandCount = hibernateUtil.getCurrentSession().createQuery("select count(brandid) from BrandDealsandOffers where brandid in("+brandids+")").setCacheable(false).list();
		hibernateUtil.closeCurrentSession();		
		 
		 return brandCount;
	 }	
	
	 public List<Object[]> getMyDealsandOffers(int userid,int categoryId)
	 {
		 UserBrandDao userbrand= new UserBrandDaoImpl();
		 String brandids = userbrand.getBrandidsByUserId(userid);
			if(brandids.equals(""))
				brandids="0";
		 hibernateUtil.openCurrentSession();
		 List<Object[]> brandCount = hibernateUtil.getCurrentSession().createQuery("select brandId,offerImage,dealDesc from BrandDealsandOffers where categoryid="+categoryId+" and brandId in("+brandids+")").setCacheable(false).list();
		hibernateUtil.closeCurrentSession();		
		 
		 return brandCount;
	 }	
	 
	 @Override
		public List<Object[]> getLikedMyDealsandOffersbyBrandId(int brandId, int userId)
		 {
			//BrandDealsandOffersDao brandDealsandOffersDaoImpl= new BrandDealsandOffersDaoImpl();
			// String brandids = brandNewArrivals.getNewArrivalsbyBrandId(brandId);
				/*if(brandids.equals(""))
					brandids="0";*/
			 hibernateUtil.openCurrentSession();
			                                                             //createQuery("select distinct(p.newarrivalId), p.brandId, p.arrivalImage, p.content, p.newarrivaldesc, c.liked from BrandNewArrivals p, NewarrivalsLeafPage c where p.brandId="+brandId+" and p.newarrivalId NOT IN (select newarrivalId FROM NewarrivalsLeafPage WHERE userid="+userId+" AND liked=TRUE) and c.liked=0").list();
			 List<Object[]> brandCount = hibernateUtil.getCurrentSession().createQuery("select distinct(p.dealandofferId),p.brandId, p.offerImage, p.content,p.dealDesc,c.liked from BrandDealsandOffers p, DealsAndOffersLeafPage c where p.brandId ="+brandId+" and p.dealandofferId in (select dealandofferid from DealsAndOffersLeafPage where userid="+userId+" and liked=TRUE) and c.liked=1").setCacheable(false).list();
			hibernateUtil.closeCurrentSession();		
			 
			 return brandCount;
		 }
	 
	 @Override
		public List<Object[]> getMyDealsandOffersbyBrandId(int brandId, int userId)
		 {
			//BrandDealsandOffersDao brandDealsandOffersDaoImpl= new BrandDealsandOffersDaoImpl();
			// String brandids = brandNewArrivals.getNewArrivalsbyBrandId(brandId);
				/*if(brandids.equals(""))
					brandids="0";*/
			 hibernateUtil.openCurrentSession();
			                                                             //createQuery("select distinct(p.newarrivalId), p.brandId, p.arrivalImage, p.content, p.newarrivaldesc, c.liked from BrandNewArrivals p, NewarrivalsLeafPage c where p.brandId="+brandId+" and p.newarrivalId NOT IN (select newarrivalId FROM NewarrivalsLeafPage WHERE userid="+userId+" AND liked=TRUE) and c.liked=0").list();
			 List<Object[]> brandCount = hibernateUtil.getCurrentSession().createQuery("select distinct(p.dealandofferId),p.brandId, p.offerImage, p.content,p.dealDesc,c.liked from BrandDealsandOffers p, DealsAndOffersLeafPage c where p.brandId ="+brandId+" and p.dealandofferId not in (select dealandofferid from DealsAndOffersLeafPage where userid="+userId+" and liked=TRUE) and c.liked=0").setCacheable(false).list();
			hibernateUtil.closeCurrentSession();		
			 
			 return brandCount;
		 }
		
		@Override
		public void persist(BrandDealsandOffers entity) {
			hibernateUtil.openCurrentSessionwithTransaction();
			hibernateUtil.getCurrentSession().save(entity);	
			hibernateUtil.closeCurrentSessionwithTransaction();
			
		}

		@Override
		public void update(BrandDealsandOffers entity) {
			hibernateUtil.openCurrentSessionwithTransaction();
			hibernateUtil.getCurrentSession().update(entity);
			hibernateUtil.closeCurrentSessionwithTransaction();
		}

		@Override
		public List<BrandDealsandOffers> findBydealandofferId(int dealandofferId) {
			hibernateUtil.openCurrentSession();
			List<BrandDealsandOffers> brandDealsandOffers = (List<BrandDealsandOffers>) hibernateUtil.getCurrentSession().createQuery("from BrandDealsandOffers where dealandofferId='"+dealandofferId+"'").setCacheable(false).list();
			hibernateUtil.closeCurrentSession();
			return brandDealsandOffers;
		}
		
		@SuppressWarnings({ "unused", "unchecked" })
		@Override
		public List<BrandDealsandOffers> findAllBrandDealsandOffers(String searchString)
		{
			 
			if(searchString==null)
				searchString="";	
			hibernateUtil.openCurrentSession();
			List<BrandDealsandOffers> brandDealsandOffers = (List<BrandDealsandOffers>) hibernateUtil.getCurrentSession().createQuery("from BrandDealsandOffers where dealDesc LIKE '%"+searchString+"%' OR offermsg LIKE '%"+searchString+"%' OR content LIKE '%"+searchString+"%' and expirydate >= CURDATE()").setCacheable(false).list();
			hibernateUtil.closeCurrentSession();
			return brandDealsandOffers;	
		}
	 
	
	
	
	
	
	
	
	

	@Override
	public List<Object[]> getDealAndOfferbyBrandId(int brandId) {
		
		 hibernateUtil.openCurrentSession();
		 List<Object[]> brandCount = hibernateUtil.getCurrentSession().createQuery("select brandId,offerImage,content,dealandofferId,dealDesc,available,bookable,brandshopid from BrandDealsandOffers where brandId="+brandId).setCacheable(false).list();
		hibernateUtil.closeCurrentSession();		
		 
		return brandCount;
	}

	@Override
	public List<Object[]> getLikedAndUnlikedDealsOfferbyBrandId(int brandId,
			int userId) {
		 hibernateUtil.openCurrentSession();
			
	 List<Object[]> brandCount1 = hibernateUtil.getCurrentSession().createQuery("select distinct(p.dealandofferId),p.brandId, p.offerImage,p.content,p.dealDesc,c.liked,c.book,p.available,p.bookable,p.brandshopid from BrandDealsandOffers p,DealsAndOffersLeafPage c where p.dealandofferId =c.dealandofferid  and userid="+userId+" and brandId="+brandId).setCacheable(false).list();
	  hibernateUtil.closeCurrentSession();		

		return brandCount1;
	}

	@Override
	public List<Object[]> getUnlikedDealAndOfferbyBrandId(int brandId,
			int userId) {
		 hibernateUtil.openCurrentSession();
			
		List<Object[]> brandCount2 = hibernateUtil.getCurrentSession().createQuery("select distinct(p.dealandofferId),p.brandId, p.offerImage,p.content,p.dealDesc,p.available,p.bookable,p.brandshopid from BrandDealsandOffers p,DealsAndOffersLeafPage c  where p.brandId="+brandId+" and p.dealandofferId NOT IN (select dealandofferid FROM DealsAndOffersLeafPage WHERE userid="+userId+")").setCacheable(false).list();
		  hibernateUtil.closeCurrentSession();	
		return brandCount2;
	}

	@Override
	public List<BrandDealsandOffers> findAllAvailableDetailesOfDealsOffers(int brandId) {
		
		hibernateUtil.openCurrentSession();
		List<BrandDealsandOffers> brandDealsandOffers = (List<BrandDealsandOffers>) hibernateUtil.getCurrentSession().createQuery("from BrandDealsandOffers where available=1 and brandId='"+brandId+"'").setCacheable(false).list();
		hibernateUtil.closeCurrentSession();
		return brandDealsandOffers;
	}

	public static void main(String args[])
	{
		
		BrandDealsandOffersDaoImpl brandImagesDaoImpl = new BrandDealsandOffersDaoImpl();
		List<BrandDealsandOffers> brandDealsandOffers=brandImagesDaoImpl.findAllAvailableDetailesOfDealsOffers(2);
		for(BrandDealsandOffers i : brandDealsandOffers)
		{
			System.out.println(i.getBrandshopid()+"    "+i.getCategoryid()+"   "+i.getDealandofferId());//+"   "+i.getNewarrivalId()+"   "+i.getArrivalImage()+"    "+i.getNewarrivaldesc()+"   "+i.getContent());
			
		}
	}
	
}
