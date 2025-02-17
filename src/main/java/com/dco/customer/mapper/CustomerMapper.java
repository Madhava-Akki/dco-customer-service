package com.dco.customer.mapper;

import com.dco.customer.dto.CustomerDTO;
import com.dco.customer.entity.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerMapper {
    private final ObjectMapper objectMapper;

    public Customer toEntity(CustomerDTO dto) {
        return objectMapper.convertValue(dto, Customer.class);
    }

    public CustomerDTO toDTO(Customer customer) {
        return objectMapper.convertValue(customer, CustomerDTO.class);
    }
}
