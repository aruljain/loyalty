package com.lola.dao;


import java.util.List;
import java.util.StringTokenizer;

import com.lola.model.DealsnOffersNoti;
import com.lola.model.OnSaleNotification;

public class OnSaleNotificationDaoImpl implements OnSaleNotificationDao <OnSaleNotification,String> {

	@Override
	public int getOnSaleNotificationCount(int userId) {
		
		int onSaleCount =0;
		//OnSaleNotificationDao OnSaleNotificationDao= new OnSaleNotificationDao();
		
		 hibernateUtil.openCurrentSession();
		 List<Object> onsCount = hibernateUtil.getCurrentSession().createQuery("select count(*) from OnSale where onsaleId not in(select onsaleId from OnSaleNotification where userId ="+userId+")and brandId in (select brandid from UserBrand where userId ="+userId+" and liked=1 and onoffnoti=1)").setCacheable(false).list();
		hibernateUtil.closeCurrentSession();		
		if(onsCount.size()>0)
		{
			for(Object o : onsCount)
			{
				onSaleCount = Integer.parseInt((o.toString()));
			}
		}
						 
		 return onSaleCount;
		//return 0;
	}

	@Override
	public void persist(OnSaleNotification entity) {
		hibernateUtil.openCurrentSessionwithTransaction();
		hibernateUtil.getCurrentSession().saveOrUpdate(entity);
		hibernateUtil.closeCurrentSessionwithTransaction();
	}
	
	@Override
	public List<Object[]> getOnSaleNotificationDetails(int userId) {
		hibernateUtil.openCurrentSession();
		 //List<Object[]> brandCount = hibernateUtil.getCurrentSession().createQuery("select dealandofferId,createdon,offermsg,dealDesc,brandId from BrandDealsandOffers where liked=0  and  dealandofferId not in(select dealandofferId from DealsnOffersNoti where userId ="+userId+")and brandid in (select brandid from UserBrand where userId ="+userId+" and liked=1)").setCacheable(false).list();
		 List<Object[]> onSaledatails = hibernateUtil.getCurrentSession().createQuery("select onsaleId,createdon,onsalemsg,onsaledesc,brandId,onsaleimage,content from OnSale where onsaleId not in(select onsaleId from OnSaleNotification where userId ="+userId+")and brandid in (select brandid from UserBrand where userId ="+userId+" and liked=1 and onoffnoti=1)").setCacheable(false).list();
		hibernateUtil.closeCurrentSession();		
		 
		 return onSaledatails;
		
	}
		
	
	@Override
	public String saveUserViewed(int userid, String onsaleids) throws Exception {
		StringTokenizer st = new StringTokenizer(onsaleids);
		
		
		for(int i=0;st.hasMoreTokens();i++)
		{
			OnSaleNotification onSaleNotification = new OnSaleNotification();
			int onsaleid = Integer.parseInt(st.nextToken(","));			
			onSaleNotification.setUserId(userid);
			onSaleNotification.setOnsaleId(onsaleid);
			OnSaleNotificationDao onSaleNotificationDaoImpl=new  OnSaleNotificationDaoImpl();
			onSaleNotificationDaoImpl.persist(onSaleNotification);
				
		}

	return "save";
		
	}
public static void main (String[] args) throws Exception{
	OnSaleNotificationDaoImpl onSaleNotificationDaoImpl= new OnSaleNotificationDaoImpl();
	System.out.println(onSaleNotificationDaoImpl.getOnSaleNotificationCount(1));
	System.out.println(onSaleNotificationDaoImpl.saveUserViewed(1,"700000"));
	
	List<Object[]> onSaledatails=onSaleNotificationDaoImpl.getOnSaleNotificationDetails(1);
	if(onSaledatails.size()>0){
		for(Object[] i : onSaledatails)
		{
			System.out.println(i[0].toString()+"   "+i[1].toString()+"    "+i[2].toString()+"    "+i[3].toString()+"    "+i[4].toString());
		}
		}
	
}





}
