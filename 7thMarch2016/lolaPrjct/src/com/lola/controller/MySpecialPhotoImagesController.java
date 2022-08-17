package com.lola.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.lola.service.MySpecialPhotoImagesService;
import com.lola.service.MySpecialPhotoImagesServiceImpl;


@Path("/brandspecialphotoimages")
public class MySpecialPhotoImagesController {

	MySpecialPhotoImagesService mySpecialPhotoImagesServiceImpl = new MySpecialPhotoImagesServiceImpl();
	
	@GET
	@Path("/getMySpecialsPhotoImagesByBrandId")
	@Produces("text/html")
	public String getMySpecialsPhotoImages(
			@QueryParam ("brandId") int brandId,
			@QueryParam ("userId") int userId
			) throws Exception {



		return mySpecialPhotoImagesServiceImpl.getMySpecialsPhotoImages(brandId,userId);		
	}
	
	/*@GET
	@Path("/saveMySpecialLeafPage")
	@Produces("text/html")
	public String saveMySpecialLeavePage(
			@QueryParam ("userId") int userId,
			@QueryParam ("myspecialchildId") int myspecialchildId
			) throws Exception {



		return mySpecialPhotoImagesServiceImpl.saveMySpecialLeavePage(userId, myspecialchildId);		
	}
*/
	
}
