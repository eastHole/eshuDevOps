package com.eshudata.repository;

import com.eshudata.pojo.Network;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 */

public interface NetworkRepository extends MongoRepository<Network, String> {
    /**
     * 通过ip地址以及网络接口名称茶盏
     * @param ip
     * @param name
     * @return Network
     */
    Network findByIpAndName(String ip, String name);
}
