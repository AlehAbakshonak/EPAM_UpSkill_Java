package com.epam.abak.projects;

import java.util.Random;
import java.util.Scanner;

public class MainTask3 {

   static void randoms() {
      Scanner scanner = new Scanner(System.in);
      int continueFlag;
      int consoleAmount;
      int consoleRowOrLine;
      do {
         consoleAmount = Common.consoleVarInput(
               1,
               127,
               "> I will return so much randoms, as you wish (1-127): ",
               "> Woow, that's not a value, pick on from 1 to 127, buddy: ",
               ""
         );

         consoleRowOrLine = Common.consoleVarInput(
               0,
               1,
               "> Btw, scanner row(0) or scanner line(1)?: ",
               "> Come on, if scanner row - type 0, if scanner line - 1: ",
               "> Gotcha, made it 4u❤: "
         );

         consoleWriteAmountOfRandoms(consoleAmount, consoleRowOrLine);

         continueFlag = Common.yesOrNoChecker(
               scanner,
               "\n> Wanna make some more randoms or we going back to Menu? y/n: "
         );
      } while (continueFlag != 0);
   }

   static void consoleWriteAmountOfRandoms(int amount, int rowOrLine) {
      byte random;
      Random randomizer = new Random();
      for (int i = 0; i < amount; i++) {
         random = (byte) randomizer.nextInt(127);
         if (rowOrLine == 0) {
            Common.consoleDelayedWriter(random + " ");
         } else {
            Common.consoleDelayedWriter("\n" + random);
         }
      }
   }
}
