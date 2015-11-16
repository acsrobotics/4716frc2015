package org.usfirst.frc.team4716.robot.commands;

import org.usfirst.frc.team4716.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithJoystick extends Command {
	
	double maxChange = 0.07;
	double maxChangeBack = 0.02;
	double speed = 0;
	double input = 0;
	
	boolean backwards = false;
	
    public DriveWithJoystick() {
    	requires(Robot.drivetrain);
    }

    protected void initialize() {}

    protected void execute() {
    	input = Robot.oi.getJoyY();
//    	if (input < 0){
//    		backwards = true;
//    	}
//    	if (input > (speed + maxChange)){
//    		speed = speed + maxChange;
//    	}else if(input < speed - maxChangeBack){
//    		speed = speed - maxChangeBack;
////    	}else if(-input > (speed + maxChangeBack) && backwards == true){
////    		speed = speed + maxChangeBack;
////    	}else if(-input < (speed - maxChangeBack) && backwards == true){
////    		speed = speed - maxChangeBack;
//    	}else{
//    		speed = input;
//    	}
    	
    	// NOTE ONLY FOR OUR ROBOT
    	Robot.drivetrain.arcadeDrive(input, -Robot.oi.getJoyX());
    	//Robot.drivetrain.arcadeDrive(Robot.oi.getJoyY(), -Robot.oi.getJoyX());
    	
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
