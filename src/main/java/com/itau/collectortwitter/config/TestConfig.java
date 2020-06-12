package com.itau.collectortwitter.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.itau.collectortwitter.model.PostTwitter;
import com.itau.collectortwitter.repository.PostTwitterRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private PostTwitterRepository postTwitterRepository;

	@Override
	public void run(String... args) throws Exception {

		PostTwitter p1 = new PostTwitter("Jr", 1000, "Teste");
		postTwitterRepository.saveAll(Arrays.asList(p1));
	}

}
