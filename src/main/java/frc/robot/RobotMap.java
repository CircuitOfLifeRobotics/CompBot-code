/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public class RobotMap {

    //drivetrain spark ports
    public static final int leftMaster = 3;
    public static final int leftSlaveA = 4;
    public static final int leftSlaveB = 5;
    public static final int rightMaster = 24;// Dont ask just leave it -Bacon  ok sounds good -Danny
    public static final int rightSlaveA = 1;
    public static final int rightSlaveB = 2;

    //arm talon ports
    public static final int armMaster = 10;//front left
    public static final int armSlaveOne = 11;//back left
    public static final int armSlaveTwo = 12;//front right
    public static final int armSlaveThree = 13;//back left

    //wrist talon ports
    public static final int wristMotor = 8;

    //intake talon ports
    public static final int intakeTop = 7;//intake top
    public static final int intakeBottom = 6;//intake bottom

    //solenoid
    public static final int shiftLow = 1;
    public static final int shiftHigh = 2;

    //******************************************

    //encoder position for ArmStates for arm
    public static final double armDown = 0;
    public static final double armPickup = 550;
    public static final double armGrabPanel = 0;
    
    public static final double armCargoLow = 0;//same as panel low
    public static final double armCargoHigh = 3770;
    
    public static final double armBottom = 2549;
    public static final double armMiddle = 4550;
    public static final double armHigh = 5598;
    
    public static final double armPanelMiddle = 2600;
    public static final double armPanelHigh = 4657;

    public static final double armCargoChute = 3770;
    public static final double armDepotPickup = 1653;

    //encoder position for ArmStates for wrist
    public static final double wristDown = -573;
    public static final double wristPickUp = -2400;
    public static final double wristGrabPanel = -1282;

    public static final double wristCargoLow = -160;//same as panel low
    public static final double wristCargoHigh = -3920;
    
    public static final double wristBottom = -3150;
    public static final double wristMiddle = -4200;
    public static final double wristHigh = -3372;
    
    public static final double wristPanelMiddle = -1424;
    public static final double wristPanelHigh = -2413;

    public static final double wristCargoChute = -3573;
    public static final double wristDepotPickup = -3714;

    /***********************************/

    public static final double desiredYValue = -18.91;// w/ big wheels: -20.33

}
