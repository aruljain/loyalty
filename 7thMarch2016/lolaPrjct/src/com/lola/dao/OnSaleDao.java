package com.lola.dao;

import java.io.Serializable;
import java.util.List;

import com.lola.model.OnSale;

public interface OnSaleDao<T, Id  extends Serializable> extends HibernateUtilDao { 
	
	public List<Object[]> getMyOnSale(int userId,int categoryId);
	
	public List<Object[]> getOnSalebyBrandId(int brandId,int userId);
	public List<Object[]> getLikedOnSalebyBrandId(int brandId,int userId);
	
	 public List<Object> getOnSalebyUserId(int userid);
	 
	 public List<Object[]> getonSalebyBrandId(int brandId);
	 
	 public List<Object[]> getLikedAndUnlikedOnSalebyBrandId(int brandId, int userId);
	 public List<Object[]> getUnlikedOnSalebyBrandId(int brandId, int userId);
	 
	 public List<OnSale> findByOnSaleId(int onsaleId);
	 
	 public List<OnSale> findAllAvailableDetailsOfOnsale(int brandId);

}
