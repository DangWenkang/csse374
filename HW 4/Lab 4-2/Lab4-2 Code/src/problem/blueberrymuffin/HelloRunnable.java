package problem.blueberrymuffin;

public class HelloRunnable extends AbstractRunnable {

	private int identifier;
	private HelloReceiver helloReceiver;

	public HelloRunnable(int identifier, HelloReceiver hello) {
		this.identifier = identifier;
		this.helloReceiver = hello;
		this.finished = false;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(this.helloReceiver.sayHello() + " from thread-" + this.identifier);
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// do nothing
			}
		}
		this.finished = true;
	}
	
}
