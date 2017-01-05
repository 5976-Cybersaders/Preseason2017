package org.usfirst.frc.team5976.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends Subsystem {
	private SpeedController leftMotor, rightMotor;
	private RobotDrive drive;
	private Encoder leftEncoder, rightEncoder;
	
	public DriveTrain() {
		super();
		leftMotor = new Talon(1);
		rightMotor = new Talon(2);
		drive = new RobotDrive(leftMotor, rightMotor);
		leftEncoder = new Encoder(1, 1);
		rightEncoder = new Encoder(2, 2);
		
		leftEncoder.setDistancePerPulse(0.042);
		LiveWindow.addActuator("Drive Train", "Left Motor", (Talon) leftMotor);
		LiveWindow.addSensor("Drive Train", "Left Encoder", leftEncoder);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO TelOp drive
		
	}
	
	public void log() {
		SmartDashboard.putNumber("Left Distance", leftEncoder.getDistance());
		SmartDashboard.putNumber("Left Speed", leftEncoder.getRate());
	}
	
	public void drive(double left, double right) {
		drive.tankDrive(left, right);
	}
	
	public void reset() {
		leftEncoder.reset();
	}
	
	public double getDistance() {
		return leftEncoder.getDistance();
	}
}
