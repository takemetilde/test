package org.pattern;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

    @Test
    public void test() {
        String testString= "Mar 2222";
        Pattern p = Pattern.compile("^([\\d]{4})$");
        Matcher m = p.matcher(testString);
        System.out.println(m.matches());
    }
}
