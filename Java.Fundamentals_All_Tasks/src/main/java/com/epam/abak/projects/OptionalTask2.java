package com.epam.abak.projects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class OptionalTask2 {

   private static final Scanner SCANNER = new Scanner(System.in);

   static void matrixAnalyser(int[][] inputMatrix) {

      boolean goalOneRowOrCol = Common.intToBoolean(Common.consoleVarInput(
            0,
            1,
            "> In goal 1 we sort matrix by rows(0) or columns(1)?: ",
            "> Just pick on from 0 to 1, buddy: ",
            "> Ok, got it!\n"
      ));
      int goalOneIndexForSort = Common.consoleVarInput(
            1,
            inputMatrix.length,
            "> Enter specific number of row/column for sorting of matrix by it (1-" + inputMatrix.length + "): ",
            "> Just pick on from 1 to " + inputMatrix.length + ", buddy: ",
            "> Ok, got it!\n"
      );
      goalOneIndexForSort--;

      boolean goalTwoIncOrDecSequence = Common.intToBoolean(Common.consoleVarInput(
            0,
            1,
            "> In goal 2 we search increasing(0) or decreasing(1) sequence?: ",
            "> Just pick on from 0 to 1, buddy: ",
            "> Ok, got it!\n"
      ));

      int[][] goalOneSortedMatrix;
      int[] goalTwoSequence;
      int[] goalThreeArrayOfSums;
      int[][] goalFourMatrixExcludeMax;

      if (goalOneRowOrCol) {
         goalOneSortedMatrix = matrixSort(inputMatrix, goalOneIndexForSort);
      } else {
         goalOneSortedMatrix =
               Common.transposeMatrix(
                     matrixSort(
                           Common.transposeMatrix(inputMatrix), goalOneIndexForSort
                     )
               );
      }

      goalTwoSequence = sequenceAnalyser(goalTwoIncOrDecSequence, inputMatrix);

      goalThreeArrayOfSums = matrixRowSums(inputMatrix);

      goalFourMatrixExcludeMax = matrixExcludeRowAndColWithValue(inputMatrix, twoDimmArrayMaxWithCoords(inputMatrix));

      outputGoalResults(inputMatrix, goalOneSortedMatrix, goalTwoSequence, goalThreeArrayOfSums, goalFourMatrixExcludeMax);

   }

   private static void outputGoalResults(
         int[][] inputMatrix,
         int[][] goalOneSortedMatrix,
         int[] goalTwoSequence,
         int[] goalThreeArrayOfSums,
         int[][] goalFourMatrixExcludeMax) {
      Common.consoleDelayedWriter("> 1. Generated matrix: \n" + Common.twoDimmArrToString(inputMatrix)
      );

      Common.consoleDelayedWriter("> 1. Sorted matrix: \n" + Common.twoDimmArrToString(goalOneSortedMatrix)
      );

      Common.consoleDelayedWriter("> 2. Longest sequence in matrix:\n     " + Common.oneDimmArrToString(goalTwoSequence) + "\n"
      );

      Common.consoleDelayedWriter("> 3. Sums in between of two first positive values of each row:\n     " +
                  Common.oneDimmArrToString(goalThreeArrayOfSums) + "\n"
      );

      Common.consoleDelayedWriter("> 4. Matrix without rows and columns with maximal value: \n" +
                  Common.twoDimmArrToString(goalFourMatrixExcludeMax)
      );

   }

   private static int[][] matrixExcludeRowAndColWithValue(int[][] inputMatrix, int[] arrayMax) {

      int[][] resultMatrix = new int[inputMatrix.length - 1][inputMatrix[0].length - 1];
      int input1 = 0;
      int result1 = 0;
      while (result1 < inputMatrix.length-1) {
         int input2 = 0;
         int result2 = 0;
         if (input1 == arrayMax[1]) {
            input1++;
         }
         while (result2 < inputMatrix[input1].length-1) {
            if (input2 == arrayMax[2]) {
               input2++;
            }
            resultMatrix[result1][result2] = inputMatrix[input1][input2];
            result2++;
            input2++;
         }
         result1++;
         input1++;
      }
      return resultMatrix;
   }

   static int[] twoDimmArrayMaxWithCoords(int[][] array) {
      int[] max = new int[]{Integer.MIN_VALUE, 0, 0};
      for (int i = 0; i < array.length; i++) {
         for (int j = 0; j < array[0].length; j++) {
            if (array[i][j] > max[0]) {
               max[0] = array[i][j];
               max[1] = i;
               max[2] = j;
            }
         }
      }
      return max;
   }

   private static int[] matrixRowSums(int[][] inputMatrix) {
      int[] sumsArray = new int[inputMatrix[0].length];
      int i = 0;
      while (i < inputMatrix.length) {
         int j = 0;
         while (j < inputMatrix[i].length) {
            if (inputMatrix[i][j] > 0) {
               while (true) {
                  j++;
                  if (j >= inputMatrix[i].length) {
                     j = inputMatrix[i].length;
                     sumsArray[i] = 0;
                     break;
                  }
                  if (inputMatrix[i][j] > 0) {
                     j = inputMatrix[i].length;
                     break;
                  }
                  sumsArray[i] += inputMatrix[i][j];
               }
            }
            j++;
         }
         i++;
      }
      return sumsArray;
   }

   static int[][] matrixSort(int[][] twoDimmArray, int keyColumnForSorting) {
      
      int[][] arrayForSorting = Arrays.copyOf(twoDimmArray,twoDimmArray.length);

      for (int searchStart = 0; searchStart < arrayForSorting.length; searchStart++) {
         int elementBackup = arrayForSorting[searchStart][keyColumnForSorting];
         int[] rowBackup = arrayForSorting[searchStart];
         int searchEnd = searchStart - 1;
         for (; searchEnd >= 0; searchEnd--) {
            if (elementBackup < arrayForSorting[searchEnd][keyColumnForSorting]) {
               arrayForSorting[searchEnd + 1] = arrayForSorting[searchEnd];
            } else break;
         }
         arrayForSorting[searchEnd + 1] = rowBackup;
      }
      return arrayForSorting;
   }

   /* FIXME i tried this with lists instead of arrays, but failed Q_Q */
   /*static int[] sequenceAnalyser(boolean incOrDec, int[][] inputMatrix) {

      ArrayList<Integer> goalTwoListSequence = new ArrayList<>();
      ArrayList<Integer> tempList = new ArrayList<>();

      goalTwoListSequence.add(inputMatrix[0][0]);
      int lastInSequence = inputMatrix[0][0];

      for (int i = 0; i < inputMatrix.length; i++) {
         for (int j = 0; j < inputMatrix[i].length; j++) {

            if (i == 0 && j == 0) continue;

            if ((lastInSequence < inputMatrix[i][j]) != incOrDec) {
               if (tempList.size() < goalTwoListSequence.size()) {
                  tempList = goalTwoListSequence;
               }
               goalTwoListSequence.clear();
            }
            goalTwoListSequence.add(inputMatrix[i][j]);
         }
      }

      return listToIntArray(tempList);
   }

   static int[] listToIntArray(ArrayList<Integer> list) {
      int[] array = new int[list.size()];
      for (int i = 0; i < array.length; i++)
         array[i] = list.get(i);
      return array;
   }*/

   static int[] sequenceAnalyser(boolean incOrDec, int[][] inputMatrix) {

      int[] goalTwoListSequence = new int[inputMatrix.length * inputMatrix[0].length];
      int indexOfSequence = 0;
      int maxIndexOfSequence = Integer.MIN_VALUE;
      int[] tempList = new int[0];

      goalTwoListSequence[0] = inputMatrix[0][0];

      for (int i = 0; i < inputMatrix.length; i++) {
         for (int j = 0; j < inputMatrix[i].length; j++) {

            if (i == 0 && j == 0) continue;

            if ((goalTwoListSequence[indexOfSequence] < inputMatrix[i][j]) != incOrDec) {
               indexOfSequence++;
            } else {
               if (maxIndexOfSequence < indexOfSequence) {
                  maxIndexOfSequence = indexOfSequence;
                  tempList = Arrays.copyOf(goalTwoListSequence,goalTwoListSequence.length);
               }
               indexOfSequence = 0;
            }
            goalTwoListSequence[indexOfSequence] = inputMatrix[i][j];
         }
      }

      return tempList;
   }

   static void randomsFillMatrix(int[][] inputMatrix) {

      Random randomizer = new Random();

      for (int i = 0; i < inputMatrix.length; i++) {
         for (int j = 0; j < inputMatrix[i].length; j++) {
            int random = randomizer.nextInt(600) - 300;
            inputMatrix[i][j] = random;
         }
      }
   }

   static void start() {

      int continueFlag;

      do {
         int matrixSize = Common.consoleVarInput(
               1,
               127,
               "> Enter size(n) of matrix(n,n) (1-127): ",
               "> Woow, that's not a value, pick on from 1 to 127, buddy: ",
               "> Nice, i'm starting to fill it with random values.. \n" +
                     "> Our goals is:\n" +
                     "> 1. Sort rows/columns by the values of specific row/column;\n" +
                     "> 2. Find longest sequence of increasing/decreasing values,\n" +
                     "     reading matrix top to bottom, left to right. Output them;\n" +
                     "> 3. Output sum of values in between of first and second positive values in each row;\n" +
                     "> 4. Find max value in matrix and delete all rows and columns, which contains it;\n"
         );

         int[][] matrix = new int[matrixSize][matrixSize];
         randomsFillMatrix(matrix);

         matrixAnalyser(matrix);

         continueFlag = Common.yesOrNoChecker(
               SCANNER,
               "\n> Wanna make some more matrix analysis? y/n: "
         );

      } while (continueFlag != 0);
   }
}
