package com.eshudata.repository;

import com.eshudata.pojo.Filesystem;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 */

public interface FilesystemRepository extends MongoRepository<Filesystem, String> {

    /**
     * 通过ip地址以及设备名称查找
     * @param ip
     * @param deviceName
     * @return Filesystem
     */
    Filesystem findByIpAndDeviceName (String ip, String deviceName);
}
