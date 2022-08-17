package com.lola.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.lola.service.BrandPhotoImagesService;
import com.lola.service.BrandPhotoImagesServiceImpl;



@Path("/brandphotoimages")
public class BrandPhotoImagesController {
	
	
	BrandPhotoImagesService brandPhotoImagesServiceImpl=new BrandPhotoImagesServiceImpl();
	

	@GET
	@Path("/getaffinityCategoriesbyBrandId")
	@Produces("text/html")
	public String getAllbrandsDealsandOffersByCategoryIdWithLimit(
			@QueryParam ("brandId") int brandId,
			@QueryParam ("userId") int userId
			) throws Exception {



		return brandPhotoImagesServiceImpl.getimagepathbyBrandId(brandId,userId);		
	}

	/*
	@GET
	@Path("/saveBrandChildPhotoImagesLeafPage")
	@Produces("text/html")
	public String saveBrandChildPhotoImagesLeafPage(
			@QueryParam ("userId") int userId,
			@QueryParam ("childphotoimageId") int childphotoimageId
			
			) throws Exception {



		return brandPhotoImagesServiceImpl.saveBrandChildPhotoImagesLeafPage(userId, childphotoimageId);		
	}*/
}
