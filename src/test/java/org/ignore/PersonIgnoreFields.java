package org.ignore;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class PersonIgnoreFields implements IgnoreFieldsInterface{

    List<String> ignoreFields = new ArrayList<>();

    @Override
    public List<String> getFields() {
        ignoreFields.add("address");
        ignoreFields.add("phoneNumber");
        return ignoreFields;
    }
}
