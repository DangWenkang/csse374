package problem.question2;

public class Payment {
	
	private float amount;
	private boolean authorized;

	public Payment (float cashTendered) {
		this.amount = cashTendered;
		this.authorized = false;
	}
	
	public void authorize() {
		this.authorized = true;
	}

}