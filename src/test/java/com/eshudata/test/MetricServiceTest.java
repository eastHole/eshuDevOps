package com.eshudata.test;

import com.eshudata.service.MetricService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class MetricServiceTest {

    @Autowired
    private MetricService metricService;

    @Test
    public void parseAndSave() throws Exception {
        String json = "{\"@timestamp\":\"2016-12-19T08:37:21.312Z\",\"beat\":{\"hostname\":\"eshubigdata03\",\"name\":\"192.168.3.83\",\"version\":\"5.0.1\"},\"metricset\":{\"module\":\"system\",\"name\":\"cpu\",\"rtt\":1062},\"system\":{\"cpu\":{\"idle\":{\"pct\":0.980800},\"iowait\":{\"pct\":0.001000},\"irq\":{\"pct\":0.000000},\"nice\":{\"pct\":0.000000},\"softirq\":{\"pct\":0.001000},\"steal\":{\"pct\":0.000000},\"system\":{\"pct\":0.007100},\"user\":{\"pct\":0.010100}}},\"type\":\"metricsets\"}";
        metricService.parseAndSave(json);
    }

}