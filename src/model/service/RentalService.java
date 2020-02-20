package model.service;

import entities.CarRental;
import entities.Invoice;

public class RentalService {

	private Float pricePerHour;
	private Float pricePerDay;
	
	private TaxService taxService;
	
	public RentalService() {}

	public RentalService(Float pricePerHour, Float pricePerDay, TaxService taxService) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;
	}

	public Float getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(Float pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	public Float getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(Float pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public TaxService getTaxService() {
		return taxService;
	}

	public void setTaxService(TaxService taxService) {
		this.taxService = taxService;
	}
	
	public void processInvoice(CarRental carRental) {
		long t1 = carRental.getStart().getTime();
		long t2 = carRental.getFinish().getTime();
		float hours = (t2 - t1) / 1000 / 60 / 60;
		
		float basicPayment;
		if(hours <= 12.0) {
			basicPayment = (float) (pricePerHour * Math.ceil(hours));
		}
		else {
			basicPayment = (float) (pricePerDay * Math.ceil(hours / 24));
		}
		
		float tax = taxService.tax(basicPayment);
		carRental.setInvoice(new Invoice(basicPayment, tax));		
	}
}
