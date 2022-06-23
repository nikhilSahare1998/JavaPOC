package com.javaAssessment.poc.service;

import com.javaAssessment.poc.dto.ExperienceDto;

public interface ExperienceService {

    ExperienceDto findExperienceById(long id);

    ExperienceDto Experience(ExperienceDto experienceDto);
}
