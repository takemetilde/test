package org;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPatternReplace
{

    @Test
    public void test() {
        String json = "{\"tenant\":\"Default IT Tenant blUs\",\"creator\":\"Default IT Creator YRR2\",\"workspaces\":[\"Default IT Workspaces 1\",\"Default IT Workspaces 2\"], \"anotherone\":[\"Default IT anotherone\"]}";
        Pattern jsonPattern = Pattern.compile("\"([\\w]*)\":\"([\\w\\s])*\"");
        Pattern jsonPatternList = Pattern.compile( "\"([\\w]*)\":\\[(\"([\\w\\s]*)\"(,)?)+]");
        Matcher matcher = jsonPattern.matcher( json );
        Matcher matcher1 = jsonPatternList.matcher( json );
        System.out.println( "Start:" );

        for (int i = 1; i <= matcher.groupCount(); i++)
        {
            matcher.find( i );
            System.out.println( matcher.group() );
        }

        System.out.println("Start: 1");
            matcher1.find();
            System.out.println( matcher1.groupCount());
    }
}
