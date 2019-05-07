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
import frc.subsystems.Arm;
import frc.subsystems.Drivetrain;
import frc.subsystems.Arm.ArmState;
import frc.utilities.NavX;

public class Turn extends Command {
 
  private  double turnAngle;
  private double offset;

  public Turn(double angleAtWhichToTurn) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);

    turnAngle = angleAtWhichToTurn;

    start();
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    Drivetrain.getInstance().zero();
    NavX.getInstance().setAdjustment(NavX.getInstance().getAdjustment() + turnAngle);
    // Arm.getInstance().setState(ArmState.CARGO_HIGH);

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    offset = 0;

    double heading = NavX.getInstance().getHeading();

    if(heading > 180){
    
      heading -= 360;
    
    }
    
    offset = (1/Math.PI) * Math.atan(heading/2);

    SmartDashboard.putNumber("offset", offset);

    Drivetrain.getInstance().setSpeed(0, offset);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {

    return (Math.abs(offset) < RobotMap.AlignmentDeadzone);

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
