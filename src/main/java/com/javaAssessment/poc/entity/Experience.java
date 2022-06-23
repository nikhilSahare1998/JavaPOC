package com.javaAssessment.poc.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Experience implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "experience_Id")
    private long experienceId;

    @Column(name = "company_Name")
    private String companyName;

    @Column(name = "joining_Date")
    private LocalDate joiningDate;

    @Column(name = "exit_Date")
    private LocalDate exitDate;

    @Column(name = "achievements")
    private String achievements;

    @Column(name = "CTC")
    private long ctc;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_Id", referencedColumnName = "user_Id")
    private User user;


}
