package com.newlecture.web.entity;

import java.util.Date;

public class Menu {
   private int id;
   private String name;
   private int price;
   private String img;
   private Date regDate;
   private int regMemberId;
   private int pat;
   private int protein;
   private int natrium;
   private int sugar;
   private int cafeine; 
   private int lgSizePat; 
   private int lgSizeProtein; 
   private int lgSizeNatrium; 
   private int lgSizeSugar; 
   private int lgSizeCafeine; 
   private int categoryId;
   
   public Menu() {
      // TODO Auto-generated constructor stub
   }
   // for inserting
   public Menu(String name, int price, String img, int regMemberId) {
      
      this.name = name;
      this.price = price;
      this.img = img;      
      this.regMemberId = regMemberId;      
   }

   // for selecting
   public Menu(int id, String name, int price, String img, Date regDate, int regMemberId, int pat, int protein,
         int natrium, int sugar, int cafeine, int lgSizePat, int lgSizeProtein, int lgSizeNatrium, int lgSizeSugar,
         int lgSizeCafeine, int categoryId) {
      super();
      this.id = id;
      this.name = name;
      this.price = price;
      this.img = img;
      this.regDate = regDate;
      this.regMemberId = regMemberId;
      this.pat = pat;
      this.protein = protein;
      this.natrium = natrium;
      this.sugar = sugar;
      this.cafeine = cafeine;
      this.lgSizePat = lgSizePat;
      this.lgSizeProtein = lgSizeProtein;
      this.lgSizeNatrium = lgSizeNatrium;
      this.lgSizeSugar = lgSizeSugar;
      this.lgSizeCafeine = lgSizeCafeine;
      this.categoryId = categoryId;
   }
   public int getId() {
      return id;
   }
   public void setId(int id) {
      this.id = id;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public int getPrice() {
      return price;
   }
   public void setPrice(int price) {
      this.price = price;
   }
   public String getImg() {
      return img;
   }
   public void setImg(String img) {
      this.img = img;
   }
   public Date getRegDate() {
      return regDate;
   }
   public void setRegDate(Date regDate) {
      this.regDate = regDate;
   }
   public int getRegMemberId() {
      return regMemberId;
   }
   public void setRegMemberId(int regMemberId) {
      this.regMemberId = regMemberId;
   }
   public int getPat() {
      return pat;
   }
   public void setPat(int pat) {
      this.pat = pat;
   }
   public int getProtein() {
      return protein;
   }
   public void setProtein(int protein) {
      this.protein = protein;
   }
   public int getNatrium() {
      return natrium;
   }
   public void setNatrium(int natrium) {
      this.natrium = natrium;
   }
   public int getSugar() {
      return sugar;
   }
   public void setSugar(int sugar) {
      this.sugar = sugar;
   }
   public int getCafeine() {
      return cafeine;
   }
   public void setCafeine(int cafeine) {
      this.cafeine = cafeine;
   }
   public int getLgSizePat() {
      return lgSizePat;
   }
   public void setLgSizePat(int lgSizePat) {
      this.lgSizePat = lgSizePat;
   }
   public int getLgSizeProtein() {
      return lgSizeProtein;
   }
   public void setLgSizeProtein(int lgSizeProtein) {
      this.lgSizeProtein = lgSizeProtein;
   }
   public int getLgSizeNatrium() {
      return lgSizeNatrium;
   }
   public void setLgSizeNatrium(int lgSizeNatrium) {
      this.lgSizeNatrium = lgSizeNatrium;
   }
   public int getLgSizeSugar() {
      return lgSizeSugar;
   }
   public void setLgSizeSugar(int lgSizeSugar) {
      this.lgSizeSugar = lgSizeSugar;
   }
   public int getLgSizeCafeine() {
      return lgSizeCafeine;
   }
   public void setLgSizeCafeine(int lgSizeCafeine) {
      this.lgSizeCafeine = lgSizeCafeine;
   }
   public int getCategoryId() {
      return categoryId;
   }
   public void setCategoryId(int categoryId) {
      this.categoryId = categoryId;
   }
   @Override
   public String toString() {
      return "Menu [id=" + id + ", name=" + name + ", price=" + price + ", img=" + img + ", regDate=" + regDate
            + ", regMemberId=" + regMemberId + ", pat=" + pat + ", protein=" + protein + ", natrium=" + natrium
            + ", sugar=" + sugar + ", cafeine=" + cafeine + ", lgSizePat=" + lgSizePat + ", lgSizeProtein="
            + lgSizeProtein + ", lgSizeNatrium=" + lgSizeNatrium + ", lgSizeSugar=" + lgSizeSugar
            + ", lgSizeCafeine=" + lgSizeCafeine + ", categoryId=" + categoryId + "]";
   }
   
   
}