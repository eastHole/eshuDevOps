package com.eshudata.service;

import com.eshudata.pojo.Network;
import com.eshudata.repository.NetworkRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class NetworkService {

    @Autowired
    private NetworkRepository networkRepository;

    private static final Logger LOGGER = LogManager.getLogger(NetworkService.class);

    private Network network = null;

    /**
     * 解析Network信息
     *
     * @param system
     */
    public void parseAndSaveNetwork(JsonNode system, String ip, DateTime timeStamp, String hostName, Long metricRtt) {
        JsonNode node = system.get("network");
        // name
        String name = node.get("name").asText();
        // in
        JsonNode in = node.get("in");
        long inBytes = in.get("bytes").asLong();
        long inDropped = in.get("dropped").asLong();
        long inErrors = in.get("errors").asLong();
        long inPackets = in.get("packets").asLong();
        // out
        JsonNode out = node.get("out");
        long outBytes = out.get("bytes").asLong();
        long outDropped = out.get("dropped").asLong();
        long outErrors = out.get("errors").asLong();
        long outPackets = out.get("packets").asLong();
        network = new Network();
        network.setIp(ip);
        network.setTimeStamp(timeStamp);
        network.setHostName(hostName);
        network.setMetricRtt(metricRtt);
        network.setName(name);
        network.setInBytes(inBytes);
        network.setInDropped(inDropped);
        network.setInErrors(inErrors);
        network.setInPackets(inPackets);
        network.setOutBytes(outBytes);
        network.setOutDropped(outDropped);
        network.setOutErrors(outErrors);
        network.setOutPackets(outPackets);
        Network result = networkRepository.findByIpAndName(ip, name);
        if (result != null) {
            network.setId(result.getId());
            networkRepository.save(network);
            LOGGER.info("更新Network成功:{id = " + network.getId() + ",ip = " + network.getIp() + "}");
        } else {
            networkRepository.insert(network);
            LOGGER.info("新增Network成功:{ip = " + network.getIp() + "}");
        }
    }
}
