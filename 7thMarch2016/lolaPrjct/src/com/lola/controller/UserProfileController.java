package com.lola.controller;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.lola.service.UserProfileService;
import com.lola.service.UserProfileServiceImpl;
import com.sun.jersey.multipart.FormDataParam;

@Path("/lolauserprofile")

public class UserProfileController {

	 @Context 
	 ServletContext context;
	 
	 UserProfileService userProfileService=new UserProfileServiceImpl();

	 public UserProfileController()
	 {
		
	 }
	 
	 @Context
	    public void setServletContext(ServletContext context) {
	        System.out.println("servlet context set here"+ context);
	        this.context = context;
	    }
	 
	 
	
	/*//@SuppressWarnings("unchecked")
		@POST
		@Path("/saveOrUpdateUserProfile")
		//@Consumes(MediaType.MULTIPART_FORM_DATA)
		@Produces("text/html")		
	    public String saveOrUpdateUserProfile(

	    		@FormParam ("userid") int userid,
	    		@FormParam ("imageString") String imageString,
	    		@FormParam ("dob") Date dob,
	    		@FormParam ("gender") String gender,
	    		@FormParam ("maritalstatus") boolean maritalstatus,
	    		@FormParam ("veg") boolean veg,
	    		@FormParam ("weddinganv") Date weddinganv

	   ) throws Exception {

			System.out.println(userid+"  "+imageString+"   "+dob+"    "+gender+"   "+maritalstatus+"    "+veg+"   "+weddinganv);
			return userProfileService.saveorupdate(userid, imageString, dob, gender, maritalstatus, veg, weddinganv);
		}*/
	@SuppressWarnings("unchecked")
	@POST
	@Path("/saveOrUpdateUserProfilePost")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces("text/html")
	public String saveUserProfilePost(
			@FormDataParam ("userid") String userid,
			@FormDataParam ("imageString") String imageString,
			@FormDataParam ("salutation") String salutation,
			@FormDataParam ("dob") String dob,
			@FormDataParam ("gender") String gender,
			@FormDataParam ("mycities") String mycities,
			@FormDataParam ("maritalstatus") boolean maritalstatus,
			@FormDataParam ("username") String username,
			@FormDataParam ("location") String location,
			@FormDataParam ("baselocation") String baselocation,
			@FormDataParam ("Email") String email,
			@FormDataParam ("mobile") String mobile,
			@FormDataParam ("password") String password,
			@FormDataParam ("veg") boolean veg,
			@FormDataParam ("weddinganv") String weddinganv)	throws Exception{


		
		int uid=Integer.parseInt(userid);
			//	String output = "File Received on server "+userid+ " \t\t\t "+imageString;
			//	System.out.println(output);
			//	return output;

			return userProfileService.saveorupdate(uid, imageString,salutation, dob, gender,mycities, maritalstatus, veg, weddinganv,username,location,baselocation,email,mobile,password);
			}

			/*@SuppressWarnings("unchecked")
			@GET
			@Path("/saveUserProfile")
			@Produces("text/html")

			public String saveOrUpdateUserProfile(

					@QueryParam ("userid") int userid,
					@QueryParam ("imageString") String imageString,
					@QueryParam ("dob") Date dob,
					@QueryParam ("gender") String gender,
					@QueryParam ("maritalstatus") boolean maritalstatus,
					@QueryParam ("veg") boolean veg,
					@QueryParam ("weddinganv") Date weddinganv

					) throws Exception {


				return userProfileService.saveorupdate(userid, imageString, dob, gender, maritalstatus, veg, weddinganv);
			}
*/

		/*	@SuppressWarnings("unchecked")
			@GET
			@Path("/getUserProfileByUserId")
			@Produces("text/html")
			public String getUserProfileByUserId(

					@QueryParam ("userid") int userid) throws Exception{
				return userProfileService.findUserProfileByuserid(userid);

			}*/

			@SuppressWarnings("unchecked")
			@GET
			@Path("/getusercompletedetailsbyuserid")
			@Produces("text/html")
			public String getusercompletedetails(

					@QueryParam ("userid") int userid) throws Exception{
				return userProfileService.getusercompletedetails(userid).replace("\\", "");

			}
			
			
			
			
			
			
			
			//
			
			
			@SuppressWarnings("unchecked")
			@GET
			@Path("/saveOrUpdateUserProfile")
			//@Consumes(MediaType.MULTIPART_FORM_DATA)
			@Produces("text/html")
			public String saveUserProfile(
					@QueryParam ("userid") String userid,
					@QueryParam ("imageString") String imageString,
					@QueryParam ("salutation") String salutation,
					@QueryParam ("dob") String dob,
					@QueryParam ("gender") String gender,
					@QueryParam ("mycities") String mycities,
					@QueryParam ("maritalstatus") boolean maritalstatus,
					@QueryParam ("username") String username,
					@QueryParam ("location") String location,
					@QueryParam ("baselocation") String baselocation,
					@QueryParam ("Email") String email,
					@QueryParam ("mobile") String mobile,
					@QueryParam ("password") String password,
					@QueryParam ("veg") boolean veg,
					@QueryParam ("weddinganv") String weddinganv)	throws Exception{


					int uid=Integer.parseInt(userid);
					

					return userProfileService.saveorupdate(uid, imageString,salutation, dob, gender,mycities, maritalstatus, veg, weddinganv,username,location,baselocation,email,mobile,password);
					}
			
			public static void main(String args[]) {
				new UserProfileController();
			}

}
