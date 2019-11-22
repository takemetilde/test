package org;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.type.TypeReference;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPatternReplace
{

    @Test
    public void test() {
        String json = "{\"tenant\":\"Default IT Tenant blUs\",\"creator\":\"Default IT Creator YRR2\",\"workspaces\":[\"Default IT Workspaces 1\",\"Default IT Workspaces 2\"], \"anotherone\":[\"Default IT anotherone\"]}";
        System.out.println( getKVPFromString( json ));
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
        for (int i = 0; i < matcher.groupCount(); i++)
        {
            matcher1.find( );
            returnList.add( matcher1.group() );
        }

        return returnList;
    }

    @Test
    public void testingJsonMapper()
    {
        try
        {
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = "{\"tenant\":\"Default IT Tenant blUs\",\"creator\":\"Default IT Creator YRR2\"}";

            String anotherone = "\"workspaces\":[\"Default IT Workspaces 1\",\"Default IT Workspaces 2\"], \"anotherone\":[\"Default IT anotherone\"]";

            Map<String, Object> jsonMap  = mapper.readValue( anotherone,
                    new TypeReference<Map<String, Array>>()
                    {
                    } );

            System.out.println( jsonMap );
        }
        catch (
                IOException ie )
        {
            ie.printStackTrace();
        }
    }
}
