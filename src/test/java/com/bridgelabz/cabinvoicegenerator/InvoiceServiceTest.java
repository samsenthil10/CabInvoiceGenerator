package com.bridgelabz.cabinvoicegenerator;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest {

	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		InvoiceGeneratorIF invoiceGeneratorOperations = new InvoiceGeneratorImpl();	
		invoiceGenerator.setDistance(2.0);
		invoiceGenerator.setTime(1);
		Double fare = invoiceGeneratorOperations.calculateFare(invoiceGenerator.getDistance(), invoiceGenerator.getTime());
		Assert.assertEquals(fare,(Double.valueOf(25.0)),0.0);
	}
}
