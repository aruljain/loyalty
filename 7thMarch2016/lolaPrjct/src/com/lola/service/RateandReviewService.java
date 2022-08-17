package com.lola.service;

public interface RateandReviewService {

	
	public String saveUserRateReview(String rate,
			String review,
			int userId,
			int brndid,
			int productid) throws Exception;
	
	public String  saveUserFeedback(		
			String feedback,
			int userId,
			int brandid,
			int productid
			) throws Exception;
	
	public String saveNotHereMail(int userid,
			String brandName, 
			String categoryName) throws Exception;
	
	public String saveUserUnLike(int userid,
			int brandid) throws Exception;
}
