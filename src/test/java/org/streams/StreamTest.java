package org.streams;

import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;
import org.model.Circle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class StreamTest
{
    List<String> list1 = new ArrayList<>();
    List<Circle> list2 = new ArrayList<>();

    public void createLists()
    {
        list1.add( "List 1 String 1" );
        list1.add( "List 1 String 2" );
        list1.add( "List 1 String 3" );

        list2.add( new Circle( 1, "Oval" ) );
        list2.add( new Circle( 2, "Ellipse" ) );
        list2.add( new Circle( 3, null ) );
    }

    @Test
    public void stream_test_for_each()
    {
        createLists();

        list2.stream().forEach( c -> System.out.println(c.getCircleShape()) );
        assertThat(list2, contains(
                hasProperty( "circleShape", equalTo(  "Oval" ) ),
                hasProperty( "circleShape", equalTo( "Ellipse" ) ),
                hasProperty( "circleShape", equalTo( null ) )
                ));

    }

    @Test
    public void stream_test_map()
    {
        createLists();

        Integer[] circleIds = { 7, 8, 9 };
        String[] circleShapes = { "Ellipse", "Symmetric", "Oval" };

        List<Circle> circleList = Stream.of( circleIds ).map( Circle::new ).collect( Collectors.toList() );
        circleList.stream().forEach( c -> System.out.println( c.toString() ) );
    }

    @Test
    public void stream_test_filter()
    {
        List<Circle> createdCircleList = list2.stream().filter( c -> c.getCircleShape() == "Oval" ).collect( Collectors.toList() );
        System.out.println( createdCircleList );
    }


}
