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
        DateTime startTime = new DateTime(cpu.get("start_time").asText());
        // fd
        JsonNode fd = system.get("fd");
        // memory
        JsonNode memory = system.get("memory");
        // name
        String processName = system.get("name").asText();
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
