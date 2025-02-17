package com.dco.customer.service;

import com.dco.customer.dto.CustomerDTO;
import com.dco.customer.entity.Customer;
import com.dco.customer.mapper.CustomerMapper;
import com.dco.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final CustomerMapper mapper;

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer savedCustomer = repository.save(mapper.toEntity(customerDTO));
        kafkaTemplate.send("customer-events", "Customer Created: " + savedCustomer.getId());
        return mapper.toDTO(savedCustomer);
    }

}
