package com.eshudata.service;

import com.eshudata.pojo.Memory;
import com.eshudata.repository.MemoryRepository;
import com.eshudata.repository.ProcessRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class MemoryService {

    @Autowired
    private MemoryRepository memoryRepository;

    private static final Logger LOGGER = LogManager.getLogger(MemoryService.class);

    private Memory memory = null;

    /**
     * 解析Memory信息
     *
     * @param system
     */
    public void parseAndSaveMemory(JsonNode system, String ip, DateTime timeStamp, String hostName, Long metricRtt) {
        JsonNode node = system.get("memory");
        // actual
        JsonNode actual = node.get("actual");
        long actualFree = actual.get("free").asLong();
        JsonNode used = actual.get("used");
        long actualUsedBytes = used.get("bytes").asLong();
        double actualUsedPct = used.get("pct").asDouble();
        // free
        long free = node.get("free").asLong();
        // swap
        JsonNode swap = node.get("swap");
        long swapFree = swap.get("free").asLong();
        long swapTotal = swap.get("total").asLong();
        JsonNode swapUsed = swap.get("used");
        long swapUsedBytes = swapUsed.get("bytes").asLong();
        double swapUsedPct = swapUsed.get("pct").asDouble();
        // total
        long total = node.get("total").asLong();
        // used
        JsonNode memoryUsed = node.get("used");
        long usedBytes = memoryUsed.get("bytes").asLong();
        double usedPct = memoryUsed.get("pct").asDouble();
        memory = new Memory();
        memory.setIp(ip);
        memory.setTimeStamp(timeStamp);
        memory.setHostName(hostName);
        memory.setMetricRtt(metricRtt);
        memory.setActualFree(actualFree);
        memory.setActualUsedBytes(actualUsedBytes);
        memory.setActualUsedPct(actualUsedPct);
        memory.setFree(free);
        memory.setSwapFree(swapFree);
        memory.setSwapTotal(swapTotal);
        memory.setSwapUsedBytes(swapUsedBytes);
        memory.setSwapUsedPct(swapUsedPct);
        memory.setTotal(total);
        memory.setUsedBytes(usedBytes);
        memory.setUsedPct(usedPct);
        Memory result = memoryRepository.findByIp(ip);
        if (result != null) {
            memory.setId(result.getId());
            memoryRepository.save(memory);
            LOGGER.info("更新Memory成功:{id = " + memory.getId() + ",ip = " + memory.getIp() + "}");
        } else {
            memoryRepository.insert(memory);
            LOGGER.info("新增Memory成功:{ip = " + memory.getIp() + "}");
        }
    }
}
