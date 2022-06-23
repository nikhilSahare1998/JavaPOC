package com.javaAssessment.poc.service;

import com.javaAssessment.poc.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto findUserById(Long id);

    UserDto findByPanCardOrAadharCard(String id);

    List<UserDto> findByStateOrCountry(String location);
}
