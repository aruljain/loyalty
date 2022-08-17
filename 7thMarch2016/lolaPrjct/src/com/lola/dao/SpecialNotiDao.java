package com.lola.dao;

import java.io.Serializable;
import java.util.List;

public interface SpecialNotiDao<T,Id extends Serializable>  extends HibernateUtilDao {

	
	public int getMySpecailsCount(int userId);
	
	public List<Object[]> getMySpecailsDetails(int userId);
	public String saveUserViewed(int userid, String sepids) throws Exception;
	public void persist(T entity);
	public int getMySpecailsCount(int userid,int brandid);
	public List<Object[]> getMySpecailsDetails(int userId,int brandid);
	
}
