package com.itau.collectortwitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itau.collectortwitter.model.PostTwitter;

public interface PostTwitterRepository extends JpaRepository<PostTwitter, Long> {

} 
