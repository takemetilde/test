package org.lambda;

import org.junit.Test;

public class LambdaTest
{
    @Test
    public void testing_lambda_with_single_method_interace() {
        SingleMethodInterfaceWithNoArgs singleMethodInterfaceWithNoArgs = () -> {
            System.out.println("This is the single method interface with no args.");
        };

        SingleMethodInterface singleMethodInterface = (String text) ->
                System.out.println("This is a single line impl. No brackets needed. " + text);

        SingleMethodInterface singleMethodInterface1 = text -> {
            String internalString =
                    "This is using type inference and single parameter. This is a multi line impl. Brackets needed. ";
            System.out.println( internalString + text);
        };

        SingleMethodInterfaceWithManyArgs singleMethodInterfaceWithManyArgs = (string1, string2) -> {
            System.out.println("This is using multiple args. String1:" + string1 + " String2:" + string2);
        };

        SingleMethodInterfaceWithReturnValue singleMethodInterfaceWithReturnValue = text -> {
            System.out.println("This should return the same string input in the next line: Input:" + text);
            return text;
        };

        SingleMethodInterfaceWithReturnValue singleMethodInterfaceWithReturnValue1 = text -> text;

        singleMethodInterfaceWithNoArgs.printIt();
        singleMethodInterface.printIt( "It should print this." );
        singleMethodInterface1.printIt( "It should also print this." );
        singleMethodInterfaceWithManyArgs.printIt( "This is the first string.", "This is the second string." );

        String returnStringFromMethod = singleMethodInterfaceWithReturnValue.printIt(
                "This is the input text." );
        System.out.println(returnStringFromMethod);

        String returnStringFromMethod1 = singleMethodInterfaceWithReturnValue1.printIt(
                "This should return as a string object. Return here is implied." );
        System.out.println(returnStringFromMethod1);
    }
}
