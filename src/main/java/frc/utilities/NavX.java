/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.utilities;

import java.util.ArrayList;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.I2C.Port;

public class NavX {

  private static NavX instance;
  private double adjustment;
  private final AHRS ahrs;

  public static NavX getInstance(){
    if(instance == null){
      instance = new NavX();
    }
    return instance;
  }

  private NavX(){
    
    ahrs = new AHRS(Port.kMXP);
    adjustment = 0;

    ahrs.resetDisplacement();
    ahrs.reset();

  }

  public void zeroHeading() {

    setAdjustment(-ahrs.getFusedHeading());

  }

  public double getAdjustment(){

    return adjustment;

  }

  public void setAdjustment(double angle) {

    adjustment = angle;

  }

  public double getHeading() {

    return (ahrs.getFusedHeading() + adjustment) % 360;
  
  }

  // public double getAccelLogVal(int ind) {

  //   try{
    
  //     return accelLog.get(ind);
    
  //   }catch(Exception IndexOutOfBoundsException){s

  //     return 0;

  //   }


  // }

  public double getDisplacement() {

    return Math.sqrt(Math.pow(ahrs.getDisplacementX(), 2) + Math.pow(ahrs.getDisplacementY(), 2) + Math.pow(ahrs.getDisplacementZ(), 2));

  }

}