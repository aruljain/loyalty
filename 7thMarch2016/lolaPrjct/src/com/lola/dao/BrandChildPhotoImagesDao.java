package com.lola.dao;

import java.io.Serializable;
import java.util.List;

import com.lola.model.BrandChildPhotoImages;

public interface BrandChildPhotoImagesDao<T, Id  extends Serializable> extends HibernateUtilDao {

	public List<Object> getimagepathbyBrandId(int brandid, int photoid);
	
	public void persist(T entity);
	 public void update(T entity);
	 public List<BrandChildPhotoImages> findBychildphotoimageId(int childphotoimageId);
	
	
}
