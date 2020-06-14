package com.itau.collectortwitter.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.itau.collectortwitter.model.ListPostTwitter;
import com.itau.collectortwitter.model.Moment;

public class MomentResponseDTO {

	private Instant time;

	private List<ListPostTwitter> momentlistPostTwitter = new ArrayList<>();

	public MomentResponseDTO(Moment moment) {
		this.time = moment.getTime();
		this.momentlistPostTwitter = moment.getMomentlistPostTwitter();
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
