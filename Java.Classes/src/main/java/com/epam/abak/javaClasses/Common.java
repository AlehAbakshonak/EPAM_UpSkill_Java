package com.epam.abak.javaClasses;

public class Common {

   public static String stringArrayToString(String[] array) {
      String result = "";

      for (int i = 0; i < array.length; i++) {
         result += array[i]+"\n";
      }

      return result;
   }
}
