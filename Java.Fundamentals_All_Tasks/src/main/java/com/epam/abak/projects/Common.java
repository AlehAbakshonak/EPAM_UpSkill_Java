package com.epam.abak.projects;

import java.util.Scanner;

public class Common {

   //TODO Remove unnecessary comments
   static void consoleDelayedWriter(String s) {
      while (!s.equals("")) {
         System.out.print(s.charAt(0));
         s = s.substring(1);
         /*try {
            TimeUnit.MILLISECONDS.sleep(50);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }*/
      }
   }

   static void consoleDelayedWriter(String s, byte x) {
      while (!s.equals("")) {
         System.out.print(s.charAt(0));
         s = s.substring(1);
         /*try {
            TimeUnit.MILLISECONDS.sleep(x);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }*/
      }
   }

   //Please use java naming convention. Methods should start from lower case yesOrNoChecker
   static byte YesOrNoChecker(Scanner scanner, String questionMessage) {
      consoleDelayedWriter(questionMessage);
      String consoleAnswer;
      //why do you need byte format? Isn't int better?
      byte answerFlag = -1;
      do {
         consoleAnswer = scanner.nextLine();
         switch (consoleAnswer) {
            case "y":
               answerFlag = 1;
               break;
            case "n":
               answerFlag = 0;
               break;
            default:
               consoleDelayedWriter("\n>Meh, try again, just y or n: ");
               break;
         }
         consoleDelayedWriter(">Ookay bud!\n");
      } while (answerFlag == -1);
      return answerFlag;
   }

   //Please use java naming convention. Methods should be camel case byteCheck
   static int bytecheck(Scanner scanner, int minBorder, int maxBorder, String errorMessage) {
      int targetInt = -1;
      String targetStrFromConsole;
      while (true) {
         targetStrFromConsole = scanner.nextLine();
         try {
            targetInt = Integer.parseInt(targetStrFromConsole);
            if ((targetInt != -1) && (targetInt >= minBorder) && (targetInt <= maxBorder)) break;
            else {
               consoleDelayedWriter(errorMessage);
            }
         } catch (NumberFormatException ex) {
            consoleDelayedWriter(errorMessage);
         }
      }
      return targetInt;
   }
   //Please use java naming convention. Methods should be camel case byteCheckStr. Even byteCheckString would be better
   static byte bytecheckstr(String targetStr, byte minBorder, byte maxBorder, String errorMessage) {
      byte ConsoleInput = -1;
      Scanner scanner = new Scanner(System.in);
      while (true) {
         try {
            ConsoleInput = (byte) Integer.parseInt(targetStr);
            if ((ConsoleInput != -1) && (ConsoleInput >= minBorder) && (ConsoleInput <= maxBorder)) break;
            else {
               consoleDelayedWriter(errorMessage);
            }
         } catch (NumberFormatException ex) {
            consoleDelayedWriter(errorMessage);
         }
         targetStr = scanner.nextLine();
      }
      return ConsoleInput;
   }
}
