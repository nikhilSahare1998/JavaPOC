package com.javaAssessment.poc.configuration;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoConfig {
    @Bean(name = "userBackupProperties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.newdb2")
    public MongoProperties getUserBackup2Props() throws Exception {
        return new MongoProperties();
    }

    @Bean(name ="userBackupDBConfigMongoTemplate")
    public MongoTemplate userBackupDBConfigMongoTemplate() throws Exception {
        return new MongoTemplate(userBackupMongoDatabaseFactory(getUserBackup2Props()));
    }

    @Bean
    public MongoDatabaseFactory userBackupMongoDatabaseFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoClientDatabaseFactory(
                mongo.getUri()
        );
    }
}
