package com.dco.customer.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    private String houseNumber;
    private String streetName;
    private String cityName;
    private String countryName;
    private String postalCode;
}
