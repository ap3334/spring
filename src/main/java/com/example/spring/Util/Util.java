package com.example.spring.Util;

public class Util {

    public static class str {

        public static String decapitalize(String str) {

            if (str == null || str.length() == 0) {
                return str;
            }

            char c[] = str.toCharArray();
            c[0] = Character.toLowerCase(c[0]);

            return new String(c);

        }

    }
}
