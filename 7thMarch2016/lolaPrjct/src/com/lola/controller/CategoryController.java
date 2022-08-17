package com.lola.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.lola.service.CategoryService;
import com.lola.service.CategoryServiceImpl;

@Path("/brands")
public class CategoryController {
	
	CategoryService categoryServiceImpl = new CategoryServiceImpl();
	
	@GET
	 @Path("/getBrands")
	 @Produces("text/html")
	 public String getBrandsAndCategoriesDetails() throws Exception{
		
		
		return categoryServiceImpl.getBrandsAndCategoriesDetails();
		
		
	}

}
