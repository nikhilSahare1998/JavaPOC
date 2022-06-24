package com.javaAssessment.poc.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Getter
@Setter
@Document(collection = "user-backup")
public class UserBackup {


    @Id
    private Long userId;

    private String emailID;
    private String password;
    private String fullName;
    private String country;
    private String state;
    private String district;
    private String pinCode;
    private String aadharCard;
    private String panCard;
    private String city;
    private String mobileNo;
    private String userType;
    private String activeStatus;


}
