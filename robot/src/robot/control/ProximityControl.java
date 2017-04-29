package robot.control;

import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;

public class ProximityControl {
	
	private static final Port proximityPort = SensorPort.S1;
	
	private EV3IRSensor sensor;
	float resultArray[];
	
	public ProximityControl() {
		this.sensor = new EV3IRSensor(proximityPort);
		if (sensor.sampleSize() <= 0) {
			throw new RuntimeException("Proximity sensor sample size is <= 0");
		}
		this.resultArray = new float[this.sensor.sampleSize()];
	}
	
	public float getDistance() {
		this.sensor.fetchSample(this.resultArray, 0);
		return this.resultArray[0];
	}

}
