package com.javaAssessment.poc.controller;

import com.javaAssessment.poc.dto.UserDto;
import com.javaAssessment.poc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/user")
@Slf4j
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody @Valid UserDto userDto) {
        log.info("");
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
