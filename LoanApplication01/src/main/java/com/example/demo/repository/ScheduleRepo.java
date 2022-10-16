package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.ScheduleEntity;

public interface ScheduleRepo extends JpaRepository<ScheduleEntity, Integer>{

}
