package com.eshudata.repository;

import com.eshudata.pojo.Fsstat;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 */

public interface FsstatRepository extends MongoRepository<Fsstat, String> {

    /**
     * 通过ip地址查找
     * @param ip
     * @return Fsstat
     */
    Fsstat findByIp(String ip);
}
