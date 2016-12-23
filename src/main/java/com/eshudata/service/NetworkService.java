package com.eshudata.service;

import com.eshudata.repository.NetworkRepository;
import com.eshudata.repository.ProcessRepository;
import com.fasterxml.jackson.databind.JsonNode;
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

    /**
     * 解析Network信息
     *
     * @param system
     */
    public void parseNetwork(JsonNode system) {
        JsonNode network = system.get("network");
        // name
        String interfaceName = network.get("name").asText();
        // in
        JsonNode in = network.get("in");
        long inBytes = in.get("bytes").asLong();
        long inDropped = in.get("dropped").asLong();
        long inErrors = in.get("errors").asLong();
        long inPackets = in.get("packets").asLong();
        // out
        JsonNode out = network.get("out");
        long outBytes = out.get("bytes").asLong();
        long outDropped = out.get("dropped").asLong();
        long outErrors = out.get("errors").asLong();
        long outPackets = out.get("packets").asLong();
    }
}
