package com.qa.opencart.utilites;

public class RandomEmail {

    public static String getRandonId(){
        String email = "testautomation_"+System.currentTimeMillis()+"@opencart.com";
        return email;
    }



}
