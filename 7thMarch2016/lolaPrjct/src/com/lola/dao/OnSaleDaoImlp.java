package com.lola.dao;


import java.util.List;

import com.lola.model.BrandDealsandOffers;
import com.lola.model.OnSale;

public class OnSaleDaoImlp  implements OnSaleDao<OnSale,String>{

	@Override
	public List<Object[]> getMyOnSale(int userId, int categoryId) {
		UserBrandDao userbrand= new UserBrandDaoImpl();
		 String brandids = userbrand.getBrandidsByUserId(userId);
			if(brandids.equals(""))
				brandids="0";
		 hibernateUtil.openCurrentSession();
		 List<Object[]> brandCount = hibernateUtil.getCurrentSession().createQuery("select brandId,onsaleimage,onsaledesc from OnSale where categoryid="+categoryId+" and brandId in("+brandids+")").setCacheable(false).list();
		hibernateUtil.closeCurrentSession();		
		 
		 return brandCount;
		
	}
	
	
	

	

	@Override
	public List<Object> getOnSalebyUserId(int userid) {
		 UserBrandDao userbrand= new UserBrandDaoImpl();
		 String brandids = userbrand.getBrandidsByUserId(userid);
			if(brandids.equals(""))
				brandids="0";
		 hibernateUtil.openCurrentSession();
		 List<Object> brandCount = hibernateUtil.getCurrentSession().createQuery("select count(brandId) from OnSale where brandId in("+brandids+")").setCacheable(false).list();
		hibernateUtil.closeCurrentSession();		
		 
		 return brandCount;
			}
	//3333333333333333333333333333333333333333333
	@Override
	public List<Object[]> getonSalebyBrandId(int brandId) {
		//BrandDealsandOffersDao brandDealsandOffersDaoImpl= new BrandDealsandOffersDaoImpl();
		
		 hibernateUtil.openCurrentSession();
		 List<Object[]> brandCount = hibernateUtil.getCurrentSession().createQuery("select brandId,onsaleimage,content,onsaleId,onsaledesc,available,bookable,brandshopid from OnSale where brandid in("+brandId+")").setCacheable(false).list();
		hibernateUtil.closeCurrentSession();		
		 
		 return brandCount;
		
	}
	
	//
	
	@Override
	public List<Object[]> getLikedOnSalebyBrandId(int brandId, int userId)
	 {
		
		 hibernateUtil.openCurrentSession();
		                                                             //createQuery("select distinct(p.newarrivalId), p.brandId, p.arrivalImage, p.content, p.newarrivaldesc, c.liked from BrandNewArrivals p, NewarrivalsLeafPage c where p.brandId="+brandId+" and p.newarrivalId NOT IN (select newarrivalId FROM NewarrivalsLeafPage WHERE userid="+userId+" AND liked=TRUE) and c.liked=0").list();
		 List<Object[]> brandCount = hibernateUtil.getCurrentSession().createQuery("select distinct(p.onsaleId),p.brandId, p.onsaleimage, p.content,p.onsaledesc,c.liked from OnSale p, OnSaleLeafPage c where p.brandId ="+brandId+" and p.onsaleId in (select onsaleid from OnSaleLeafPage where userId="+userId+" and liked=TRUE) and c.liked=1").setCacheable(false).list();
		hibernateUtil.closeCurrentSession();		
		 
		 return brandCount;
	 }
 
 @Override
	public List<Object[]> getOnSalebyBrandId(int brandId, int userId)
	 {
		
		 hibernateUtil.openCurrentSession();
		                                                             //createQuery("select distinct(p.newarrivalId), p.brandId, p.arrivalImage, p.content, p.newarrivaldesc, c.liked from BrandNewArrivals p, NewarrivalsLeafPage c where p.brandId="+brandId+" and p.newarrivalId NOT IN (select newarrivalId FROM NewarrivalsLeafPage WHERE userid="+userId+" AND liked=TRUE) and c.liked=0").list();
		 List<Object[]> brandCount = hibernateUtil.getCurrentSession().createQuery("select distinct(p.onsaleId),p.brandId, p.onsaleimage, p.content,p.onsaledesc,c.liked from OnSale p, OnSaleLeafPage c where p.brandId ="+brandId+" and p.onsaleId in (select onsaleid from OnSaleLeafPage where userId="+userId+" and liked=TRUE) and c.liked=0").setCacheable(false).list();
		hibernateUtil.closeCurrentSession();		
		 
		 return brandCount;
	 }

