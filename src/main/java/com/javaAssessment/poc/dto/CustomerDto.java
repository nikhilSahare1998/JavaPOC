package com.javaAssessment.poc.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerDto {
    private Long customerId;
    private String firstName;
    private String lastName;
    private  String mobileNumber;
    private String address;
    private LocalDate dateOfBirth;
    private String email;
    private String aadharNumber;
}
