package com.clicklogs.taplogger.model;

public class TapLog {

    private Integer sequenceNumber;
    private Long startTimestamp;
    private Long endTimestamp;
    private Long durationMs;
    private String interfaceType;
    private String sessionId;
    private String devicePlatform;
    private Long createdAt;

    public TapLog() {}

    public TapLog(Integer sequenceNumber, Long startTimestamp, Long endTimestamp,
                  Long durationMs, String interfaceType, String sessionId,
                  String devicePlatform, Long createdAt) {

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

    public Long getCreatedAt() { return createdAt; }
    public void setCreatedAt(Long createdAt) { this.createdAt = createdAt; }
}