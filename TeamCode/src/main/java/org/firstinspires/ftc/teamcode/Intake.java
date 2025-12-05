package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    DcMotor motor;

    public Intake(HardwareMap hardwareMap) {
        motor = hardwareMap.dcMotor.get("intake");
    }

    public void intake() {
        motor.setPower(1);
    }

    public void outake() {
        motor.setPower(-1);
    }
    public void stop() {
        motor.setPower(0);
    }
}

