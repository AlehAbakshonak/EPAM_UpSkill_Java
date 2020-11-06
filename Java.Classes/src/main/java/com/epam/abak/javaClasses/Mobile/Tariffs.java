package com.epam.abak.javaClasses.Mobile;

public class Tariffs {

   private int ID;
   private String name;
   private int cityCost;
   private int intercityCost;

   public Tariffs(int ID, String name, int cityCost, int intercityCost) {
      this.ID = ID;
      this.name = name;
      this.cityCost = cityCost;
      this.intercityCost = intercityCost;
   }

   public int getID() {
      return ID;
   }

   public String getName() {
      return name;
   }

   public int getCityCost() {
      return cityCost;
   }

   public int getIntercityCost() {
      return intercityCost;
   }

   public void setID(int ID) {
      this.ID = ID;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setCityCost(int cityCost) {
      this.cityCost = cityCost;
   }

   public void setIntercityCost(int intercityCost) {
      this.intercityCost = intercityCost;
   }
}
