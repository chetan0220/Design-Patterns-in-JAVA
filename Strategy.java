class PaymentService{
	int cost;
	PaymentStrategy strategy;
	void processOrder(){
		strategy.collectDetails();
		if(strategy.validateDetails()){
			strategy.pay(cost);
		}
	}
}

interface PaymentStrategy {
	void collectDetails();
	boolean validateDetails();
    void pay(int amount);
}

class PaypalStrategy implements PaymentStrategy{

	public void collectDetails() {
		// TODO Auto-generated method stub
		System.out.println("Collecting details from Paypal");
		
	}

	public boolean validateDetails() {
		// TODO Auto-generated method stub
		System.out.println("Validating details from Paypal");
		return true;
	}

	public void pay(int amount) {
		// TODO Auto-generated method stub
		System.out.println("Paying amount from Paypal");
	}
	
}

class CreditCardStrategy implements PaymentStrategy{

	public void collectDetails() {
		// TODO Auto-generated method stub
		System.out.println("Collecting details from Credit Card");
		
	}

	public boolean validateDetails() {
		// TODO Auto-generated method stub
		System.out.println("Validating details from Credit Card");
		return true;
	}

	public void pay(int amount) {
		// TODO Auto-generated method stub
		System.out.println("Paying amount from Credit Card");
		
	}
	
}

public class Main{
	public static void main(String[] args){
		PaymentService paymentService = new PaymentService();
		paymentService.cost = 100;
		paymentService.strategy = new CreditCardStrategy();
		paymentService.processOrder();
	}
}

/*
Output: 
Collecting details from Credit Card
Validating details from Credit Card
Paying amount from Credit Card

------------

Collecting details from Paypal
Validating details from Paypal
Paying amount from Paypal

*/
