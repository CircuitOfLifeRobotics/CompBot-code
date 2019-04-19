/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.subsystems.Arm;
import frc.subsystems.Arm.ArmState;

public class MoveArm extends Command {
  
  ArmState state;

  public MoveArm(ArmState s){
    requires(Arm.getInstance());
    
    state = s;
  }
  
  public MoveArm(ArmState s, boolean isInstant) {
    requires(Arm.getInstance());
    
    state = s;

    if(isInstant){
      start();
    }
  }
  
  // Called once when the command executes
  @Override
  protected void initialize() {
    Arm.getInstance().setState(state);
  }

  @Override
  protected boolean isFinished() {
    return true;
  }
 

}
