package com.itau.collectortwitter.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.itau.collectortwitter.model.ListPostTwitter;
import com.itau.collectortwitter.model.PostTwitter;
import com.itau.collectortwitter.repository.ListPostTwitterRepository;
import com.itau.collectortwitter.repository.PostTwitterRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private PostTwitterRepository postTwitterRepository;
	
	@Autowired
	private ListPostTwitterRepository listPostTwitterRepository;

	@Override
	public void run(String... args) throws Exception {
//
//		PostTwitter p1 = new PostTwitter("Jr", 1000, "Teste");
//		PostTwitter p2 = new PostTwitter("Jose", 2000, "Teste2");
//		postTwitterRepository.saveAll(Arrays.asList(p1,p2));
//		
//		ListPostTwitter l1 = new ListPostTwitter("#teste", Arrays.asList(p1,p2));
//		listPostTwitterRepository.saveAll(Arrays.asList(l1));
		
		
	}

}
