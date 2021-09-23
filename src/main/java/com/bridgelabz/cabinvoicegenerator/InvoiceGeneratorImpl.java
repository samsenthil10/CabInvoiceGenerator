package com.bridgelabz.cabinvoicegenerator;

import java.util.List;

public class InvoiceGeneratorImpl implements InvoiceGeneratorIF {

	@Override
	public Double calculateFare(Ride ride) {

		Double fare = (ride.MINIMUM_RATE_PER_KILOMETER*ride.getDistance())+(ride.MINIMUM_RATE_PER_MINUTE*ride.getTime());
		if(ride.getDistance() > 0.0 && ride.getTime() > 0 && fare < 5.0 && fare > 0.0)
			return 5.0;
		return fare;
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
}
