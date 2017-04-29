package robot.control;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.Port;
import lejos.hardware.port.TachoMotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.navigation.Navigator;
import lejos.utility.PilotProps;

public class EngineControl {
	
	// LEFT WHEEL
	private static final Port LEFT_WHEEL_PORT = MotorPort.D;
	private static final double LEFT_WHEEL_DIAMETER = 2.0f;
	private static final int LEFT_WHEEL_OFFSET = -8;
	
	// RIGHT WHEEL
	private static final Port RIGHT_WHEEL_PORT = MotorPort.A;
	private static final double RIGHT_WHEEL_DIAMETER = 2.0f;
	private static final int RIGHT_WHEEL_OFFSET = 8;
	
	// MOVE PILOT
	private MovePilot movePilot;
	
	// COLOR SENSOR MOVEMENT ENGINE
	private static final Port COLOR_MOVEMENT_ENGINE_PORT = MotorPort.B;
	
	//private static final 
	
	public EngineControl() {
		Wheel leftWheel = new WheeledChassis.Modeler(new EV3LargeRegulatedMotor(LEFT_WHEEL_PORT), LEFT_WHEEL_DIAMETER).offset(LEFT_WHEEL_OFFSET);
		Wheel rightWheel = new WheeledChassis.Modeler(new EV3LargeRegulatedMotor(RIGHT_WHEEL_PORT), RIGHT_WHEEL_DIAMETER).offset(RIGHT_WHEEL_OFFSET);
		this.movePilot = new MovePilot(new WheeledChassis(new Wheel [] {leftWheel, rightWheel}, WheeledChassis.TYPE_DIFFERENTIAL));
	}
	
	private MovePilot getPilot() {
		return this.movePilot;
	}
	
	public void startMovingForward() {
		getPilot().forward();
	}
	
	public void startMovingBackward() {
		getPilot().backward();
	}
	
	public void stopMoving() {
		getPilot().stop();
	}
	
	public void rotateLeft() {
		getPilot().rotate(90);
	}
	
	public void rotateRight() {
		getPilot().rotate(-90);
	}

}