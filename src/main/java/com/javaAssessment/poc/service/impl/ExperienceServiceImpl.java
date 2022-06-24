package com.javaAssessment.poc.service.impl;

import com.javaAssessment.poc.dto.ExperienceDto;
import com.javaAssessment.poc.entity.Experience;
import com.javaAssessment.poc.entity.User;
import com.javaAssessment.poc.exception.UserException;
import com.javaAssessment.poc.user.repository.ExperienceRepository;
import com.javaAssessment.poc.user.repository.UserRepository;
import com.javaAssessment.poc.service.ExperienceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class ExperienceServiceImpl implements ExperienceService {
    @Autowired
    ExperienceRepository experienceRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public ExperienceDto Experience(ExperienceDto experienceDto) {
        if (experienceDto.getJoiningDate().isAfter(experienceDto.getExitDate())) {
            throw new UserException("Joining Date is always Greater than the Exit Date ", HttpStatus.BAD_REQUEST);

        } else {

            return entityToDto(experienceRepository.save(dtoTOEntity(experienceDto))) ;
        }
    }

    @Override
    public ExperienceDto findExperienceById(long id) {
        Experience byId = experienceRepository.findById(id).orElse(null);
        if (Objects.nonNull(byId)) {
            return entityToDto(byId);
        } else {
            throw new UserException("No record found for given id " + id, HttpStatus.BAD_REQUEST);
        }
    }

    private Experience dtoTOEntity(ExperienceDto experienceDto) {
        Experience experience = new Experience();
        BeanUtils.copyProperties(experienceDto, experience);
        User user = userRepository.findById(experienceDto.getUserId()).orElse(null);
        if (Objects.nonNull(user)) {
            experience.setUser(user);
        } else {
            throw new UserException("This user does not exit " + experienceDto.getUserId(), HttpStatus.BAD_REQUEST);
        } return experience;
    }

    private ExperienceDto entityToDto(Experience experience) {
        ExperienceDto experienceDto = new ExperienceDto();

        BeanUtils.copyProperties(experience, experienceDto);
        return experienceDto;


    }
}
