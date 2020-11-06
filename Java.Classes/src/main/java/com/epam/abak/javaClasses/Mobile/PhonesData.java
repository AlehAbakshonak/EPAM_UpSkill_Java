package com.epam.abak.javaClasses.Mobile;

import java.util.List;

public class PhonesData {

   public static String[] getMainPhonesDataInStringArray(List<Phone> phoneBook, int ID) {

      String[] resultArray = new String[phoneBook.size()];

      for (int i = 0; i < phoneBook.size(); i++) {
         resultArray[i] = Phone.getMainPhoneDataInString(phoneBook.get(i));
         }

      return resultArray;
      }

   public static int[] getIDFromList(List<Phone>phoneBook) {
      int[] array = new int[phoneBook.size()];
      for (int i = 0; i < array.length; i++) {
         array[i] = phoneBook.get(i).getID();
      }
      return array;
   }

   public static int[] getDebitsFromList(List<Phone>phoneBook) {
      int[] array = new int[phoneBook.size()];
      for (int i = 0; i < array.length; i++) {
         array[i] = phoneBook.get(i).getDebit();
      }
      return array;
   }

   public static int[] getCreditsFromList(List<Phone>phoneBook) {
      int[] array = new int[phoneBook.size()];
      for (int i = 0; i < array.length; i++) {
         array[i] = phoneBook.get(i).getCredit();
      }
      return array;
   }

   public static int[] getCityCallsFromList(List<Phone>phoneBook) {
      int[] array = new int[phoneBook.size()];
      for (int i = 0; i < array.length; i++) {
         array[i] = phoneBook.get(i).getCityCalls();
      }
      return array;
   }

   public static int[] getInterCityCallsFromList(List<Phone>phoneBook) {
      int[] array = new int[phoneBook.size()];
      for (int i = 0; i < array.length; i++) {
         array[i] = phoneBook.get(i).getIntercityCalls();
      }
      return array;
   }

   public static int[] getNumbersFromList(List<Phone>phoneBook) {
      int[] array = new int[phoneBook.size()];
      for (int i = 0; i < array.length; i++) {
         array[i] = phoneBook.get(i).getNumber();
      }
      return array;
   }

   public static String[] getNamesFromList(List<Phone>phoneBook) {
      String[] array = new String[phoneBook.size()];
      for (int i = 0; i < array.length; i++) {
         array[i] = phoneBook.get(i).getName();
      }
      return array;
   }

   public static String[] getSurnamesFromList(List<Phone>phoneBook) {
      String[] array = new String[phoneBook.size()];
      for (int i = 0; i < array.length; i++) {
         array[i] = phoneBook.get(i).getSurname();
      }
      return array;
   }

   public static String[] getPatronymicFromList(List<Phone>phoneBook) {
      String[] array = new String[phoneBook.size()];
      for (int i = 0; i < array.length; i++) {
         array[i] = phoneBook.get(i).getPatronymic();
      }
      return array;
   }

   public static String[] getAddressesFromList(List<Phone>phoneBook) {
      String[] array = new String[phoneBook.size()];
      for (int i = 0; i < array.length; i++) {
         array[i] = phoneBook.get(i).getAddress();
      }
      return array;
   }

   public static String[] getCreditCardsFromList(List<Phone>phoneBook) {
      String[] array = new String[phoneBook.size()];
      for (int i = 0; i < array.length; i++) {
         array[i] = phoneBook.get(i).getCreditCard();
      }
      return array;
   }
}
