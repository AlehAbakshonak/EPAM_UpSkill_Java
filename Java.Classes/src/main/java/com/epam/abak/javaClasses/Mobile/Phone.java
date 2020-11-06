package com.epam.abak.javaClasses.Mobile;

public class Phone {
   private int ID;
   private int debit;
   private int credit;
   private int cityCalls;
   private int intercityCalls;
   private int number;
   private String name;
   private String surname;
   private String patronymic;
   private String address;
   private String creditCard;

   public Phone(int ID,
                int debit,
                int credit,
                int cityCalls,
                int intercityCalls,
                int number, String name,
                String surname,
                String patronymic,
                String address,
                String creditCard) {
      this.ID = ID;
      this.debit = debit;
      this.credit = credit;
      this.cityCalls = cityCalls;
      this.intercityCalls = intercityCalls;
      this.number = number;
      this.name = name;
      this.surname = surname;
      this.patronymic = patronymic;
      this.address = address;
      this.creditCard = creditCard;
   }

   public static String getMainPhoneDataInString(Phone phone) {
      return String.format("ID: %d | Full name: %s %s %s | Number: +%d",
            phone.getID(),
            phone.getSurname(),
            phone.getName(),
            phone.getPatronymic(),
            phone.getNumber()
      );
   }


   public void setID(int id) {
      this.ID = id;
   }

   public void setDebit(int debit) {
      this.debit = debit;
   }

   public void setCredit(int credit) {
      this.credit = credit;
   }

   public void setCityCalls(int cityCalls) {
      this.cityCalls = cityCalls;
   }

   public void setIntercityCalls(int intercityCalls) {
      this.intercityCalls = intercityCalls;
   }

   public void setNumber(int number) {
      this.number = number;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setSurname(String surname) {
      this.surname = surname;
   }

   public void setPatronymic(String patronymic) {
      this.patronymic = patronymic;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public void setCreditCard(String creditCard) {
      this.creditCard = creditCard;
   }

   public int getID() {
      return this.ID;
   }

   public int getDebit() {
      return this.debit;
   }

   public int getCredit() {
      return this.credit;
   }

   public int getCityCalls() {
      return this.cityCalls;
   }

   public int getIntercityCalls() {
      return this.intercityCalls;
   }

   public int getNumber() {
      return this.number;
   }

   public String getName() {
      return this.name;
   }

   public String getSurname() {
      return this.surname;
   }

   public String getPatronymic() {
      return this.patronymic;
   }

   public String getAddress() {
      return this.address;
   }

   public String getCreditCard() {
      return this.creditCard;
   }
}
