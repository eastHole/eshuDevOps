package com.eshudata.pojo;

import com.eshudata.common.pojo.OSCommon;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 */
@Document
public class Memory extends OSCommon {

    @Id
    public String id;
    // 内存实际空闲大小
    private Long actualFree;
    // 内存实际使用大小
    private Long actualUsedBytes;
    // 内存实际使用百分比
    private Double actualUsedPct;
    // 内存空闲大小
    private Long free;
    // 虚拟内存交换分区空闲大小
    private Long swapFree;
    // 虚拟内存交换分区总大小
    private Long swapTotal;
    // 虚拟内存交换分区使用大小
    private Long swapUsedBytes;
    // 虚拟内存交换分区已使用百分比
    private Double swapUsedPct;
    // 内存总大小
    private Long total;
    // 内存已使用大小
    private Long usedBytes;
    // 内存已使用百分比
    private Double usedPct;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getActualFree() {
        return actualFree;
    }

    public void setActualFree(Long actualFree) {
        this.actualFree = actualFree;
    }

    public Long getActualUsedBytes() {
        return actualUsedBytes;
    }

    public void setActualUsedBytes(Long actualUsedBytes) {
        this.actualUsedBytes = actualUsedBytes;
    }

    public Double getActualUsedPct() {
        return actualUsedPct;
    }

    public void setActualUsedPct(Double actualUsedPct) {
        this.actualUsedPct = actualUsedPct;
    }

    public Long getFree() {
        return free;
    }

    public void setFree(Long free) {
        this.free = free;
    }

    public Long getSwapFree() {
        return swapFree;
    }

    public void setSwapFree(Long swapFree) {
        this.swapFree = swapFree;
    }

    public Long getSwapTotal() {
        return swapTotal;
    }

    public void setSwapTotal(Long swapTotal) {
        this.swapTotal = swapTotal;
    }

    public Long getSwapUsedBytes() {
        return swapUsedBytes;
    }

    public void setSwapUsedBytes(Long swapUsedBytes) {
        this.swapUsedBytes = swapUsedBytes;
    }

    public Double getSwapUsedPct() {
        return swapUsedPct;
    }

    public void setSwapUsedPct(Double swapUsedPct) {
        this.swapUsedPct = swapUsedPct;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getUsedBytes() {
        return usedBytes;
    }

    public void setUsedBytes(Long usedBytes) {
        this.usedBytes = usedBytes;
    }

    public Double getUsedPct() {
        return usedPct;
    }

    public void setUsedPct(Double usedPct) {
        this.usedPct = usedPct;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "id='" + id + '\'' +
                ", actualFree=" + actualFree +
                ", actualUsedBytes=" + actualUsedBytes +
                ", actualUsedPct=" + actualUsedPct +
                ", free=" + free +
                ", swapFree=" + swapFree +
                ", swapTotal=" + swapTotal +
                ", swapUsedBytes=" + swapUsedBytes +
                ", swapUsedPct=" + swapUsedPct +
                ", total=" + total +
                ", usedBytes=" + usedBytes +
                ", usedPct=" + usedPct +
                '}';
    }
}
