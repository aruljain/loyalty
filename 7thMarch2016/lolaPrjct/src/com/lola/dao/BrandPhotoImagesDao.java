package com.lola.dao;

import java.io.Serializable;
import java.util.List;

import com.lola.model.BrandChildPhotoImages;
import com.lola.model.BrandDealsandOffers;

public interface BrandPhotoImagesDao<T, Id  extends Serializable> extends HibernateUtilDao {

	public List<Object[]> getAffinityCategoriesbyBrandId(int brandid, int userid);
	public List<Object[]> getLikedAffinityCategoriesbyBrandId(int brandid, int userid);
	public List<BrandChildPhotoImages> findAllPhotoImages(String searchString);
	

	
}
