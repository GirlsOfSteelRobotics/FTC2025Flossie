package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Hood {
    Servo hood;

    public Hood(HardwareMap hardwareMap) {
        hood = hardwareMap.servo.get("hood");
    }

    public void setPosition(double goal) {
        hood.setPosition(goal);
    }

    public double getPosition() {
        return hood.getPosition();
    }

}
