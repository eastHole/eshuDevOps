package com.eshudata.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 */
@Document
public class Network extends OSCommon{

    // 网络接口名称
    private String name;
    // 入口网络流量
    private Long inBytes;
    // 入口网络丢包数
    private Long inDropped;
    // 入口网络错包数
    private Long inErrors;
    // 入口网络报文数
    private Long inPackets;
    // 出口网络流量
    private Long outBytes;
    // 出口网络丢包数
    private Long outDropped;
    // 出口网络错包数
    private Long outErrors;
    // 网络报文数
    private Long outPackets;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getInBytes() {
        return inBytes;
    }

    public void setInBytes(Long inBytes) {
        this.inBytes = inBytes;
    }

    public Long getInDropped() {
        return inDropped;
    }

    public void setInDropped(Long inDropped) {
        this.inDropped = inDropped;
    }

    public Long getInErrors() {
        return inErrors;
    }

    public void setInErrors(Long inErrors) {
        this.inErrors = inErrors;
    }

    public Long getInPackets() {
        return inPackets;
    }

    public void setInPackets(Long inPackets) {
        this.inPackets = inPackets;
    }

    public Long getOutBytes() {
        return outBytes;
    }

    public void setOutBytes(Long outBytes) {
        this.outBytes = outBytes;
    }

    public Long getOutDropped() {
        return outDropped;
    }

    public void setOutDropped(Long outDropped) {
        this.outDropped = outDropped;
    }

    public Long getOutErrors() {
        return outErrors;
    }

    public void setOutErrors(Long outErrors) {
        this.outErrors = outErrors;
    }

    public Long getOutPackets() {
        return outPackets;
    }

    public void setOutPackets(Long outPackets) {
        this.outPackets = outPackets;
    }

    @Override
    public String toString() {
        return "Network{" +
                "name='" + name + '\'' +
                ", inBytes=" + inBytes +
                ", inDropped=" + inDropped +
                ", inErrors=" + inErrors +
                ", inPackets=" + inPackets +
                ", outBytes=" + outBytes +
                ", outDropped=" + outDropped +
                ", outErrors=" + outErrors +
                ", outPackets=" + outPackets +
                '}';
    }
}
