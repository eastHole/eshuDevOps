package com.eshudata.service;

import com.eshudata.repository.FilesystemRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class FilesystemService {
    @Autowired
    private FilesystemRepository filesystemRepository;

    /**
     * 解析Filesystem信息
     *
     * @param system
     */
    public void parseFilesystem(JsonNode system) {
        JsonNode filesystem = system.get("filesystem");
        // available
        long available = filesystem.get("available").asLong();
        // deviceName
        String deviceName = filesystem.get("device_name").asText();
        // files
        long files = filesystem.get("files").asLong();
        // free
        long free = filesystem.get("free").asLong();
        // freeFiles
        long freeFiles = filesystem.get("free_files").asLong();
        // mountPoint
        String mountPoint = filesystem.get("mount_point").asText();
        // total
        long total = filesystem.get("total").asLong();
        // used
        JsonNode used = filesystem.get("used");
        long usedBytes = used.get("bytes").asLong();
        double usedPct = used.get("pct").asDouble();
    }
}
