package com.bridgelabz.cabinvoicegenerator;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.cabinvoicegenerator.InvoiceGeneratorException.exceptionType;

public class InvoiceServiceTest {

	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {

		Ride ride = new Ride();
		InvoiceGeneratorIF rideOperations = new InvoiceGeneratorImpl();	
		Double distance = 2.0;
		Integer time = 5;
		createRecord(ride, distance, time);
		Double fare = rideOperations.calculateFare(ride);
		Assert.assertEquals(fare,(Double.valueOf(25.0)),0.0);
	}

	@Test
	public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {

		Ride ride = new Ride();
		InvoiceGeneratorIF rideOperations = new InvoiceGeneratorImpl();	
		Double distance = 0.1;
		Integer time = 1;
		createRecord(ride, distance, time);
		Double fare = rideOperations.calculateFare(ride);
		Assert.assertEquals(fare,(Double.valueOf(5.0)),0.0);
	}

	@Test
	public void givenMultipleRide_ShouldReturnAggregateTotalFareForAllRides() {

		List<Ride> rides = new LinkedList<Ride>();
		InvoiceGeneratorIF rideOperations = new InvoiceGeneratorImpl();	
		Double distance[] = {0.1,2.0};
		Integer time[] = {1,5};
		for(int index = 0; index < distance.length; index++) {

			Ride ride = new Ride();
			createRecord(ride, distance[index], time[index]);
			rides.add(ride);
		}
		Double totalFare = rideOperations.calculateFare(rides);
		Assert.assertEquals(totalFare,(Double.valueOf(30.0)),0.0);
	}

	private void createRecord(Ride ride, Double distance, Integer time) {

		try {
			if(distance<=0)
				throw new InvoiceGeneratorException(exceptionType.DISTANCE_INVALID,"Invalid Distance!");
			ride.setDistance(distance);
		}
		catch(NullPointerException e) {
			throw new InvoiceGeneratorException(exceptionType.DISTANCE_NULL,"Null Distance!");
		}

		try {
			if(time<0)
				throw new InvoiceGeneratorException(exceptionType.TIME_INVALID,"Invalid Time!");
			ride.setTime(time);
		}
		catch(NullPointerException e) {
			throw new InvoiceGeneratorException(exceptionType.TIME_NULL,"Null Time!");
		}
	}
}
