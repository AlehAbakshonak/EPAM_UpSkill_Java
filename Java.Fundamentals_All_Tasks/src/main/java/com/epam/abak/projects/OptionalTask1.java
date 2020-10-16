package com.epam.abak.projects;

import java.util.Scanner;

public class OptionalTask1 {

   private final static int NUM_OF_TECH_COLS = 5;
   private final static int VAL_LENGTH = 0;
   private final static int VAL_GROWS = 1;
   private final static int VAL_UNIQ = 2;
   private final static int VAL_EVEN = 3;
   private final static int VAL_NOT_EVEN = 4;
   private final static int VAL_SELF = 5;

   private static float summaryLengthOfValues = 0;
   private static int minLengthOfValues = 100;
   private static int minLengthValue = 0;
   private static int maxLengthOfValues = 0;
   private static int maxLengthValue = 0;

   private static byte isValueDigitsGrows = 0;
   private static byte numOfNotUniqueDigits = 0;
   private static byte numOfEven = 0;
   private static byte numOfNotEven = 0;
   
   private static Scanner SCANNER = new Scanner(System.in);

   private static final int countAllValuesWidth = NUM_OF_TECH_COLS + 10;

   static int[][] ArraySort(int[][] twoDimmArray, byte keyColumnForSorting) {
      for (int searchStart = 0; searchStart < twoDimmArray.length; searchStart++) {
         int elementBackup = twoDimmArray[searchStart][keyColumnForSorting];
         int[] rowBackup = twoDimmArray[searchStart];
         int searchEnd = searchStart - 1;
         for (; searchEnd >= 0; searchEnd--) {
            if (elementBackup < twoDimmArray[searchEnd][keyColumnForSorting]) {
               twoDimmArray[searchEnd + 1] = twoDimmArray[searchEnd];
            } else break;
         }
         twoDimmArray[searchEnd + 1] = rowBackup;
      }
      return twoDimmArray;
   }

   static int[] valueAnalyser() {
      int[] doOneValue = new int[countAllValuesWidth]; //делаем заготовку для массива цифр

      doOneValue[VAL_SELF] = Common.byteCheckScanner(SCANNER, 1, 2147483646,
            ">Woow, that's not a value, pick one from 1 to 2147483646, buddy: ");
      char[] consoleValueCharArr = String.valueOf(doOneValue[VAL_SELF]).toCharArray(); //разбиваем полученное число на массив чаров
      doOneValue[VAL_LENGTH] = (byte) consoleValueCharArr.length; //закидываем длину в заготовку для массива цифр

      summaryLengthOfValues += doOneValue[VAL_LENGTH]; //считаем среднюю длину
      if (minLengthOfValues > doOneValue[VAL_LENGTH]) { //ищем минимальную длину
         minLengthOfValues = doOneValue[VAL_LENGTH];
         minLengthValue = doOneValue[VAL_SELF];
      }
      if (maxLengthOfValues < doOneValue[VAL_LENGTH]) { //ищем максимальную длину
         maxLengthOfValues = doOneValue[VAL_LENGTH];
         maxLengthValue = doOneValue[VAL_SELF];
      }

      for (char charChecked : consoleValueCharArr) {
         byte numberChecked = (byte) Integer.parseInt(String.valueOf(charChecked));
         if ((isValueDigitsGrows != -1) && (isValueDigitsGrows < numberChecked)) {
            isValueDigitsGrows = numberChecked;
         } else isValueDigitsGrows = -1;

         if (numberChecked % 2 == 0) {
            numOfEven++;
         } else numOfNotEven++;

         doOneValue[numberChecked + NUM_OF_TECH_COLS - 1]++;
         if (doOneValue[numberChecked + NUM_OF_TECH_COLS - 1] == 1) numOfNotUniqueDigits += 1;
      }

      doOneValue[VAL_GROWS] = isValueDigitsGrows;
      doOneValue[VAL_UNIQ] = numOfNotUniqueDigits;
      doOneValue[VAL_EVEN] = numOfEven;
      doOneValue[VAL_NOT_EVEN] = numOfNotEven;

      return doOneValue;
   }

