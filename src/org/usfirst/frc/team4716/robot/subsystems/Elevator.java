package org.usfirst.frc.team4716.robot.subsystems;

import org.usfirst.frc.team4716.robot.RobotMap;
import org.usfirst.frc.team4716.robot.commands.StopElevator;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Elevator extends Subsystem {
	   
    private SpeedController leftElevCIM, rightElevCIM;
    private Encoder elevEncoder;
    private DigitalInput limit;
    
    public Elevator(){
    	//objects
    	leftElevCIM = new Talon(4);
    	rightElevCIM = new Talon(7);
    	limit = new DigitalInput(6);
    	elevEncoder	= new Encoder(RobotMap.ELEVATOR_ENCODER_PORT_1, RobotMap.ELEVATOR_ENCDER_PORT_2,
    							  false, EncodingType.k4X);
    	//properties
    	elevEncoder.setDistancePerPulse(1.0); //inches per pulse 
    	
    	
    	//live window
    	LiveWindow.addActuator("Elevator", "Elevator CIM", (Talon) leftElevCIM);
    	LiveWindow.addActuator("Elevator", "Elevator CIM", (Talon) rightElevCIM);
    	LiveWindow.addSensor("Encoder", "Elevator Encoder", elevEncoder);
    	
    }

    public void initDefaultCommand() {
        setDefaultCommand(new StopElevator());
    }
    
    //getters     
    public double getEncoderDistance(){
    	return elevEncoder.getDistance();
    }
    
    public boolean limitGet(){
    	return limit.get();
    }
    
    //setters
    public void moveElevCIM(double speed){
    	leftElevCIM.set(speed);
    	rightElevCIM.set(speed);
    }
    
    public void encoderReset(){
    	elevEncoder.reset();
    }
    //logging
    public void smartDashLog(){
    	SmartDashboard.putNumber("Elevator Encoder", elevEncoder.getDistance());
    }
}

