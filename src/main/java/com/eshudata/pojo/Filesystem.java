package com.eshudata.pojo;

import com.eshudata.common.pojo.OSCommon;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 */
@Document
public class Filesystem extends OSCommon {

    @Id
    public String id;
    // 文件系统可用大小
    private Long available;
    // 设备名称
    private String deviceName;
    // 文件系统文件数目
    private Long files;
    // 文件系统空闲大小
    private Long free;
    // 文件系统空闲文件数
    private Long freeFiles;
    // 文件系统挂载点
    private String mountPoint;
    // 文件系统总大小
    private Long total;
    // 文件系统已用大小
    private Long usedBytes;
    // 文件系统已用百分比
    private Double usedPct;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getAvailable() {
        return available;
    }

    public void setAvailable(Long available) {
        this.available = available;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
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

    public String getMountPoint() {
        return mountPoint;
    }

    public void setMountPoint(String mountPoint) {
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

    public Double getUsedPct() {
        return usedPct;
    }

    public void setUsedPct(Double usedPct) {
        this.usedPct = usedPct;
    }

    @Override
    public String toString() {
        return "Filesystem{" +
                "id='" + id + '\'' +
                ", available=" + available +
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