	//1111111111111111111111
	@Override
	public List<Object[]> getLikedAndUnlikedOnSalebyBrandId(int brandId,
			int userId) {
		 hibernateUtil.openCurrentSession();
		// SELECT s.onsaleid,s.brandid,s.onsaleimage,s.content,s.onsaledesc,p.liked FROM tbl_onsale s INNER JOIN tbl_onsaleleafpage p ON p.onsaleid=s.onsaleid WHERE userid=1 AND brandid=2
         //createQuery("select distinct(p.newarrivalId), p.brandId, p.arrivalImage, p.content, p.newarrivaldesc, c.liked from BrandNewArrivals p, NewarrivalsLeafPage c where p.brandId="+brandId+" and p.newarrivalId NOT IN (select newarrivalId FROM NewarrivalsLeafPage WHERE userid="+userId+" AND liked=TRUE) and c.liked=0").list();
List<Object[]> brandCount = hibernateUtil.getCurrentSession().createQuery("select distinct(p.onsaleId),p.brandId, p.onsaleimage,p.content,p.onsaledesc,c.liked,c.book,p.available,p.bookable,p.brandshopid from OnSale p,OnSaleLeafPage c where p.onsaleId =c.onsaleid  and userId="+userId+" and brandId="+brandId).setCacheable(false).list();
  hibernateUtil.closeCurrentSession();		

return brandCount;
		//return null;
	}
	
	//22222222222222222222222222
	
	
	
	@Override
	public List<Object[]> getUnlikedOnSalebyBrandId(int brandId, int userId) {
		 hibernateUtil.openCurrentSession();
		// SELECT DISTINCT(p.onsaleid) FROM tbl_onsale p, tbl_onsaleleafpage c WHERE p.brandid =2 AND p.onsaleid NOT IN (SELECT onsaleid FROM tbl_onsaleleafpage WHERE userid=1 )
	List<Object[]> brandCount = hibernateUtil.getCurrentSession().createQuery("select distinct(p.onsaleId),p.brandId, p.onsaleimage,p.content,p.onsaledesc,p.available,p.bookable,p.brandshopid from OnSale p,OnSaleLeafPage c  where p.brandId="+brandId+" and p.onsaleId NOT IN (select onsaleid FROM OnSaleLeafPage WHERE userId="+userId+")").setCacheable(false).list();
	  hibernateUtil.closeCurrentSession();	
		return brandCount;
	}

	
	
	@Override
	public List<OnSale> findByOnSaleId(int onsaleId) {
		hibernateUtil.openCurrentSession();
		List<OnSale> onsale = (List<OnSale>) hibernateUtil.getCurrentSession().createQuery("from OnSale where onsaleId='"+onsaleId+"'").setCacheable(false).list();
		hibernateUtil.closeCurrentSession();
		return onsale;
	}
	

	@Override
	public List<OnSale> findAllAvailableDetailsOfOnsale(int brandId) {
		hibernateUtil.openCurrentSession();
		List<OnSale> onsale = (List<OnSale>) hibernateUtil.getCurrentSession().createQuery("from OnSale where available=1 and brandId='"+brandId+"'").setCacheable(false).list();
		hibernateUtil.closeCurrentSession();
		return onsale;
	}

	public static void main(String[] args) {
		OnSaleDaoImlp onSaleDaoImlp = new OnSaleDaoImlp();
		//List<Object[]> brandCount=onSaleDaoImlp.getMyOnSale(1, 4);
		/* List<Object[]> onsalecount=onSaleDaoImlp.getOnSalebyBrandId(2, 1);
		
		for(Object[] i : onsalecount)
		{
			System.out.println(i[0].toString()+"    "+i[1].toString()+"   "+i[2].toString());//+"   "+i.getNewarrivalId()+"   "+i.getArrivalImage()+"    "+i.getNewarrivaldesc()+"   "+i.getContent());
			
		}*/List<OnSale> brandCount =onSaleDaoImlp.findAllAvailableDetailsOfOnsale(2);
		
		for(OnSale i : brandCount)
		{
			System.out.println(i.getOnsaleId()+"  "+i.getOnsalemsg());//+"   "+i.getNewarrivalId()+"   "+i.getArrivalImage()+"    "+i.getNewarrivaldesc()+"   "+i.getContent());
			
		}
		
	}



	
	
	
}
