package com.eshudata.pojo;

import com.eshudata.common.pojo.OSCommon;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 */
@Document
public class Fsstat extends OSCommon {

    @Id
    public String id;
    // 文件系统数目
    private Long count;
    // 文件系统总文件数
    private Long totalFiles;
    // 文件系统空闲大小
    private Long totalSizeFree;
    // 文件系统总大小
    private Long totalSizeTotal;
    // 文件系统已用大小
    private Long totalSizeUsed;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getTotalFiles() {
        return totalFiles;
    }

    public void setTotalFiles(Long totalFiles) {
        this.totalFiles = totalFiles;
    }

    public Long getTotalSizeFree() {
        return totalSizeFree;
    }

    public void setTotalSizeFree(Long totalSizeFree) {
        this.totalSizeFree = totalSizeFree;
    }

    public Long getTotalSizeTotal() {
        return totalSizeTotal;
    }

    public void setTotalSizeTotal(Long totalSizeTotal) {
        this.totalSizeTotal = totalSizeTotal;
    }

    public Long getTotalSizeUsed() {
        return totalSizeUsed;
    }

    public void setTotalSizeUsed(Long totalSizeUsed) {
        this.totalSizeUsed = totalSizeUsed;
    }

    @Override
    public String toString() {
        return "Fsstat{" +
                "id='" + id + '\'' +
                ", count=" + count +
                ", totalFiles=" + totalFiles +
                ", totalSizeFree=" + totalSizeFree +
                ", totalSizeTotal=" + totalSizeTotal +
                ", totalSizeUsed=" + totalSizeUsed +
                '}';
    }
}
