package org.ignore;

import org.junit.Test;
import org.model.Person;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.samePropertyValuesAs;

public class MatcherTest {

    Person person1 = new Person("John", "Smith", "1 Main St", "JohnSmith@gmail.com", 12345);
    Person person2 = new Person("Jane", "Doe", "2 Rodeo Dr", "JaneDoe#gmail.com", 67890);
    Person person3 = new Person("John", "Smith", "3 Main St", "JohnSmith@gmail.com", 01234);
    Person person4 = new Person("Jane", "Doe", "4 Rodeo Dr", "JaneDoe#gmail.com", 56789);

    @Test
    public void testMatcher() {
        assertThat(person1, is(samePropertyValuesAs(person3 , IgnoreFields.get(person1.getClass()))));
    }
}
