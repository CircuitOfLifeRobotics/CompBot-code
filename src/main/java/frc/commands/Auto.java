/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.subsystems.Arm.ArmState;

public class Auto extends CommandGroup {

  public static int count;

  public static void run() {

    count = 1;
    Timer time = new Timer();

    time.start();
    time.reset();
    
    while(count < 6){

      SmartDashboard.putNumber("time", time.get());
      Scheduler.getInstance().run();
      // if(count == 1 && time.get() > 0){
      
      //   new MoveForward(5, -.4);//10.65 for cargo
      //   count++;
      
      // }else if(count == 2 && time.get() > .1){
      
      //   new MoveArm(ArmState.CARGO_LOW, true);
      //   count++;
      
      // }else if(count == 3 && time.get() > 7){
      
      //   new PlacePanel(true);
      //   count++;
      
      // }else if(count == 4 && time.get() > 9){
      
      //   new MoveForward(2, .4);
      //   count++;
      
      // }else if(count == 5 && time.get() > 10){

      //   new Turn(180);
      //   count++;

      // }else if(count == 6 && time.get() > 10){

      //   new MoveForward(5, -.4);
      //   count++;

      // }
      if(count == 1 && time.get() > 5){
      
        new MoveForward(4, -.4);//10.65 for cargo
        count++;
      
      }else if(count == 2 && time.get() > 10){

        new Turn(180);
        count++;

      }else if(count == 3 && time.get() > 15){

        new MoveForward(4, -.4);
        count++;

      }else if(count == 4 && time.get() > 20){

        new Turn(180);
        count++;

      }else if(count == 5 && time.get() > 20){

        count = 1;
        time.reset();

      }

    }

  }
}
