package com.lola.controller;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.lola.service.BrandImagesService;
import com.lola.service.BrandImagesServiceImpl;
import com.lola.services.util.BrandImagesUtility;


@Path("/brandimages")
public class BrandImagesController {
	
	@GET
	 @Path("/getByCategoryIdWithLimit/{start}/{offset}")
	 @Produces("text/html")
	 public String getBrandsByCategoryWithLimit(
			 @QueryParam ("categoryId") int categoryId,
			 @PathParam ("start") int start,
			 @PathParam ("offset") int offset
			 ) throws Exception {
		
		BrandImagesService brandImagesServiceImpl=new BrandImagesServiceImpl();
		
		return brandImagesServiceImpl.findByCategoryIdWithLimit(categoryId, start, offset).replace("\\", "");		
		}
	

}
