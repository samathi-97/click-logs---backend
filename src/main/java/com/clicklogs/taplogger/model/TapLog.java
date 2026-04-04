package com.clicklogs.taplogger.model;
import com.google.cloud.Timestamp;

public class TapLog {

    private Integer sequenceNumber;
    private Long startTimestamp;
    private Long endTimestamp;
    private Long durationMs;
    private String interfaceType;
    private String sessionId;
    private String devicePlatform;
    //private Long createdAt;
    private Timestamp createdAt;

    public TapLog() {}

    public TapLog(Integer sequenceNumber, Long startTimestamp, Long endTimestamp,
                  Long durationMs, String interfaceType, String sessionId,
                  String devicePlatform, Timestamp createdAt) {

        this.sequenceNumber = sequenceNumber;
        this.startTimestamp = startTimestamp;
        this.endTimestamp = endTimestamp;
        this.durationMs = durationMs;
        this.interfaceType = interfaceType;
        this.sessionId = sessionId;
        this.devicePlatform = devicePlatform;
        this.createdAt = createdAt;
    }

    public Integer getSequenceNumber() { return sequenceNumber; }
    public void setSequenceNumber(Integer sequenceNumber) { this.sequenceNumber = sequenceNumber; }

    public Long getStartTimestamp() { return startTimestamp; }
    public void setStartTimestamp(Long startTimestamp) { this.startTimestamp = startTimestamp; }

    public Long getEndTimestamp() { return endTimestamp; }
    public void setEndTimestamp(Long endTimestamp) { this.endTimestamp = endTimestamp; }

    public Long getDurationMs() { return durationMs; }
    public void setDurationMs(Long durationMs) { this.durationMs = durationMs; }

    public String getInterfaceType() { return interfaceType; }
    public void setInterfaceType(String interfaceType) { this.interfaceType = interfaceType; }

    public String getSessionId() { return sessionId; }
    public void setSessionId(String sessionId) { this.sessionId = sessionId; }

    public String getDevicePlatform() { return devicePlatform; }
    public void setDevicePlatform(String devicePlatform) { this.devicePlatform = devicePlatform; }

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
}