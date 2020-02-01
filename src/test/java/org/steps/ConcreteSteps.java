package org.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.DataTableType;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.impl.ConcreteImpl;
import org.model.Circle;

import java.util.List;

public class ConcreteSteps
{
    ConcreteImpl concrete = new ConcreteImpl();

    @Then( "print concrete string after setting base string" )
    public void return_concrete_1() throws Exception {
        Thread.sleep( 5000 );
        concrete.setBaseString( "OOIOIOIOIOIOIOIOIOIOI" );
        System.out.println( "concrete.getConcreteString(): " + concrete.getBaseString() );

    }

    @Given("this table for testing typeconfigurer:")
    public void table_to_test_typeconfigurer( List<Circle> circleDt)
    {
        List<Circle> circleListFromDt = circleDt;
        System.out.println(circleListFromDt.get( 0 ).getCircleId());
        System.out.println( "Should get out of bounds here:\n");
        System.out.println(circleListFromDt.get( 1 ).getCircleId());

    }

}
