package com.eshudata.repository;

import com.eshudata.pojo.CPU;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 */

public interface CPURepository extends MongoRepository<CPU, String> {
}
