package com.example.new_pos_system.service;

import com.example.new_pos_system.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    String saveCustomer(CustomerDto customerDto);

    List<CustomerDto> getAllCustomer();

    String updateCustomer(CustomerDto customerDto);

    String deleteCustomer(Integer id);
}
