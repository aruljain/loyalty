package com.lola.dao;

import java.io.Serializable;
import java.util.List;

public interface UserBrandloyalityPointsDao<T,Id extends Serializable> extends HibernateUtilDao  {
	public List<Object> getUserExpiringPoints(int userid);
	
	public List<Object[]> getUserExpiringPointscal(int userid);
	public List<Object[]> getUserExpiringPointsByBrandid(int userid,int brandid);
	

}
