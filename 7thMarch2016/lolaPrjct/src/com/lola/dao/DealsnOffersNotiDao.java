package com.lola.dao;

import java.io.Serializable;
import java.util.List;

public interface DealsnOffersNotiDao<T,Id extends Serializable>  extends HibernateUtilDao {

	public int getMyDealsnOffersCount(int userId);
	
	public List<Object[]> getMyDealsnOffersDetails(int userId);
	public String saveUserViewed(int userid, String dnoids) throws Exception;
    public int getMyDealsnOffersCount(int userid, int brandid);
    public List<Object[]> getMyDealsnOffersDetails(int userId, int brandid);
    public void persist(T entity);
	
}
