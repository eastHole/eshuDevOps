package com.eshudata.service;

import com.eshudata.pojo.Fsstat;
import com.eshudata.repository.FsstatRepository;
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
public class FsstatService {

    @Autowired
    private FsstatRepository fsstatRepository;

    private static final Logger LOGGER = LogManager.getLogger(FsstatService.class);

    private Fsstat fsstat = null;

    /**
     * 解析Fsstat信息
     *
     * @param system
     */
    public void parseAndSaveFsstat(JsonNode system, String ip, DateTime timeStamp, String hostName, Long metricRtt) {
        JsonNode node = system.get("fsstat");
        // count
        long count = node.get("count").asLong();
        // totalFiles
        long totalFiles = node.get("total_files").asLong();
        // totalSize
        JsonNode totalSize = node.get("total_size");
        long totalSizeFree = totalSize.get("free").asLong();
        long totalSizeTotal = totalSize.get("total").asLong();
        long totalSizeUsed = totalSize.get("used").asLong();
        fsstat = new Fsstat();
        fsstat.setIp(ip);
        fsstat.setTimeStamp(timeStamp);
        fsstat.setMetricRtt(metricRtt);
        fsstat.setHostName(hostName);
        fsstat.setCount(count);
        fsstat.setTotalFiles(totalFiles);
        fsstat.setTotalSizeFree(totalSizeFree);
        fsstat.setTotalSizeTotal(totalSizeTotal);
        fsstat.setTotalSizeUsed(totalSizeUsed);
        Fsstat result = fsstatRepository.findByIp(ip);
        if (result != null) {
            fsstat.setId(result.getId());
            fsstatRepository.save(fsstat);
            LOGGER.info("更新Fsstat成功:{id = " + fsstat.getId() + ",ip = " + fsstat.getIp() + "}");
        } else {
            fsstatRepository.insert(fsstat);
            LOGGER.info("新增Fsstat成功:{ip = " + fsstat.getIp() + "}");
        }
    }
}
