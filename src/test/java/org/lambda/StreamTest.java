package org.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest
{
    @Test
    public void stream()
    {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        {
            list1.add( "List 1 String 1" );
//            list1.add( "List 1 String 2" );
//            list1.add( "List 1 String 3" );

            list2.add( "List 2 String 1" );
            list2.add( "List 2 String 2" );
            list2.add( "List 2 String 3" );
        }

        System.out.println(String.join(",", list1));

    }
}
