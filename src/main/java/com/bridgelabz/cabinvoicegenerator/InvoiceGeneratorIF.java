package com.bridgelabz.cabinvoicegenerator;

import java.util.List;

public interface InvoiceGeneratorIF {

	public Double calculateFare(Ride ride);
	public Double calculateFare(List<Ride> rides);
	public InvoiceSummary calculateSummary(List<Ride> rides);
	public Ride createRecord(Double distance, Integer time);
	public RideRepository createRideRepository(Integer userId,  Double[] distance, Integer[] time);
	
}
