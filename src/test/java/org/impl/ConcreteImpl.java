package org.impl;

public class ConcreteImpl extends BaseImpl
{
    private String concreteString = "CONCRETE";

    public ConcreteImpl() {

    }

    public String getConcreteString() {
        return concreteString;
    }

    public void setConcreteString( String concreteString )
    {
        this.concreteString = concreteString;
    }

    @Override
    public void setBaseString(String string) {

    }
}
