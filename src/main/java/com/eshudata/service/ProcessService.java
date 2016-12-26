package com.eshudata.service;

import com.eshudata.repository.ProcessRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class ProcessService {

    @Autowired
    private ProcessRepository processRepository;

    /**
     * 解析Process信息
     *
     * @param system
     */
    public void parseProcess(JsonNode system) {
        JsonNode process = system.get("process");
        if (process.has("cmdline")) {
            String cmdLine = process.get("cmdline").asText();
        }
        // cpu
        JsonNode cpu = system.get("cpu");
        DateTime cpuStartTime = new DateTime(cpu.get("start_time").asText());
        Double cpuTotalPct = cpu.get("total").get("pct").asDouble();
        // fd
        JsonNode limit = system.get("fd").get("limit");
        long fdLimitHard = limit.get("hard").asLong();
        long fdLimitSoft = limit.get("soft").asLong();
        long fdOpen = system.get("fd").get("open").asLong();
        // memory
        JsonNode memory = system.get("memory");
        long memorySize = memory.get("size").asLong();
        long memoryShare = memory.get("share").asLong();
        JsonNode rss = memory.get("rss");
        long memoryRssBytes = rss.get("bytes").asLong();
        double memoryRssPct = rss.get("pct").asDouble();
        // name
        String name = system.get("name").asText();
        // pgid
        long pgid = system.get("pgid").asLong();
        // pid
        long pid = system.get("pid").asLong();
        // ppid
        long ppid = system.get("ppid").asLong();
        // state
        String state = system.get("state").asText();
        // userName
        String userName = system.get("username").asText();
    }
}
