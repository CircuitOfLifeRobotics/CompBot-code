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

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.RobotMap;

public class Wrist extends PIDSubsystem {
  
  private TalonSRX master = new TalonSRX(RobotMap.wristMotor);

  private static Wrist instance;
  public static Wrist getInstance(){
    if(instance == null) instance = new Wrist();

    return instance;

  }

  private Wrist() {

    super("Wrist", 1, 1, 1);
    super.getPIDController().setContinuous(false);
    super.setAbsoluteTolerance(.05);

    master.setNeutralMode(NeutralMode.Brake);
  }

  public void setPIDStatus(boolean status){
    if(status)
      enable();
    else
      disable();
  }

  public void z(){
    master.setSelectedSensorPosition(0);
  }

  public void move(double speed){
    master.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void initDefaultCommand() {
    
  }

  public double getPos(){
    return master.getSelectedSensorPosition();
  }

  public void changeSetpoint(double change){
    change += getSetpoint();
    setSetpoint(change);
  }
  
  @Override
  protected double returnPIDInput() {
    return master.getSelectedSensorPosition();
  }

  @Override
  protected void usePIDOutput(double output) {

    if(Math.abs(output) > .4){
      if(output < 0){
        output = -.4;
      }else{
        output = .4;
      }
    }

    if(Math.abs(master.getSelectedSensorPosition() - super.getSetpoint()) < 100){
      output /= 5.0;
     }
    if(Math.abs(master.getSelectedSensorPosition() - super.getSetpoint()) < 50) output = 0;

    master.set(ControlMode.PercentOutput, output);
  }
}
