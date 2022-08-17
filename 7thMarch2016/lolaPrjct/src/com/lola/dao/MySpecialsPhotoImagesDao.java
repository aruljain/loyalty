package com.lola.dao;

import java.io.Serializable;
import java.util.List;

import com.lola.model.MySpecialsChild;

public interface MySpecialsPhotoImagesDao<T,Id extends Serializable>  extends HibernateUtilDao {
	
	//public List<Object[]> getLikedMySpecialsPhotoImages(int brandid,int userId);
	
	//public List<Object[]> getMySpecialsPhotoImages(int brandid,int userId);

	public List<Object[]> getMySpecialChildImages();
	
	 public void persist(T entity);
	 public void update(T entity);
	 public List<MySpecialsChild> findBymyspecialchildId(int myspecialchildId);
	 public List<Object[]> getAllMySpecialsPhotoImages(String  searchString);
	 
	 
	 
	 public List<Object[]> getMyspecialchildbyBrandId(int brandId);
	 public List<Object[]> getLikedAndUnlikedMyspecialchildbyBrandId(int brandId, int userId);
	 public List<Object[]> getUnlikedMyspecialchildbyBrandId(int brandId, int userId);
}
