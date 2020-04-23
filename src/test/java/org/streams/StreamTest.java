package org.streams;

import org.junit.Test;
import org.model.Circle;
import org.model.Square;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;

public class StreamTest
{
    List<String> list1 = new ArrayList<>();
    List<Circle> list2 = new ArrayList<>();
    List<Square> list3 = new ArrayList<>();

    public StreamTest()
    {
        list1.add( "List 1 String 1" );
        list1.add( "List 1 String 2" );
        list1.add( "List 1 String 3" );

        list2.add( new Circle( 1, "Oval" ) );
        list2.add( new Circle( 2, "Ellipse" ) );
        list2.add( new Circle( 3, null ) );

        list3.add( new Square( 1, "Perfect" ) );
        list3.add( new Square( 2, "Rectangle" ) );
        list3.add( new Square( 3, "" ) );
    }

    @Test
    public void stream_test_for_each()
    {
        list2.stream().forEach( c -> System.out.println( c.getCircleShape() ) );
        assertThat( list2, contains(
                hasProperty( "circleShape", equalTo( "Oval" ) ),
                hasProperty( "circleShape", equalTo( "Ellipse" ) ),
                hasProperty( "circleShape", equalTo( null  )
        ) );
    }

    @Test
    public void stream_test_map()
    {
        Integer[] circleIds = { 7, 8, 9 };
        String[] circleShapes = { "Ellipse", "Symmetric", "Oval" };

        List<Circle> circleList = Stream.of( circleIds ).map( Circle::new ).collect( Collectors.toList() );
        circleList.stream().forEach( c -> System.out.println( c.toString() ) );
    }

    @Test
    public void stream_test_filter()
    {
        List<Circle> createdCircleList = list2.stream().filter( c -> c.getCircleShape() == "Oval" ).collect(
                Collectors.toList() );
        System.out.println( createdCircleList );
    }

    @Test
    public void stream_test_filter_then_map()
    {
        System.out.println( list3 );
        list3.stream().filter( s -> s.getSquareId() == 1 ).forEach( s -> s.setSquareShape( "Imperfect" ) );
        System.out.println( list3 );
    }

    @Test
    public void stream_test_another_map()
    {

    }
}
