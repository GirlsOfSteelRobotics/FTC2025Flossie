package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Feeder {

    CRServo feeder;

    public Feeder(HardwareMap hardwareMap) {
        feeder = hardwareMap.crservo.get("feeder");
    }

    public void setPower(double goal) {
        feeder.setPower(goal);
    }

    public double getPower() {
        return feeder.getPower();
    }
}
