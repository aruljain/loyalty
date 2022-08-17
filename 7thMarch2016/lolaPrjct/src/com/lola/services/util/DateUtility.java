package com.lola.services.util;

import java.text.*;
import java.util.*;

public class DateUtility {

    static DateFormat df = new SimpleDateFormat("dd MMM yyyy");
    static int[][] fields = {
        { 2007, 3, 15 }, { 2007, 4, 2 }, { 2007, 11, 12 }
    };
 
    public static void main(String[] args) {
        for(int i = 0; i < fields.length; i++) {
            Calendar calendar = Calendar.getInstance();
            int[] n = fields[i];
            calendar.set(n[0], n[1], n[2]);
            System.out.printf("%s = %s%n",
                               Arrays.toString(fields[i]),
                               df.format(calendar.getTime()));
            System.out.printf("expiryDate = %s%n",
                               getExpiaryDate(calendar.getTime()));
        }
    }
  
    private static String getExpiaryDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        if(day != 1) {
            calendar.add(Calendar.MONTH, 1);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
        }
        return df.format(calendar.getTime());
               //calendar.toString();
    }
    
    
    
    public static String formatDate(String inputDate)
    {
     Date outputDate=null;
      SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss"); 
        try {
       outputDate = ft.parse(inputDate);
      // System.out.println(outputDate);
     } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
     } 
        
        return outputDate.toString();
    }
}

