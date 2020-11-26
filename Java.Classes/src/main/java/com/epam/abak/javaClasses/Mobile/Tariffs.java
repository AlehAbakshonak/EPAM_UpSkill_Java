package com.epam.abak.javaClasses.Mobile;

public class Tariffs {

   private int id;
   private String name;
   private int cityCost;
   private int intercityCost;

   public Tariffs(int id, String name, int cityCost, int intercityCost) {
      this.id = id;
      this.name = name;
      this.cityCost = cityCost;
      this.intercityCost = intercityCost;
   }

   public int getId() {
      return id;
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

   public void setId(int id) {
      this.id = id;
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
