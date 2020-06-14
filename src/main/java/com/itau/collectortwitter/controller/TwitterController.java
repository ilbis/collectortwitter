package com.itau.collectortwitter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itau.collectortwitter.dto.MomentResponseDTO;
import com.itau.collectortwitter.service.TwitterService;

@RestController
@RequestMapping("/twitter")
public class TwitterController {

	@Autowired
	private TwitterService twitterService;

	@GetMapping(value = "/alltweets")
	public ResponseEntity<List<MomentResponseDTO>> returnAllTweets() throws Exception {
		return ResponseEntity.ok().body(twitterService.returnAllTweets());

	}

	@PostMapping(value = "/alltweets/add")
	public void addAllTweets() throws Exception {
		twitterService.addAllTweets();
	}

}
