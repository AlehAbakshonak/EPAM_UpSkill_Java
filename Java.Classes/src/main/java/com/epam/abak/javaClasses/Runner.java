package com.epam.abak.javaClasses;
import com.epam.abak.javaClasses.Mobile.Phone;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 */
public class Runner {

   public static void main(String[] args) {
      List<Phone> phoneBook = Arrays.asList(
            new Phone(3, 100, 300, 40,
                  60, 12345678, "name1",
                  "sur1", "fam1", "address1", "1111 2222 3333 4444"),
            new Phone(2, 100, 600, 10,
                  0, 24683579, "name2",
                  "sur2", "fam2", "address2", "2222 3333 4444 5555"),
            new Phone(1, 100, 120, 150,
                  10, 32460489, "name3",
                  "sur3", "fam3", "address3", "3333 4444 5555 6666"),
            new Phone(4, 400, 200, 400,
                  80, 40985872, "name4",
                  "sur4", "fam4", "address4", "4444 5555 6666 7777"),
            new Phone(5, 600, 300, 200,
                  20, 50792340, "name5",
                  "sur5", "fam5", "address5", "5555 6666 7777 8888")
      );

      System.out.println(
            "summaryCallTimeMoreThan\n"+
            Common.stringArrayToString(
                  Analyser.summaryCallTimeMoreThan(phoneBook, 400)
            )
      );

      System.out.println(
            "cityCallTimeMoreThan\n"+
            Common.stringArrayToString(
                  Analyser.interCityCallsUsedPhones(phoneBook)
            )
      );

      System.out.println(
            "sortListByID\n"+
            Common.stringArrayToString(
                  Analyser.sortListByID(phoneBook)
            )
      );
   }
}
