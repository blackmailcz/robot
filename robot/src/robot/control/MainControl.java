package robot.control;

public class MainControl {
	
	private EngineControl engineControl;
	private ProximityControl proximityControl;
	
	public MainControl() {
		this.engineControl = new EngineControl();
		this.proximityControl = new ProximityControl();
	}
	
	public EngineControl getEngineControl() {
		return engineControl;
	}
	
	public ProximityControl getProximityControl() {
		return proximityControl;
	}
	
	
	
}
