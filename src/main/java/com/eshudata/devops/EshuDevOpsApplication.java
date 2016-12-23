package com.eshudata.devops;

import com.eshudata.service.MetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EshuDevOpsApplication implements CommandLineRunner {

    @Autowired
    private MetricService metricService;

    public static void main(String[] args) {
        SpringApplication.run(EshuDevOpsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
