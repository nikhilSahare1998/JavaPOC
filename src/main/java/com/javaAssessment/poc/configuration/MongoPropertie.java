package com.javaAssessment.poc.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "mongodb")
public class MongoPropertie {


    private MongoPropertie primary = new MongoPropertie();

}
