package com.eshudata;

import com.eshudata.service.CPUService;
import com.eshudata.service.MetricService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.util.StringUtils;

@SpringBootApplication
public class EshuDevOpsApplication {

    private static final Logger LOGGER = LogManager.getLogger(CPUService.class);

    @Autowired
    private MetricService metricService;

    @KafkaListener(topics = "os-metricbeat")
    public void processMsg(String content) {
        if (StringUtils.isEmpty(content)) {
            LOGGER.info("No messages from kafka...");
        }
        metricService.parseAndSave(content);
    }

    public static void main(String[] args) {
        SpringApplication.run(EshuDevOpsApplication.class, args);
    }

}
