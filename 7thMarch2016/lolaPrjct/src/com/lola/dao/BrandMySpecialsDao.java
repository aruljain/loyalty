package com.lola.dao;

import java.io.Serializable;
import java.util.List;

import com.lola.model.BrandMySpecials;
import com.lola.model.MySpecialsChild;

public interface BrandMySpecialsDao<T, Id  extends Serializable> extends HibernateUtilDao {

	
	public List<Object> getMySpecialsbyUserId(int userid);
	
	public List<Object[]> getMySpecials(int userid,int categoryId);
	
	//public List<Object[]> getMySpecialsbyBrandId(int brandId);
	
	public List<Object[]> getMySpecialsChildbyBrandId(int brandId);
	
	public List<Object[]> getMySpecialsByCategoryId(int userid,int categoryId);
	
	public List<Object[]> getMySpecialsChildByCategoryId(int userid,int categoryId);
	
	public List<MySpecialsChild> findAllMySpecialChild(String searchString);
	
	public List<MySpecialsChild> findByMySpecialChildId(int myspecialchildId);
	
	
	public List<MySpecialsChild> findAllAvailableDeatilsOfMySpecial(int brandId);
	
}
