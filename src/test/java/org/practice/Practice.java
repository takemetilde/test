package org.practice;

public class Practice {

    public static void main(String[] args) {
        String string = "This is a string";
        System.out.println(reverseString(string));
        System.out.println(hasVowel(string));
    }

    // Reverse a string
    public static String reverseString(String strToReverse) {
        String[] strArray = strToReverse.split("");
        String strReturn = "";
        for (int i = strArray.length - 1; i >= 0; i--) {
            strReturn = strReturn.concat(strArray[i]);
        }

        return strReturn;
    }

    // Check if string has a vowel
    public static Boolean hasVowel(String strToCheck) {
        return (strToCheck.matches(".*[aeiou].*"));
    }

    // Check if string is prime
    public static boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
