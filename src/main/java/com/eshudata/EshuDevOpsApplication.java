package com.eshudata;

import com.eshudata.service.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class EshuDevOpsApplication implements CommandLineRunner {

    @Autowired
    private MetricService metricService;

    public static void main(String[] args) {
        SpringApplication.run(EshuDevOpsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String cpu = "{\"@timestamp\":\"2016-12-22T08:37:21.312Z\",\"beat\":{\"hostname\":\"eshubigdata03\",\"name\":\"192.168.3.83\",\"version\":\"5.0.1\"},\"metricset\":{\"module\":\"system\",\"name\":\"cpu\",\"rtt\":1062},\"system\":{\"cpu\":{\"idle\":{\"pct\":0.980800},\"iowait\":{\"pct\":0.001000},\"irq\":{\"pct\":0.000000},\"nice\":{\"pct\":0.000000},\"softirq\":{\"pct\":0.001000},\"steal\":{\"pct\":0.000000},\"system\":{\"pct\":0.007100},\"user\":{\"pct\":0.010100}}},\"type\":\"metricsets\"}";
        String filesystem = "{\"@timestamp\":\"2016-12-19T08:37:21.314Z\",\"beat\":{\"hostname\":\"eshubigdata03\",\"name\":\"192.168.3.83\",\"version\":\"5.0.1\"},\"metricset\":{\"module\":\"system\",\"name\":\"filesystem\",\"rtt\":331},\"system\":{\"filesystem\":{\"available\":29083803648,\"device_name\":\"/dev/sda3\",\"files\":2346512,\"free\":31005790208,\"free_files\":2202318,\"mount_point\":\"/\",\"total\":37836492800,\"used\":{\"bytes\":6830702592,\"pct\":0.180500}}},\"type\":\"metricsets\"}";
        String network = "{\"@timestamp\":\"2016-12-19T08:37:21.314Z\",\"beat\":{\"hostname\":\"eshubigdata03\",\"name\":\"192.168.3.83\",\"version\":\"5.0.1\"},\"metricset\":{\"module\":\"system\",\"name\":\"network\",\"rtt\":233},\"system\":{\"network\":{\"in\":{\"bytes\":247334266,\"dropped\":0,\"errors\":0,\"packets\":1597248},\"name\":\"eth0\",\"out\":{\"bytes\":2878751510,\"dropped\":0,\"errors\":0,\"packets\":2869592}}},\"type\":\"metricsets\"}";
        String fsstat = "{\"@timestamp\":\"2016-12-19T08:37:21.315Z\",\"beat\":{\"hostname\":\"eshubigdata03\",\"name\":\"192.168.3.83\",\"version\":\"5.0.1\"},\"metricset\":{\"module\":\"system\",\"name\":\"fsstat\",\"rtt\":167},\"system\":{\"fsstat\":{\"count\":8,\"total_files\":2661743,\"total_size\":{\"free\":32246605824,\"total\":39117272064,\"used\":6870666240}}},\"type\":\"metricsets\"}";
        String memory = "{\"@timestamp\":\"2016-12-19T08:37:21.315Z\",\"beat\":{\"hostname\":\"eshubigdata03\",\"name\":\"192.168.3.83\",\"version\":\"5.0.1\"},\"metricset\":{\"module\":\"system\",\"name\":\"memory\",\"rtt\":349},\"system\":{\"memory\":{\"actual\":{\"free\":886906880,\"used\":{\"bytes\":1065406464,\"pct\":0.545700}},\"free\":468238336,\"swap\":{\"free\":4194295808,\"total\":4194295808,\"used\":{\"bytes\":0,\"pct\":0.000000}},\"total\":1952313344,\"used\":{\"bytes\":1484075008,\"pct\":0.760200}}},\"type\":\"metricsets\"}";
        String process1 = "{\"@timestamp\":\"2016-12-19T08:37:21.348Z\",\"beat\":{\"hostname\":\"eshubigdata03\",\"name\":\"192.168.3.83\",\"version\":\"5.0.1\"},\"metricset\":{\"module\":\"system\",\"name\":\"process\",\"rtt\":56007},\"system\":{\"process\":{\"cmdline\":\"/sbin/init\",\"cpu\":{\"start_time\":\"2016-12-14T05:36:40.000Z\",\"total\":{\"pct\":0.000000}},\"fd\":{\"limit\":{\"hard\":4096,\"soft\":1024},\"open\":9},\"memory\":{\"rss\":{\"bytes\":1585152,\"pct\":0.000800},\"share\":1261568,\"size\":19820544},\"name\":\"init\",\"pgid\":1,\"pid\":1,\"ppid\":0,\"state\":\"sleeping\",\"username\":\"root\"}},\"type\":\"metricsets\"}";
        String process2 = "{\"@timestamp\":\"2016-12-19T08:37:21.348Z\",\"beat\":{\"hostname\":\"eshubigdata03\",\"name\":\"192.168.3.83\",\"version\":\"5.0.1\"},\"metricset\":{\"module\":\"system\",\"name\":\"process\",\"rtt\":56007},\"system\":{\"process\":{\"cpu\":{\"start_time\":\"2016-12-14T05:36:40.000Z\",\"total\":{\"pct\":0.000000}},\"fd\":{\"limit\":{\"hard\":4096,\"soft\":1024},\"open\":0},\"memory\":{\"rss\":{\"bytes\":0,\"pct\":0.000000},\"share\":0,\"size\":0},\"name\":\"kthreadd\",\"pgid\":0,\"pid\":2,\"ppid\":0,\"state\":\"sleeping\",\"username\":\"root\"}},\"type\":\"metricsets\"}";
        metricService.parseAndSave(process2);
    }
}
