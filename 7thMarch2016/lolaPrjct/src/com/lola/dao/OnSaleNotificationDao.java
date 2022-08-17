package com.lola.dao;

import java.io.Serializable;
import java.util.List;

public interface OnSaleNotificationDao<T,Id extends Serializable>  extends HibernateUtilDao {
	
   public int getOnSaleNotificationCount(int userId);
	
	public List<Object[]> getOnSaleNotificationDetails(int userId);
	public String saveUserViewed(int userid, String onsaleids) throws Exception;
   // public int getMyDealsnOffersCount(int userid, int brandid);
    //public List<Object[]> getMyDealsnOffersDetails(int userId, int brandid);
    public void persist(T entity);

}
