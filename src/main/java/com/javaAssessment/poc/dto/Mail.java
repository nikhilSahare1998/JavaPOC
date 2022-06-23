package com.javaAssessment.poc.dto;

import lombok.Data;

import java.util.List;

@Data
public class Mail {

    private String mailFrom;

    private List<String> mailList;

    private String mailSubject;

    private String mailContent;

    private String contentType;

    private String mailTo;
}
