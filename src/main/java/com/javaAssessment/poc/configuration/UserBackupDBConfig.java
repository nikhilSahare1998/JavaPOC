package com.javaAssessment.poc.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.javaAssessment.poc.repository.userbackup"},
        mongoTemplateRef = UserBackupDBConfig.MONGO_TEMPLATE
)
public class UserBackupDBConfig{
    public static final String MONGO_TEMPLATE = "userBackupDBConfigMongoTemplate";

}
