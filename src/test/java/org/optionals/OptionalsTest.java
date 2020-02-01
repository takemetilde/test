package org.optionals;

import org.junit.Test;
import org.model.Circle;
import org.model.Square;

public class OptionalsTest
{
    @Test
    public void optionalsTest() {
        Circle circle = new Circle();
        circle.setCircleId( 123 );
        circle.setCircleShape( "Oval" );

        Square square = new Square();
        square.setSquareId( 124 );
        square.setSquareShape( null );

        String shape = circle.getCircleShape().toUpperCase();
    }
}
