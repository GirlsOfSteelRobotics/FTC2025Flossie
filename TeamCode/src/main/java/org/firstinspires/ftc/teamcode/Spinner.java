package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Spinner {
    DcMotor motor;

    public Spinner(HardwareMap hardwareMap) {
        motor = hardwareMap.dcMotor.get("spinner");
    }

    public void forward() {
        motor.setPower(1);
    }

    public void backward() {
        motor.setPower(-1);
    }

    public void stop() {
        motor.setPower(0);
    }
}
