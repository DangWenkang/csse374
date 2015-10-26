package problem.question6;

public class B {
	
	private C myC;

	public void doA() {
		myC.doB();
	}
	
	public void authenticate(int id) {
		myC.doM1(id);
		myC.doM2(id);
		
		myC.doX();
		myC.doY();
		myC.doZ();
	}

}
