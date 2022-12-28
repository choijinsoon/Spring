package com.newlecture.web;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestApp {
   public static void main(String[] args) throws Exception {
      String pwd = "user";

      BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

      for(int i=0; i<5; i++) {

         String encoded= encoder.encode(pwd);
         System.out.println(encoded);

         boolean isEqual = encoder.matches(pwd, encoded);
         System.out.println(isEqual);

      }
   }
}
