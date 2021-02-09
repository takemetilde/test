package org.ignore;

import org.model.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IgnoreFields {

    private static final IgnoreFieldsInterface PersonIgnoreProperties = new PersonIgnoreFields();

    private static final Map<Class<?>, IgnoreFieldsInterface> MAP = new HashMap<>();

    static {
        MAP.put(Person.class, PersonIgnoreProperties);
    }

    public static String[] get(Class<?> clazz) {
        return MAP.get(clazz).getFields().toArray(new String[0]);
    }
}
