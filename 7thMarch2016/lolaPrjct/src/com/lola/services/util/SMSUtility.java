package com.lola.services.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.json.JSONObject;






import com.lola.dao.UserDaoImpl;
import com.lola.model.User;
import com.lola.service.UserServiceImpl;





public class SMSUtility {
	
	
	
	
	
	public boolean sendSMS(String mobile, String otp)
	 {
	   try {
	    
	    String serviceUrl = "http://trans3.mobidrive.in/sendsms.jsp?user=myshare&password=mobi1234&senderid=myshar&unicode=1&version=3&mobiles="+mobile+"&sms="+otp;

	    URL url = new URL(serviceUrl);
	    
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    conn.setRequestMethod("GET");
	    conn.setRequestProperty("Accept", "application/json");

	    if (conn.getResponseCode() != 200) {
	     throw new RuntimeException("Failed : HTTP error code : "
	       + conn.getResponseCode());
	    }

	    BufferedReader br = new BufferedReader(new InputStreamReader(
	     (conn.getInputStream())));

	    String output;
	    System.out.println("Output from Server");
	    while ((output = br.readLine()) != null) {
	     System.out.println(output);
	    }

	    conn.disconnect();

	     } catch (MalformedURLException e) {

	      return false;

	     } catch (IOException e) {

	    return false;

	     }
	   
	   return true;

	 }
	
	

	 public static void main(String args[])
	 {
	  SMSUtility smsUtility = new SMSUtility();
	  System.out.println(smsUtility.sendSMS("8144999100","1234"));
	 }
	


		
}
