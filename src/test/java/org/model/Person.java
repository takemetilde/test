package org.model;

import lombok.*;

@AllArgsConstructor
@Data
public class Person {

    private String firstName;

    private String lastName;

    private String address;

    private String email;

    private int phoneNumber;

}
