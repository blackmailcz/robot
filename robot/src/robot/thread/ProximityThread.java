package robot.thread;

import robot.control.MainControl;

public class ProximityThread implements Runnable {
	
	private MainControl control;
	
	private boolean isActive = true;
	
	public ProximityThread(MainControl control) {
		this.control = control;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (isActive) {
			try {
				float distance = control.getProximityControl().getDistance();
				System.out.println("Distance: "+distance);
				if (distance < 20) {
					control.getEngineControl().stopMoving();
					System.out.println("Stopping");
					//return;
				};
				Thread.sleep(30);
			} catch (InterruptedException e) {
				
			}
		}
	}
	
	
	
	
}
