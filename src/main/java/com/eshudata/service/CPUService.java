package com.eshudata.service;

import com.eshudata.pojo.CPU;
import com.eshudata.repository.CPURepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 解析并写入CPU信息
 */
@Service
public class CPUService {

    @Autowired
    private CPURepository cpuRepository;

    private static final Logger LOGGER = LogManager.getLogger(CPUService.class);

    private CPU cpu = null;

    /**
     * 解析CPU信息并保存到MongoDB中。
     * 由于后台CPU信息同一时刻对应于某台设备(某个ip地址)只存在一条数据,此处通过ip地址进行逻辑判断。
     *
     * @param system
     */
    public void parseAndSaveCPU(JsonNode system, String ip, DateTime timeStamp, String hostName, Long metricRtt) {
        JsonNode node = system.get("cpu");
        // idle
        double idlePct = node.get("idle").get("pct").asDouble();
        // iowait
        double iowaitPct = node.get("iowait").get("pct").asDouble();
        // irq
        double irqPct = node.get("irq").get("pct").asDouble();
        // nice
        double nicePct = node.get("nice").get("pct").asDouble();
        // softIrq
        double softIrqPct = node.get("softirq").get("pct").asDouble();
        // steal
        double stealPct = node.get("steal").get("pct").asDouble();
        // system
        double systemPct = node.get("system").get("pct").asDouble();
        // user
        double userPct = node.get("user").get("pct").asDouble();
        cpu = new CPU();
        cpu.setIp(ip);
        cpu.setTimeStamp(timeStamp);
        cpu.setHostName(hostName);
        cpu.setMetricRtt(metricRtt);
        cpu.setIdlePct(idlePct);
        cpu.setIowaitPct(iowaitPct);
        cpu.setIrqPct(irqPct);
        cpu.setNicePct(nicePct);
        cpu.setSoftIrqPct(softIrqPct);
        cpu.setStealPct(stealPct);
        cpu.setSystemPct(systemPct);
        cpu.setUserPct(userPct);
        // 通过ip地址判断数据在后台是否存在
        CPU result = cpuRepository.findByIp(ip);
        if (result != null) {
            cpu.setId(result.getId());
            cpuRepository.save(cpu);
            LOGGER.info("更新CPU成功:{id = " + cpu.getId() + ",ip = " + cpu.getIp() + "}");
        } else {
            cpuRepository.insert(cpu);
            LOGGER.info("新增CPU成功:{ip = " + cpu.getIp() + "}");
        }
    }
}
