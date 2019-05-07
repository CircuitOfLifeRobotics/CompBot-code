/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.utilities;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight {

    private NetworkTable table;
    private NetworkTableEntry tx;
    private NetworkTableEntry ty;
    private NetworkTableEntry ta;
    private NetworkTableEntry ts;
    private NetworkTableEntry tshort;
    private NetworkTableEntry tlong;
    private NetworkTableEntry thor;
    private NetworkTableEntry tvert;


    private boolean isTracking;

    private static Limelight instance;
    public static Limelight getInstance(){
        if(instance == null) instance = new Limelight();

        return instance;
    }

    private Limelight(){

        table = NetworkTableInstance.getDefault().getTable("limelight");
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(0);//1  = driver mode
        isTracking = false;
        tx = table.getEntry("tx");
        ty = table.getEntry("ty");
        ta = table.getEntry("ta");
        ts = table.getEntry("ts");
        tshort = table.getEntry("tshort");
        tlong = table.getEntry("tlong");
        thor = table.getEntry("thor");
        tvert = table.getEntry("tvert");
        
    }

    public void setState(boolean state){

        if(state){
            NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(0);
            isTracking = state;
        }else{
            NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(0);
            isTracking = state;
        }

    }

    public double getX(){
        return tx.getDouble(0.0);
    }

    public double getY(){
        return ty.getDouble(0.0);
    }

    public double getArea(){
        return ta.getDouble(0);
    }

    public double getRotation(){
        return ts.getDouble(0);
    }

    public double getShort(){
        return tshort.getDouble(0);
    } 

    public double getLong(){
        return tlong.getDouble(0);
    }

    public double getHoz(){
        return thor.getDouble(0);
    }

    public double getVert(){
        return tvert.getDouble(0);
    }
    public boolean getIsTracking(){
        return isTracking;
    }

}
