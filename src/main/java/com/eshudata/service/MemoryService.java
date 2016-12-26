package com.eshudata.service;

import com.eshudata.repository.MemoryRepository;
import com.eshudata.repository.ProcessRepository;
import com.fasterxml.jackson.databind.JsonNode;
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

    /**
     * 解析Memory信息
     *
     * @param system
     */
    public void parseMemory(JsonNode system) {
        JsonNode memory = system.get("memory");
        // actual
        JsonNode actual = memory.get("actual");
        long actualFree = actual.get("free").asLong();
        JsonNode used = actual.get("used");
        long actualUsedBytes = used.get("bytes").asLong();
        double actualUsedPct = used.get("pct").asDouble();
        // free
        long free = memory.get("free").asLong();
        // swap
        JsonNode swap = memory.get("swap");
        long swapFree = swap.get("free").asLong();
        long swapTotal = swap.get("total").asLong();
        JsonNode swapUsed = swap.get("used");
        long swapUsedBytes = swapUsed.get("bytes").asLong();
        double swapUsedPct = swapUsed.get("pct").asDouble();
        // total
        long total = memory.get("total").asLong();
        // used
        JsonNode memoryUsed = memory.get("used");
        long usedBytes = memoryUsed.get("bytes").asLong();
        double usedPct = memoryUsed.get("pct").asDouble();
    }
}
