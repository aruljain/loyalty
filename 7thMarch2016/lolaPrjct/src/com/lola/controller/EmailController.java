package com.lola.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.lola.model.User;
import com.lola.services.util.EmailUtility;
import com.lola.services.util.UserUtility;

@Path("/Email")
public class EmailController {
	UserUtility userUtility=new  UserUtility();
	@GET
	 @Path("/sendEmail")
	 @Produces("text/html")
	 public String sendSignupEmail(
			 @QueryParam ("userId") int userId,
			 @QueryParam ("username") String username,
			 @QueryParam ("email") String email,
			 @QueryParam ("password") String password,
			 @QueryParam ("mobile") String mobile,
			 @QueryParam ("otpStatus") boolean otpStatus
			 )throws Exception {
		
					
					
					   return userUtility.sendEmail(userId,username, email, password,mobile,otpStatus) ;		
					}

}
