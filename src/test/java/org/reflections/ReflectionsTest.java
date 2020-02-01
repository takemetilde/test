package org.reflections;

import org.junit.Assert;
import org.junit.Test;
import org.model.Square;

import java.lang.reflect.Field;
import java.util.Arrays;

public class ReflectionsTest
{
    @Test
    public void reflections_test() throws NoSuchFieldException, IllegalAccessException {
        Square square = new Square();
        square.setSquareId( 123 );
        square.setSquareShape( "Rectangle" );
        square.setShape( "Square" );

        for ( Field f : square.getClass().getDeclaredFields() )
        {
            f.setAccessible( true );
            System.out.println( f.getName() );
            System.out.println( f.get( square ) );
            System.out.println( square.getClass().getDeclaredField( f.getName() ) );
        }

        for ( Field f : square.getClass().getSuperclass().getDeclaredFields() )
        {
            f.setAccessible( true );
            System.out.println( f.getName() );
            System.out.println( f.get( square ) );
            System.out.println( square.getClass().getSuperclass().getDeclaredField( f.getName() ) );
        }
    }

    @Test
    public void compareNonNullParametersFromObjects_test() {
        Square square1 = new Square();
        Square square2 = new Square();

        square1.setSquareId( 123 );
        square1.setSquareShape( null );
        square2.setSquareId( 123 );
        square2.setSquareShape( "Rectangle" );

        Assert.assertTrue( compareNonNullParametersFromObjects( square1, square2 ) );
    }

    public <T>  boolean compareNonNullParametersFromObjects( T expectedFromDt, T actualFromResponse )
    {
        for ( Field f: expectedFromDt.getClass().getDeclaredFields() )
        {
            f.setAccessible( true );
            if ( !f.getName().equals( "serialVersionUID" ))
                try
                {
                    Field fieldFromActual = actualFromResponse.getClass().getDeclaredField( f.getName() );
                    fieldFromActual.setAccessible( true );
                    if( f.get(expectedFromDt) != null && !f.get( expectedFromDt ).equals( fieldFromActual.get( actualFromResponse ) ) )
                    {
                        System.out.println( String.format( "Fields do not match! Field Name:[%s] Expected:[%s] Actual:[%s]",
                                f.getName(), f, fieldFromActual ) );
                        return false;
                    }
                }
                catch ( NoSuchFieldException | IllegalAccessException e )
                {
                    e.printStackTrace();
                    return false;
                }
        }
        return true;
    }
}
