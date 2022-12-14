package com.lola.services.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class OTPGenerator {
	
	 public static String random() {
		    final int size = 6;
		         StringBuilder generatedToken = new StringBuilder();
		         try {
		             SecureRandom number = SecureRandom.getInstance("SHA1PRNG");
		             // Generate 20 integers 0..20
		             for (int i = 0; i < size; i++) {
		                 generatedToken.append(number.nextInt(9));
		             }
		         } catch (NoSuchAlgorithmException e) {
		             e.printStackTrace();
		         }

		         return generatedToken.toString();
		     }

}
