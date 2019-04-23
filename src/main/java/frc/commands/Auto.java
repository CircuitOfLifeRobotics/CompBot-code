/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.subsystems.Arm.ArmState;

public class Auto extends CommandGroup {

  public Auto() {

    int count = 1;
    Timer time = new Timer();

    time.start();
    System.out.println(time);

    while(count < 3){

      if(count == 1 && time.get() > 500){
        addSequential(new MoveForward(11.8, -.4));
        count++;
      }else if(count == 2 && time.get() > 1000){
        addSequential(new MoveArm(ArmState.CARGO_HIGH, true));
        count++;
      }

    }

    // addSequential(new WaitCommand(5));
    // addSequential(new MoveArm(ArmState.CARGO_HIGH));
    // addSequential(new WaitCommand(2));
    // addSequential(new MoveForward(500));
    // addSequential(new PlaceBall());
  }

  public void next(){
    addSequential(new MoveForward(2, .3));
  }
}
