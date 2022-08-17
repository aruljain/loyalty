package com.lola.dao;

import java.io.Serializable;
import java.util.List;

public interface BrandBannerDao<T,Id extends Serializable>  extends HibernateUtilDao {

	 public List<Object[]> getBrandBanner(int brandid);

	
}
