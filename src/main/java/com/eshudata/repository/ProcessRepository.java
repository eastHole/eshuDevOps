package com.eshudata.repository;

import com.eshudata.pojo.Process;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 */

public interface ProcessRepository extends MongoRepository<Process, String> {

    /**
     * 通过ip地址以及进程名称查询
     * @param ip
     * @param name
     * @return Process
     */
    Process findByIpAndName (String ip, String name);
}
