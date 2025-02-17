package com.dco.customer.controller;

import com.dco.customer.dto.CustomerDTO;
import com.dco.customer.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@Tag(name = "Customer API", description = "Customer management API")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;

    @PostMapping
    @Operation(summary = "Create a new customer")
    public ResponseEntity<CustomerDTO> createCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        return new ResponseEntity<>(service.createCustomer(customerDTO), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Get all customers")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        return ResponseEntity.ok(service.getAllCustomers());
    }
}
