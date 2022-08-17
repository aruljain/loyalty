package com.lola.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.lola.service.BrandAffinityService;
import com.lola.service.BrandAffinityServiceImpl;

@Path("/brandaffinity")
public class BrandAffinityController {
	
	 BrandAffinityService  brandAffinityServiceImpl= new  BrandAffinityServiceImpl();

	
	 @GET
	 @Path("/getBrandaffinityPage")
	 @Produces("text/html")
	 public String getMyBrandsByCategoryId(
			 @QueryParam ("userid") int userid,
			 @QueryParam ("brandid") int brandid,
			 @QueryParam ("lat") double lat,
			 @QueryParam ("lng") double lng,
			 @QueryParam ("dist") float dist
			) throws Exception{
			 
			 if( dist==0 || dist==0.0f)
				 dist=0.5f;
			 return brandAffinityServiceImpl.getBrandAffinityDetails(userid, brandid, lat, lng, dist) ;	
	
		
		
}
}
