package com.example.SystemEvents.Model;

import com.google.protobuf.Timestamp;

public class Event {

    private Integer id;

    private String timestamp;

    private String serviceName;

    private Integer actionType;

    private String resourceName;

    private Long userId;

    private Integer statusCode;

    public Event(Timestamp timestamp, Long userId, String serviceName, Integer actionType, String resourceName, Integer statusCode) {
        this.id = id;
        this.timestamp = timestamp.toString();
        this.serviceName = serviceName;
        this.actionType = actionType;
        this.resourceName = resourceName;
        this.userId = userId;
        this.statusCode = statusCode;
    }

    public Event() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getActionType() {
        return actionType;
    }

    public void setActionType(Integer actionType) {
        this.actionType = actionType;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", userId=" + userId +
                ", serviceName='" + serviceName + '\'' +
                ", actionType=" + actionType +
                ", resourceName='" + resourceName + '\'' +
                ", statusCode='" + statusCode + '\'' +
                '}';
    }
}