package com.itau.collectortwitter.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

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
	private long id;

	@Column(name = "TIME", nullable = false, unique = true)
	private Instant time;

	@OneToMany
	@JoinColumn(name = "LIST_POST_TWITTER_ID")
	private Set<PostTwitter> listPostTwitter = new HashSet<>();

	public ListPostTwitter(long id, Set<PostTwitter> listPostTwitter) {
		this.id = id;
		this.time = Instant.now();
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
