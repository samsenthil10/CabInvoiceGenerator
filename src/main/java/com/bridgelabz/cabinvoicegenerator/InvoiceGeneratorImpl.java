package com.bridgelabz.cabinvoicegenerator;

public class InvoiceGeneratorImpl implements InvoiceGeneratorIF {

	@Override
	public Double calculateFare(Double distance, Integer time) {

		InvoiceGenerator invoiceGenerator = new InvoiceGenerator(); 
		Double fare = (invoiceGenerator.RATE_PER_KILOMETER*distance)+(invoiceGenerator.RATE_PER_MINUTE*time);
		if(distance > 0.0 && time > 0 && fare < 5.0 && fare > 0.0)
			return 5.0;
		return fare;
	}
}
