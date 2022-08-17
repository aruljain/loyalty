package com.lola.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.lola.service.OnSaleService;
import com.lola.service.OnSaleServiceImpl;
import com.lola.services.util.OnSaleUtility;

@Path("/onsale")
public class OnSaleController {
	
	@GET
	 @Path("/getMyOnSale")
	 @Produces("text/html")
	 public String getMyOnSale(
			 @QueryParam ("userId") int userId,
			 @QueryParam ("categoryId") int categoryId) throws Exception {			 
			 		
		
		OnSaleService OnSaleServiceImpl =new OnSaleServiceImpl();
		return OnSaleServiceImpl.getMyOnSale(userId, categoryId);		
		}
	
	
	
	@GET
	 @Path("/getMyOnSaleByBrandid")
	 @Produces("text/html")
	 public String getMyOnSaleByBrandid(
			 @QueryParam ("userId") int userId,
			 @QueryParam ("brandId") int brandId) throws Exception {			 
			 		
		OnSaleUtility OnSaleUtility= new OnSaleUtility();
		
		return OnSaleUtility.getOnSalebyBrandId(brandId, userId);		
		}
	

}
