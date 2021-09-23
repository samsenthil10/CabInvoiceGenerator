package com.bridgelabz.cabinvoicegenerator;

import java.util.List;

public interface InvoiceGeneratorIF {

	public Double calculateNormalFare(Ride ride);
	public Double calculateNormalFare(List<Ride> rides);
	public InvoiceSummary calculateNormalSummary(List<Ride> rides);
	public Ride createRecord(Double distance, Integer time);
	public RideRepository createNormalRideRepository(Integer userId,  Double[] distance, Integer[] time);
	public Double calculatePremiumFare(Ride ride);
	public Double calculatePremiumFare(List<Ride> rides);
	public InvoiceSummary calculatePremiumSummary(List<Ride> rides);
	public RideRepository createPremiumRideRepository(Integer userId,  Double[] distance, Integer[] time);
}
