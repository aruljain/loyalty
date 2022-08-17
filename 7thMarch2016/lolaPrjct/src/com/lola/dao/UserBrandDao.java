package com.lola.dao;

import java.io.Serializable;
import java.util.List;

import com.lola.model.UserBrand;

public interface UserBrandDao<T,Id extends Serializable> extends HibernateUtilDao {
	
	 public void persist(T entity);
	 public void update(T entity);
	 public String getUserBrandids(int userid);
	 public String getBrandidsByUserId(int userid);
	 public String getUserbrandIds(int userid,String brandids);
	 public int getUserbrandId(int userid,int brandid);
	 public List<Object[]> getUserBrandPoints(int userid);
	 public List<Object> getUserPointsByBrandid(int userid,int brandid);
	 public String getUserBrandIdsByBrandidsAnduserIds(int userId, String brandIds);
	 public int getMyBrandCountByCategoryId(int userid, int categoryid);
	 
	 public List<T> findByuserId(int userId);
	 public List<T> findBybrandId(int brandId);
	 

}
