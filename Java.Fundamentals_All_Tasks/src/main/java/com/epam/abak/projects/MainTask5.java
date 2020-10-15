package com.epam.abak.projects;

import java.util.Scanner;

public class MainTask5 {

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
}
