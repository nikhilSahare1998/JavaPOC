package com.javaAssessment.poc.controller;

import com.javaAssessment.poc.dto.UserDto;
import com.javaAssessment.poc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@ControllerAdvice
@Validated
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody @Valid UserDto userDto) {
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);

    }

    @GetMapping("/{userId}")
    public UserDto findUserById(@PathVariable("userId") Long id) {
        return userService.findUserById(id);
    }

    @GetMapping("/identity-card/{identityCard}")
    public UserDto findByPanCardOrAadharCard(@PathVariable("identityCard") String id) {
        return userService.findByPanCardOrAadharCard(id);
    }

    @GetMapping("/location/{location}")
    public List<UserDto> findByStateOrCountry(@PathVariable("location") String location) {
        return userService.findByStateOrCountry(location);
    }


}
