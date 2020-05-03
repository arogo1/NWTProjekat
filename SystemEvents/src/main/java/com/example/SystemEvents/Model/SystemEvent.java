package com.example.SystemEvents.Model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SystemEvent {
    @Id
    @GeneratedValue
    private int systemEventId;
    private LocalDateTime timeStamp;
    private String serviceName;
    private int userId;

    public int GetSystemEventId(){
        return systemEventId;
    }

    public void SetSystemEventId(int systemEventId){
        this.systemEventId = systemEventId;
    }

    public LocalDateTime GetTimeStamp(){
        return timeStamp;
    }

    public void SetTimeStamp(LocalDateTime timeStamp){
        this.timeStamp = timeStamp;
    }

    public String GetServiceName(){
        return serviceName;
    }

    public void SetServiceName(String serviceName){
        this.serviceName = serviceName;
    }

    public int GetUserId(){
        return userId;
    }

    public void SetUserId(int userId){
        this.userId = userId;
    }
}