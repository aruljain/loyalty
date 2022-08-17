package com.lola.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.lola.service.UserNotificationService;
import com.lola.service.UserNotificationServiceImpl;

@Path("/lolanotification")
public class UserNotificationController {

	UserNotificationService userNotificationServiceImpl = new   UserNotificationServiceImpl();

	@GET
	@Path("/getNotificationCount")
	@Produces("text/html")
	public String getNotificationCount(@QueryParam ("userid") int userid) throws Exception {

		// TODO Auto-generated method stub
		return userNotificationServiceImpl.getNotificationCount(userid);
	}


	@GET
	@Path("/getUserNotificationDetails")
	@Produces("text/html")
	public String getUserNotificationDetails(
			@QueryParam ("userid") int userid
			) throws Exception{


		return userNotificationServiceImpl.getUserNotificationDetails(userid).toString().replace("\\", "") ;	



	}

	@GET
	@Path("/getUserNotificationCountforDealsAndOffers")
	@Produces("text/html")
	public String getUserNotificationCountforDealsAndOffers(
			@QueryParam ("userid") int userid
			) throws Exception{


		return userNotificationServiceImpl.getNotificationCountForDealsnOffers(userid) ;	



	}

	@GET
	@Path("/getUserNotificationDetailsForDealsAndOffers")
	@Produces("text/html")
	public String getUserNotificationDetailsForDealsAndOffers(
			@QueryParam ("userid") int userid
			) throws Exception{


		return userNotificationServiceImpl.getUserNotificationDetailsForDealsnOffers(userid) ;	



	}


	@GET
	@Path("/getUserNotificationCountforMySpecials")
	@Produces("text/html")
	public String getUserNotificationCountforMySpecials(
			@QueryParam ("userid") int userid
			) throws Exception{


		return userNotificationServiceImpl.getNotificationCountForMySpecials(userid) ;	



	}


	@GET
	@Path("/getUserNotificationDetailsForMySpecials")
	@Produces("text/html")
	public String getUserNotificationDetailsForMySpecials(
			@QueryParam ("userid") int userid
			) throws Exception{


		return userNotificationServiceImpl.getUserNotificationDetailsForMySpecials(userid) ;	



	}

	@GET
	@Path("/getUserNotificationCountForParticularBrand")
	@Produces("text/html")
	public String getUserNotificationCountForParticularBrand(
			@QueryParam ("userid") int userid,
			@QueryParam ("brandid") int brandid
			) throws Exception{


		return userNotificationServiceImpl.getNotificationCountforParticularBrand(userid, brandid) ;			
	}
	
	@GET
	@Path("/getUserNotificationDetailsForParticularBrand")
	@Produces("text/html")
	public String getUserNotificationDetailsForParticularBrand(
			@QueryParam ("userid") int userid,
			@QueryParam ("brandid") int brandid
			) throws Exception{


		return userNotificationServiceImpl.getUserNotificationDetailsForParticularBrand(userid, brandid) ;			
	}

}
