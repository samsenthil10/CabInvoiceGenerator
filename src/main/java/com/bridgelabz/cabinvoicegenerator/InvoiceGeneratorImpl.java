package com.bridgelabz.cabinvoicegenerator;

import java.util.List;

public class InvoiceGeneratorImpl implements InvoiceGeneratorIF {

	@Override
	public Double calculateFare(Ride ride) {

		Double fare = (ride.MINIMUM_RATE_PER_KILOMETER*ride.getDistance())+(ride.MINIMUM_RATE_PER_MINUTE*ride.getTime());
		return Math.max(fare, 5.0);
	}

	@Override
	public Double calculateFare(List<Ride> rides) {

		Double totalFare = 0.0;
		for (Ride ride : rides) {
			Double total = calculateFare(ride);
			totalFare+=total;
		}
		return totalFare;
	}

	@Override
	public InvoiceSummary calculateSummary(List<Ride> rides) {

		InvoiceSummary invoiceSummary = new InvoiceSummary();
		Integer totalRides = rides.size();
		invoiceSummary.setTotalNumberOfRides(totalRides);
		Double totalFare = 0.0;
		for (Ride ride : rides) {
			Double total = calculateFare(ride);
			totalFare+=total;
		}
		invoiceSummary.setTotalFare(totalFare);
		invoiceSummary.setAverageFare(totalFare/totalRides);
		return invoiceSummary;
	}
}
