package org.usfirst.frc.team5976.robot.commands;

import org.usfirst.frc.team5976.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SpeedRampAdjustmentCommand extends Command {

	private double adjustmentAmount;
	
	public SpeedRampAdjustmentCommand(double adjustmentAmount){
		this.adjustmentAmount = adjustmentAmount;
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		double newMaxAllowedChange = Robot.maxAllowedSpeedChange  + adjustmentAmount;
		System.out.println("Attempt to set newMaxAllowedChange to " + newMaxAllowedChange);
		if(newMaxAllowedChange > 0 && newMaxAllowedChange < 1){
			Robot.maxAllowedSpeedChange = newMaxAllowedChange;
			System.out.println(Robot.maxAllowedSpeedChange);
		} else System.out.println("newMaxAllowedChange of " + newMaxAllowedChange + " not allowed. Keeping at " + Robot.maxAllowedSpeedChange);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
