package org.practice;

import java.sql.SQLOutput;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InterviewSolution {

    public static void main(String[] args) {

        String test = "123abc789";

        if (verifyAlphaNumeric(test)) {
            // Break string into string array
            String[] testArray = test.split("");
            // Make string array with only letter
            StringBuilder newTest = new StringBuilder();
            for (String s: testArray) {
                try {
                    Integer.parseInt(s);
                    newTest.append(s);
                } catch (NumberFormatException ignored) {
                }
            }

            // Reverse string
            newTest = newTest.reverse();
            String[] newTestArray = newTest.toString().split("");
            StringBuilder returnString = new StringBuilder();
            int i = 0;
            // Iterate through original string and only replace the char with new reverse string if a letter
            for (String s: testArray) {
                try {
                    Integer.parseInt(s);
                    returnString.append(newTestArray[i]);
                    i++;
                } catch (NumberFormatException ignored) {
                    returnString.append(s);
                }
            }
            // Print string
            System.out.println(returnString);
        } else
            System.out.println("The string is not alphanumeric.");

    }

    public static Boolean verifyAlphaNumeric(String s) {
        Pattern p = Pattern.compile("^[a-zA-Z0-9]+$");
        Matcher m = p.matcher(s);
        return m.find();
    }

}
