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
         Common.consoleDelayedWriter(">I will return so much randoms, as you wish (1-127): ");
         consoleAmount = Common.bytecheck(scanner, 1, 127,
               ">Woow, that's not a value, pick on from 1 to 127, buddy: ");
         Common.consoleDelayedWriter(">Btw, scanner row(0) or scanner line(1)?: ");
         consoleRowOrLine = Common.bytecheck(scanner, 0, 1,
               ">Come on, if scanner row - type 0, if scanner line - 1: ");
         Common.consoleDelayedWriter(">Gotcha, made it 4u❤: ");
         consoleWriteAmountOfRandoms(consoleAmount, consoleRowOrLine);
         continueFlag = Common.YesOrNoChecker(scanner,
               "\n>Wanna make some more randoms or we going back to Menu? y/n: ");
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
