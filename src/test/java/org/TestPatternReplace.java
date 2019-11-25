package org;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.type.TypeReference;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPatternReplace
{

    public void test() {
        String json = "{\"tenant\":\"Default IT Tenant blUs\",\"creator\":\"Default IT Creator YRR2\",\"workspaces\":[\"Default IT Workspaces 1\",\"Default IT Workspaces 2\"], \"anotherone\":[\"Default IT anotherone\"]}";
        final String regex = "\"([\\w]*)\":\\[(\"([\\w\\s]*)\"(,)?)+]";
        System.out.println( returnArrayFromRegex( json, regex ));
        System.out.println(  getKVPFromString( json ));

    }

    public static ArrayList<String> returnArrayFromRegex(String json, String regex) {
        Pattern jsonPatternList = Pattern.compile( regex );
        Matcher matcher1 = jsonPatternList.matcher( json );
        ArrayList<String> returnList = new ArrayList<String>(  );
        for (int i = 0; i < matcher1.groupCount(); i++)
        {
            matcher1.find( );
            returnList.add( matcher1.group() );
        }
        System.out.println( "OOOOOOOOOOOOOOOOOO:" + returnList );
        return returnList;
    }

    public ArrayList<String> getKVPFromString(String json) {
        Pattern jsonPattern = Pattern.compile("\"([\\w]*)\":\"([\\w\\s])*\"");
        Pattern jsonPatternList = Pattern.compile( "\"([\\w]*)\":\\[(\"([\\w\\s]*)\"(,)?)+]");
        Matcher matcher = jsonPattern.matcher( json );
        Matcher matcher1 = jsonPatternList.matcher( json );
        ArrayList<String> returnList = new ArrayList<String>(  );

        for (int i = 0; i < matcher.groupCount(); i++)
        {
            matcher.find(  );
            returnList.add( matcher.group() );
        }
        for (int i = 0; i < matcher1.groupCount(); i++)
        {
            matcher1.find( );
            returnList.add( matcher1.group() );
        }

        return returnList;
    }
}
