package com.bridgelabz.cabinvoicegenerator;

import java.util.List;

public class RideRepository {

	private Integer userId;
	private List<InvoiceSummary> invoiceSummaries;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public List<InvoiceSummary> getInvoiceSummaries() {
		return invoiceSummaries;
	}
	public void setInvoiceSummaries(List<InvoiceSummary> invoiceSummaries) {
		this.invoiceSummaries = invoiceSummaries;
	}
}
