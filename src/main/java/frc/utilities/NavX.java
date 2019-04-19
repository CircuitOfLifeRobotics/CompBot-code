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
  private ArrayList<Double> accelLog;
  private final AHRS ahrs;

  public static NavX getInstance(){
    if(instance == null){
      instance = new NavX();
    }
    return instance;
  }

  private NavX(){
    
    ahrs = new AHRS(Port.kMXP);
    accelLog = new ArrayList<Double>();

    ahrs.resetDisplacement();
    ahrs.reset();

  }

  public double getHeading() {

    return ahrs.getFusedHeading();
  
  }

  // public double getAccelLogVal(int ind) {

  //   try{
    
  //     return accelLog.get(ind);
    
  //   }catch(Exception IndexOutOfBoundsException){s

  //     return 0;

  //   }


  // }

  public double getAcceleration() {

    double val = Math.sqrt(Math.pow(ahrs.getWorldLinearAccelX(), 2) + Math.pow(ahrs.getWorldLinearAccelY(), 2) + Math.pow(ahrs.getWorldLinearAccelZ(), 2));

    accelLog.add(0, val);

    return val;

  }

  public double getDisplacement() {

    return Math.sqrt(Math.pow(ahrs.getDisplacementX(), 2) + Math.pow(ahrs.getDisplacementY(), 2) + Math.pow(ahrs.getDisplacementZ(), 2));

  }

}