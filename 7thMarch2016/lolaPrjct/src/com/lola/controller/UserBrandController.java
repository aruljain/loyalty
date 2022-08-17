package com.lola.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.lola.service.UserBrandService;
import com.lola.service.UserBrandServiceImpl;
@Path("/userbrand")
public class UserBrandController {
	
	UserBrandService userBrandService=new UserBrandServiceImpl();
	
	@GET
	 @Path("/saveUserBrand")
	 @Produces("text/html")
	 public String saveMyBrands(
			 @QueryParam ("userid") int userid,
			 @QueryParam ("brandids") String brandids			
			 ) throws Exception {
		
		
		
		
		return userBrandService.saveUserBrand(userid, brandids);
		}

	
	@GET
	 @Path("/getUserBrandPointsDetails")
	 @Produces("text/html")
	 public String getUserBrandPointsDetails(
			 @QueryParam ("userid") int userid
						
			 ) throws Exception {
		
		
		
		
		return userBrandService.getMyBrandPoints(userid);
		}
	
	
	@GET
	 @Path("/unlikeUserBrand")
	 @Produces("text/html")
	 public String unlikeUserBrand(
			 @QueryParam ("userid") int userid,
			 @QueryParam ("brandids") String brandids			
			 ) throws Exception {
		
		
		
		
		return userBrandService.unlikeUserBrand(userid, brandids);
		}
	
	@GET
	 @Path("/getUserBrandCountByCategoryId")
	 @Produces("text/html")
	 public String getUserBrandPointsDetails(
			 @QueryParam ("userid") int userid,
			 @QueryParam ("categoryid") int categoryid
						
			 ) throws Exception {
		
		
		
		
		return userBrandService.getMyBrandsCountByCategoryId(userid, categoryid);
		}

	
	@GET
	 @Path("/brandPreferenceNotification")
	 @Produces("text/html")
	 public String brandPreferenceNotification(
			 @QueryParam ("userId") int userId,
			 @QueryParam ("brandId") int brandId
						
			 ) throws Exception {
		
		
		
		
		return userBrandService.brandPreferenceNoti(userId, brandId);
		}
}
