package com.lola.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.lola.service.BrandShowRoomService;
import com.lola.service.BrandShowRoomServiceImpl;
import com.lola.services.util.BrandShowRoomUtility;


@Path("/lola")
public class BrandShowRoomController {

	
	BrandShowRoomService brandShowRoomServiceImpl = new BrandShowRoomServiceImpl();
	BrandShowRoomUtility brandShowRoomUtility=new BrandShowRoomUtility();
	
	@GET
	 @Path("/lolaShowroomDetails")
	 @Produces("text/html")
	public String getLolaContact() throws Exception{
		
		
		return brandShowRoomServiceImpl.getLolaContact();
		
		
	}
	
	
	
	@GET
	 @Path("/lolaCheckin")
	 @Produces("text/html")
	public String lolaCheckin(@QueryParam ("brandid") int brandId,
			 @QueryParam ("lat") double lat,
			 @QueryParam ("lng") double lng,
			 @QueryParam ("pin") String pin) throws Exception{
		
		
		return brandShowRoomUtility.checkPin(brandId, lat, lng, pin);
		
		
	}
}
