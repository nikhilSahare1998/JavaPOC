package com.javaAssessment.poc.entity;


import com.javaAssessment.poc.util.UserType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_Id")
    private Long userId;

    @Column(name = "email_ID", unique = true)
    private String emailID;

    @Column(name = "password")
    private String password;

    @Column(name = "full_Name")
    private String fullName;

    @Column(name = "Country")
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "district")
    private String district;

    @Column(name = "pinCode")
    private String pinCode;

    @Column(name = "aadhar_Card", unique = true)
    private String aadharCard;

    @Column(name = "pan_Card", unique = true)
    private String panCard;

    @Column(name = "city")
    private String city;

    @Column(name = "mobile_No", unique = true)
    private String mobileNo;

    @Column(name = "userType")
    @Enumerated  (EnumType.STRING)
    private UserType userType;

    @Column(name = "activeStatus")
    private String activeStatus;


}
