package com.eshudata.service;

import com.eshudata.pojo.Process;
import com.eshudata.repository.ProcessRepository;
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
public class ProcessService {

    @Autowired
    private ProcessRepository processRepository;

    private Process process = null;

    private static final Logger LOGGER = LogManager.getLogger(ProcessService.class);

    /**
     * 解析Process信息
     *
     * @param system
     */
    public void parseAndSaveProcess(JsonNode system, String ip, DateTime timeStamp, String hostName, Long metricRtt) {
        JsonNode node = system.get("process");
        // cpu
        JsonNode cpu = node.get("cpu");
        DateTime cpuStartTime = new DateTime(cpu.get("start_time").asText());
        Double cpuTotalPct = cpu.get("total").get("pct").asDouble();
        // fd
        JsonNode limit = node.get("fd").get("limit");
        long fdLimitHard = limit.get("hard").asLong();
        long fdLimitSoft = limit.get("soft").asLong();
        long fdOpen = node.get("fd").get("open").asLong();
        // memory
        JsonNode memory = node.get("memory");
        long memorySize = memory.get("size").asLong();
        long memoryShare = memory.get("share").asLong();
        JsonNode rss = memory.get("rss");
        long memoryRssBytes = rss.get("bytes").asLong();
        double memoryRssPct = rss.get("pct").asDouble();
        // name
        String name = node.get("name").asText();
        // pgid
        long pgid = node.get("pgid").asLong();
        // pid
        long pid = node.get("pid").asLong();
        // ppid
        long ppid = node.get("ppid").asLong();
        // state
        String state = node.get("state").asText();
        // userName
        String userName = node.get("username").asText();
        process = new Process();
        process.setIp(ip);
        process.setTimeStamp(timeStamp);
        process.setHostName(hostName);
        process.setMetricRtt(metricRtt);
        // 如果包含cmdline字段,则保存至实体
        if (node.has("cmdline")) {
            String cmdLine = node.get("cmdline").asText();
            process.setCmdLine(cmdLine);
        }
        process.setCpuStartTime(cpuStartTime);
        process.setCpuTotalPct(cpuTotalPct);
        process.setFdLimitHard(fdLimitHard);
        process.setFdLimitSoft(fdLimitSoft);
        process.setFdOpen(fdOpen);
        process.setMemorySize(memorySize);
        process.setMemoryShare(memoryShare);
        process.setMemoryRssBytes(memoryRssBytes);
        process.setMemoryRssPct(memoryRssPct);
        process.setName(name);
        process.setPgid(pgid);
        process.setPid(pid);
        process.setPpid(ppid);
        process.setState(state);
        process.setUserName(userName);
        Process result = processRepository.findByIpAndName(ip, name);
        if (result != null) {
            process.setId(result.getId());
            processRepository.save(process);
            LOGGER.info("更新Process成功:{id = " + process.getId() + ",ip = " + process.getIp() + "}");
        } else {
            processRepository.insert(process);
            LOGGER.info("新增Process成功:{ip = " + process.getIp() + "}");
        }
    }
}
