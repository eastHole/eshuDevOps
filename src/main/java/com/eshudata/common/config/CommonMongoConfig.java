package com.eshudata.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public abstract class CommonMongoConfig extends AbstractMongConfig {
    /**
     * @return MongoTemplate
     * @throws Exception
     * @Bean 为MongoTemplate实例起了别名
     */
    @Override
    public @Bean MongoTemplate getMongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory());
    }
}
