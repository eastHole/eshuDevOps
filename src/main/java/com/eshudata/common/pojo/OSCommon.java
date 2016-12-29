package com.eshudata.common.pojo;

import org.joda.time.DateTime;

/**
 * 系统通用参数
 */
public class OSCommon {
    // ip地址
    private String ip;
    // 主机名
    private String hostName;
    // 时间戳
    private DateTime timeStamp;
    // 指标时延
    private Long metricRtt;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public DateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(DateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Long getMetricRtt() {
        return metricRtt;
    }

    public void setMetricRtt(Long metricRtt) {
        this.metricRtt = metricRtt;
    }

    @Override
    public String toString() {
        return "OSCommon{" +
                "ip='" + ip + '\'' +
                ", hostName='" + hostName + '\'' +
                ", timeStamp=" + timeStamp +
                ", metricRtt=" + metricRtt +
                '}';
    }
}
