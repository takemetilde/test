package org.steps;

import io.cucumber.java.en.Then;
import org.impl.BaseImpl;

public class BaseSteps
{
    BaseImpl base = new BaseImpl();

    @Then( "print BaseImpl string" )
    public void return_baseimpl_string() throws Exception{
        System.out.format("Thread ID - %2d - BaseImpl\n",
                Thread.currentThread().getId());
        System.out.println( "base.getBaseString(): " + base.getBaseString());
    }
}
