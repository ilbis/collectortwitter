package com.itau.collectortwitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itau.collectortwitter.model.Moment;

public interface MomentRepository extends JpaRepository<Moment, Long> {

} 
