package com.bridgelabz.cabinvoicegenerator;

public class InvoiceGeneratorImpl implements InvoiceGeneratorIF {

	@Override
	public Double calculateFare(Double distance, Integer time) {

		Ride invoiceGenerator = new Ride(); 
		Double fare = (invoiceGenerator.MINIMUM_RATE_PER_KILOMETER*distance)+(invoiceGenerator.MINIMUM_RATE_PER_MINUTE*time);
		if(distance > 0.0 && time > 0 && fare < 5.0 && fare > 0.0)
			return 5.0;
		return fare;
	}
}
