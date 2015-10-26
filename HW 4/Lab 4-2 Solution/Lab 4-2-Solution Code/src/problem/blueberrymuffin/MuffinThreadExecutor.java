package problem.blueberrymuffin;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MuffinThreadExecutor {
	///////////// Internal APIs - Start /////////////   
	static final int CORES = 4;
	static final int SLEEP_TIME = 100;
	
	// Not very costly to initialize it up front
	private static MuffinThreadExecutor instance = new MuffinThreadExecutor();
	
	Queue<VirtualThread> queue;
	List<RealThread> runners;

	private MuffinThreadExecutor() {
		runners = new ArrayList<RealThread>();
		queue = new LinkedList<VirtualThread>();
	}
	
	synchronized void add(RealThread r) {
		runners.add(r);
	}
	
	synchronized void remove(RealThread r) {
		runners.remove(r);
	}
	
	synchronized int getRealThreadCount() {
		return runners.size();
	}
	
	synchronized VirtualThread take() {
		return queue.poll();
	}
	
	synchronized boolean isCoreAvailable() {
		return runners.size() < CORES - 1;
	}
	
	synchronized boolean hasMoreWork() {
		return !queue.isEmpty() || !runners.isEmpty();
	}
	///////////// Internal APIs - End /////////////
	

	///////////// Public APIs - Start /////////////
	public static MuffinThreadExecutor getInstance() {
		return instance;
	}

	public synchronized void schedule(VirtualThread t) {
		queue.add(t);
	}

	public synchronized int getVirtualThreadCount() {
		return queue.size();
	}
	
	public void start() {
		while(this.hasMoreWork()) {
			if(this.isCoreAvailable()) {
				VirtualThread vThread = this.take();
				
				if(vThread != null) {
					RealThread rThread = new RealThread(vThread);
					rThread.start();
				}
			}
			
			try {
				Thread.sleep(SLEEP_TIME);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	///////////// Public APIs - End /////////////
}
