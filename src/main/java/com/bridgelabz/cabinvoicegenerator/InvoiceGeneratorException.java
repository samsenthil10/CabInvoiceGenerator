package com.bridgelabz.cabinvoicegenerator;

@SuppressWarnings("serial")
public class InvoiceGeneratorException extends RuntimeException {

	enum exceptionType {

		DISTANCE_NULL,
		DISTANCE_INVALID,
		TIME_NULL,
		TIME_INVALID;
	}
	exceptionType type;

	public InvoiceGeneratorException(exceptionType type, String message) {
		super(message);
		this.type = type;
		System.out.println(message);
	}
}
