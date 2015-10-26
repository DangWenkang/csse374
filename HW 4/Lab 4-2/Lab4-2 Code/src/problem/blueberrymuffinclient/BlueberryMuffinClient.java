package problem.blueberrymuffinclient;

import problem.blueberrymuffin.*;

public class BlueberryMuffinClient {

	public static void main(String[] args) throws InterruptedException {
		BlueberryMuffin bm = new BlueberryMuffin();
		
		HelloReceiver hReceiver = new HelloReceiver();
		
		for (int i = 0; i < 5; i++) {
			HelloRunnable hRunnable = new HelloRunnable(i, hReceiver);
			bm.setThread(hRunnable);
		}
		
		bm.threadWasStarted();
	}
	
}
