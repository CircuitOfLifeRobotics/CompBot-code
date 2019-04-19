/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Intake extends Subsystem {
  
  private TalonSRX top = new TalonSRX(RobotMap.intakeTop);
  private TalonSRX bottom = new TalonSRX(RobotMap.intakeBottom);


  private static Intake instance;
  public static Intake getInstance() {
    if(instance == null) instance = new Intake();

    return instance;
  }

  private Intake(){

    top.setNeutralMode(NeutralMode.Brake);
    bottom.setNeutralMode(NeutralMode.Brake);

    bottom.setInverted(true);

  }

  @Override
  public void initDefaultCommand() {
  
  }

  public void setSpeed(double speed){
    top.set(ControlMode.PercentOutput, speed);
    bottom.set(ControlMode.PercentOutput, speed);
  }

  public void setSpeed(double topSpeed, double bottomSpeed){
    top.set(ControlMode.PercentOutput, topSpeed);
    bottom.set(ControlMode.PercentOutput, bottomSpeed);
  }


}
