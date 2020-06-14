package com.itau.collectortwitter.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itau.collectortwitter.model.ListPostTwitter;
import com.itau.collectortwitter.model.Moment;
import com.itau.collectortwitter.model.PostTwitter;
import com.itau.collectortwitter.repository.ListPostTwitterRepository;
import com.itau.collectortwitter.repository.MomentRepository;
import com.itau.collectortwitter.repository.PostTwitterRepository;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

@Component(value = "twitterService")
public class TwitterService {

	@Autowired
	MomentRepository momentRepository;

	@Autowired
	ListPostTwitterRepository listPostTwitterRepository;

	@Autowired
	PostTwitterRepository postTwitterRepository;

	public Moment returnAllTweets() {

		final int countQuery = 10;
		List<ListPostTwitter> response = new ArrayList<>();

		List<String> valueQuery = new ArrayList<>();
		valueQuery.add("\"%23cloud\"");
		valueQuery.add("\"%23container\"");
		valueQuery.add("\"%23devops\"");
		valueQuery.add("\"%23aws\"");
		valueQuery.add("\"%23microservices\"");
		valueQuery.add("\"%23docker\"");
		valueQuery.add("\"%23openstack\"");
		valueQuery.add("\"%23automation\"");
		valueQuery.add("\"%23gcp\"");
		valueQuery.add("\"%23azure\"");
		valueQuery.add("\"%23istio\"");
		valueQuery.add("\"%23sre\"");

		Twitter twitter = TwitterFactory.getSingleton();

		valueQuery.forEach(currentQuery -> {

			Query query = new Query(currentQuery);
			query.count(countQuery);
			query.setResultType(Query.RECENT);
			QueryResult result;

			try {
				result = twitter.search(query);
				List<PostTwitter> currentResponse = new ArrayList<>();
				for (Status status : result.getTweets()) {
					currentResponse.add(new PostTwitter(status.getUser().getName(),
							status.getUser().getFollowersCount(), status.getText()));
				}
				Collections.sort(currentResponse, (c1, c2) -> {
					return c2.getFollowers() - c1.getFollowers();
				});

				currentResponse = currentResponse.subList(0, 5);
				postTwitterRepository.saveAll(currentResponse);

				
				ListPostTwitter lst = new ListPostTwitter(currentQuery.replace("\"%23", "#").replace("\"", ""), currentResponse);
				response.add(lst);
//						new ListPostTwitter(currentQuery.replace("\"%23", "#").replace("\"", ""), currentResponse));
				listPostTwitterRepository.save(lst);
//						new ListPostTwitter(currentQuery.replace("\"%23", "#").replace("\"", ""), currentResponse));

			} catch (TwitterException e) {
				e.printStackTrace();
			}
		});

		momentRepository.save(new Moment(response));
		return new Moment(response);
	}

}
