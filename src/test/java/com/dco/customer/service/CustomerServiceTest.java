package com.dco.customer.service;

import com.dco.customer.dto.AddressDTO;
import com.dco.customer.dto.CustomerDTO;
import com.dco.customer.entity.Address;
import com.dco.customer.entity.Customer;
import com.dco.customer.mapper.CustomerMapper;
import com.dco.customer.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerMapper customerMapper;

    @InjectMocks
    private CustomerService customerService;

    private Customer customer;
    private CustomerDTO customerDTO;

    @BeforeEach
    void setUp() {
        Address address = new Address(1L, "123", "Main St", "New York", "USA", "10001");
        customer = new Customer(1L, "John", "Doe", "Male", new Date(), "1234567890", "john.doe@example.com", "American", "SSN1234", address);
        customerDTO = new CustomerDTO("John", "Doe", "Male", new Date(), "1234567890", "john.doe@example.com", "American", "SSN1234", new AddressDTO("123", "Main St", "New York", "USA", "10001"));
    }

    @Test
    void testCreateCustomerSuccess() {
        when(customerMapper.toEntity(any())).thenReturn(customer);
        when(customerRepository.save(any())).thenReturn(customer);
        when(customerMapper.toDTO(any())).thenReturn(customerDTO);

        CustomerDTO result = customerService.createCustomer(customerDTO);

        assert result != null;
        assert result.getFirstName().equals("John");
    }

    @Test
    void testCreateCustomerFailure() {
        when(customerMapper.toEntity(any())).thenReturn(customer);
        when(customerRepository.save(any())).thenThrow(new RuntimeException("Database error"));

        try {
            customerService.createCustomer(customerDTO);
            assert false;
        } catch (Exception e) {
            assert e.getMessage().equals("Database error");
        }
    }
}
