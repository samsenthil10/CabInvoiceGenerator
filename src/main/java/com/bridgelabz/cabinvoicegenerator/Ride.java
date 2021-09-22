package com.bridgelabz.cabinvoicegenerator;

public class Ride {

	public final Integer MINIMUM_RATE_PER_KILOMETER = 10;
	public final Integer MINIMUM_RATE_PER_MINUTE = 1;
	
	private Double distance;
	private Integer time;
	
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	
}
