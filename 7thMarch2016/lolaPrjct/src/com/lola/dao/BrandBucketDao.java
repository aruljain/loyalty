package com.lola.dao;

import java.io.Serializable;

public interface BrandBucketDao<T,Id extends Serializable> extends HibernateUtilDao {
	 public String getBucketidsByBrandid(int brandid);
	

}
