package org.steps;

import io.cucumber.java.en.Then;
import org.impl.ConcreteImpl;

public class ConcreteSteps
{
    ConcreteImpl concrete = new ConcreteImpl();

    @Then( "print concrete string after setting base string" )
    public void return_concrete_1() throws Exception {
        Thread.sleep( 5000 );
        concrete.setBaseString( "OOIOIOIOIOIOIOIOIOIOI" );
        System.out.println( "concrete.getConcreteString(): " + concrete.getBaseString() );

    }
}
