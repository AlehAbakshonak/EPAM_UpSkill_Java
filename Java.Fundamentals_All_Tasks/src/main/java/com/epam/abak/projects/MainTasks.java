package com.epam.abak.projects;

import java.util.Scanner;

public class MainTasks {

   public static void main(String[] args) {
      int ch;
      boolean exit = false;
      do {
         ch = taskPanel();

         switch (ch) {
            case 1:
               MainTask1.hello();
               break;
            case 2:
               MainTask2.negative();
               break;
            case 3:
               MainTask3.randoms();
               break;
            case 4:
               MainTask4.multiply();
               break;
            case 5:
               MainTask5.monthName();
               break;
            case 6:
               OptionalTask1.start();
               break;
            case 7:
               OptionalTask2.start();
               break;
            case 8:
               exit = true;
               break;
         }
      } while (!exit);
      Common.consoleDelayedWriter("> Ok bye! :*\n");
   }

   static int taskPanel() {
      int x;
      Scanner scanner = new Scanner(System.in);
      Common.consoleDelayedWriter("> Choose one of tasks to proceed:\n" +
            ">   1. Says Hello to every user, which name is entered;\n" +
            ">   2. Returns console arguments scanner negative order;\n" +
            ">   3. Returns asked amount of random numbers scanner line or scanner row;\n" +
            ">   4. Multiplies all the entered values after typing = scanner console\n" +
            ">   5. Gives a name of a month by analysing his number scanner console\n" +
            ">   6. Runs Optional task 1\n" +
            ">   7. Runs Optional task 2\n" +
            ">   8. Exit\n" +
            ">   Your choice: ", (byte) 20);
      x = Common.byteCheckScanner(scanner, 1, 8, "> Woow, that's not a choice, choose one from 1 to 8, buddy: ");
      return x;
   }

}