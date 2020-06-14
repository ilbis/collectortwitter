package com.itau.collectortwitter.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itau.collectortwitter.model.Moment;
import com.itau.collectortwitter.service.TwitterService;

@RestController
@RequestMapping("/twitter")
public class TwitterController {

	@Autowired
	private TwitterService twitterService;

	@GetMapping(value = "/alltweets")
	public Moment listTweets() throws Exception {
		return twitterService.returnAllTweets();
	}

}
