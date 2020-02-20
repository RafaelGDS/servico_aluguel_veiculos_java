package entities;

public class Invoice {

	private Float basicPayment;
	private Float tax;
	
	public Invoice() {}

	public Invoice(Float basicPayment, Float tax) {
		this.basicPayment = basicPayment;
		this.tax = tax;
	}

	public Float getBasicPayment() {
		return basicPayment;
	}

	public void setBasicPayment(Float basicPayment) {
		this.basicPayment = basicPayment;
	}

	public Float getTax() {
		return tax;
	}

	public void setTax(Float tax) {
		this.tax = tax;
	}	
	
	public float getTotalPayment() {
		return basicPayment + tax;
	}
}
