/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.RobotMap;
import frc.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.utilities.Limelight;
import frc.utilities.NavX;
import frc.utilities.Pigeon;
import frc.utilities.Ultra;

public class Move_VOS_Distance extends Command {

  public double distance;
  public double offset;
  public double desiredDistance;

  public Move_VOS_Distance(double dd) {

    offset = 0;
    System.out.println("IN THE STUPID CONSTRUCTOR");
    // start();
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }
  
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("IN THE STUPID COMMAND");
  }
  
  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

      desiredDistance = SmartDashboard.getNumber("Desired Distance", 15);

      distance = desiredDistance - RobotMap.VOS_Equation(Limelight.getInstance().getY());
      
      offset = ((Math.atan(1.5 * distance)) / Math.PI) / 1.5;

      SmartDashboard.putNumber("offset", offset);

      Drivetrain.getInstance().setSpeed(offset, 0);
  

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return (offset == 0);
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {

  }
}
