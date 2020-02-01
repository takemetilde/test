package org.model;

import java.io.Serializable;

public class Circle extends Shape
{
    int circleId;
    String circleShape;

    public Circle()
    {
    }

    public Circle( int circleId )
    {
        this.circleId = circleId;
    }

    public Circle( int circleId, String circleShape )
{
    this.circleId = circleId;
    this.circleShape = circleShape;
}

    public int getCircleId()
    {
        return circleId;
    }

    public void setCircleId( int circleId )
    {
        this.circleId = circleId;
    }

    public String getCircleShape()
    {
        return circleShape;
    }

    public void setCircleShape( String circleShape )
    {
        this.circleShape = circleShape;
    }

    @Override public String toString()
    {
        return "Circle{" +
                "circleId=" + circleId +
                ", circleShape='" + circleShape + '\'' +
                '}';
    }
}
