package com.lola.dao;

import java.io.Serializable;
import java.util.List;

import com.lola.model.BrandDealsandOffers;
import com.lola.model.MySpecialsChild;

public interface BrandDealsandOffersDao<T, Id  extends Serializable> extends HibernateUtilDao {

	public List<T> getAllbrandsDealsandOffersByCategoryIdWithLimit(int categoryId,int start, int offset);
	public List<Object> getMyDealsandOffersbyUserId(int userid);
	public List<Object[]> getMyDealsandOffers(int userid,int categoryId);
	public List<Object[]> getMyDealsandOffersbyBrandId(int brandId,int userId);
	public List<Object[]> getLikedMyDealsandOffersbyBrandId(int brandId,int userId);
	
	public void persist(T entity);
	 public void update(T entity);
	 public List<BrandDealsandOffers> findBydealandofferId(int dealandofferId);
	 public List<BrandDealsandOffers> findAllBrandDealsandOffers(String searchString);
	 
	 public List<BrandDealsandOffers> findAllAvailableDetailesOfDealsOffers(int brandId);
	 
	 
	 
	 
     public List<Object[]> getDealAndOfferbyBrandId(int brandId);
	 public List<Object[]> getLikedAndUnlikedDealsOfferbyBrandId(int brandId, int userId);
	 public List<Object[]> getUnlikedDealAndOfferbyBrandId(int brandId, int userId);

}
