package problem.question6;

public class C {
	
	private int id = 0x2222;

	public void doB() {
		System.out.println("Did B\n");
	}
	
	public void doM1(int id) {
		this.id = id & 0x1000;
	}

	public void doM2(int id) {
		this.id = this.id & 0x33;
	}
	
	public void doX() {
		System.out.println("User authenticated\n");
	}
	
	public void doY() {
		System.out.println("Mask applied\n");
	}
	
	public void doZ() {
		System.out.println("Exiting...\n");
	}
}
