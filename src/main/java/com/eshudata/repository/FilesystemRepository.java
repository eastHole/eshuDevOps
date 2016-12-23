package com.eshudata.repository;

import com.eshudata.pojo.Filesystem;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 */

public interface FilesystemRepository extends MongoRepository<Filesystem, String> {
}
