package com.lola.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.lola.service.UserService;
import com.lola.service.UserServiceImpl;
import com.sun.jersey.multipart.FormDataParam;


@Path("/lolauser")
public class UserController {

	UserService userServiceImpl = new UserServiceImpl();
	
		
	@SuppressWarnings("unchecked")
	@GET
	@Path("/saveCustomer")
	@Produces("text/html")
	public String saveCustomer(
			@QueryParam ("imageString") String imageString,
			@QueryParam ("salutation") String salutation,
			@QueryParam ("username") String username,
			@QueryParam ("password") String password,
			@QueryParam ("email") String email,
			@QueryParam ("location") String location,
			@QueryParam ("baseLocation") String baseLocation,
			@QueryParam ("mobile") String mobile,
			@QueryParam ("latitude") String latitude,
			@QueryParam ("longtitude") String longtitude
			) throws Exception {
		
	return userServiceImpl.persist(imageString,salutation,username,password,email,location,baseLocation,mobile,latitude,longtitude);
	}
	
	
	@GET
	@Path("/logindata")
	@Produces("text/html")
	public String login(
			@QueryParam("userid") String  email,
			@QueryParam("password") String  password
			) throws Exception {

		
		return userServiceImpl.loginUser(email, password);

	}
	
	@GET
	@Path("/forgotpassword")
	@Produces("text/html")
	public String forgotPassword(
			@QueryParam("userid") String  email		
			) throws Exception {

		 
		return userServiceImpl.forgotPassword(email);
	}
	
	
	@GET
	@Path("/resetpassword")
	@Produces("text/html")
	public String resetPassword(
			@QueryParam("userid") String  email,
			@QueryParam("password") String password
			) throws Exception {

		 
		return userServiceImpl.resetPassword(email,password);
	}
	
	@GET
	@Path("/getEmailidnMob")
	@Produces("text/html")
	public String getEmailidnMob(
			@QueryParam("email") String  email
			
			) throws Exception {

		 
		return userServiceImpl.getUserByEmailId(email);
	}
	
	@SuppressWarnings("unchecked")
	@POST
	@Path("/saveCustomerForm")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces("text/html")
	public String saveCustomerForm(
			@FormDataParam ("userProfilePic") String imageString,
			@FormDataParam ("salutation") String salutation,
			@FormDataParam ("username") String username,
			@FormDataParam ("password") String password,
			@FormDataParam ("email") String email,
			@FormDataParam ("location") String location,
			@FormDataParam ("baseLocation") String baseLocation,
			@FormDataParam ("mobile") String mobile,
			@FormDataParam ("latitude") String latitude,
			@FormDataParam ("longtitude") String longtitude
			) throws Exception {
		
	
		
	return userServiceImpl.persist(imageString,salutation,username,password,email,location,baseLocation,mobile,latitude,longtitude);
	}
	
	@GET
	@Path("/resendOTP")
	@Produces("text/html")
	public String resendOTP(
			@QueryParam("userId") int  userId
			
			) throws Exception {

		 
		return userServiceImpl.resendOTP(userId);
	}
}
