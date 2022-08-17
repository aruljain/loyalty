package com.lola.dao;

import java.io.Serializable;
import java.util.List;

public interface BucketMasterDao <T, Id  extends Serializable> extends HibernateUtilDao {
	
	public List<Object[]> getBucketDetails(int brandid);

}
