package com.itau.collectortwitter.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "POST_TWITTER")
public class PostTwitter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "NAME", nullable = false, unique = true, length = 255)
	private String name;

	@Column(name = "FOLLOWERS", nullable = false)
	private int followers;

	@Column(name = "TEXT", nullable = false, length = 255)
	private String text;

	@Column(name = "TIME", nullable = false, unique = true)
	private Instant time;

	public PostTwitter(String name, int followers, String text) {
		this.name = name;
		this.followers = followers;
		this.text = text;
		this.time = Instant.now();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFollowers() {
		return followers;
	}

	public void setFollowers(int followers) {
		this.followers = followers;
	}

}
