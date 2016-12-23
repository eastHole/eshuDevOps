package com.eshudata.repository;

import com.eshudata.pojo.Process;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 */

public interface ProcessRepository extends MongoRepository<Process, String> {
}
