package com.eshudata.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * 性能指标解析服务
 */
@Service
@EnableAutoConfiguration
public class MetricService {

    @Autowired
    private ProcessService processService;

    @Autowired
    private CPUService cpuService;

    @Autowired
    private FilesystemService filesystemService;

    @Autowired
    private NetworkService networkService;

    @Autowired
    private FsstatService fsstatService;

    @Autowired
    private MemoryService memoryService;

    private static ObjectMapper mapper = new ObjectMapper();

    public void parseAndSave(String json) {
        try {
            JsonNode nodeTree = mapper.readTree(json);
            JsonNode time = nodeTree.get("@timestamp");
            JsonNode beat = nodeTree.get("beat");
            JsonNode metricSet = nodeTree.get("metricset");
            JsonNode system = nodeTree.get("system");
            // 获取时间戳
            DateTime timeStamp = new DateTime(time.asText());
            // 获取主机名
            String hostName = beat.get("hostname").asText();
            // 获取ip地址
            String ip = beat.get("name").asText();
            // 获取指标名称
            String metricName = metricSet.get("name").asText();
            // 获取指标延时
            Long metricRtt = metricSet.get("rtt").asLong();

            switch (metricName) {
                case "cpu":
                    cpuService.parseAndSaveCPU(system, ip, timeStamp, hostName, metricRtt);
                    break;
                case "load":
                    break;
                case "network":
                    networkService.parseAndSaveNetwork(system, ip, timeStamp, hostName, metricRtt);
                    break;
                case "filesystem":
                    filesystemService.parseAndSaveFilesystem(system, ip, timeStamp, hostName, metricRtt);
                    break;
                case "fsstat":
                    fsstatService.parseAndSaveFsstat(system, ip, timeStamp, hostName, metricRtt);
                    break;
                case "memory":
                    memoryService.parseAndSaveMemory(system, ip, timeStamp, hostName, metricRtt);
                    break;
                case "process":
                    processService.parseAndSaveProcess(system, ip, timeStamp, hostName, metricRtt);
                    break;
                default:
                    System.out.println("节点解析失败!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
