package com.eshudata.repository;

import com.eshudata.pojo.CPU;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 */
public interface CPURepository extends MongoRepository<CPU, String> {

    /**
     * 通过ip查找
     * @param ip
     * @return
     */
    CPU findByIp(String ip);
}
