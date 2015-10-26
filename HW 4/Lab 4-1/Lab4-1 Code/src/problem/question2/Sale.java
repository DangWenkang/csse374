package problem.question2;

public class Sale {

	public void makePayment(float cashTendered) {
		Payment payment = new Payment(cashTendered);
		payment.authorize();
	}
	
}