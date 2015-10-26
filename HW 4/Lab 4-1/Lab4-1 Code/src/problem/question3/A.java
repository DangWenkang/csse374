package problem.question3;

public class A {
	
	private B myB;
	private C myC;

	public void doX(int x) {
		if (x < 10) {
			myB.calculate(x);
		} else {
			myC.calculate(x);
		}
	}
	
}
