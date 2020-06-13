package com.itau.collectortwitter.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LIST_POST_TWITTER")
public class ListPostTwitter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "HASHTAG", nullable = false, unique = false)
	private String hashtag;

	@Column(name = "TIME", nullable = false, unique = true)
	private Instant time;

	@OneToMany
	@JoinColumn(name = "LIST_POST_TWITTER_ID")
	private List<PostTwitter> listPostTwitter = new ArrayList<>();

	public ListPostTwitter() {
	}

	public ListPostTwitter(Long id, String hashtag, List<PostTwitter> listPostTwitter) {
		this.id = id;
		this.hashtag = hashtag;
		this.listPostTwitter = listPostTwitter;
		this.time = Instant.now();
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Instant getTime() {
		return time;
	}

	public void setTime(Instant time) {
		this.time = time;
	}

}
