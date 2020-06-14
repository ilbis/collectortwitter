package com.itau.collectortwitter.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MOMENT")
public class Moment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "TIME", nullable = false, unique = true)
	private Instant time;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "MOMENT_ID")
	private List<ListPostTwitter> momentlistPostTwitter = new ArrayList<>();

	public Moment() {
	}

	public Moment(List<ListPostTwitter> listPostTwitter) {
		this.momentlistPostTwitter = listPostTwitter;
		this.time = Instant.now();
	}

	public Instant getTime() {
		return time;
	}

	public void setTime(Instant time) {
		this.time = time;
	}

	public List<ListPostTwitter> getMomentlistPostTwitter() {
		return momentlistPostTwitter;
	}

	public void setMomentlistPostTwitter(List<ListPostTwitter> momentlistPostTwitter) {
		this.momentlistPostTwitter = momentlistPostTwitter;
	}

}
