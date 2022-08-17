package com.lola.dao;

import java.io.Serializable;
import java.util.List;

public interface BrandImagesDao<T,Id extends Serializable>  extends HibernateUtilDao {
	
	 public List<T> findByCategoryIdWithLimit(int categoryId,int start, int offset);
	/* public List<Object[]> findByCategoryIdWithLimit1(int categoryId,int start, int offset);
*/
}
