package com.example.new_pos_system.service.Impl;

import com.example.new_pos_system.dto.CustomerDto;
import com.example.new_pos_system.entity.Customer;
import com.example.new_pos_system.repository.CustomerRepo;
import com.example.new_pos_system.service.CustomerService;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public String saveCustomer(CustomerDto customerDto) {



        Customer customer = modelMapper.map(customerDto, Customer.class);
         customerRepo.save(customer);


        return "Customer Saved Successfully  " ;
    }
}