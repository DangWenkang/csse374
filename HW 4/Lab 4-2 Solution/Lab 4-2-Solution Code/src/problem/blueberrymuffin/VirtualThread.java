package problem.blueberrymuffin;

public abstract class VirtualThread {
	private static int count = 0;
	private int id;
	
	public VirtualThread() {
		this.id = ++count;
	}
	
	public int getId() {
		return this.id;
	}
	
	public abstract void run();
}
