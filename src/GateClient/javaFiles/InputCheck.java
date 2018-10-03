/*
###File created at 01/10/2018 20:45
###Created by Alexandre Brito

##Revision v0.1
#1/10/2018 20:45
#Alexandre Brito
#Initial Criation



*/
package es.gate;

public class InputCheck {

    static String stringNameFormat(String str){

        return str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();
    }

    static boolean stringCheckLength(String str, int length){

        return str.length() >= length;
    }

    static boolean stringCheckOnlyLetters(String str){

        return str.matches("[A-Za-z]*");
    }

    static boolean stringCheckChars(String str){

        return str.matches("[A-Za-z0-9 ]*");
    }

    static boolean stringCheckEmail(String str){

        return true;
    }
}
