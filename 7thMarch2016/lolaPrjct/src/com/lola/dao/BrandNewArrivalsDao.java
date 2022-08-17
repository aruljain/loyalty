package com.lola.dao;

import java.io.Serializable;
import java.util.List;

import com.lola.model.BrandDealsandOffers;
import com.lola.model.BrandNewArrivals;

public interface BrandNewArrivalsDao<T, Id  extends Serializable> extends HibernateUtilDao {

	
	public List<Object> getNewArrivalCountByBrandId(int brandId);
	
	 public void persist(T entity);
	 public void update(T entity);
	 public List<BrandNewArrivals> findBynewarrivalId(int newarrivalId);
	 public List<BrandNewArrivals> findAllNewArrivals(String searchString);
	 
	 
	     public List<Object[]> getNewArrivalsbyBrandId(int brandId);
		 public List<Object[]> getLikedaAndUnlikedNewArrivalsbyBrandId(int brandId, int userId);
		 public List<Object[]> getUnlikedNewArrivalsbyBrandId(int brandId, int userId);
		 
		 
		 
		 public List<BrandNewArrivals> findAllAvailableNewArrivals(int brandId);
	
		 
		 
}
