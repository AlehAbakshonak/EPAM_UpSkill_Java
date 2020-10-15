package com.epam.abak.projects;

import java.util.Scanner;

public class MainTask2 {

   static void negative() {
      Scanner scanner = new Scanner(System.in);
      byte continueFlag;
      do {
         Common.consoleDelayedWriter(">I will invert everything you say, bud: ");
         Common.consoleDelayedWriter(">Made it 4u❤: " + invertString(scanner.nextLine()));
         continueFlag = Common.YesOrNoChecker(scanner,
               "\n>Wanna invert something else or we going back to Menu? y/n: ");
      } while (continueFlag != 0);
   }

   static String invertString(String target) {
      char[] charArrayTarget = target.toCharArray();
      char[] InvertedCharArray = new char[charArrayTarget.length];
      for (int i = 0; i < charArrayTarget.length; i++) {
         InvertedCharArray[i] = charArrayTarget[charArrayTarget.length - i - 1];
      }
      return (new String(InvertedCharArray));
   }
}
