package com.lola.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.lola.service.MyLeafPageServiceImpl;
import com.lola.services.util.BooknowUtility;
import com.lola.services.util.DealsAndOffersLeafPageUtility;
import com.lola.services.util.MySpecialLeafPageUtility;
import com.lola.services.util.NewarrivalsLeafPageUtility;
import com.lola.services.util.OnSaleLeafPageUtility;
import com.lola.services.util.PhotoimageLeafPageUtility;

@Path("/leafpage")
public class MyLeafPageController {
	
	MyLeafPageServiceImpl myLeafPageServiceImpl =new MyLeafPageServiceImpl();
	
	@GET
	@Path("/saveMySpecialLeafPage")
	@Produces("text/html")
	public String saveMyspecialLeafPage(
			@QueryParam ("userId") int userId,
			@QueryParam ("myspecialchildId") int myspecialchildId

			) throws Exception {

		return myLeafPageServiceImpl.saveMySpecialLeafPage(userId, myspecialchildId);
	}


	
	

	
	@GET
	@Path("/saveDealsAndOffersLeafPage")
	@Produces("text/html")
	public String saveDealsAndOffersLeafPage(
			@QueryParam ("userId") int userId,
			@QueryParam ("dealandofferId") int dealandofferId

			) throws Exception {

		return myLeafPageServiceImpl.saveDealsAndOffersLeafPage(userId, dealandofferId);
	}


	
	
	@GET
	@Path("/saveNewarrivalLeafPage")
	@Produces("text/html")
	public String saveNewarrivalsLeafPage(
			@QueryParam ("userId") int userId,
			@QueryParam ("newarrivalId") int newarrivalId

			) throws Exception {

		return myLeafPageServiceImpl.saveNewarrivalsLeafPage(userId, newarrivalId);
	}
	
	
	
	
	@GET
	@Path("/savePhoimageLeafPage")
	@Produces("text/html")
	public String savePhotoimagesLeafPage(
			@QueryParam ("userId") int userId,
			@QueryParam ("childphotoimageId") int childphotoimageId

			) throws Exception {

		return myLeafPageServiceImpl.savePhotoimagesLeafPage(userId, childphotoimageId);
	}
	
	
	@GET
	@Path("/saveOnSaleLeafPage")
	@Produces("text/html")
	public String saveOnSaleLeafPage(
			@QueryParam ("userId") int userId,
			@QueryParam ("onSaleId") int onSaleId

			) throws Exception {

		return myLeafPageServiceImpl.saveOnSaleLeafPage(userId, onSaleId);
	}

	
	
	@GET
	@Path("/sendBooknow")
	@Produces("text/html")
	public String sendBooknow(
			@QueryParam ("userId") int userId,
			@QueryParam ("bucketId") int bucketId,
			@QueryParam ("brandId") int brandId

			) throws Exception {

		return myLeafPageServiceImpl.SendBooknow(userId, bucketId,brandId);
	}

	
	@GET
	@Path("/checkedin")
	@Produces("text/html")
	public String sendBooknow(
			@QueryParam ("userId") int userId,
		    @QueryParam ("brandId") int brandId

			) throws Exception {
		BooknowUtility booknowUtility =new BooknowUtility();
		return booknowUtility.Checked(userId, brandId);
	}
	
	
	public static void main(String[] args) throws Exception{
		
		MyLeafPageController myLeafPageController=new  MyLeafPageController();
		System.out.println(myLeafPageController.saveMyspecialLeafPage(1, 5));
		
	}
	
	
	
	
}
