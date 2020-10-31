package com.epam.abak.projects;

import java.util.Scanner;

public class Common {

   static int consoleVarInput(int minBorber, int maxBorder, String requestText, String errorText, String proceedText) {

      Scanner scanner = new Scanner(System.in);

      Common.consoleDelayedWriter(requestText);
      int consoleInput = Common.byteCheckScanner(scanner, minBorber, maxBorder, errorText);
      if (!proceedText.equals("")) {
         Common.consoleDelayedWriter(proceedText);
      }

      return consoleInput;
   }

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

   static byte yesOrNoChecker(Scanner scanner, String questionMessage) {
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

   static int byteCheckScanner(Scanner scanner, int minBorder, int maxBorder, String errorMessage) {
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

   static byte byteCheckString(String targetStr, byte minBorder, byte maxBorder, String errorMessage) {
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

   static String oneDimmArrToString(int[] inputMatrix) {
      String resultString = String.valueOf(inputMatrix[0]);
      for (int i = 1; i < inputMatrix.length; i++) {
         resultString += ", " + inputMatrix[i];
      }
      return resultString;
   }

   static String twoDimmArrToString(int[][] inputMatrix) {
      String resultString = "";

      for (int i = 0; i < inputMatrix.length; i++) {
         resultString += "   ";
         for (int j = 0; j < inputMatrix[i].length - 1; j++) {
            int ijLength = String.valueOf(inputMatrix[i][j]).length();
            if (ijLength < 4) {
               for (int k = 0; k < 4-ijLength; k++) {
                  resultString += " ";
               }
            }
            resultString += inputMatrix[i][j] + " | ";
         }
         resultString += inputMatrix[i][inputMatrix[0].length-1] + "\n";
      }
      return resultString;
   }

   static boolean intToBoolean(int input) {
      if ((input == 0) || (input == 1)) {
         return input != 0;
      } else {
         throw new IllegalArgumentException("> intToBoolean: Just pick on from 0 to 1, buddy");
      }
   }

   static int[][] transposeMatrix(int[][] inputMatrix) {

      int[][] transposedMatrix = new int[inputMatrix.length][inputMatrix[0].length];

      for (int i = 0; i < inputMatrix.length; i++) {
         for (int j = 0; j < inputMatrix[i].length; j++) {
            transposedMatrix[i][j] = inputMatrix[j][i];
         }
      }
      return transposedMatrix;
   }
}
