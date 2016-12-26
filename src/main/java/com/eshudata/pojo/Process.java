package com.eshudata.pojo;

import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 */
@Document
public class Process extends OSCommon{

    // 进程名称
    private String name;
    // 启动进程所使用的cmd命令行
    private String cmdLine;
    // 进程在cpu中的启动时间
    private DateTime cpuStartTime;
    // 进程占cpu百分比
    private Double cpuTotalPct;
    // 文件描述符硬限制
    private Long fdLimitHard;
    // 文件描述符软限制
    private Long fdLimitSoft;
    // 文件描述符打开数量
    private Long fdOpen;
    // 进程占用内存大小
    private Long memorySize;
    // 进程共享内存大小
    private Long memoryShare;
    // 进程实际驻留内存大小
    private Long memoryRssBytes;
    // 进程实际驻留内存百分比
    private Double memoryRssPct;
    // 进程组编号
    private Long pgid;
    // 进程号
    private Long pid;
    // 父进程号
    private Long ppid;
    // 进程状态
    private String state;
    // 进程所属用户名
    private String userName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCmdLine() {
        return cmdLine;
    }

    public void setCmdLine(String cmdLine) {
        this.cmdLine = cmdLine;
    }

    public DateTime getCpuStartTime() {
        return cpuStartTime;
    }

    public void setCpuStartTime(DateTime cpuStartTime) {
        this.cpuStartTime = cpuStartTime;
    }

    public Double getCpuTotalPct() {
        return cpuTotalPct;
    }

    public void setCpuTotalPct(Double cpuTotalPct) {
        this.cpuTotalPct = cpuTotalPct;
    }

    public Long getFdLimitHard() {
        return fdLimitHard;
    }

    public void setFdLimitHard(Long fdLimitHard) {
        this.fdLimitHard = fdLimitHard;
    }

    public Long getFdLimitSoft() {
        return fdLimitSoft;
    }

    public void setFdLimitSoft(Long fdLimitSoft) {
        this.fdLimitSoft = fdLimitSoft;
    }

    public Long getFdOpen() {
        return fdOpen;
    }

    public void setFdOpen(Long fdOpen) {
        this.fdOpen = fdOpen;
    }

    public Long getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(Long memorySize) {
        this.memorySize = memorySize;
    }

    public Long getMemoryShare() {
        return memoryShare;
    }

    public void setMemoryShare(Long memoryShare) {
        this.memoryShare = memoryShare;
    }

    public Long getMemoryRssBytes() {
        return memoryRssBytes;
    }

    public void setMemoryRssBytes(Long memoryRssBytes) {
        this.memoryRssBytes = memoryRssBytes;
    }

    public Double getMemoryRssPct() {
        return memoryRssPct;
    }

    public void setMemoryRssPct(Double memoryRssPct) {
        this.memoryRssPct = memoryRssPct;
    }

    public Long getPgid() {
        return pgid;
    }

    public void setPgid(Long pgid) {
        this.pgid = pgid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getPpid() {
        return ppid;
    }

    public void setPpid(Long ppid) {
        this.ppid = ppid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Process{" +
                "name='" + name + '\'' +
                ", cmdLine='" + cmdLine + '\'' +
                ", cpuStartTime=" + cpuStartTime +
                ", cpuTotalPct=" + cpuTotalPct +
                ", fdLimitHard=" + fdLimitHard +
                ", fdLimitSoft=" + fdLimitSoft +
                ", fdOpen=" + fdOpen +
                ", memorySize=" + memorySize +
                ", memoryShare=" + memoryShare +
                ", memoryRssBytes=" + memoryRssBytes +
                ", memoryRssPct=" + memoryRssPct +
                ", pgid=" + pgid +
                ", pid=" + pid +
                ", ppid=" + ppid +
                ", state='" + state + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
