package com.eshudata.repository;

import com.eshudata.pojo.Memory;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 */

public interface MemoryRepository extends MongoRepository<Memory, String> {
}
