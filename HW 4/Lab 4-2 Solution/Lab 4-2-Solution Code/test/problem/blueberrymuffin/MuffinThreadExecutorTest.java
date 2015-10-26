package problem.blueberrymuffin;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

import org.junit.Test;

public class MuffinThreadExecutorTest {
	@Test
	public final void testGetInstance() {
		MuffinThreadExecutor executor = MuffinThreadExecutor.getInstance();
		assertTrue(executor != null);
		assertTrue(executor.queue.isEmpty());
		assertTrue(executor.runners.isEmpty());
	}
	
	@Test
	public final void testRealThreadAddRemoveAndCount() throws InterruptedException {
		final MuffinThreadExecutor executor = MuffinThreadExecutor.getInstance();
		int expected = executor.getRealThreadCount() + 1;
		
		final RealThread rThread = new RealThread(new VirtualThread() {
			@Override
			public void run() {
				try {
					// Let's notify the main thread that it is now time to count the real thread 
					synchronized(this) {
						this.notify();
					}

					// Let's block this thread so that counting is done before its completion
					synchronized(this) {
						this.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		rThread.start();

		VirtualThread vThread = rThread.getVirtualThread();
		
		// Let's wait for the virtual thread to notify us that it is time to start counting
		synchronized(vThread) {
			vThread.wait();
		}
		
		int actual = executor.getRealThreadCount();
		assertEquals(expected, actual);
		
		// Notify the virtual thread that we are done counting
		synchronized(vThread) {
			vThread.notify();
		}
		rThread.join();
		
		// At this point we expect the real thread to be done, so it must be removed
		// from the executor
		expected -= 1;
		actual = executor.getRealThreadCount();
		assertEquals(expected, actual);
	}

	@Test
	public final void testVirtualThreadScheduleTakeAndCount() {
		final VirtualThread vThread = new VirtualThread() {
			@Override
			public void run() {
			}
		};
		
		final MuffinThreadExecutor executor = MuffinThreadExecutor.getInstance();
		executor.schedule(vThread);
		
		int expected = 1;
		int actual = executor.getVirtualThreadCount();
		assertEquals(expected, actual);

		executor.take();
		expected = 0;
		actual = executor.getVirtualThreadCount();
		assertEquals(expected, actual);
	}

	@Test
	public final void testIsCoreAvailableAllCases() {
		final MuffinThreadExecutor executor = MuffinThreadExecutor.getInstance();
		
		// Lower bound - No threads
		assertTrue(executor.isCoreAvailable());
		
		// Cases with some threads
		for(int i = 0; i < MuffinThreadExecutor.CORES - 2; ++i) {
			executor.add(new RealThread(null));
			assertTrue(executor.isCoreAvailable());
		}

		// Upper bound - Max capacity
		executor.add(new RealThread(null));
		assertFalse(executor.isCoreAvailable());
		
		// Restore the executor
		executor.runners.clear();
	}

	@Test
	public final void testHasMoreWorkAllCases() {
		final VirtualThread vThread = new VirtualThread() {
			@Override
			public void run() {
			}
		};
		final RealThread rThread = new RealThread(vThread);
		
		final MuffinThreadExecutor executor = MuffinThreadExecutor.getInstance();

		// Case 1: queue empty - runner empty
		assertFalse(executor.hasMoreWork());
		
		// Case 2: queue empty - runner non-empty
		executor.add(rThread);
		assertTrue(executor.hasMoreWork());
		
		// Case 3: queue non-empty 	- runner non-empty
		executor.schedule(vThread);
		assertTrue(executor.hasMoreWork());

		// Case 4: queue non-empty 	- runner empty
		executor.remove(rThread);
		assertTrue(executor.hasMoreWork());
		
		// Restore executor
		executor.take();
	}

	@Test
	public final void testStart() {
		final MuffinThreadExecutor executor = MuffinThreadExecutor.getInstance();
		final List<Integer> executionProfile = Collections.synchronizedList(new ArrayList<Integer>());
		
		final int totalThreads = 6;
		final int totalLoop = 5;
		for(int i = 0; i < totalThreads; ++ i) {
			final VirtualThread workerThread = new VirtualThread() {
				@Override
				public void run() {
					for(int i = 0; i < totalLoop; ++i) {
						executionProfile.add(this.getId());
						try {
							// Sleep, so that we see some thread interleaving behavior
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			};
			executor.schedule(workerThread);
		}
		executor.start();
		
		// Executor is done at this point, let's now analyze the states to detect thread interleaving
		// All we need to check is that there are enough threads that did not execute in a consecutive sequence
		TreeMap<Integer, List<Integer>> threadToExeSeq = new TreeMap<Integer, List<Integer>>();
		for(int seq = 1; seq <= executionProfile.size(); ++seq) {
			int threadId = executionProfile.get(seq-1);
			
			List<Integer> exeSeq = threadToExeSeq.get(threadId);
			if(exeSeq == null) {
				exeSeq = new ArrayList<Integer>();
				threadToExeSeq.put(threadId, exeSeq);
			}
			exeSeq.add(seq);
		}
		
		// Threads that did not executive consecutively in a sequence
		int count = 0;
		for(List<Integer> sequence : threadToExeSeq.values()) {
			int exeSeq = sequence.get(0);
			for(int seq : sequence) {
				if(seq != ++exeSeq) {
					// This thread did not execute consecutively in a sequence
					// So, increment the count and break out of the inner loop
					++count;
					break;
				}
			}
		}
		
		// Test that we had more than three threads that interleaved as we have 
		// six scheduled virtual threads with enough sleep time to allow interleaving
		assertTrue(count > 3);
	}
}
