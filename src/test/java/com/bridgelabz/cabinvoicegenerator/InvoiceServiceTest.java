package com.bridgelabz.cabinvoicegenerator;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.cabinvoicegenerator.InvoiceGeneratorException.exceptionType;

public class InvoiceServiceTest {

	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		InvoiceGeneratorIF invoiceGeneratorOperations = new InvoiceGeneratorImpl();	
		Double distance = 2.0;
		Integer time = 5;
		createRecord(invoiceGenerator, distance, time);
		Double fare = invoiceGeneratorOperations.calculateFare(invoiceGenerator.getDistance(), invoiceGenerator.getTime());
		Assert.assertEquals(fare,(Double.valueOf(25.0)),0.0);
	}

	private void createRecord(InvoiceGenerator invoiceGenerator, Double distance, Integer time) {
		
		try {
			if(distance<=0)
				throw new InvoiceGeneratorException(exceptionType.DISTANCE_INVALID,"Invalid Distance!");
			invoiceGenerator.setDistance(distance);
		}
		catch(NullPointerException e) {
			throw new InvoiceGeneratorException(exceptionType.DISTANCE_NULL,"Null Distance!");
		}
		
		try {
			if(time<0)
				throw new InvoiceGeneratorException(exceptionType.TIME_INVALID,"Invalid Time!");
			invoiceGenerator.setTime(time);
		}
		catch(NullPointerException e) {
			throw new InvoiceGeneratorException(exceptionType.TIME_NULL,"Null Time!");
		}
	}
}
