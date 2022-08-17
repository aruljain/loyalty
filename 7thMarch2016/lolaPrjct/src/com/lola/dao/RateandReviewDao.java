package com.lola.dao;

import java.io.Serializable;
import java.util.List;

import com.lola.model.RateandReview;

public interface RateandReviewDao<T, Id  extends Serializable> extends HibernateUtilDao {

	 public void saveUserRateReview(T entity);
	 public void saveOrUpdate(T entity);	
}
