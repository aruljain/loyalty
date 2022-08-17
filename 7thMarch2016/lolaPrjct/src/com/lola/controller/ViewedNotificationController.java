package com.lola.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.lola.service.ViewedNotificationService;
import com.lola.service.ViewedNotificationServiceImpl;
@Path("/UserVeiwNotification")
public class ViewedNotificationController {
	
	
	ViewedNotificationService viewedNotificationServiceImpl=new  ViewedNotificationServiceImpl();
	
	 @GET
	 @Path("/saveUserVeiwNotification")
	 @Produces("text/html")
	public String userviewed( @QueryParam ("userid") int userid,
			@QueryParam ("dealsoffers") String dealsoffers,
			@QueryParam ("newarrivals") String newarrivals,
			@QueryParam ("myspecials") String myspecials) throws Exception{
		return viewedNotificationServiceImpl.userviewed(userid, dealsoffers, newarrivals, myspecials);
	}
	 
	 @GET
	 @Path("/saveUserVeiwedNotification")
	 @Produces("text/html")
	public String userviewedNotification( 
			@QueryParam ("userid") int userid,
			@QueryParam ("bucketids") String bucketids) throws Exception{
		return viewedNotificationServiceImpl.userviewedNotification(userid, bucketids);
	}

	 
	 @GET
	 @Path("/saveUserVeiwNotificationForDealsnOffers")
	 @Produces("text/html")
	public String saveUserVeiwNotificationForDealsnOffers( @QueryParam ("userid") int userid,
			@QueryParam ("dealsoffers") String dealsoffers
			) throws Exception{
		return viewedNotificationServiceImpl.uservieweddealsnoffers(userid, dealsoffers);
	}

	 
	 
	 @GET
	 @Path("/saveUserVeiwNotificationForMySpecials")
	 @Produces("text/html")
	public String saveUserVeiwNotificationForMySpecials( @QueryParam ("userid") int userid,
			@QueryParam ("myspecials") String myspecials
			) throws Exception{
		return viewedNotificationServiceImpl.userviewedMySpecials(userid, myspecials);
	}
}
