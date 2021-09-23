package com.bridgelabz.cabinvoicegenerator;

public class InvoiceSummary {

	private Integer totalNumberOfRides;
	private Double totalFare;
	private Double averageFare;

	public Integer getTotalNumberOfRides() {
		return totalNumberOfRides;
	}
	public void setTotalNumberOfRides(Integer totalNumberOfRides) {
		this.totalNumberOfRides = totalNumberOfRides;
	}
	public Double getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(Double totalFare) {
		this.totalFare = totalFare;
	}
	public Double getAverageFare() {
		return averageFare;
	}
	public void setAverageFare(Double averageFare) {
		this.averageFare = averageFare;
	}

}
