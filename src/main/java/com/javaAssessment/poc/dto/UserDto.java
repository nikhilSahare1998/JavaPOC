package com.javaAssessment.poc.dto;


import com.javaAssessment.poc.enums.UserType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserDto {

    private final String ACTIVE_STATUS = "Active";

    private long userId;

    @Email(message = "email.invalid")
    @Length(max = 70, message = "{email.length}")
    private String emailID;

    @NotBlank(message = "fullName.required")
    private String fullName;

    @NotBlank(message = "Country.required")
    private String country;

    @NotBlank(message = "Password.required")
    @Size(min = 8, message = "{password.length.required}")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")
    private String password;

    @NotBlank(message = "state.required")
    private String state;

    @NotBlank(message = "district.required")
    private String district;

    @NotBlank(message = "pinCode.required")
    @Size(min = 6, message = "{pinCode.length.required}")
    private String pinCode;

    @NotBlank(message = "aadhar_Card.required")
    @Size(min = 12, message = "{aadhar_Card.length.required}")
    private String aadharCard;

    @NotBlank(message = "panCard.required")
    @Size(min = 10, message = "{panCard.length.required}")
    private String panCard;

    @NotBlank(message = "city.required")
    private String city;

    @NotBlank(message = "Mobile Number required")
    @NotBlank(message = "mobileNo.required")
    @Size(min = 10, message = "{mobileNo.length.required}")
    private String mobileNo;

    private UserType userType;

    private String activeStatus = ACTIVE_STATUS;
}
