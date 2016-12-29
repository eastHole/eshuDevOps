package com.eshudata.common.config;

import com.mongodb.MongoClientURI;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 *
 */
@ConfigurationProperties(prefix = "spring.data.mongodb")
public abstract class AbstractMongConfig {
    // MongoDB properties
    private String uri;

    /**
     * 创建MongoDbFactory
     * @return MongoDbFactory
     * @throws Exception
     */
    public MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(new MongoClientURI(uri));
    }

    /**
     * 创建MongoTemplate的工厂方法
     * @return
     * @throws Exception
     */
    abstract public MongoTemplate getMongoTemplate() throws Exception;

}
