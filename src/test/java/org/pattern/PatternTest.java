package org.pattern;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PatternTest {

    @Test
    public void test() {
        String testString= "Mar 2222";
        Pattern p = Pattern.compile("^([\\d]{4})$");
        Matcher m = p.matcher(testString);
        System.out.println(m.matches());
    }

    @Test
    public void test1() {
        String testString= "%[afl;kje , afjeafje, gggjeig,eakefejf]";
        Pattern p = Pattern.compile("%\\[(.)*]");
        Matcher m = p.matcher(testString);
        System.out.println(m.matches());
        String newString = testString.replace("%[", "");
        String[] stringArray = StringUtils.split(newString.replace("]", ""), ",");
        List<String> stringList = Arrays.stream(stringArray).map(String::trim).collect(Collectors.toList());
        System.out.println(stringList);
    }
}
