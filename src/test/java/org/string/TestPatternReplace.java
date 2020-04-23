package org.string;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.type.TypeReference;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.time.Instant;
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

    @Test
    public void testingMatcher() {
        String stringTest = "{\"id\":\"a35b7b34-c90a-4868-802b-6fe768a57104\",\"created\":{\"epochSecond\":1582915843,\"nano\":93000000},\"tenant\":\"INT TEST TENANT\",\"status\":\"Active\",\"participants\":null,\"workspaces\":[{\"id\":\"05e3d0b3-1b96-43e9-b10c-16a989f6f987\",\"status\":\"PENDING\",\"referenceId\":null,\"referenceType\":\"INT TEST WKSPC REF TYPE 1\",\"expiration\":{\"epochSecond\":1582921843,\"nano\":93000000},\"effective\":{\"epochSecond\":1582915843,\"nano\":93000000},\"needs\":{\"skills\":[\"INT TEST SKILLS 1\",\"INT TEST SKILLS 2\"]";

        System.out.println(stringTest);
        String newStringTest = stringTest.replaceAll( "\\{\"epochSecond\":(\\d+),\"nano\":(\\d+)}","$1.$2");
        System.out.println(newStringTest);
    }
}
