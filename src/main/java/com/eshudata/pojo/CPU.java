package com.eshudata.pojo;

import com.eshudata.common.pojo.OSCommon;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * CPU实体
 */
@Document(collection = "cpu")
public class CPU extends OSCommon {

    @Id
    public String id;
    // 空闲时间百分比
    private Double idlePct;
    // I/O请求挂起空闲时间百分比
    private Double iowaitPct;
    // 中断请求百分比
    private Double irqPct;
    // 进程可被执行的优先级
    private Double nicePct;
    // 软件中断百分比
    private Double softIrqPct;
    // 虚拟CPU等待实际CPU时间百分比
    private Double stealPct;
    // 系统模式时间百分比
    private Double systemPct;
    // 用户模式时间百分比
    private Double userPct;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getIdlePct() {
        return idlePct;
    }

    public void setIdlePct(Double idlePct) {
        this.idlePct = idlePct;
    }

    public Double getIowaitPct() {
        return iowaitPct;
    }

    public void setIowaitPct(Double iowaitPct) {
        this.iowaitPct = iowaitPct;
    }

    public Double getIrqPct() {
        return irqPct;
    }

    public void setIrqPct(Double irqPct) {
        this.irqPct = irqPct;
    }

    public Double getNicePct() {
        return nicePct;
    }

    public void setNicePct(Double nicePct) {
        this.nicePct = nicePct;
    }

    public Double getSoftIrqPct() {
        return softIrqPct;
    }

    public void setSoftIrqPct(Double softIrqPct) {
        this.softIrqPct = softIrqPct;
    }

    public Double getStealPct() {
        return stealPct;
    }

    public void setStealPct(Double stealPct) {
        this.stealPct = stealPct;
    }

    public Double getSystemPct() {
        return systemPct;
    }

    public void setSystemPct(Double systemPct) {
        this.systemPct = systemPct;
    }

    public Double getUserPct() {
        return userPct;
    }

    public void setUserPct(Double userPct) {
        this.userPct = userPct;
    }

    @Override
    public String toString() {
        return "CPU{" +
                "id='" + id + '\'' +
                ", idlePct=" + idlePct +
                ", iowaitPct=" + iowaitPct +
                ", irqPct=" + irqPct +
                ", nicePct=" + nicePct +
                ", softIrqPct=" + softIrqPct +
                ", stealPct=" + stealPct +
                ", systemPct=" + systemPct +
                ", userPct=" + userPct +
                '}';
    }
}
