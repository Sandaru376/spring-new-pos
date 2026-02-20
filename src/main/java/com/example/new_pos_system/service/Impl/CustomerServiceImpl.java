package com.example.new_pos_system.service.Impl;

import com.example.new_pos_system.dto.CustomerDto;
import com.example.new_pos_system.entity.Customer;
import com.example.new_pos_system.repository.CustomerRepo;
import com.example.new_pos_system.service.CustomerService;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<CustomerDto> getAllCustomer() {
        List<Customer> customers= customerRepo.findAll();

        if(customers.isEmpty()){
            System.out.println("customer not found");
        }

        List<CustomerDto>customerDtoList = new ArrayList<>();

        for (Customer customer : customers) {
//            CustomerDto dto =new CustomerDto(
//
//                    customer.getCustomerName(),
//                    customer.getCustomerEmail(),
//                    customer.getCustomerPhone()
//            );

            CustomerDto dto =modelMapper.map(customer, CustomerDto.class);
            customerDtoList.add(dto);
        }
        return customerDtoList;

    }
    @Override
    public String updateCustomer(CustomerDto customerDto) {

        if (customerRepo.existsById(customerDto.getId())) {

            Customer customer = customerRepo.findById(customerDto.getId()).get();

            customer.setCustomerName(customerDto.getCustomerName());
            customer.setCustomerEmail(customerDto.getCustomerEmail());
            customer.setCustomerPhone(customerDto.getCustomerPhone());

            customerRepo.save(customer);

            return "Customer Updated Successfully";

        } else {
            return "Customer Not Found";
        }
    }

    @Override
    public String deleteCustomer(Integer id) {
    if(customerRepo.existsById(id)){
        customerRepo.deleteById(id);
        return "Customer Deleted Successfully";
    }else {
        return "customer not found";
    }
    }
}