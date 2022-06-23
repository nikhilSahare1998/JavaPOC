package com.javaAssessment.poc.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
public class JwtRequestDto implements Serializable {
    private static final long serialVersionUID = 59264685830051507L;
    @NotBlank(message = "userName.required")
    private String username;

    @NotBlank(message = "Password.required")
    @Size(min = 8, message = "{password.length.required}")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")
    private String password;

    //need default constructor for JSON Parsing
    public JwtRequestDto() {

    }

    public JwtRequestDto(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }


}
