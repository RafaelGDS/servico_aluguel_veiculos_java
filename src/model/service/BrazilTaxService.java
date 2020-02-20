package model.service;

public class BrazilTaxService implements TaxService{

	public float tax(float amount) {
		if(amount <= 100.0) {
			return (float) (amount * 0.2);
		}
		else {
			return (float) (amount * 0.15);
		}
	}
}
