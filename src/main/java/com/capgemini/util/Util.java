package com.capgemini.util;

public class Util {
    public static boolean isNumeric(String val) {
        boolean is = Boolean.TRUE;


        try{
            Integer.valueOf(val);
        }
        catch (Exception e){
            is = Boolean.FALSE;
        }
        return is;

    }


}
