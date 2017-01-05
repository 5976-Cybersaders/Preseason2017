package org.usfirst.frc.team5976.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCommand extends CommandGroup {
	public AutonomousCommand() {
		addSequential(new DriveStraight(10));
		addSequential(new DriveStraight(-10));
	}
}
