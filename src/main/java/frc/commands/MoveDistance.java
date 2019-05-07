/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.subsystems.Drivetrain;
import frc.utilities.Limelight;
import frc.utilities.Ultra;

public class MoveDistance extends Command {

  double offset;
  double desiredDistance;
  double distance;
  double speed;

  public MoveDistance(double distance) {
    
    offset = 0;
    
    // start();
    
  }
  
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("MOveDistancce is run");
  }
  
  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    
    desiredDistance = SmartDashboard.getNumber("Desired Distance", 15);
    
    distance = desiredDistance - Ultra.getInstance().getInches();
      
    speed = ((Math.atan(1.5 * distance)) / Math.PI) / 1.5;

    Drivetrain.getInstance().setSpeed(speed, 0);
  
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {

    return (speed == 0);
  
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {

    Drivetrain.getInstance().setSpeed(0, 0);

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
