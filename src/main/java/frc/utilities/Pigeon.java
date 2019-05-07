/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.utilities;

import com.ctre.phoenix.sensors.PigeonIMU;
import com.ctre.phoenix.sensors.PigeonIMU.PigeonState;

import frc.robot.RobotMap;
import frc.subsystems.Arm;

/**
 * Add your docs here.
 */
public class Pigeon {

    private static Pigeon instance;

    private PigeonIMU pigeon;

    public static Pigeon getInstance(){

        if(instance == null){

            instance = new Pigeon();

        }

        return instance;

    }

    private Pigeon() {

        pigeon = new PigeonIMU(Arm.getInstance().getPigeonTalon());
        pigeon.clearStickyFaults();

    }

    public double getAbsCompass(){

        return pigeon.getAbsoluteCompassHeading();

    }

    public double[] getYPR(){

        double[] ypr = new double[3];

        pigeon.getYawPitchRoll(ypr);

        return ypr;

    }

    public double getFusedHeading(){

        return pigeon.getFusedHeading();

    }

    public double getCompass(){

        return pigeon.getCompassHeading();

    }

    public PigeonState isFinishedInitializing(){

        return pigeon.getState();

    }

}
