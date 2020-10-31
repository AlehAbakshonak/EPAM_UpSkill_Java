package com.epam.abak.projects;

import java.util.Scanner;

public class MainTask1 {

   static void hello() {
      Scanner scanner = new Scanner(System.in);
      byte continueFlag;
      do {
         Common.consoleDelayedWriter("> Enter user name: ");
         Common.consoleDelayedWriter("> Hello, " + scanner.nextLine() + "!");
         continueFlag = Common.yesOrNoChecker(scanner,
               "\n> Wanna say hello to someone else or we going back to Menu? y/n: ");
      } while (continueFlag != 0);
   }
}