   static void start() {

      int continueFlag = 0;
      do {
         Common.consoleDelayedWriter(">How many values should i take? (1-127): ");
         int consoleNumOfValues = Common.byteCheckScanner(SCANNER, 1,
               127, ">Woow, that's not a value, pick on from 1 to 127, buddy: ");
         Common.consoleDelayedWriter(">Okay, start to enter them by one (1-2147483646): ");

         int[][] countAllValues = new int[consoleNumOfValues][countAllValuesWidth];
         int[][] countAllValuesSorted;

         for ( int i = 0; i < consoleNumOfValues; i++) {

            countAllValues[i] = valueAnalyser();

            if (i < consoleNumOfValues - 1) {
               Common.consoleDelayedWriter(">An' anoder one: ");
            } else {
               Common.consoleDelayedWriter(">That's enough, " + consoleNumOfValues + " values are already here!\n");
            }

         }

         countAllValuesSorted = countAllValues;

         countAllValuesSorted = ArraySort(countAllValuesSorted, (byte) VAL_LENGTH);

         String msgForTask2pt1 = "";
         String msgForTask2pt2 = "";
         String msgForTask3 = "";
         int averageLengthOfValues = (int) (summaryLengthOfValues / consoleNumOfValues);
         int minOfUniqDigits = 100;
         int MinUniqueDigitsVal = 0;
         int ValueEvenDigitsCounter = 0;
         int isEvenEqualsNotEven = 0;
         int isValDigitsGrows = 0;
         int isValDigitsFullUniq = 0;

         for (int i = 0; i < consoleNumOfValues; i++) {

            if (i < consoleNumOfValues - 1) {
               msgForTask2pt1 +=
                     countAllValues[i][VAL_SELF] +
                           " (" + countAllValuesSorted[i][VAL_LENGTH] + "), ";
            }

            if ((countAllValues[i][VAL_LENGTH] > averageLengthOfValues) &&
                  (i < consoleNumOfValues - 1)) {
               msgForTask3 +=
                     countAllValues[i][VAL_SELF] +
                           " (" + countAllValues[i][VAL_LENGTH] + "), ";
            }

            if ((countAllValues[i][VAL_GROWS] != -1) &&
                  (isValDigitsGrows == 0) &&
                  (countAllValues[i][VAL_LENGTH] > 1)) {
               isValDigitsGrows = countAllValues[i][VAL_SELF];
            }

            if ((countAllValues[i][VAL_UNIQ] == countAllValues[i][0]) &&
                  (countAllValues[i][VAL_LENGTH] > 1)) {
               isValDigitsFullUniq = countAllValues[i][VAL_SELF];
            }

            if (countAllValues[i][VAL_EVEN] == countAllValues[i][VAL_LENGTH]) { //5.1 четные = длина
               ValueEvenDigitsCounter++;
            }
            if (countAllValues[i][VAL_EVEN] == countAllValues[i][VAL_NOT_EVEN]) { //5.2 четные = нечетные
               isEvenEqualsNotEven++;
            }
         }
         msgForTask2pt1 +=
               countAllValues[consoleNumOfValues - 1][VAL_SELF] +
                     " (" + countAllValuesSorted[consoleNumOfValues - 1][VAL_LENGTH] + ")"; //2

         msgForTask3 +=
               countAllValues[consoleNumOfValues - 1][VAL_SELF] +
                     " (" + countAllValues[consoleNumOfValues - 1][VAL_LENGTH] + ")"; //3

         for (int i = consoleNumOfValues - 1; i >= 0; i--) {

            if (i > 0) {
               msgForTask2pt2 +=
                     countAllValues[i][VAL_SELF] +
                           " (" + countAllValuesSorted[i][VAL_LENGTH] + "), ";
            }

            if ((countAllValues[i][VAL_UNIQ] < minOfUniqDigits) &&
                  (countAllValues[i][VAL_LENGTH] > 1)) { //4
               minOfUniqDigits = countAllValues[i][VAL_UNIQ];
               MinUniqueDigitsVal = countAllValues[i][VAL_SELF];
            }
         }
         msgForTask2pt2 += countAllValues[0][VAL_SELF] + " (" + countAllValuesSorted[0][VAL_LENGTH] + ")"; //2

         Common.consoleDelayedWriter(">1. Shortest: " + minLengthValue +
               " (" + minLengthOfValues + "); Longest: " + maxLengthValue + " (" + maxLengthOfValues + ");\n");
         Common.consoleDelayedWriter(">2.1 Growing lengths order: " + msgForTask2pt1 + ");\n");
         Common.consoleDelayedWriter(">2.1 Decreasing lengths order: " + msgForTask2pt2 + ");\n");
         Common.consoleDelayedWriter(">3. Average length: " + averageLengthOfValues +
               "; List of values, longer than average: " + msgForTask3 + ";\n");
         Common.consoleDelayedWriter(">4. Minimal amount of unique numbers: " +
               MinUniqueDigitsVal + " (" + minOfUniqDigits + ");\n");
         Common.consoleDelayedWriter(">5.1. Amount of values with full-even numbers: " + ValueEvenDigitsCounter + ";\n");
         Common.consoleDelayedWriter(">5.2. Amount of values scanner which even and uneven numbers are equal: " +
               isEvenEqualsNotEven + ";\n");
         if (isValDigitsGrows != 0) Common.consoleDelayedWriter(">6. First value with instantly growing numbers: " +
               isValDigitsGrows + ";\n");
         else Common.consoleDelayedWriter(">6. First value with instantly growing numbers: absent;\n");
         if (isValDigitsFullUniq != 0) Common.consoleDelayedWriter(">7. Value with full-unique numbers: " +
               isValDigitsFullUniq + ";\n");
         else Common.consoleDelayedWriter(">7. Value with full-unique numbers: absent;\n");
         continueFlag = Common.yesOrNoChecker(SCANNER, "\n>Wanna make some more randoms or we going back to Menu? y/n: ");
      } while (continueFlag != 0);
   }
}
