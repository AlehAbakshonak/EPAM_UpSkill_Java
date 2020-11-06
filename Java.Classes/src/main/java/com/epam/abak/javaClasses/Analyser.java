package com.epam.abak.javaClasses;

import com.epam.abak.javaClasses.Mobile.Phone;
import com.epam.abak.javaClasses.Mobile.PhonesData;
import java.util.ArrayList;
import java.util.List;

public class Analyser {

   public static String[] summaryCallTimeMoreThan(List<Phone> phoneBook, int timeLimit) {

      int[] allCityCalls = PhonesData.getCityCallsFromList(phoneBook);

      int[] allInterCityCalls = PhonesData.getInterCityCallsFromList(phoneBook);

      ArrayList<String> listOfTimeExpiredPhones = new ArrayList<String>();

      for (int i = 0; i < phoneBook.size(); i++) {
         if (allCityCalls[i] + allInterCityCalls[i] > timeLimit) {
            listOfTimeExpiredPhones.add(
                  Phone.getMainPhoneDataInString(phoneBook.get(i))
            );
         }
      }

      return listOfTimeExpiredPhones.toArray(new String[0]);
   }

   public static String[] intercityCallTimeMoreThan(List<Phone> phoneBook, int timeLimit) {

      int[] allCityCalls = PhonesData.getCityCallsFromList(phoneBook);

      int[] allInterCityCalls = PhonesData.getInterCityCallsFromList(phoneBook);

      ArrayList<String> listOfTimeExpiredPhones = new ArrayList<String>();

      for (int i = 0; i < phoneBook.size(); i++) {
         if (allInterCityCalls[i] > timeLimit) {
            listOfTimeExpiredPhones.add(
                  Phone.getMainPhoneDataInString(phoneBook.get(i))
            );
         }
      }
      return (String[]) listOfTimeExpiredPhones.toArray(new String[0]);
   }

   public static String[] cityCallTimeMoreThan(List<Phone> phoneBook, int timeLimit) {

      int[] allCityCalls = PhonesData.getCityCallsFromList(phoneBook);

      int[] allInterCityCalls = PhonesData.getInterCityCallsFromList(phoneBook);

      ArrayList<String> listOfTimeExpiredPhones = new ArrayList<String>();

      for (int i = 0; i < phoneBook.size(); i++) {
         if (allCityCalls[i] > timeLimit) {
            listOfTimeExpiredPhones.add(
                  Phone.getMainPhoneDataInString(phoneBook.get(i))
            );
         }
      }
      return (String[]) listOfTimeExpiredPhones.toArray(new String[0]);
   }

   public static String[] interCityCallsUsedPhones(List<Phone> phoneBook) {

      int[] allCityCalls = PhonesData.getInterCityCallsFromList(phoneBook);

      ArrayList<String> resultList = new ArrayList<>();

      for (int i = 0; i < phoneBook.size(); i++) {
         if (allCityCalls[i]>0) {
            resultList.add(
                  Phone.getMainPhoneDataInString(phoneBook.get(i))
            );
         }
      }
      return resultList.toArray(new String[0]);
   }

   public static String[] sortListByID(List<Phone> phoneBook) {

      int [] allID = PhonesData.getIDFromList(phoneBook);
      String[] resultArray = new String[allID.length];

      for (int i = 0; i < resultArray.length; i++) {
         resultArray[i] = Phone.getMainPhoneDataInString(phoneBook.get(allID[i]-1));
      }

      return resultArray;
   }
}
