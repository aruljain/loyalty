package com.lola.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.lola.service.RateandReviewService;
import com.lola.service.RateandReviewServiceImpl;


@Path("/rateandreview")
public class RateandReviewController {

	RateandReviewService rateandReviewServiceImpl = new RateandReviewServiceImpl();
	
	@SuppressWarnings("unchecked")
	@GET
	@Path("/saverateandreview")
	@Produces("text/html")
	public String saveUserRateReview(

			@QueryParam ("rate") String rate,
			@QueryParam ("review") String review,
			@QueryParam ("userId") int userId,
			@QueryParam ("brandid") int brandid,
			@QueryParam ("productid") int productid
			) throws Exception {
		System.out.println(brandid+"     "+productid);
	return rateandReviewServiceImpl.saveUserRateReview(rate,review,userId,brandid,productid).toString();
	
	}
	
	@SuppressWarnings("unchecked")
	@GET
	@Path("/saveUserFeedback")
	@Produces("text/html")
	public String saveUserFeedback(

			@QueryParam ("feedback") String feedback,
			@QueryParam ("userId") int userId,
			@QueryParam ("brandid") int brandid,
			@QueryParam ("productid") int productid
			) throws Exception {
		System.out.println(brandid+"     "+productid);
	return rateandReviewServiceImpl.saveUserFeedback(feedback, userId, brandid, productid);
	
	}
	
	@SuppressWarnings("unchecked")
	@GET
	@Path("/saveNotHere")
	@Produces("text/html")
	public String saveNothere(
			@QueryParam ("userId") int userId,
			@QueryParam ("brandName") String brandName,
			@QueryParam ("categoryName") String categoryName
			) throws Exception {
		System.out.println(brandName+"     "+categoryName);
	return rateandReviewServiceImpl.saveNotHereMail(userId, brandName, categoryName);
	
	}
	
	@SuppressWarnings("unchecked")
	@GET
	@Path("/saveUserUnLike")
	@Produces("text/html")
	public String saveUserUnLike(
			@QueryParam ("userId") int userId,
			@QueryParam ("brandid") int brandid			
			) throws Exception {
		
	return rateandReviewServiceImpl.saveUserUnLike(userId, brandid);
	
	}
	
	
/*	@SuppressWarnings("unchecked")
	@GET
	@Path("/saveratereviewByBrandId")
	@Produces("text/html")
	public String saveUserRateReviewByBrandId(

			@QueryParam ("rate") String rate,
			@QueryParam ("review") String review,
			@QueryParam ("userId") int userId,
			@QueryParam ("brandId") int brandId
			) throws Exception {
		
	return rateandReviewServiceImpl.saveUserRateReviewByBrandId(rate,review,userId,brandId).toString();
	
	}*/
	
	/*@SuppressWarnings("unchecked")
	@GET
	@Path("/saveratereviewByProductId")
	@Produces("text/html")
	public String saveUserRateReviewByProductId(

			@QueryParam ("rate") String rate,
			@QueryParam ("review") String review,
			@QueryParam ("userId") int userId,
			@QueryParam ("brandId") int brandId,
			@QueryParam ("productId") int productId
			) throws Exception {
		
	return rateandReviewServiceImpl.saveUserRateReviewByProductId(rate,review,userId,brandId,productId).toString();
	
	}
*/
	
}
