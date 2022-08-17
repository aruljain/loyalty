package com.lola.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.lola.service.SearchService;
import com.lola.service.SearchServiceImpl;
import com.lola.services.util.CheckInUtility;

@Path("/search")
public class SearchController {

	
	SearchService searchServiceImpl = new SearchServiceImpl();
	CheckInUtility checkInUtility=new  CheckInUtility();
	
	@GET
	 @Path("/global")
	 @Produces("text/html")
	 public String searchGlobally(
			 @QueryParam ("userid") int userid,
			 @QueryParam ("searchString") String searchString) throws Exception {			 
			 		
		return searchServiceImpl.searchGlobal(userid, searchString);		
		}
	
	
	public static void main(String args[]) throws Exception
	{
		System.out.println(new SearchController().searchGlobally(5,"derby"));
	}
	
	@GET
	 @Path("/checkin")
	 @Produces("text/html")
	 public String searchGlobally(
			 @QueryParam ("brandid") int brandId,
			 @QueryParam ("lat") double lat,
			 @QueryParam ("lng") double lng
			) throws Exception {			 
			 		
		return checkInUtility.checkInUtility(brandId, lat, lng);		
		}
	
	
	
	
}









