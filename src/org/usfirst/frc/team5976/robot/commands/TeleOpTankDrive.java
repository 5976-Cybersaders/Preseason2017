package org.usfirst.frc.team5976.robot.commands;

import org.usfirst.frc.team5976.robot.Robot;
import org.usfirst.frc.team5976.robot.XBoxController;
import org.usfirst.frc.team5976.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;

public class TeleOpTankDrive extends Command {

	private final RobotDrive robotDrive;
	private final SpeedCalculator leftSpeedCalculator; 
	private final SpeedCalculator rightSpeedCalculator;
	private PowerDistributionPanel pdp = new PowerDistributionPanel(); 
	
	public TeleOpTankDrive(XBoxController driveController, RobotDrive robotDrive, DriveTrain driveBase){
		this.robotDrive = robotDrive;
		leftSpeedCalculator = new TeleOpSpeedCalculator(true, driveController);
		rightSpeedCalculator = new TeleOpSpeedCalculator(false, driveController);
		requires(driveBase);
	}

	@Override
	protected void initialize() {
	
	}

	@Override
	protected void execute() {
		System.out.println("Current Left: " + (pdp.getCurrent(2) + pdp.getCurrent(3)) + " Current Right: " + (pdp.getCurrent(12) + pdp.getCurrent(13)));
		robotDrive.tankDrive(leftSpeedCalculator.calcNext(), rightSpeedCalculator.calcNext());
	}
	
	@Override
	protected boolean isFinished() {
		// Command is always on because we want to continuously respond to driving inputs
		return false;
	}

	@Override
	protected void end() {
		robotDrive.tankDrive(0.0, 0.0);
	}

	@Override
	protected void interrupted() {
		end();
	}
}
