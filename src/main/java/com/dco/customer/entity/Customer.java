package com.dco.customer.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String gender;

    @Past
    private Date dateOfBirth;

    @NotBlank
    private String phoneNumber;

    @Email
    private String email;

    @NotBlank
    private String nationality;

    @NotBlank
    private String socialSecurityNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "residential_id", referencedColumnName = "id")
    private Address residential;
}
