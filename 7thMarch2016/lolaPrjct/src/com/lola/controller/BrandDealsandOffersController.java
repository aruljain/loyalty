package com.lola.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.lola.service.BrandDealsandOffersService;
import com.lola.service.BrandDealandOffersServiceImpl;
import com.lola.service.BrandMySpecialsService;
import com.lola.service.BrandMySpecialsServiceImpl;
import com.lola.service.BrandNewArrivalsService;
import com.lola.service.BrandNewArrivalsServiceImpl;


@Path("/branddealsandoffers")
public class BrandDealsandOffersController {


	BrandDealsandOffersService brandDealandOffersServiceImpl=new BrandDealandOffersServiceImpl();
	
	BrandNewArrivalsService brandNewArrivalsServiceImpl = new BrandNewArrivalsServiceImpl();

	@GET
	@Path("/getAllbrandsDealsandOffersByCategoryIdWithLimit/{start}/{offset}")
	@Produces("text/html")
	public String getAllbrandsDealsandOffersByCategoryIdWithLimit(
			@QueryParam ("categoryId") int categoryId,
			@PathParam ("start") int start,
			@PathParam ("offset") int offset
			) throws Exception {



		return brandDealandOffersServiceImpl.getAllbrandsDealsandOffersByCategoryIdWithLimit(categoryId, start, offset).replace("\\", "");		
	}

	@GET
	@Path("/getMyDealsandOffersbyUserId")
	@Produces("text/html")
	public String getMyDealsandOffersbyUserId(
			@QueryParam ("userid") int userid

			) throws Exception {

		return brandDealandOffersServiceImpl.getMyDealsandOffersbyUserId(userid);
	}
	
	BrandMySpecialsService brandMySpecialsServiceImpl = new BrandMySpecialsServiceImpl();
	
	@GET
	@Path("/getMySpecialsbyUserId")
	@Produces("text/html")
	public String getMySpecialsbyUserId(
			@QueryParam ("userid") int userid

			) throws Exception {

		return brandMySpecialsServiceImpl.getMySpecialsbyUserId(userid);
	}
	
	@GET
	@Path("/getMyDealsandOffers")
	@Produces("text/html")
	public String getMyDealsandOffers(
			@QueryParam ("userid") int userid,
			@QueryParam ("categoryid") int categoryId

			) throws Exception {

		return brandDealandOffersServiceImpl.getMyDealsandOffers(userid,categoryId);
	}
	
	@GET
	@Path("/getMySpecials")
	@Produces("text/html")
	public String getMySpecials(
			@QueryParam ("userid") int userid,
			@QueryParam ("categoryid") int categoryId

			) throws Exception {

		return brandMySpecialsServiceImpl.getMySpecials(userid,categoryId);
	}
	
	@GET
	@Path("/getNewArrivalsbyBrandId")
	@Produces("text/html")
	public String getNewArrivalsbyBrandId(
			@QueryParam ("brandId") int brandId,
			@QueryParam ("userId") int userId

			) throws Exception {

		return brandNewArrivalsServiceImpl.getNewArrivalsbyBrandId(brandId,userId);
	}
	
	@GET
	@Path("/getMyDealsandOffersbyBrandId")
	@Produces("text/html")
	public String getMyDealsandOffersbyBrandId(
			@QueryParam ("brandId") int brandId,
			@QueryParam ("userId") int userId

			) throws Exception {

		return brandDealandOffersServiceImpl.getMyDealsandOffersbyBrandId(brandId,userId);
	}
	
	/*@GET
	@Path("/getMySpecialsbyBrandId")
	@Produces("text/html")
	public String getMySpecialsbyBrandId(
			@QueryParam ("brandId") int brandId

			) throws Exception {

		return brandMySpecialsServiceImpl.getMySpecialsbyBrandId(brandId);
	}*/
	
	/*@GET
	@Path("/getMySpecialsByCategoryID")
	@Produces("text/html")
	public String getMySpecialsByCategoryID(
			@QueryParam ("userid") int userid,
			@QueryParam ("categoryid") int categoryId

			) throws Exception {

		return brandMySpecialsServiceImpl.getMySpecialsByCategoryId(userid, categoryId);
	}*/
	
	
	@GET
	@Path("/getMySpecialsByCategoryID")
	@Produces("text/html")
	public String getMySpecialsChildByCategoryID(
			@QueryParam ("userid") int userid,
			@QueryParam ("categoryid") int categoryId

			) throws Exception {

		return brandMySpecialsServiceImpl.getMySpecialsChildByCategoryId(userid, categoryId);
	}
	
	/*@GET
	@Path("/saveDealsAndOffersLeafPage")
	@Produces("text/html")
	public String saveDealsAndOffersLeavePage(
			@QueryParam ("userId") int userId,
			@QueryParam ("dealandofferId") int dealandofferId

			) throws Exception {

		return brandDealandOffersServiceImpl.saveDealsAndOffersLeavePage(userId, dealandofferId);
	}*/
}
	
	/*@GET
	@Path("/saveNewArrivalsLeafPage")
	@Produces("text/html")
	public String saveNewArrivalsLeafPage(
			@QueryParam ("userId") int userId,
			@QueryParam ("newarrivalId") int newarrivalId

			) throws Exception {

		return brandNewArrivalsServiceImpl.saveNewArrivalsLeavePage(userId, newarrivalId);
	}
}*/
