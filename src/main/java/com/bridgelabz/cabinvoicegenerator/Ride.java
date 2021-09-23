package com.bridgelabz.cabinvoicegenerator;

public class Ride {

	public final Integer MINIMUM_RATE_PER_KILOMETER_FOR_NORMAL_USER = 10;
	public final Integer MINIMUM_RATE_PER_MINUTE_FOR_NORMAL_USER = 1;
	public final Integer MINIMUM_RATE_PER_KILOMETER_FOR_PREMIUM_USER = 15;
	public final Integer MINIMUM_RATE_PER_MINUTE_FOR_PREMIUM_USER = 2;
	
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
