package com.itau.collectortwitter.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itau.collectortwitter.model.PostTwitter;
import com.itau.collectortwitter.service.TwitterService;

@RestController
@RequestMapping("/twitter")
public class TwitterController {

	@Autowired
	private TwitterService twitterService;

	@GetMapping(value = "/alltweets")
	public Map<String, List<PostTwitter>> listTweets() throws Exception {
		return twitterService.returnAllTweets();
	}

}
