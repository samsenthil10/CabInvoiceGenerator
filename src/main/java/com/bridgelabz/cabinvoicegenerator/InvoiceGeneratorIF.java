package com.bridgelabz.cabinvoicegenerator;

import java.util.List;

public interface InvoiceGeneratorIF {

	public Double calculateFare(Ride ride);
	public Double calculateFare(List<Ride> rides);
	public InvoiceSummary calculateSummary(List<Ride> rides);
	
}
