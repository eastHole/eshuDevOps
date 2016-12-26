package com.eshudata.service;

import com.eshudata.repository.CPURepository;
import com.eshudata.repository.ProcessRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class CPUService {

    @Autowired
    private CPURepository cpuRepository;

    /**
     * 解析CPU信息,封装为CPU实体对象
     *
     * @param system
     */
    public void parseCPU(JsonNode system) {
        JsonNode cpu = system.get("cpu");
        // idle
        double idlePct = cpu.get("idle").get("pct").asDouble();
        // iowait
        double iowaitPct = cpu.get("iowait").get("pct").asDouble();
        // irq
        double irqPct = cpu.get("irq").get("pct").asDouble();
        // nice
        double nicePct = cpu.get("nice").get("pct").asDouble();
        // softIrq
        double softIrqPct = cpu.get("softirq").get("pct").asDouble();
        // steal
        double stealPct = cpu.get("steal").get("pct").asDouble();
        // system
        double systemPct = cpu.get("system").get("pct").asDouble();
        // user
        double userPct = cpu.get("user").get("pct").asDouble();
    }
}
