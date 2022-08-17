package com.lola.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import com.lola.service.LolaHomeService;
import com.lola.service.LolaHomeServiceImpl;
import com.lola.services.util.LolaHomeUtility;

@Path("/lolaHomeScreen")
public class LolaHomeController {
	LolaHomeService lolaHomeService=new LolaHomeServiceImpl();
	LolaHomeUtility lolaHomeBrandUtility=new LolaHomeUtility();
	
	@GET
	 @Path("/lolaHomeScreenDetails")
	 @Produces("text/html")
	 public String lolaHomeScreenDetails(
			 @QueryParam ("userid") int userid)throws Exception {
				 
				 
					
					
					
					   return lolaHomeService.getHomeScreenDetails(userid) ;		
					}
	
	@GET
	 @Path("/getUserPic")
	 @Produces("text/html")
	 public String getUserPic(
			 @QueryParam ("userid") int userid)throws Exception {
				 
		//		 Context context = 				
					
					   return lolaHomeBrandUtility.getProfilepic(userid) ;		
					}
	
				

}
