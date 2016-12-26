package com.eshudata.service;

import com.eshudata.repository.FsstatRepository;
import com.eshudata.repository.ProcessRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class FsstatService {

    @Autowired
    private FsstatRepository fsstatRepository;

    /**
     * 解析Fsstat信息
     *
     * @param system
     */
    public void parseFsstat(JsonNode system) {
        JsonNode fsstat = system.get("fsstat");
        // count
        long count = fsstat.get("count").asLong();
        // totalFiles
        long totalFiles = fsstat.get("total_files").asLong();
        // totalSize
        JsonNode totalSize = fsstat.get("total_size");
        long totalSizeFree = totalSize.get("free").asLong();
        long totalSizeTotal = totalSize.get("total").asLong();
        long totalSizeUsed = totalSize.get("used").asLong();

    }
}
