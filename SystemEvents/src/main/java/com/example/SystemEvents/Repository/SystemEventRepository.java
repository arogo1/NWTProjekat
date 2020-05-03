package com.example.SystemEvents.Repository;

import com.example.SystemEvents.Model.SystemEvent;

import org.springframework.data.repository.CrudRepository;

public interface SystemEventRepository extends CrudRepository<SystemEvent, Integer> {
    
}