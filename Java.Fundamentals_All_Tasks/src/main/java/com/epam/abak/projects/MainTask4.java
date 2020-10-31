package com.epam.abak.projects;

import java.util.Scanner;

public class MainTask4 {

   static void multiply() {
      Scanner scanner = new Scanner(System.in);
      String consoleStr;
      byte continueFlag;
      byte amountLimiter = 0;
      byte[] arrayForMultiplying = new byte[10];
      byte[] emptyArray = new byte[10];
      while (true) {
         Common.consoleDelayedWriter("> Enter values(1-40) by one (10 max), then enter \"=\" and I will multiply all values: ");
         while (true) {
            if (amountLimiter < 10) {
               consoleStr = scanner.nextLine();
               if (consoleStr.equals("=")) {
                  Common.consoleDelayedWriter("> Ookey-dokey, now let's multiply it!\n");
                  Common.consoleDelayedWriter("> hmmmmmm.......\n", (byte) 127);
                  amountLimiter = 0;
                  break;
               } else {
                  arrayForMultiplying[amountLimiter] = Common.byteCheckString(consoleStr, (byte) 1, (byte) 40,
                        "> Woow, that's not a value, choose one from 1 to 40, buddy: ");
                  amountLimiter++;
               }
            } else {
               Common.consoleDelayedWriter("> 10 values is enough for this time ;) Now let's multiply it!\n");
               Common.consoleDelayedWriter("> hmmmmmm.......\n", (byte) 127);
               amountLimiter = 0;
               break;
            }
         }
         Common.consoleDelayedWriter("> Gotcha, made it 4u❤: " + arrayMultiplier(arrayForMultiplying));
         continueFlag = Common.yesOrNoChecker(scanner,
               "\n> Wanna make some more multiplying or we going back to Menu? y/n: ");
         if (continueFlag == 0) {
            break;
         }
         else {
            arrayForMultiplying = emptyArray;
         }
      }
   }

   static long arrayMultiplier(byte[] targetArray) {
      long result = 1;
      for (int i = 0; i < targetArray.length; i++) {
         if (targetArray[i] > 0) {
            result *= targetArray[i];
         }
      }
      return result;
   }
}
