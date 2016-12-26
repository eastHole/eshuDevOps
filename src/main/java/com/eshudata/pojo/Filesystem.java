package com.eshudata.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 */
@Document
public class Filesystem extends OSCommon{

    // 文件系统可用大小
    private Long available;
    // 设备名称
    private Long deviceName;
    // 文件系统文件数目
    private Long files;
    // 文件系统空闲大小
    private Long free;
    // 文件系统空闲文件数
    private Long freeFiles;
    // 文件系统挂载点
    private Long mountPoint;
    // 文件系统总大小
    private Long total;
    // 文件系统已用大小
    private Long usedBytes;
    // 文件系统已用百分比
    private Long usedPct;

    public Long getAvailable() {
        return available;
    }

    public void setAvailable(Long available) {
        this.available = available;
    }

    public Long getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(Long deviceName) {
        this.deviceName = deviceName;
    }

    public Long getFiles() {
        return files;
    }

    public void setFiles(Long files) {
        this.files = files;
    }

    public Long getFree() {
        return free;
    }

    public void setFree(Long free) {
        this.free = free;
    }

    public Long getFreeFiles() {
        return freeFiles;
    }

    public void setFreeFiles(Long freeFiles) {
        this.freeFiles = freeFiles;
    }

    public Long getMountPoint() {
        return mountPoint;
    }

    public void setMountPoint(Long mountPoint) {
        this.mountPoint = mountPoint;
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

    public Long getUsedPct() {
        return usedPct;
    }

    public void setUsedPct(Long usedPct) {
        this.usedPct = usedPct;
    }

    @Override
    public String toString() {
        return "Filesystem{" +
                "available=" + available +
                ", deviceName=" + deviceName +
                ", files=" + files +
                ", free=" + free +
                ", freeFiles=" + freeFiles +
                ", mountPoint=" + mountPoint +
                ", total=" + total +
                ", usedBytes=" + usedBytes +
                ", usedPct=" + usedPct +
                '}';
    }
}
