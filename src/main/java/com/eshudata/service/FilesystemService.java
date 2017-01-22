package com.eshudata.service;

import com.eshudata.pojo.Filesystem;
import com.eshudata.repository.FilesystemRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class FilesystemService {

    @Autowired
    private FilesystemRepository filesystemRepository;

    private static final Logger LOGGER = LogManager.getLogger(FilesystemService.class);

    private Filesystem filesystem = null;

    /**
     * 解析Filesystem信息并保存如MongoDB中。
     * 由于后台CPU信息对应于某台设备(某个ip地址)存在多条记录,此处通过同一ip下的不同设备名称(deviceName)进行逻辑判断。
     *
     * @param system
     */
    public void parseAndSaveFilesystem(JsonNode system, String ip, DateTime timeStamp, String hostName, Long metricRtt) {
        JsonNode node = system.get("filesystem");
        // available
        long available = node.get("available").asLong();
        // deviceName
        String deviceName = node.get("device_name").asText();
        // files
        long files = node.get("files").asLong();
        // free
        long free = node.get("free").asLong();
        // freeFiles
        long freeFiles = node.get("free_files").asLong();
        // mountPoint
        String mountPoint = node.get("mount_point").asText();
        // total
        long total = node.get("total").asLong();
        // used
        JsonNode used = node.get("used");
        long usedBytes = used.get("bytes").asLong();
        double usedPct = used.get("pct").asDouble();
        filesystem = new Filesystem();
        filesystem.setIp(ip);
        filesystem.setHostName(hostName);
        filesystem.setTimeStamp(timeStamp);
        filesystem.setMetricRtt(metricRtt);
        filesystem.setAvailable(available);
        filesystem.setDeviceName(deviceName);
        filesystem.setFiles(files);
        filesystem.setFree(free);
        filesystem.setFreeFiles(freeFiles);
        filesystem.setMountPoint(mountPoint);
        filesystem.setTotal(total);
        filesystem.setUsedBytes(usedBytes);
        filesystem.setUsedPct(usedPct);
        Filesystem result = filesystemRepository.findByIpAndDeviceName(ip, deviceName);
        if (result != null) {
            filesystem.setId(result.getId());
            filesystemRepository.save(filesystem);
            LOGGER.info("更新Filesystem成功:{id = " + filesystem.getId() + ",ip = " + filesystem.getIp() + "}");
        } else {
            filesystemRepository.insert(filesystem);
            LOGGER.info("新增Filesystem成功:{ip = " + filesystem.getIp() + "}");
        }
    }
}
