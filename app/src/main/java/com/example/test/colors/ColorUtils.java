package com.example.test.colors;

  class ColorUtils {

    static String capitalize(String str) {
        String strLowerCase = str.toLowerCase();
        return Character.toUpperCase(strLowerCase.charAt(0)) + strLowerCase.substring(1);
    }
}
