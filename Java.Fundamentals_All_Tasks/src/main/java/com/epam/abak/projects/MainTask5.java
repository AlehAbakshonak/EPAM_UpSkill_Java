package com.epam.abak.projects;

import java.util.Scanner;

public class MainTask5 {

   //Should be monthName
   static void month_name() {
      Scanner scanner = new Scanner(System.in);
      int continueFlag = 0;
      int consoleNumberOfMonth;
      String[] monthList = new String[]{"January", "February",
            "March", "April", "May",
            "June", "July", "August",
            "September", "October", "November",
            "December"};
      do {
         Common.consoleDelayedWriter(">Enter month number (1-12): ");
         consoleNumberOfMonth = Common.bytecheck(scanner, 1, 12,
               ">Woow, there is no such month, choose one from 1 to 12, buddy: ");
         Common.consoleDelayedWriter(">Gotcha, it's " + monthList[consoleNumberOfMonth - 1] + "!");
         continueFlag = Common.YesOrNoChecker(scanner,
               "\n>Wanna check another month number or we going back to Menu? y/n: ");
      } while (continueFlag != 0);
   }

   /**
    * private static String getMonthName(int number){
    *     String monthName;
    *     switch (month) {
    *             case 1:  monthName = "January";
    *                      break;
    *             case 2:  monthName = "February";
    *                      break;
    *             case 3:  monthName = "March";
    *                      break;
    *             case 4:  monthName = "April";
    *                      break;
    *             case 5:  monthName = "May";
    *                      break;
    *             case 6:  monthName = "June";
    *                      break;
    *             case 7:  monthName = "July";
    *                      break;
    *             case 8:  monthName = "August";
    *                      break;
    *             case 9:  monthName = "September";
    *                      break;
    *             case 10: monthName = "October";
    *                      break;
    *             case 11: monthName = "November";
    *                      break;
    *             case 12: monthName = "December";
    *                      break;
    *             default: monthName = "Invalid month";
    *                      break;
    *         }
    *         return monthName;
    * }
    *
    */

}
