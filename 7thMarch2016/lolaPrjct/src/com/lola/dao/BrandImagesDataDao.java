package com.lola.dao;

import java.io.Serializable;
import java.util.List;

import com.lola.model.BrandImageData;

public interface BrandImagesDataDao<T,Id extends Serializable>  extends HibernateUtilDao {
	
	public List<Object[]> getMyBrandsByCategoryId(int userid,int categoryid);
	public List<Object[]> getAllBrandsByCategoryId(int userid,int categoryid);
	public List<BrandImageData> getAllBrands(int userid, String searchString);
	public List<BrandImageData> getMyBrands(int userid, String searchString);

}
