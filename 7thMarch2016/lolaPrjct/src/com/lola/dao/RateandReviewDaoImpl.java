package com.lola.dao;

import java.util.List;

import com.lola.model.RateandReview;
import com.lola.model.User;


public class RateandReviewDaoImpl implements RateandReviewDao<RateandReview, String> {

	
	public RateandReviewDaoImpl() {
		
	}
	
	public void saveUserRateReview(RateandReview entity){
		hibernateUtil.openCurrentSessionwithTransaction();
		hibernateUtil.getCurrentSession().save(entity);	
		hibernateUtil.closeCurrentSessionwithTransaction();
	}
	
	public void saveOrUpdate(RateandReview entity){
		hibernateUtil.openCurrentSessionwithTransaction();
		hibernateUtil.getCurrentSession().saveOrUpdate(entity);	
		hibernateUtil.closeCurrentSessionwithTransaction();
	}
	
	 
	 public static void main(String arg[]) throws Exception
	 {
		// new RateandReviewDaoImpl().saveUserFeedback(3,"Very Good");
	 }
}
