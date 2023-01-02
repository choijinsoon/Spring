package com.newlecture.web.entity;

public class Member {
   private int id;
   private String username;
   private String pwd;
   private String email;
   private String regDate;
   private String oAuthId;
   private String oAuthIss;

   
   
   public Member() {
   }

   public Member(int id, String username, String pwd, String email, String regDate) {
      this.id = id;
      this.username = username;
      this.pwd = pwd;
      this.email = email;
      this.regDate = regDate;
   }

   public Member(String username, String pwd, String email) {
      this.username = username;
      this.pwd = pwd;
      this.email = email;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPwd() {
      return pwd;
   }

   public void setPwd(String pwd) {
      this.pwd = pwd;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getRegDate() {
      return regDate;
   }

   public void setRegDate(String regDate) {
      this.regDate = regDate;
   }

   public String getOAuthId() {
      return oAuthId;
   }

   public void setOAuthId(String oAuthId) {
      this.oAuthId = oAuthId;
   }

   public String getOAuthIss() {
      return oAuthIss;
   }

   public void setOAuthIss(String oAuthIss) {
      this.oAuthIss = oAuthIss;
   }

   @Override
   public String toString() {
      return "Member [id=" + id + ", username=" + username + ", pwd=" + pwd + ", email=" + email + ", regDate="
            + regDate + ", oAuthId=" + oAuthId + ", oAuthIss=" + oAuthIss + "]";
   }
   
   
   
}