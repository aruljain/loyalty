package com.lola.dao;

import java.io.Serializable;
import java.util.List;

public interface NewArrivalNotiDao<T,Id extends Serializable>  extends HibernateUtilDao {

	
	public int getMyNewArrivalsCount(int userId);
	public List<Object[]> getMyNewArrivalsDetails(int userId);
	public void persist(T entity);
	public String saveUserViewed1(int userid, String naids) throws Exception;
	public int getMyNewArrivalsCount(int userid,int brandid);
	public List<Object[]> getMyNewArrivalsDetails(int userId,int brandid);
    
	
}
