package com.lola.controller;

import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.lola.dao.BrandDaoImpl;
import com.lola.model.Brand;
import com.lola.service.BrandService;
import com.lola.service.BrandServiceImpl;
import com.lola.services.util.BrandUtility;

@Path("/lolabrand")
public class BrandController {

	
	BrandService brandServiceImpl = new BrandServiceImpl();
	/*@GET
	 @Path("/getMyBrandsByCategoryId/{start}/{offset}")
	 @Produces("text/html")
	 public String getMyBrandsByCategoryId(
			 @QueryParam ("userid") int userid,
			 @QueryParam ("categoryid") int categoryid,
			 @PathParam ("start") int start,
			 @PathParam ("offset") int offset) throws Exception {
			 
			 
		
	
		
		return brandServiceImpl.getMyBrandsByCategoryId(userid,categoryid,start,offset).replace("\\", "");		
		}
	*/
	
	@GET
	 @Path("/getMyBrandsByCategoryId")
	 @Produces("text/html")
	 public String getMyBrandsByCategoryId(
			 @QueryParam ("userid") int userid,
			 @QueryParam ("categoryid") int categoryid) throws Exception {			 
			 		
		return brandServiceImpl.getMyBrandsByCategoryId(userid,categoryid).replace("\\", "");		
		}
	
	
	@GET
	 @Path("/getAllBrandsByCategoryId")
	 @Produces("text/html")
	 public String getAllBrandsByCategoryId(
			 @QueryParam ("userid") int userid,
			 @QueryParam ("categoryid") int categoryid
			 ) throws Exception {
			 
			 
		
		
		
		return brandServiceImpl.getAllBrandsByCategoryId(userid,categoryid);		
		}
	
	
	@GET
	 @Path("/getTotalBrands")
	 @Produces("text/html")
	public String getTotalBrands() throws Exception{
		
		
		return brandServiceImpl.getTotalBrands();
		
		
	}
	
	@GET
	 @Path("/getBrandsByCategoryid")
	 @Produces("text/html")
	public String getBrandsByCategoryid(
			@QueryParam ("categoryid") int categoryid) throws Exception{
		
		
		return brandServiceImpl.getBrandsByCategoryId(categoryid);
		
		
	}
	
	@GET
	 @Path("/getAllBrandsCountByCategoryId")
	 @Produces("text/html")
	 public String getAllBrandsCountByCategoryId(
			 @QueryParam ("userid") int userid,
			 @QueryParam ("categoryid") int categoryid) throws Exception {
			 			 		
		return brandServiceImpl.getAllBrandsCountByCategory(userid, categoryid);		
		}
	
	
	@GET
	 @Path("/getBrandHomePage")
	 @Produces("text/html")
	 public String getBrandHomePage(
			 @QueryParam ("brandId") int brandId
			) throws Exception {
			 			 		
		return brandServiceImpl.getBrandHomepage(brandId);		
		}
}









