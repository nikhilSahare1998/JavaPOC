package com.javaAssessment.poc.dto;

import java.io.Serializable;

public class JwtResponseDto implements Serializable {
    private static final long serialVersionUID = -80918790914046844L;
    private final String jwtToken;

    public JwtResponseDto(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getToken() {
        return this.jwtToken;
    }
}
