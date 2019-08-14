/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.utilities;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Timer;

/**
 * Add your docs here.
 */
public class Lidar{

    private I2C i2c = new I2C(I2C.Port.kMXP, 0x62);


    private static Lidar instance;

    public static Lidar getInstance(){

        if(instance == null){
            instance = new Lidar();
        }

        return instance;
    }

    private Lidar(){

    }

    public int getDistance(){
        byte[] buffer = new byte[2];

        i2c.write(0x00, 0x04);
        Timer.delay(.04);
        i2c.read(0x8f, 2, buffer);

        return (int) Integer.toUnsignedLong(buffer[0] << 8) + Byte.toUnsignedInt(buffer[1]);
    }

}
