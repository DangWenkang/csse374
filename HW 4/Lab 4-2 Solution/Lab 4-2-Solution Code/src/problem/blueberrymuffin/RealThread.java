package problem.blueberrymuffin;

class RealThread extends Thread {
	private VirtualThread vThread;
	
	public RealThread(VirtualThread t) {
		this.vThread = t;
	}
	
	public VirtualThread getVirtualThread() {
		return this.vThread;
	}
	
	@Override
	public void run() {
		MuffinThreadExecutor executor = MuffinThreadExecutor.getInstance();
		executor.add(this);
		
		if(this.vThread != null)
			this.vThread.run();
		
		executor.remove(this);
	}
}
