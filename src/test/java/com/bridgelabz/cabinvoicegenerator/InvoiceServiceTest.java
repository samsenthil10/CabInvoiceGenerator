package com.bridgelabz.cabinvoicegenerator;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest {

	@Test
	public void givenDistanceAndTimeForNormalUser_ShouldReturnTotalFare() {

		Ride ride = new Ride();
		InvoiceGeneratorIF rideOperations = new InvoiceGeneratorImpl();	
		Double distance = 2.0;
		Integer time = 5;
		ride=rideOperations.createRecord(distance, time);
		Double fare = rideOperations.calculateNormalFare(ride);
		Assert.assertEquals(fare,(Double.valueOf(25.0)),0.0);
	}

	@Test
	public void givenLessDistanceAndTimeForNormalUser_ShouldReturnMinimumFare() {

		Ride ride = new Ride();
		InvoiceGeneratorIF rideOperations = new InvoiceGeneratorImpl();	
		Double distance = 0.1;
		Integer time = 1;
		ride=rideOperations.createRecord(distance, time);
		Double fare = rideOperations.calculateNormalFare(ride);
		Assert.assertEquals(fare,(Double.valueOf(5.0)),0.0);
	}

	@Test
	public void givenMultipleRideForNormalUser_ShouldReturnAggregateTotalFareForAllRides() {

		List<Ride> rides = new LinkedList<Ride>();
		InvoiceGeneratorIF rideOperations = new InvoiceGeneratorImpl();	
		Double distance[] = {0.1,2.0};
		Integer time[] = {1,5};
		for(int index = 0; index < distance.length; index++) {

			Ride ride = new Ride();
			ride=rideOperations.createRecord(distance[index], time[index]);
			rides.add(ride);
		}
		Double totalFare = rideOperations.calculateNormalFare(rides);
		Assert.assertEquals(totalFare,(Double.valueOf(30.0)),0.0);
	}

	@Test
	public void givenMultipleRideForNormalUser_ShouldReturnInvoiceSummary() {

		List<Ride> rides = new LinkedList<Ride>();
		InvoiceGeneratorIF rideOperations = new InvoiceGeneratorImpl();	
		Double distance[] = {0.1,2.0};
		Integer time[] = {1,5};
		for(int index = 0; index < distance.length; index++) {

			Ride ride = new Ride();
			ride=rideOperations.createRecord(distance[index], time[index]);
			rides.add(ride);
		}
		InvoiceSummary invoiceSumary = rideOperations.calculateNormalSummary(rides);
		Assert.assertTrue(invoiceSumary.getTotalNumberOfRides().equals(rides.size())&&(invoiceSumary.getTotalFare().equals(30.0))&&invoiceSumary.getAverageFare().equals(15.0));
	}

	@Test
	public void givenRideRepositoriesForNormalUser_ShouldReturnMultipleInvoiceSummary() {

		RideRepository rideRepository1 = new RideRepository();
		RideRepository rideRepository2 = new RideRepository();
		InvoiceGeneratorIF rideOperations = new InvoiceGeneratorImpl();
		Double distance1[] = {0.1,2.0};
		Integer time1[] = {1,5};
		Double distance2[] = {0.5,2.0,7.0};
		Integer time2[] = {1,5,3};
		rideRepository1= rideOperations.createNormalRideRepository(1,distance1,time1);
		rideRepository2= rideOperations.createPremiumRideRepository(2,distance2,time2);
		Assert.assertEquals(rideRepository1.getInvoiceSummaries().size(),1);
		Assert.assertEquals(rideRepository2.getInvoiceSummaries().size(),1);
	}
	
	@Test
	public void givenDistanceAndTimeForPremiumUser_ShouldReturnTotalFare() {

		Ride ride = new Ride();
		InvoiceGeneratorIF rideOperations = new InvoiceGeneratorImpl();	
		Double distance = 2.0;
		Integer time = 5;
		ride=rideOperations.createRecord(distance, time);
		Double fare = rideOperations.calculatePremiumFare(ride);
		Assert.assertEquals(fare,(Double.valueOf(40.0)),0.0);
	}

	@Test
	public void givenLessDistanceAndTimeForPremiumUser_ShouldReturnMinimumFare() {

		Ride ride = new Ride();
		InvoiceGeneratorIF rideOperations = new InvoiceGeneratorImpl();	
		Double distance = 0.1;
		Integer time = 1;
		ride=rideOperations.createRecord(distance, time);
		Double fare = rideOperations.calculatePremiumFare(ride);
		Assert.assertEquals(fare,(Double.valueOf(20.0)),0.0);
	}

	@Test
	public void givenMultipleRideForPremiumUser_ShouldReturnAggregateTotalFareForAllRides() {

		List<Ride> rides = new LinkedList<Ride>();
		InvoiceGeneratorIF rideOperations = new InvoiceGeneratorImpl();	
		Double distance[] = {0.1,2.0};
		Integer time[] = {1,5};
		for(int index = 0; index < distance.length; index++) {

			Ride ride = new Ride();
			ride=rideOperations.createRecord(distance[index], time[index]);
			rides.add(ride);
		}
		Double totalFare = rideOperations.calculatePremiumFare(rides);
		Assert.assertEquals(totalFare,(Double.valueOf(60.0)),0.0);
	}

	@Test
	public void givenMultipleRideForPremiumUser_ShouldReturnInvoiceSummary() {

		List<Ride> rides = new LinkedList<Ride>();
		InvoiceGeneratorIF rideOperations = new InvoiceGeneratorImpl();	
		Double distance[] = {0.1,2.0};
		Integer time[] = {1,5};
		for(int index = 0; index < distance.length; index++) {

			Ride ride = new Ride();
			ride=rideOperations.createRecord(distance[index], time[index]);
			rides.add(ride);
		}
		InvoiceSummary invoiceSumary = rideOperations.calculatePremiumSummary(rides);
		Assert.assertTrue(invoiceSumary.getTotalNumberOfRides().equals(rides.size())&&(invoiceSumary.getTotalFare().equals(60.0))&&invoiceSumary.getAverageFare().equals(30.0));
	}

	@Test
	public void givenRideRepositoriesForPremiumUser_ShouldReturnMultipleInvoiceSummary() {

		RideRepository rideRepository1 = new RideRepository();
		RideRepository rideRepository2 = new RideRepository();
		InvoiceGeneratorIF rideOperations = new InvoiceGeneratorImpl();
		Double distance1[] = {0.1,2.0};
		Integer time1[] = {1,5};
		Double distance2[] = {0.5,2.0,7.0};
		Integer time2[] = {1,5,3};
		rideRepository1= rideOperations.createNormalRideRepository(1,distance1,time1);
		rideRepository2= rideOperations.createPremiumRideRepository(2,distance2,time2);
		Assert.assertEquals(rideRepository1.getInvoiceSummaries().size(),1);
		Assert.assertEquals(rideRepository2.getInvoiceSummaries().size(),1);
	}

}
