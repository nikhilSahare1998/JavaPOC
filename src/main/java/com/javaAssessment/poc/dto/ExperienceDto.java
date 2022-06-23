package com.javaAssessment.poc.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class ExperienceDto {

    private long experienceId;

    @NotBlank(message = "companyName.required")
    private String companyName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate joiningDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate exitDate;

    @NotBlank(message = "achievements.required")
    @Column(name = "achievements")
    private String achievements;

    @NotNull(message = "ctc.required")
    @Column(name = "CTC")
    private long ctc;

    @NotNull(message = "user_Id.required")
    private long userId;
}
