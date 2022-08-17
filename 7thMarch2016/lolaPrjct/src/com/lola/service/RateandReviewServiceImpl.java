package com.lola.service;

import com.lola.dao.RateandReviewDao;
import com.lola.dao.RateandReviewDaoImpl;
import com.lola.services.util.RateandReviewUtility;

public class RateandReviewServiceImpl implements RateandReviewService{
	
	private static RateandReviewDao rateandReviewDaoImpl;
	
	public RateandReviewServiceImpl() {
		rateandReviewDaoImpl = new RateandReviewDaoImpl();
		
	}
	
	RateandReviewUtility rateandReviewUtility=new RateandReviewUtility();
	public String saveUserRateReview(String rate,
			String review,
			int userid,
			int brandid,
			int productid)  throws Exception{

	
	return	rateandReviewUtility.saveUserRateReview(rate,review,userid,brandid,productid);
		
		//rateandReviewUtility.saveUserRateReview(rate, review, userId).toString();
	}
	@Override
	public String saveUserFeedback(String feedback, int userId, int brandid,
			int productid) throws Exception {
		// TODO Auto-generated method stub
		
		return rateandReviewUtility.saveUserFeedback(feedback, userId, brandid, productid);
	}
	
	@Override
	public String saveNotHereMail(int userid, String brandName,
			String categoryName) throws Exception {
		
		return rateandReviewUtility.saveNotHere(userid, brandName, categoryName);
	}
	@Override
	public String saveUserUnLike(int userid,int brandid){
		rateandReviewUtility.saveUserUnLike(userid,brandid);
		return"";
		
	}
	

}
