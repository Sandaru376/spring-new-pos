package com.example.new_pos_system.controller;

import com.example.new_pos_system.dto.CustomerDto;
import com.example.new_pos_system.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public String saveCustomer(@RequestBody CustomerDto customerDto){
        return customerService.saveCustomer(customerDto);
    }

    @GetMapping("/get-all")
    public List<CustomerDto> getAllCustomer(){
        return customerService.getAllCustomer() ;
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody CustomerDto customerDto){
        return customerService.updateCustomer(customerDto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id){
        return customerService.deleteCustomer(id);
    }




}