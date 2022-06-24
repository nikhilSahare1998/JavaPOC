package com.javaAssessment.poc.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;


@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(MongoPropertie.class)
public class MongoTemplate {
    private final MongoPropertie mongoPropertie;
/*
    @Primary
    @Bean(name = "mongoTemplate")
    public MongoTemplate primaryMongoTemplate() throws Exception {
        return new MongoTemplate(primaryFactory(this.mongoPropertie.getPrimary());
    }

    @Bean
    @Primary
    public MongoDbFactory primaryFactory(final MongoProperties mongo)  {
        return new SimpleMongoDbFactory(new MongoClient(mongo.getHost(), mongo.getPort()),
                mongo.getDatabase());
    }*/

    @Bean
    public MongoClientFactoryBean mongoClientFactoryBean(final MongoProperties mongo) throws Exception {
        MongoClientFactoryBean factoryBean = new MongoClientFactoryBean();
        factoryBean.setHost(mongo.getHost());
        factoryBean.setHost(String.valueOf(mongo.getPort()));
        return factoryBean;
    }
}
