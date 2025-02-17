package com.dco.customer.dto;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private String firstName;
    private String lastName;
    private String gender;
    private Date dateOfBirth;
    private String phoneNumber;
    private String email;
    private String nationality;
    private String socialSecurityNumber;
    private AddressDTO address;
}
