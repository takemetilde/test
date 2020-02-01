package org.model;

public class Square extends Shape
{
    int squareId;
    String squareShape;

    public int getSquareId()
    {
        return squareId;
    }

    public void setSquareId( int squareId )
    {
        this.squareId = squareId;
    }

    public String getSquareShape()
    {
        return squareShape;
    }

    public void setSquareShape( String squareShape )
    {
        this.squareShape = squareShape;
    }
}
