package com.lola.services.util;


//import com.lola.controller.string;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.commons.lang3.RandomStringUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.lola.dao.RoleDaoImpl;
import com.lola.dao.UserDao;
import com.lola.dao.UserDaoImpl;
import com.lola.model.User;
//import com.sun.media.jfxmedia.logging.Logger;

public class UserUtility {



	private static UserDao userDaoImpl;
	private SMSUtility smsUtility = new SMSUtility();



	public UserUtility() {
		userDaoImpl = new UserDaoImpl();

	}


	JSONObject obj =new JSONObject();
	JSONArray jsonArray = new JSONArray();

	public String saveCustomer(
			String imageString,
			String salutation,
			String username,
			String password,
			String email,
			String location,
			String baseLocation,
			String mobile,
			String latitude,
			String longtitude
			) throws Exception
	{



		boolean userProfileSaved =false;
		User entity= new User();

		try{

			List<User> users = userDaoImpl.findByemailId(email);
			List<User> users1 = userDaoImpl.findByMobile(mobile);

			for(int i=0;i<users.size();i++)
			{
				User user = (User) users.get(i);
				if(email.equals(user.getEmail()))
				{
					return userExists(email);
				}

				if(mobile.equals(user.getMobile()))
				{
					return userExistsMobile(mobile);
				}

			}
			
			for(int i=0;i<users1.size();i++)
			{
				User user1 = (User) users1.get(i);
				if(mobile.equals(user1.getMobile()))
				{
					return userExistsMobile(mobile);
				}

			}
			entity.setRoleid(1); 
			entity.setUserName(username);
			entity.setPassword(password);
			entity.setOtp(OTPGenerator.random());
			entity.setEmail(email);
			entity.setLocation(location);
			entity.setMobile(mobile);
			entity.setActive(true);			
			entity.setCreatedon(new Date());

			if(latitude!=null)
				entity.setLattitude(latitude);
			if(longtitude!=null)
				entity.setLongtitude(longtitude);

			userDaoImpl.persist(entity);
			entity.setCreatedby(entity.getUserId());
			userDaoImpl.update(entity);

			new Thread(new Runnable() {

				public void run() {
					boolean userProfileSaved =false;
					UserProfileUtility userProfileUtility = new UserProfileUtility();	
					System.out.println("Saving User Profile");
					try {
						// Thread.sleep(30000);
						userProfileSaved = userProfileUtility.saveorupdateUserProfilePic(entity.getUserId(), imageString,salutation,baseLocation);

						if(userProfileSaved)
							System.out.println("User Profile saved");

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}).start();



			/*if(latitude!=null)
				entity.setLattitude(latitude);
			if(longtitude!=null)
				entity.setLongtitude(longtitude);*/



			//String msgBody = "Welcome to our Lola app ! "+entity.getUserName()+"\n Email ID :"+entity.getEmail()+" \n Password :"+entity.getPassword();
				//boolean message = smsUtility.sendSMS(entity.getMobile(),"One time password for your registration at Lola is "+entity.getOtp()+". Please use this to complete the registration.");
				


			String otpmsg="One time password for your registration at Lola is "+entity.getOtp()+". Please use this to complete the registration.";
			new Thread(new Runnable() {

				public void run() {
					
			try {
				EmailUtility.sendEmail("smtp.critsend.com",
						"587", 
						"noreply@myshareindia.com", 
						"JxRApreLseNR", 
						entity.getEmail(), "Lola Login crendentials", otpmsg);
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				}

			}).start();
			
			String encodedOtpMsg = URLEncoder.encode(otpmsg, "UTF-8");
			//String msgBody = "Welcome to our Lola app ! "+entity.getUserName()+"\n Email ID :"+entity.getEmail()+" \n Password :"+entity.getPassword();


			new Thread(new Runnable() {

				public void run() {

					System.out.println("Sending SMS");
					smsUtility.sendSMS(entity.getMobile(),encodedOtpMsg);

				}

			}).start();

			//message = smsUtility.sendSMS(entity.getMobile(),entity.getOtp());
			/*EmailUtility.sendEmail("smtp.critsend.com",
						"587", 
						"noreply@myshareindia.com", 
						"JxRApreLseNR", 
						entity.getEmail(), "Lola Login crendentials", msgBody);*/


			//if(userProfileSaved){			   
			obj.put("Status","Success");  
			obj.put("Message", "Your OTP has been sent to your registered mobile number and Email Id.");
			obj.put("userid", entity.getUserId());
			obj.put("OTP",entity.getOtp());

			//	}
			/*else{
					obj.put("Status","Failure");  
					obj.put("Message", "Sending OTP Failed");	

				}*/



			jsonArray.put(obj);

			return jsonArray.toString();

		}catch(Exception e)
		{

			obj.put("Status","Failure");
			obj.put( "Message","User Already Exist");
			jsonArray.put(obj);
			System.out.println("Error :"+e.toString());
			return jsonArray.toString();


		}




	}




	public void updateCustomer(
			int userId, 
			String username,
			String password,
			String email,
			String location,
			String mobile
			//int createdby
			) throws Exception
	{
		String status = null;
		//boolean sendSms = false;
		//boolean sendEmail = false;
		//boolean sendSms1 = false;
		boolean sendEmailnSms1 = false;
		boolean sendEmailnSms = false;


		List<User> userObject = userDaoImpl.findByuserid(userId);

		if(userObject.size()>0){				

			for(User entity : userObject)
			{				

				entity.setRoleid(1); 
				entity.setUserId(userId);				


				if(username.isEmpty() || username== null){
					entity.setUserName(entity.getUserName());
				}
				else{
					entity.setUserName(username);
				}


				if(password.isEmpty()){
					entity.setPassword(entity.getPassword());
				}
				else{
					entity.setPassword(password);
				}

				if(email.isEmpty()){

					entity.setEmail(entity.getEmail());

				}
				else{
					if(!entity.getEmail().equals(email))
					{
						entity.setEmail(email);
						//sendEmail = true;
						//sendSms = true;
						sendEmailnSms=true;
						entity.setOtpstatus(false);

					}
					entity.setEmail(email);
				}

				if(location.isEmpty() || location== null){
					entity.setLocation(entity.getLocation());
				}
				else{
					entity.setLocation(location);
				}

				if(mobile.isEmpty()){
					entity.setMobile(entity.getMobile());
				}
				else{

					if(!entity.getMobile().equals(mobile))
					{
						entity.setMobile(mobile);

						sendEmailnSms1 = true;
						entity.setOtpstatus(false);

					}
					entity.setMobile(mobile);

				}

				entity.setActive(true);

				entity.setCreatedby(entity.getUserId());
				userDaoImpl.update(entity);

				if(sendEmailnSms && sendEmailnSms1)
				{
					//String otpmsg="One time password  "+entity.getOtp()+". Please use this to complete the registration.";
					String msg=" Looks like you have changed your registered email id and mobile number.\n Pls login with the new emailid to confirm the changes you have made.";
					String encodedMsg = URLEncoder.encode(msg, "UTF-8");
					//String msgBody = "Welcome to our Lola app ! "+entity.getUserName()+"\n Email ID :"+entity.getEmail()+" \n Password :"+entity.getPassword();

					

											    	
							boolean message = smsUtility.sendSMS(entity.getMobile(),encodedMsg);

						


					

						

							
								EmailUtility.sendEmail("smtp.critsend.com",
										"587", 
										"noreply@myshareindia.com", 
										"JxRApreLseNR", 
										email, "Lola Login crendentials", msg);
							
						

					



				}


				else if(sendEmailnSms)
				{
					//String otpmsg="One time password  "+entity.getOtp()+". Please use this to complete the registration.";
					String msg="Looks like you have changed your registered email id.\n Pls login with new mailid to continue in Lola";
					String encodedMsg = URLEncoder.encode(msg, "UTF-8");
					//String msgBody = "Welcome to our Lola app ! "+entity.getUserName()+"\n Email ID :"+entity.getEmail()+" \n Password :"+entity.getPassword();
					boolean message = smsUtility.sendSMS(entity.getMobile(),encodedMsg);

					EmailUtility.sendEmail("smtp.critsend.com",
							"587", 
							"noreply@myshareindia.com", 
							"JxRApreLseNR", 
							email, "Lola Login crendentials", msg);
				}


				else if(sendEmailnSms1)
				{
					//String otpmsg="One time password  "+entity.getOtp()+". Please use this to complete the registration.";

					String msgBody1="Looks like you have changed your registered mobile no.\n An OTP will be sent to the new number.\n Pls Sign in once again to confirm the mobile number.";
					String encodedMsg = URLEncoder.encode(msgBody1, "UTF-8");
					//String msgBody = "Welcome to our Lola app ! "+entity.getUserName()+"\n Email ID :"+entity.getEmail()+" \n Password :"+entity.getPassword();
					boolean message = smsUtility.sendSMS(entity.getMobile(),encodedMsg);
					EmailUtility.sendEmail("smtp.critsend.com",
							"587", 
							"noreply@myshareindia.com", 
							"JxRApreLseNR", 
							email, "Lola Login crendentials", msgBody1);

				}




			}
		}



	}



	public String authUser(String email, String password) throws Exception
	{

		//String userInvalidMsg = "Invalid Email id or password, Please try again.";
		//String userInvalidMsg = "Sorry! We couldn&apos;t find a valid account for this email id. Please re-enter or click Sign-up!"; 
		String userInvalidMsg = "Sorry! We couldn't find a valid account for this email id. Please re-enter or click Sign-up!";
		String userInvalidMsg1=null;

		List<User> userObject = userDaoImpl.findByemailId(email);
		RoleDaoImpl roleDaoImpl = new RoleDaoImpl();
		if(userObject.size()>0){
			for(int i=0;i<userObject.size();i++)
			{
				User user = (User) userObject.get(i);
				if(email.equals(userObject.get(i).getEmail()) && password.equals(userObject.get(i).getPassword()))
				{
					obj = new JSONObject();
					obj.put("Status", "Success");
					obj.put("Userid",user.getUserId());
					obj.put("name",user.getUserName());
					obj.put("mobile",user.getMobile());
					obj.put("email", user.getEmail());
					obj.put("roleid", user.getRoleid());
					obj.put("OTPStatus", user.isOtpstatus());
					List<Object> role=roleDaoImpl.getRoleName( user.getRoleid());
					if(role.size()>0){
						for(Object o:role){
							obj.put("rolename", o.toString());
						}
					}

					obj.put("Message", "Successfully Logged in. Welcome to Lola!");




					return obj.toString();
				}
				else {
					obj = new JSONObject();
					obj.put("Status", "Failure");	
					if(!email.equals(userObject.get(i).getEmail()))
					obj.put("Message", userInvalidMsg);
                     if(!password.equals(userObject.get(i).getPassword()))
                     userInvalidMsg1="Forgotten the password for "+userObject.get(i).getEmail()+"? Enter a valid password or try forgot password";
                     obj.put("Message", userInvalidMsg1);
					return obj.toString();

				}

			}}

		obj = new JSONObject();
		obj.put("Status", "Failure");					
		obj.put("Message", userInvalidMsg);



		return obj.toString();
	}


	public String sendPasswordEmailAndSms(String email) throws Exception
	{
		String defaultPassword="";
		SMSUtility smsUtility = new SMSUtility();
		JSONObject obj =null;
		JSONArray jsonArray = new JSONArray();
		String userInvalidMsg = "Invalid userid :";
		List<User> userObject = userDaoImpl.findByemailId(email);
		if(userObject.size()>0){
			for(int i=0;i<userObject.size();i++)
			{
				User user = (User) userObject.get(i);
				if(email.equals(userObject.get(i).getEmail()))
				{
					defaultPassword=RandomStringUtils.randomAlphanumeric(6).toUpperCase();
					user.setPassword(defaultPassword);
					if(update(user).equalsIgnoreCase("Success")){
						EmailUtility.sendEmail("smtp.critsend.com",
								"587", 
								"noreply@myshareindia.com", 
								"JxRApreLseNR", 
								user.getEmail(), "Lola app Password", "Dear Member, you can login using Password: "+user.getPassword()+". Thank you.");


						//boolean message = userUtility.sendSMS(user.getMobile(),user.getPassword());
						String defaultpw="Dear "+user.getUserName()+" Your password has been reset to"+user.getPassword()+" please use this to login to your account ";
						//String defaultpw="Dear Member, you can login using Password:"+user.getPassword()+". Thank you.";
						String str1 = URLEncoder.encode(defaultpw, "UTF-8");
						smsUtility.sendSMS(user.getMobile(),str1);

					}
					obj = new JSONObject();
					obj.put("Status", "Success");	
					obj.put("Email",user.getEmail());
					obj.put("Mobile",user.getMobile());
					obj.put("Message", "Your One Time Password has been sent to your regsitered Email id and Mobile number.");
					

//Dear <Salutation>.[Space] <Full Name>,  Your password has been reset to ******, use this to log in to your account please.


					jsonArray.put(obj);

					return jsonArray.toString();

				}
				else {
					obj = new JSONObject();
					obj.put("Status", "Failure");					
					obj.put("Message", userInvalidMsg);



				}

			}}

		obj = new JSONObject();
		obj.put("Status", "Failure");					
		obj.put("Message", userInvalidMsg);

		jsonArray.put(obj);

		return jsonArray.toString();

	}


	public String resetPassword(String email, String newPassword) throws Exception
	{

		String userInvalidMsg = "Password Reset Failed";
		List<User> userObject = userDaoImpl.findByemailId(email);
		if(userObject.size()>0){
			for(int i=0;i<userObject.size();i++)
			{
				User user = (User) userObject.get(i);
				if(email.equals(userObject.get(i).getEmail()))
				{
					user.setPassword(newPassword);
					if(update(user).equalsIgnoreCase("Success")){

						EmailUtility.sendEmail("smtp.critsend.com",
								"587", 
								"noreply@myshareindia.com", 
								"JxRApreLseNR", 
								user.getEmail(), "Reset Password Success", "Dear Member,\nLola App\nYour password Reset Success!\nYou can login using password: "+user.getPassword()+".\n Thank you.");

						obj = new JSONObject();
						obj.put("Status", "Success");	
						//obj.put("Message", "Your password has been reset successfully! Please check your Email");
						obj.put("Message", "New password saved. Click Next to Proceed to your dashboard.");
						

						jsonArray.put(obj);

						return jsonArray.toString();


					}

				}
				else {
					obj = new JSONObject();
					obj.put("Status", "Failure");					
					obj.put("Message", userInvalidMsg);

				}

			}}

		obj = new JSONObject();
		obj.put("Status", "Failure");					
		obj.put("Message", userInvalidMsg);

		jsonArray.put(obj);

		return jsonArray.toString();




	}

	public List<User> findByemailId(String email) {

		List<User> users = userDaoImpl.findByemailId(email);	

		return users;
	}


	public List<User> findByuserid(int userId) {

		List<User> user = userDaoImpl.findByuserid(userId);

		return user;
	}


	public String update(User entity) {
		String status = null;
		try{
			userDaoImpl.update(entity);
			status = "Success";
		}catch(Exception e){
			status = "Failure";
			return status;
		}
		return status;
	}


	public String userExists(String email) throws Exception
	{

		obj.put("Status","Failure");
		obj.put("Message","This email id is already registered.");
		jsonArray.put(obj);
		return jsonArray.toString();
	}

	public String userExistsMobile(String mobile) throws Exception
	{

		obj.put("Status","Failure");
		obj.put("Message","This mobile number is already registered.");
		jsonArray.put(obj);
		return jsonArray.toString();
	}



	public String getUserByEmailId(String email ) throws Exception{
		List<Object> useremail=userDaoImpl.findByemailId(email);
		if(useremail.size()>0){
			obj = new JSONObject();
			for(int i=0;i<useremail.size();i++)
			{
				User user = (User) useremail.get(i);
				obj.put("Email", user.getEmail());
				obj.put("Mobile", user.getMobile());
				obj.put("Status", "Success");

			}
		}else{
			obj.put("Status", "Failure");
			obj.put("Messsage", "Invalid EmailId");
		}
		return obj.toString();
	}


	public String sendEmail(int userId,String username,String email,String password,String mobile,boolean otpStatus)throws Exception{

		JSONObject obj =null;


		try{

			List<User> userObject = userDaoImpl.findByuserid(userId);

			if(userObject.size()>0){
				for(User user : userObject)
				{
					user.setOtpstatus(otpStatus);
					userDaoImpl.update(user);
				}

			}
			if(email==null || email.equals(""))
			{
				obj = new JSONObject();
				obj.put("Status", "Failure");					
				obj.put("Message", "Email sent failed due to Email Id is : NULL or Empty");
				return obj.toString();
			}
			else
			{


				String msgBody = "Welcome to our Lola app ! "+username+"\n Email ID :"+email+" \n Password :"+password;

				String msgBody1 = "Hello  "+username+"\n\n\nWelcome to LOLA!!!!\n\n\nThank you for Joining LOLA, your personal brand engagement app.\n\n\n Now you'll be first to experience about the latest trends, receive personalized offers, preview new collections,get invited to exclusive events  from your favourite brands. So, Go ahead and get Pampered !!\n\n\nFor your reference,\n\n\nYour Lola Login ID :"+email+"\nYour Lola Mobile no:"+mobile+"\nYour Lola Password:"+password;

				EmailUtility.sendEmail("smtp.critsend.com",
						"587", 
						"noreply@myshareindia.com", 
						"JxRApreLseNR", 
						email, "Lola Login crendentials", msgBody1);

				obj = new JSONObject();
				obj.put("Status", "Success");	

				obj.put("Message", "Email sent");
			}

		}
		catch(Exception e)
		{
			obj = new JSONObject();
			obj.put("Status", "Failure");					
			obj.put("Message", "Email sent failed");

			return obj.toString();
		}


		return obj.toString();



	}
	/*List<User> userObject = userDaoImpl.findByemailId(email);
			if(userObject.size()>0){
				for(int i=0;i<userObject.size();i++)
				{
					User user = (User) userObject.get(i);
				if(username.equals(userObject.get(i).getUserName()) && email.equals(userObject.get(i).getEmail()) && password.equals(userObject.get(i).getPassword()))
					{

						String msgBody = "Welcome to our Lola app ! "+user.getUserName()+"\n Email ID :"+user.getEmail()+" \n Password :"+user.getPassword();

							EmailUtility.sendEmail("smtp.critsend.com",
									"587", 
									"noreply@myshareindia.com", 
									"JxRApreLseNR", 
									user.getEmail(), "Lola Login crendentials", msgBody);



						obj = new JSONObject();
						obj.put("Status", "Success");	

						obj.put("Message", "Email sent");
						jsonArray.put(obj);

						return jsonArray.toString();

					}

				}	
					}
					else {
						obj = new JSONObject();
						obj.put("Status", "Failure");					
						obj.put("Message", "Email sent failed");

						jsonArray.put(obj);
						return jsonArray.toString();
					}

	 */				


	public String resendOTP(int userId) throws Exception{
		JSONObject obj =null;
		String newOtp="";
		SMSUtility smsUtility = new SMSUtility();
		UserDao userDaoImpl = new UserDaoImpl();

		try{

			List<User> userObject = userDaoImpl.findByuserid(userId);

			if(userObject.size()>0){

				newOtp = OTPGenerator.random();

				for(User user : userObject)
				{
					user.setOtp(newOtp);
					userDaoImpl.update(user);
					//String newOtpMessage="Your resend OTP success\n new OTP is :"+newOtp;
					String newOtpMessage="One time password for your registration at Lola is "+newOtp+". Please use this to complete the registration.";
					String encodedNewOtpMessage = URLEncoder.encode(newOtpMessage, "UTF-8");
					smsUtility.sendSMS(user.getMobile(),encodedNewOtpMessage);

					//System.out.println("OTP re-sent to mobile "+user.getMobile()+" of user "+user.getUserName());

					//"Message","OTP Successfully Resent"
					obj = new JSONObject();
					obj.put("Status", "Success");	
					obj.put("username",user.getUserName());
					obj.put("mobile",user.getMobile());
					obj.put("email", user.getEmail());
					obj.put("roleid", user.getRoleid());
					obj.put("OTP", user.getOtp());
					obj.put("OTPStatus", user.isOtpstatus());
					obj.put("Message", "OTP Successfully Resent");

				}


				return obj.toString();
			}
			else
			{
				//System.out.println("User Does not exist");
				obj = new JSONObject();
				obj.put("Status", "Failure");
				obj.put("Message", "User Does not exist");
				return obj.toString();
			}
		}catch(Exception exception)
		{
			obj = new JSONObject();
			obj.put("Status", "Failure");
			obj.put("Message", "User Does not exist");
			return obj.toString();
		}

		//return newOtp;
	}




	public static void main(String argv[]) throws Exception{

		UserUtility userUtility = new UserUtility();
		//System.out.print(userUtility.saveCustomer("abcdefgh","arulj", "12345", "arulkumar.a@truetechsolutions.co.in", "VELECHERRY, chennai", "8754300266", "12.9758° N", "80.2205° E"));
		//userUtility.updateCustomer(243,"smruti", "yuiououoooi", "s@pp.com", "VELECHERRY, chennai", "8754300266");
		//userUtility.resetPassword("arulkumar.a@truetechsolutions.co.in", "abc123");

		System.out.println(userUtility.sendEmail(1,"snigdha", "smrutipani19@gmail.com", "F1FI5B","9778740229",true));

		/*String username=null;
		String mobile=null;
		String password=null;
		String email="";

		System.out.println(userUtility.sendEmail(username, email, password, mobile));*/

		//System.out.print(userUtility.resendOTP(83));
	}





}
