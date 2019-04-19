/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.subsystems.Arm;
import frc.subsystems.Drivetrain;
import frc.subsystems.Arm.ArmState;
import frc.utilities.NavX;

public class MoveForward extends Command {
 
  private  double distance;
  private final double FEET_TO_TICKS = 26.523624420166016 / 4;

  public MoveForward(double feet) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);

    distance = feet * FEET_TO_TICKS;

    start();
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    Drivetrain.getInstance().zero();
    // Arm.getInstance().setState(ArmState.CARGO_HIGH);

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    SmartDashboard.putNumber("Heading", NavX.getInstance().getHeading());
    SmartDashboard.putNumber("Acceleration Norm", NavX.getInstance().getAcceleration());
    double offset = 0;
    if(NavX.getInstance().getHeading() > 180 && NavX.getInstance().getHeading() < 357){
      System.out.println("left");
      offset = -.4;
    }else if(NavX.getInstance().getHeading() < 180 && NavX.getInstance().getHeading() > 3){
      System.out.println("right");
      offset = .4;
    }

    Drivetrain.getInstance().setSpeed(-.3, offset);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Drivetrain.getInstance().getPos() >= distance;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    
    // new PlaceBall();

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}