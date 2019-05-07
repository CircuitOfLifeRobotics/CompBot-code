package frc.utilities;

import edu.wpi.first.wpilibj.AnalogInput;
import frc.robot.RobotMap;

public class Ultra {
    
    public static Ultra ultra;

    private AnalogInput uSensor;

    private Ultra(){

        uSensor = new AnalogInput(RobotMap.ULTRASONICSENSOR_PORT);

    }

    public static Ultra getInstance(){

        if(ultra == null){
            
            ultra = new Ultra();

        }

        return ultra;

    }

    // public static double getDistance(){

        

    // }

    public double getValue(){

        return uSensor.getValue();

    }

    public double getVoltage(){

        return uSensor.getVoltage()*99999;

    }

    public double getInches(){

        return uSensor.getValue() / 10.0;

    }

}