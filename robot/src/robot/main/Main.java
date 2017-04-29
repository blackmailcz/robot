package robot.main;

import java.util.concurrent.CountDownLatch;

import robot.control.MainControl;
import robot.thread.ProximityThread;

public class Main {
	
	private static CountDownLatch latch = new CountDownLatch(1);
	
	public static void main(String[] args) {
		System.out.println("Main thread started");
		// Initialize control object
		MainControl control = new MainControl();
		// Initialize thread
		(new Thread(new ProximityThread(control))).start();
		// Start moving
		control.getEngineControl().startMovingForward();
		// Lock main thread
		try {
			latch.await();
		} catch (InterruptedException e) {
			// ..
		}
		// Lock the thread
		System.out.println("Main thread ended");
	}
	
	public static void terminate() {
		latch.countDown();
	}

}
