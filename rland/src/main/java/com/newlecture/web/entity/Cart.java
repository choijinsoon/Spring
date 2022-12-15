package com.newlecture.web.entity;

import java.util.Date;

public class Cart {
   private int id;
   private int memberId;
   private int menuId;
   private boolean ice;
   private boolean large;
   private Date date;
   
   
   public Cart() {
      // TODO Auto-generated constructor stub
   }
   
   

   public Cart(int memberId, int menuId, boolean ice, boolean large) {
      super();
      this.memberId = memberId;
      this.menuId = menuId;
      this.ice = ice;
      this.large = large;
   }
   
}