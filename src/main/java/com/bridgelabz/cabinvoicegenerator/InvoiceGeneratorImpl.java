package com.bridgelabz.cabinvoicegenerator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.bridgelabz.cabinvoicegenerator.InvoiceGeneratorException.exceptionType;

public class InvoiceGeneratorImpl implements InvoiceGeneratorIF {

	@Override
	public Double calculateNormalFare(Ride ride) {

		Double fare = (ride.MINIMUM_RATE_PER_KILOMETER_FOR_NORMAL_USER*ride.getDistance())+(ride.MINIMUM_RATE_PER_MINUTE_FOR_NORMAL_USER*ride.getTime());
		return Math.max(fare, 5.0);
	}

	@Override
	public Double calculateNormalFare(List<Ride> rides) {

		Double totalFare = 0.0;
		for (Ride ride : rides) {
			Double total = calculateNormalFare(ride);
			totalFare+=total;
		}
		return totalFare;
	}

	@Override
	public InvoiceSummary calculateNormalSummary(List<Ride> rides) {

		InvoiceSummary invoiceSummary = new InvoiceSummary();
		Integer totalRides = rides.size();
		invoiceSummary.setTotalNumberOfRides(totalRides);
		Double totalFare = 0.0;
		for (Ride ride : rides) {
			Double total = calculateNormalFare(ride);
			totalFare+=total;
		}
		invoiceSummary.setTotalFare(totalFare);
		invoiceSummary.setAverageFare(totalFare/totalRides);
		return invoiceSummary;
	}

	@Override
	public Ride createRecord(Double distance, Integer time) {

		Ride ride = new Ride();
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
		return ride;
	}

	@Override
	public RideRepository createNormalRideRepository(Integer userId, Double[] distance, Integer[] time) {

		RideRepository rideRepository = new RideRepository();
		List<InvoiceSummary> invoiceSummaries = new ArrayList<>();
		List<Ride> rides = new LinkedList<Ride>();
		InvoiceGeneratorIF rideOperations = new InvoiceGeneratorImpl();	
		for(int index = 0; index < distance.length; index++) {

			Ride ride = new Ride();
			ride=rideOperations.createRecord(distance[index], time[index]);
			rides.add(ride);
		}
		InvoiceSummary invoiceSumary = rideOperations.calculateNormalSummary(rides);
		invoiceSummaries.add(invoiceSumary);
		rideRepository.setUserId(userId);
		rideRepository.setInvoiceSummaries(invoiceSummaries);
		return rideRepository;
	}

	@Override
	public Double calculatePremiumFare(Ride ride) {

		Double fare = (ride.MINIMUM_RATE_PER_KILOMETER_FOR_PREMIUM_USER*ride.getDistance())+(ride.MINIMUM_RATE_PER_MINUTE_FOR_PREMIUM_USER*ride.getTime());
		return Math.max(fare, 20.0);
	}

	@Override
	public Double calculatePremiumFare(List<Ride> rides) {

		Double totalFare = 0.0;
		for (Ride ride : rides) {
			Double total = calculatePremiumFare(ride);
			totalFare+=total;
		}
		return totalFare;
	}

	@Override
	public InvoiceSummary calculatePremiumSummary(List<Ride> rides) {

		InvoiceSummary invoiceSummary = new InvoiceSummary();
		Integer totalRides = rides.size();
		invoiceSummary.setTotalNumberOfRides(totalRides);
		Double totalFare = 0.0;
		for (Ride ride : rides) {
			Double total = calculatePremiumFare(ride);
			totalFare+=total;
		}
		invoiceSummary.setTotalFare(totalFare);
		invoiceSummary.setAverageFare(totalFare/totalRides);
		return invoiceSummary;
	}
	@Override
	public RideRepository createPremiumRideRepository(Integer userId, Double[] distance, Integer[] time) {

		RideRepository rideRepository = new RideRepository();
		List<InvoiceSummary> invoiceSummaries = new ArrayList<>();
		List<Ride> rides = new LinkedList<Ride>();
		InvoiceGeneratorIF rideOperations = new InvoiceGeneratorImpl();	
		for(int index = 0; index < distance.length; index++) {

			Ride ride = new Ride();
			ride=rideOperations.createRecord(distance[index], time[index]);
			rides.add(ride);
		}
		InvoiceSummary invoiceSumary = rideOperations.calculatePremiumSummary(rides);
		invoiceSummaries.add(invoiceSumary);
		rideRepository.setUserId(userId);
		rideRepository.setInvoiceSummaries(invoiceSummaries);
		return rideRepository;
	}

}