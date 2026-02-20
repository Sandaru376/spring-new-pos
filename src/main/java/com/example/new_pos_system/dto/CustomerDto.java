package com.example.new_pos_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private int id;
    private String customerName;
    private String customerEmail;
    private String customerPhone;


}