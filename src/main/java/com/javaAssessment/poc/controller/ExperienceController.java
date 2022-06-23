package com.javaAssessment.poc.controller;

import com.javaAssessment.poc.dto.ExperienceDto;
import com.javaAssessment.poc.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@ControllerAdvice
@Validated
@RequestMapping("/api/experience")
public class ExperienceController {
    @Autowired
    ExperienceService experienceService;

    @PostMapping
    public ResponseEntity<Object> createExperience(@RequestBody @Valid ExperienceDto experienceDto) {
        return new ResponseEntity<>(experienceService.Experience(experienceDto), HttpStatus.CREATED);
    }

    @GetMapping("/{UserId}")
    public ExperienceDto findExperienceById(@PathVariable("UserId") long id) {
        return experienceService.findExperienceById(id);
    }

}
